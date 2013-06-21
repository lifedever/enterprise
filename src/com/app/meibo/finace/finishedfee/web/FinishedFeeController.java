package com.app.meibo.finace.finishedfee.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.meibo.constant.ExpenditureEnum;
import com.app.meibo.finace.account.model.Account;
import com.app.meibo.finace.account.service.AccountManager;
import com.app.meibo.finace.expenditure.model.Expenditure;
import com.app.meibo.finace.expenditure.service.ExpenditureManager;
import com.app.meibo.finace.model.FinishedFee;
import com.app.meibo.finace.model.vo.FinishedFeeVO;
import com.app.meibo.finace.model.vo.ShowIndexVO;
import com.app.meibo.finace.service.FinishedFeeManager;
import com.app.meibo.order.model.Order;
import com.app.meibo.order.model.OrderItem;
import com.app.meibo.order.service.OrderItemManager;
import com.app.meibo.order.service.OrderManager;
import com.app.permission.model.Page;
import com.app.permission.model.User;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;
import com.sqds.util.SessionManager;

/**
 * 成品收款管理
 * 
 * @author MSQ
 * @email gefangshuai@163.com
 * @createdata 2013-2-26 下午9:37:09
 */
@Controller
@RequestMapping("/finace/finishedfee/*.html")
@GlobalAutowired
public class FinishedFeeController {
	private FinishedFeeManager finishedFeeManager;
	private OrderManager orderManager;
	private OrderItemManager orderItemManager;
	private ExpenditureManager expenditureManager;
	private AccountManager accountManager;

	/**
	 * 
	 * @param request
	 * @param model
	 */
	@RequestMapping
	public void detailIndex(HttpServletRequest request, String orderNo, ModelMap model) {
		double hasMoney = 0;
		List<FinishedFee> finishedFees = finishedFeeManager.getListByOrderNo(orderNo);
		for (FinishedFee finishedFee : finishedFees) {
			hasMoney += finishedFee.getHasCount();
		}
		model.addAttribute("hasMoney", hasMoney);
		model.addAttribute("orderNo", orderNo);
	}

	/**
	 * 
	 * @param response
	 * @param request
	 * @param model
	 */
	@RequestMapping
	public void detailListContent(HttpServletResponse response, HttpServletRequest request, ModelMap model) {
		Page<FinishedFee> page = new Page<FinishedFee>();
		page.setQueryDatas(request, page);//
		SpringUtils.bind(page);//
		page.search(page, "FinishedFee", finishedFeeManager);
		List<FinishedFee> finishedFees = page.getResult();
		List<FinishedFeeVO> finishedFeeVOs = new ArrayList<FinishedFeeVO>();
		double totalMoney = 0;
		for (FinishedFee finishedFee : finishedFees) {
			totalMoney += finishedFee.getHasCount();
			FinishedFeeVO vo = new FinishedFeeVO();
			BeanUtilsEx.copyProperties(vo, finishedFee);
			finishedFeeVOs.add(vo);
		}
		model.put("total", page.getTotalCount());
		model.put("totalMoney", totalMoney);
		model.put("rows", finishedFeeVOs);
		JsonUtils.writeJson(response, model);
	}

	/**
	 * 
	 * @param request
	 * @param model
	 */
	@RequestMapping
	public void index(HttpServletRequest request, ModelMap model) {

	}

	/**
	 * 
	 * @param response
	 * @param request
	 * @param model
	 */
	@RequestMapping
	public void listContent(HttpServletResponse response, HttpServletRequest request, ModelMap model) {
		Page<Order> page = new Page<Order>();
		page.setQueryDatas(request, page);//
		SpringUtils.bind(page);//

		page.search(page, "Order", orderManager);
		List<Order> orders = page.getResult();
		List<ShowIndexVO> showIndexVOs = new ArrayList<ShowIndexVO>();
		for (Order order : orders) {
			ShowIndexVO vo = new ShowIndexVO();
			double countMoney = 0;
			List<OrderItem> orderItems = orderItemManager.getListByOrderNo(order.getOrderNo());
			for (OrderItem orderItem : orderItems) {
				countMoney += (orderItem.getPrice() * orderItem.getProductCount());
			}
			double hasMoney = 0;
			List<FinishedFee> finishedFees = finishedFeeManager.getListByOrderNo(order.getOrderNo());
			for (FinishedFee finishedFee : finishedFees) {
				hasMoney += finishedFee.getHasCount();
			}
			BeanUtilsEx.copyProperties(vo, order);
			vo.setCustomerName(order.getCustomer().getCustomerName());
			vo.setAllCount(countMoney);
			vo.setHasCount(hasMoney);
			showIndexVOs.add(vo);
		}
		model.put("total", page.getTotalCount());
		model.put("rows", showIndexVOs);
		JsonUtils.writeJson(response, model);
	}

	/**
	 * 跳转收款页面
	 * 
	 * @param finishedFeeId
	 * @param model
	 */
	@RequestMapping
	public void addForm(@RequestParam(defaultValue = "0") int orderId, ModelMap model) {
		FinishedFee finishedFee = new FinishedFee();
		Order order = orderManager.get(orderId);
		double countMoney = 0;
		List<OrderItem> orderItems = orderItemManager.getListByOrderNo(order.getOrderNo());
		for (OrderItem orderItem : orderItems) {
			countMoney += orderItem.getPrice() * orderItem.getProductCount();
		}
		double hasMoney = 0;
		List<FinishedFee> finishedFees = finishedFeeManager.getListByOrderNo(order.getOrderNo());
		for (FinishedFee finishedFeeb : finishedFees) {
			hasMoney += finishedFeeb.getHasCount();
		}
		model.addAttribute("finishedFee", finishedFee);
		model.addAttribute("orderNo", order.getOrderNo());
		model.addAttribute("countMoney", countMoney);
		model.addAttribute("hasMoney", hasMoney);
	}

	/**
	 * 保存收款
	 * 
	 * @param finishedFee
	 * @param response
	 * @param request
	 */
	@RequestMapping
	public void saveForm(FinishedFee finishedFee, HttpServletResponse response, HttpServletRequest request) {
		User user = (User) SessionManager.getAttribute(request, "user");
		if (finishedFee.getId() != null && finishedFee.getId().intValue() != 0) {
			finishedFee = finishedFeeManager.get(finishedFee.getId());
			SpringUtils.bind(finishedFee);
		}

		finishedFee.setPayee(user.getRealName());
		finishedFeeManager.save(finishedFee);
		Order order = orderManager.getByOrderNo(finishedFee.getOrderNo());
		// 加入收支统计
		Expenditure expenditure = expenditureManager.getByEntityId(order.getId(), ExpenditureEnum.TOTALCOST.getType());
		if (expenditure == null) {
			expenditure = new Expenditure();
			expenditure.setEntityId(order.getId());
			expenditure.setType(ExpenditureEnum.TOTALCOST.getType());
			expenditure.setInOrOut(1);
		}
		List<FinishedFee> fees = finishedFeeManager.getListByOrderNo(finishedFee.getOrderNo());
		double cost = 0;
		for (FinishedFee fee : fees) {
			cost+=fee.getHasCount();
		}
		Account account = accountManager.getByAccountNo(finishedFee.getAccountNo());
		expenditure.setChangeDate(expenditure.getCreateDate());
		expenditure.setAccountId(account.getId());
		expenditure.setMoney(cost);
		expenditure.setRemark("<span style=\"color:red\">【订单】</span>" + finishedFee.getOrderNo());
		expenditureManager.save(expenditure);

		JsonUtils.writeJson(response, true);
	}
}
