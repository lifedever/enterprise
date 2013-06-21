package com.app.filter;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;

import com.app.meibo.message.model.Message;
import com.app.meibo.message.service.MessageManager;
import com.app.meibo.message.utils.MessageUtils;
import com.app.permission.model.User;
import com.sqds.spring.SpringUtils;
import com.sqds.util.SessionManager;

@Aspect
public class LogFilter {

	@Autowired
	private MessageManager messageManager;
	/**
	 * 定义要排除验证的url
	 */
	private List<String> accessUrl = new ArrayList<String>();
	private static String CONFIG_PATH = "WEB-INF/classes/config/messageTemplate.properties";

	public LogFilter() {
		/*
		 * 将要过滤掉的url加入到排除队列中
		 */
		accessUrl.add("/login/login.html");
		accessUrl.add("/login/checkLogin.html");
		accessUrl.add("/test/");
		// accessUrl.add("/main/index.html");
		MessageUtils.map = monitMessage();
		// System.out.println(map.get("/offer/addOffer.html"));
	}

	/**
	 * .do 结尾的文件需要进行权限验证
	 * 
	 * @param jp
	 * @throws IOException
	 * @throws ServletException
	 */
	@Before("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void validation(JoinPoint jp) throws ServletException, IOException {
		HttpServletRequest request = SpringUtils.getRequest();
		if (request == null) {
			return;
		}
		String url = request.getRequestURI();
		System.out.println(url);
		// 获得session
		// 判断用户是否登录，如果没登陆则跳转的登录界面
		User user = (User) SessionManager.getAttribute(request, "user");
		if (user == null) {
//			for (String str : accessUrl) {
				if (!accessUrl.contains(url) && !SpringUtils.getResponse().isCommitted())
					SpringUtils.getResponse().sendRedirect("/login/login.html");
//			}
		}
		// 监控消息
		// saveMassage(user, url);
		// 发送消息到前台提示
		setMessageToSession(user, url);
	}

	/**
	 * 解析配置文件，将配置的消息信息加载到map，程序启动只加载一次
	 * 
	 * @return
	 */
	private Map<String, String> monitMessage() {
		Map<String, String> map = new HashMap<String, String>();
		Properties prop = new Properties();
		try {
			String webroot = System.getProperty("project.root");
			prop.load(new FileInputStream(new File(webroot + CONFIG_PATH)));
			Set<Object> keySet = prop.keySet();
			for (Object key : keySet) {
				map.put(key.toString(), prop.get(key).toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return map;
	}

	/**
	 * 每次访问独立大模块时，查询消息表，检查是否有新消息并提示用户. <br/>
	 * 如果用户点击了不再提醒，将session中的remind清除，并且不再提醒用户
	 */
	private void setMessageToSession(User user, String url) {
		if (user != null && SessionManager.getAttribute(SpringUtils.getRequest(), "remind") != null && url.endsWith("index.html")) {
			List<Message> messages = messageManager.listMessageByUserId(user.getId(), 0);
			SessionManager.setAttribute(SpringUtils.getRequest(), "messages", messages);
		}
	}
}
