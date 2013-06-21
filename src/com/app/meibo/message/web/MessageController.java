package com.app.meibo.message.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.message.model.Message;
import com.app.meibo.message.model.MessageType;
import com.app.meibo.message.model.vo.MessageVO;
import com.app.meibo.message.service.MessageManager;
import com.app.permission.model.Page;
import com.app.permission.model.User;
import com.app.permission.service.UserManager;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.util.SessionManager;

/**
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-11-30 下午10:57:10
 */
@Controller
@RequestMapping("/message/*.html")
public class MessageController {
	@Autowired
	private MessageManager messageManager;
	@Autowired
	private UserManager userManager;

	@RequestMapping
	public void getMessage(String nowClick, ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
		modelMap.clear();// 必须的，否则容易出异常
		Page<Message> page = new Page<Message>();
		page.setQueryDatas(request, page);// 将前台request传来的查询参数绑定的page对象，进行查询
		SpringUtils.bind(page);// page前台数据绑定
		messageManager.search(page, nowClick, (User) SessionManager.getAttribute(request, "user"));// 要查询请调用search()方法，如调用了list，默认是没有查询功能的
		List<MessageVO> list = new ArrayList<MessageVO>();
		for (Message message : page.getResult()) {
			MessageVO vo = new MessageVO();
			BeanUtilsEx.copyProperties(vo, message);
			vo.setSendUser(userManager.get(message.getSendUserId()).getUsername());
			vo.setType(MessageType.getTypeNameByValue(message.getMessageType()));
			list.add(vo);
		}
		modelMap.put("total", page.getTotalCount());
		modelMap.put("rows", list);
		JsonUtils.writeJson(response, modelMap);
	}

	/**
	 * 显示信息
	 * 
	 * @param response
	 * @param id
	 */
	@RequestMapping
	public void showMessage(HttpServletResponse response, Integer id) {
		Message message = messageManager.get(id);
		message.setIsRead(1);
		messageManager.update(message);
		response.setContentType("text/html");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.println("<h3>" + message.getTitle() + "</h3>");
			out.println("来自：<font color='blue'>" + userManager.get(message.getSendUserId()).getUsername() + "</font>");
			out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
			out.println("时间：" + message.getCreateDate());
			out.println("&nbsp;&nbsp;&nbsp;&nbsp;");
			out.println("类型：" + MessageType.getTypeNameByValue(message.getMessageType()));
			out.println("<hr/>");
			out.println("<div>" + message.getContent() + "</div>");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 移入回收站
	 * 
	 * @param response
	 * @param id
	 */
	@RequestMapping
	public void remove(HttpServletResponse response, Integer id) {
		Message message = messageManager.get(id);
		message.setIsDelete(1);// 移入回收站
		messageManager.update(message);
		JsonUtils.writeJson(response);
	}

	/**
	 * 消息还原
	 * 
	 * @param response
	 * @param id
	 */
	@RequestMapping
	public void unremove(HttpServletResponse response, Integer id) {
		Message message = messageManager.get(id);
		message.setIsDelete(0);// 移入回收站
		messageManager.update(message);
		JsonUtils.writeJson(response);
	}

	/**
	 * 查询是否有此用户
	 * 
	 * @param response
	 * @param usernames
	 */
	@RequestMapping
	public void checkUsernames(HttpServletResponse response, String usernames, ModelMap model) {
		model.clear();
		String noUser = "";
		if (usernames.contains(",")) {
			String[] names = usernames.split(",");
			for (String name : names) {
				User user = userManager.getUserByUsername(name);
				if (user == null) {
					noUser += name + ",";
				}
			}
		} else if (!"".equals(usernames)) {
			User user = userManager.getUserByUsername(usernames);
			if (user == null) {
				noUser = usernames;
			}
		}
		model.put("noUser", noUser);
		JsonUtils.writeJson(response, model);
	}

	/**
	 * 发送消息
	 * 
	 * @param message
	 * @param usernames
	 */
	@RequestMapping
	public void sendMessage(HttpServletResponse response,Message message, String usernames) {
		List<User> users = new ArrayList<User>();
		if (usernames.contains(",")) {
			String[] names = usernames.split(",");
			for (String name : names) {
				User user = userManager.getUserByUsername(name);
				users.add(user);
			}
		} else if (!"".equals(usernames) && usernames != null) {
			User user = userManager.getUserByUsername(usernames);
			users.add(user);
		}
		message.setCreateDate(new Date());
		message.setMessageType(MessageType.USER.getTypeValue());
		message.setUsers(users);
		messageManager.save(message);
		JsonUtils.writeJson(response);
	}
}
