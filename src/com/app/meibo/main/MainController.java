package com.app.meibo.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.customer.model.Customer;
import com.app.meibo.customer.service.CustomerManager;
import com.app.meibo.finace.expenditure.service.ExpenditureManager;
import com.app.meibo.human.service.EmployeeManager;
import com.app.meibo.message.service.MessageManager;
import com.app.meibo.storeroom.inoutstore.service.ProductInOutstoreManager;
import com.app.permission.model.Function;
import com.app.permission.model.User;
import com.app.permission.service.UserManager;
import com.sqds.spring.annotation.GlobalAutowired;
import com.sqds.util.SessionManager;

/**
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createtime 2012-10-31 下午10:52:33
 */
@Controller
@GlobalAutowired
public class MainController {
	private EmployeeManager employeeManager;
	private UserManager userManager;
	private CustomerManager customerManager;
	private MessageManager messageManager;
	private ExpenditureManager expenditureManager;
	private ProductInOutstoreManager productInOutstoreManager;

	@RequestMapping("/main/index.html")
	public void index(HttpServletRequest request, ModelMap model) {

	}

	@RequestMapping("/main/top.html")
	public void top() {
	}

	@RequestMapping("/main/left.html")
	public String left(HttpServletRequest request, ModelMap model) {
		User user = (User) SessionManager.getAttribute(request, "user");
		user = userManager.get(user.getId());
		if (user.getRole() == null) {
			return "/login/login";
		} else {
			List<Function> parFuns = new ArrayList<Function>();
			List<Function> subFuns = new ArrayList<Function>();
			for (Function function : user.getRole().getFunctions()) {
				if (function.getParentFunction() != null) {
					subFuns.add(function);
				} else {
					parFuns.add(function);
				}
			}
			// 处理function，将当前登录用户没有的权限的功能删去
			for (Function fun1 : parFuns) {
				List<Function> tempList = new ArrayList<Function>();
				for (Function fun2 : fun1.getFunctions()) {
					if (!subFuns.contains(fun2)) {
						tempList.add(fun2);
					}
				}
				fun1.getFunctions().removeAll(tempList);
				// 对子连接表排序
				Collections.sort(fun1.getFunctions(), new Comparator<Function>() {
					@Override
					public int compare(Function o1, Function o2) {
						return o1.getOrderIndex() - o2.getOrderIndex();
					}
				});
			}

			Collections.sort(parFuns, new Comparator<Function>() {
				@Override
				public int compare(Function o1, Function o2) {
					return o1.getOrderIndex() - o2.getOrderIndex();
				}
			});
			model.addAttribute("functions", parFuns);
			return "/main/left";
		}
	}

	@RequestMapping("/main/main.html")
	public String main(HttpServletRequest request, ModelMap model) {
		User user = (User) SessionManager.getAttribute(request, "user");
		user = userManager.get(user.getId());
		// 查询信息在页面显示
		// 总员工数和三个月内新员工数
		int empCount[] = employeeManager.getAllCountAndNewCount();
		// 总客户数和三个月内新客户数
		int customerCount[] = customerManager.getAllCountAndNewCount();
		// 最活跃用户
		List<Customer> customers = customerManager.listCustomers();
		// 总消息和未读消息数
		int[] msgArr = messageManager.getAllAndNotReadCount(user);
		// 出售额
		double[] sales = expenditureManager.getAllAndRecentSales();
		// 热销商品
		List<Object[]> hotList = productInOutstoreManager.getHostList();

		model.addAttribute("msgArr", msgArr);
		model.addAttribute("empCount", empCount);
		model.addAttribute("customerCount", customerCount);
		model.addAttribute("customers", customers);
		model.addAttribute("sales", sales);
		model.addAttribute("hotList", hotList);
		return user.getRole().getHomePage();
	}
}
