package com.app.meibo.message.utils;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.app.meibo.message.model.Message;
import com.app.meibo.message.model.MessageType;
import com.app.meibo.message.service.MessageManager;
import com.app.permission.model.Role;
import com.app.permission.model.User;
import com.app.permission.service.RoleManager;
import com.app.permission.service.UserManager;
import com.sqds.spring.SpringUtils;
import com.sqds.util.SessionManager;

public final class MessageUtils {
	public static Map<String, String> map = new HashMap<String, String>();
	private static RoleManager roleManager = (RoleManager) SpringUtils.getBean("roleManager");
	private static UserManager userManager = (UserManager) SpringUtils.getBean("userManager");
	private static MessageManager messageManager = (MessageManager) SpringUtils.getBean("messageManager");

	/**
	 * 监控map中的url，如果有消息配置，则将消息保存到数据库
	 */
	public static void saveMassage(HttpServletRequest request) {
		String url = request.getRequestURI();
		User user = (User) SessionManager.getAttribute(request, "user");
		for (String mUrl : map.keySet()) {
			if (url.equalsIgnoreCase(mUrl)) {
				String[] value = map.get(mUrl).split(":");
				String roleName = value[0];
				Role role = roleManager.findUnique("from Role r where r.roleName=?", roleName);
				List<User> users = userManager.listUsersByRole(role);
				Message message = new Message();
				message.setContent(value[2]);
				message.setCreateDate(new Date());
				message.setTitle(value[1]);
				message.setSendUserId(user.getId());
				message.setUsers(users);
				message.setMessageType(MessageType.SYSTEM.getTypeValue());
				messageManager.save(message);
			}
		}
	}

	/**
	 * 自定义消息内容并存储
	 * 
	 * @param request
	 *            request用来取用户
	 * @param content
	 *            消息内容
	 * @param title
	 *            标题
	 * @param users
	 *            接收此消息的用户列表
	 */
	public static void saveDefinedManager(HttpServletRequest request, String content, String title, List<User> users) {
		User user = (User) SessionManager.getAttribute(request, "user");
		Message message = new Message();
		message.setContent(content);
		message.setCreateDate(new Date());
		message.setTitle(title);
		message.setSendUserId(user.getId());
		message.setUsers(users);
		message.setMessageType(MessageType.SYSTEM.getTypeValue());
		messageManager.save(message);
	}
}
