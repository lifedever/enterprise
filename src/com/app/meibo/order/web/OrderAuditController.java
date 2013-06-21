package com.app.meibo.order.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.order.model.Order;
import com.app.meibo.order.service.OrderManager;
import com.app.permission.model.User;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.annotation.GlobalAutowired;
import com.sqds.util.ParamUtils;
import com.sqds.util.SessionManager;

/**
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-23 上午9:04:56
 */
@Controller
@GlobalAutowired
@RequestMapping("/meibo/order/audit/*.html")
public class OrderAuditController {
	private OrderManager orderManager;

	@RequestMapping
	public void index() {

	}

	@RequestMapping
	public void auditForm(Integer orderId, ModelMap model) {
		Order order = orderManager.get(orderId);
		model.addAttribute("order", order);
	}

	@RequestMapping
	public void saveAudit(Integer orderId, HttpServletResponse response,HttpServletRequest request) {
		int isAudit = ParamUtils.getInt("isAudit", 0);
		Order order = orderManager.get(orderId);
		User user = (User) SessionManager.getAttribute(request, "user");
		order.setAuditUser(user.getRealName());
		order.setIsAudit(isAudit);
		orderManager.update(order);
		JsonUtils.writeJson(response);
	}
}
