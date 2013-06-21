package com.app.meibo.customer.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.contract.model.Contract;
import com.app.meibo.contract.service.ContractManager;
import com.app.meibo.customer.model.Customer;
import com.app.meibo.customer.service.CustomerManager;
import com.app.meibo.offer.model.Offer;
import com.app.meibo.offer.service.OfferManager;
import com.app.meibo.order.model.Order;
import com.app.meibo.order.service.OrderManager;
import com.app.permission.model.User;
import com.app.permission.service.UserManager;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.annotation.GlobalAutowired;

/**
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-3-5 下午10:28:00
 */
@Controller
@GlobalAutowired
@RequestMapping("/meibo/customer/customerManager/*.html")
public class CustomerManagerController {
	private UserManager userManager;
	private CustomerManager customerManager;
	private OfferManager offerManager;
	private OrderManager orderManager;
	private ContractManager contractManager;

	@RequestMapping
	public void index() {

	}

	/**
	 * 业务员列表，
	 * 
	 * @param id
	 * @param model
	 */
	@RequestMapping
	public void listUser(Integer id, ModelMap model) {
		User user = userManager.get(id);
		model.addAttribute("user", user);
	}

	@RequestMapping
	public void confirmAssign(Integer userId, Integer customerId, HttpServletResponse response) {
		Customer customer = customerManager.get(customerId);
		customer.setUserId(userId);
		customerManager.update(customer);

		// 与客户有关的报价
		List<Offer> offers = offerManager.listByCustomer(customerId);
		for (Offer offer : offers) {
			offer.setUserId(userId);
			offerManager.update(offer);
		}
		// 与客户有关的订单
		List<Order> orders = orderManager.listByCustomer(customerId);
		for (Order order : orders) {
			order.setUserId(userId);
			orderManager.update(order);

			// 与订单有关的签单
			Contract contract = contractManager.getByOrderId(order.getId());
			contract.setUserId(userId);
			contractManager.update(contract);
		}

		JsonUtils.writeJson(response);
	}
}
