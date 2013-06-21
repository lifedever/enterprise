package com.app.meibo.order.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.contract.model.Contract;
import com.app.meibo.contract.service.ContractManager;
import com.app.meibo.customer.model.Customer;
import com.app.meibo.customer.service.CustomerManager;
import com.app.meibo.finace.model.FinishedFee;
import com.app.meibo.finace.service.FinishedFeeManager;
import com.app.meibo.offer.model.Offer;
import com.app.meibo.offer.model.OfferItem;
import com.app.meibo.offer.service.OfferItemManager;
import com.app.meibo.offer.service.OfferManager;
import com.app.meibo.order.model.Order;
import com.app.meibo.order.model.OrderItem;
import com.app.meibo.order.model.vo.OrderVO;
import com.app.meibo.order.prepare.model.Material;
import com.app.meibo.order.prepare.model.PrepareOrder;
import com.app.meibo.order.prepare.service.PrepareMaterialManager;
import com.app.meibo.order.prepare.service.PrepareOrderManager;
import com.app.meibo.order.service.OrderItemManager;
import com.app.meibo.order.service.OrderManager;
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
 * @createdata 2013-2-17 下午8:33:17
 */
@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/meibo/order/*.html")
@GlobalAutowired
public class OrderController {
	private OrderManager orderManager;
	private OrderItemManager orderItemManager;
	private CustomerManager customerManager;
	private OfferManager offerManager;
	private OfferItemManager offerItemManager;
	private ContractManager contractManager;
	private PrepareOrderManager prepareOrderManager;
	private PrepareMaterialManager prepareMaterialManager;
	private UserManager userManager;
	private FinishedFeeManager finishedFeeManager;

	@RequestMapping
	public void index() {

	}

	@RequestMapping
	public void listContent(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		Page<Order> page = new Page<Order>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);
		page.search(page, "Order", orderManager);
		List<OrderVO> orderVOs = new ArrayList<OrderVO>();
		for (Order order : page.getResult()) {
			OrderVO vo = new OrderVO();
			BeanUtilsEx.copyProperties(vo, order);
			if (order.getSignState() == 1 && order.getIsProof() == 0) {
				Contract contract = contractManager.getByOrderId(order.getId());
				if (contract != null) {
					vo.setContractNo(contract.getContractNo());
				}
			}

			// 已收款和全款
			double countMoney = 0;
			List<OrderItem> orderItems = orderItemManager
					.getListByOrderNo(order.getOrderNo());
			for (OrderItem orderItem : orderItems) {
				countMoney += (orderItem.getPrice() * orderItem
						.getProductCount());
			}
			double hasMoney = 0;
			List<FinishedFee> finishedFees = finishedFeeManager
					.getListByOrderNo(order.getOrderNo());
			for (FinishedFee finishedFee : finishedFees) {
				hasMoney += finishedFee.getHasCount();
			}
			vo.setAllCount(countMoney);
			vo.setHasCount(hasMoney);

			vo.setCustomerName(order.getCustomer().getCustomerName());
			vo.setCustomerId(order.getCustomer().getId());
			vo.setUsername(userManager.get(order.getUserId()).getRealName());
			orderVOs.add(vo);
		}
		model.put("total", page.getTotalCount());
		model.put("rows", orderVOs);
		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void saveOrder(Order order, Integer customerId,
			HttpServletResponse response, HttpServletRequest request) {
		User user = (User) SessionManager.getAttribute(request, "user");
		Customer customer = customerManager.get(customerId);
		order.setUserId(user.getId());
		order.setDepartmentId(user.getDepartment().getId());
		order.setCustomer(customer);
		order.setOrderNo(orderManager.generateOrderNo());
		if (order.getIsProof() == 1) {
			order.setSignState(1);
		}
		orderManager.save(order);
		Set<OrderItem> orderItems = (Set<OrderItem>) SessionManager
				.getAttribute(request, "orderItems");
		Iterator<OrderItem> iterable = orderItems.iterator();
		if (iterable.hasNext()) {
			OfferItem offerItem = offerItemManager.get(iterable.next().getId());
			Offer offer = offerItem.getOffer();
			offer.setIsOrder(1);
			offer.setOrderNo(order.getOrderNo());
			offerManager.update(offer);
		}
		for (OrderItem item : orderItems) {
			item.setId(null);
			item.setOrder(order);
			item.setProductNo(orderItemManager.generateOrderItemNo());
			orderItemManager.save(item);
		}
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void viewOrderByOrderNo(String orderNo, ModelMap model) {
		Order order = orderManager.getByOrderNo(orderNo);
		model.addAttribute("order", order);
	}

	/**
	 * 取消订单
	 */
	@RequestMapping
	public void cancelOrder(Integer orderId, HttpServletResponse response) {
		Order order = orderManager.get(orderId);
		List<OrderItem> orderItems = orderItemManager.getListByOrderNo(order
				.getOrderNo());
		for (OrderItem orderItem : orderItems) {
			PrepareOrder prepareOrder = prepareOrderManager
					.findByOrderItem(orderItem.getId());
			if (prepareOrder != null) {
				List<Material> materials = prepareMaterialManager
						.findbyPrepareOrder(prepareOrder.getId());
				prepareMaterialManager.removeObjects(materials);
				prepareOrderManager.deleteObject(prepareOrder);
			}
			orderItemManager.deleteObject(orderItem);
		}
		Offer offer = offerManager.getByOrderNo(order.getOrderNo());
		if (offer != null) {
			offer.setIsOrder(0);
			offer.setOrderNo(null);
		}
		offerManager.update(offer);
		orderManager.deleteObject(order);
		JsonUtils.writeJson(response);
	}

	/**
	 * 更新订单状态
	 * 
	 * @param model
	 * @param oederId
	 */
	@RequestMapping
	public void updateStatus(ModelMap model, Integer orderId) {
		Order order = orderManager.get(orderId);
		model.addAttribute("order", order);
	}

	/**
	 * 更新状态
	 * @param order
	 * @param response
	 * @param request
	 */
	@RequestMapping
	public void update(Order order, HttpServletResponse response, HttpServletRequest request){
		if(order.getId() != null && order.getId().intValue() != 0){
			order = orderManager.get(order.getId());
			SpringUtils.bind(order);
			orderManager.update(order);
			JsonUtils.writeJson(response, true);
		}
	}
	/**
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(
				dateFormat, true));
	}
}
