package com.app.permission.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.permission.model.User;
import com.app.permission.service.UserManager;
import com.sqds.exception.SqdsException;
import com.sqds.util.SessionManager;

/**
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createtime 2012-10-31 下午10:08:38
 */
@Controller
@RequestMapping("/login/*.html")
public class LoginController {
	@Autowired
	private UserManager userManager;

	@RequestMapping
	public void login(String result, HttpServletRequest request, ModelMap model) {
		String title = "北京美博雅克丽工贸有限公司";
		SessionManager.removeAttribute(request, "user");
		SessionManager.setAttribute(request, "title", title);
	}

	@RequestMapping
	public void checkLogin(String username, String password, HttpServletRequest request, ModelMap model) {
		if (username == null || password == null) {
			throw new SqdsException("请输入用户名和密码！");
		}
		User user = userManager.getUserByUsername(username);
		String result = "";
		String redirectUrl = "/login/login.html";
		// boolean flag = false;
		// 验证用户身份
		if (user == null) {
			result = "用户不存在";
		} else if (user.getActiveFlag() == 0) {
			result = "帐号被屏蔽";
		} else if (!user.getPassword().equals(password)) {
			result = "密码不正确";
		} else { // 验证通过
			result = "验证通过，正在登录";
			if (user.getRole() == null) {
				result = "用户未分配角色";
			} else {
				// flag = true;
				SessionManager.setAttribute(request, "user", user);
				SessionManager.setAttribute(request, "remind", "remind");
				redirectUrl = "/main/index.html";
			}
		}
		model.addAttribute("result", result);
		model.addAttribute("redirectUrl", redirectUrl);
	}

	@RequestMapping
	public String logout(HttpServletRequest request, ModelMap model) {
		SessionManager.removeAttribute(request, "user");
		return "/login/login";
	}
}
