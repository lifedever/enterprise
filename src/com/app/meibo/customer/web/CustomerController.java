package com.app.meibo.customer.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.meibo.customer.model.Customer;
import com.app.meibo.customer.model.vo.CustomerVO;
import com.app.meibo.customer.service.CustomerManager;
import com.app.meibo.offer.service.OfferManager;
import com.app.permission.model.Page;
import com.app.permission.model.User;
import com.app.permission.service.UserManager;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;
import com.sqds.util.SessionManager;

/**
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-8 下午2:07:30
 */
@Controller
@GlobalAutowired
@RequestMapping("/meibo/customer/*.html")
public class CustomerController {
	private CustomerManager customerManager;
	private OfferManager offerManager;
	private UserManager userManager;

	@RequestMapping
	public void index() {

	}

	@RequestMapping
	public void listContent(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Page<Customer> page = new Page<Customer>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);
		page.search(page, "Customer", customerManager);
		List<CustomerVO> customerVOs = new ArrayList<CustomerVO>();
		for (Customer customer : page.getResult()) {
			CustomerVO vo = new CustomerVO();
			BeanUtilsEx.copyProperties(vo, customer);
			if (offerManager.getLastOffer(customer.getId()) != null)
				vo.setOfferDate(offerManager.getLastOffer(customer.getId()).getCreateDate());
			User user = userManager.get(customer.getUserId());
			vo.setUserName(user.getRealName());
			customerVOs.add(vo);
		}

		model.put("total", page.getTotalCount());
		model.put("rows", customerVOs);
		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void addForm(@RequestParam(defaultValue = "0") int customerId, ModelMap model) {
		Customer customer = null;
		if (customerId == 0) {
			customer = new Customer();
		} else {
			customer = customerManager.get(customerId);
		}
		model.addAttribute("customer", customer);
	}

	@RequestMapping
	public void saveCustomer(Customer customer, HttpServletResponse response, HttpServletRequest request) {
		if (customer.getId() != null && customer.getId().intValue() != 0) {
			customer = customerManager.get(customer.getId());
			SpringUtils.bind(customer);
		} else {
			User user = (User) SessionManager.getAttribute(request, "user");
			customer.setUserId(user.getId());
			customer.setDepartmentId(user.getDepartment().getId());
		}
		customerManager.save(customer);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void deleteCustomer(Integer customerId, HttpServletResponse response) {
		customerManager.delete(customerId);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void viewCustomer(Integer customerId, ModelMap model) {
		Customer customer = customerManager.get(customerId);
		model.addAttribute("customer", customer);
	}

}
