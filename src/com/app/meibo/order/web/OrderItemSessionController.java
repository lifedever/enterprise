package com.app.meibo.order.web;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.constant.FilePathEnum;
import com.app.meibo.offer.model.OfferItem;
import com.app.meibo.offer.model.OfferMoney;
import com.app.meibo.offer.service.OfferItemManager;
import com.app.meibo.offer.service.OfferMoneyManager;
import com.app.meibo.order.model.OrderItem;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.FileUtils;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.annotation.GlobalAutowired;
import com.sqds.util.SessionManager;

/**
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-17 下午8:33:17
 */
@Controller
@RequestMapping("/meibo/order/orderItem")
@GlobalAutowired
public class OrderItemSessionController {
	private OfferItemManager offerItemManager;
	private OfferMoneyManager offerMoneyManager;

	/**
	 * 保存列表到session
	 * 
	 * @param ids
	 * @param response
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("saveTempOrderItem.html")
	public void saveTempOrderItem(Integer[] ids, HttpServletResponse response, HttpServletRequest request) {
		Set<OrderItem> orderItems = (Set<OrderItem>) SessionManager.getAttribute(request, "orderItems");
		orderItems = (orderItems == null ? new HashSet<OrderItem>() : orderItems);
		
		for (Integer id : ids) {
			OfferItem offerItem = offerItemManager.get(id);
			OrderItem item = new OrderItem();
			BeanUtilsEx.copyProperties(item, offerItem);
			OfferMoney offerMoney = offerMoneyManager.getLast(offerItem.getId());
			if (offerMoney != null) {
				item.setPrice(offerMoney.getPrice());
			}
			for (OrderItem item2 : orderItems) {
				if (item2.equals(item)) {
					BeanUtilsEx.copyProperties(item2, item);
				}
			}
			orderItems.add(item);
			SessionManager.setAttribute(request, "orderItems", orderItems);
			JsonUtils.writeJson(response);
		}
	}

	/**
	 * 从session中显示列表
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("listTempContent.html")
	public void listTempContent(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Set<OrderItem> orderItems = (Set<OrderItem>) SessionManager.getAttribute(request, "orderItems");
		orderItems = (orderItems == null ? new HashSet<OrderItem>() : orderItems);
		model.put("total", orderItems.size());
		model.put("rows", orderItems);
		JsonUtils.writeJson(response, model);
	}

	/**
	 * @param request
	 * @param orderItemid
	 * @param model
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("formTempOrderItem.html")
	public void formTempOrderItem(HttpServletRequest request, Integer orderItemid, ModelMap model) {
		OrderItem tempOrderItem = null;
		Set<OrderItem> orderItems = (Set<OrderItem>) SessionManager.getAttribute(request, "orderItems");
		for (OrderItem item : orderItems) {
			if (item.getId().intValue() == orderItemid.intValue()) {
				tempOrderItem = item;
				break;
			}
		}
		model.addAttribute("orderItem", tempOrderItem);
	}

	/**
	 * 编辑session中的条目
	 * 
	 * @param response
	 * @param orderItem
	 * @param model
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping("editTempOrderItem.html")
	public void editTempOrderItem(HttpServletResponse response, HttpServletRequest request, OrderItem orderItem, ModelMap model) throws IOException {
		Set<OrderItem> orderItems = (Set<OrderItem>) SessionManager.getAttribute(request, "orderItems");
		OfferItem offerItem = offerItemManager.get(orderItem.getId());
		OfferMoney offerMoney = offerMoneyManager.getLast(offerItem.getId());
		for (OrderItem item : orderItems) {
			if (item.getId().intValue()==orderItem.getId().intValue()) {
				BeanUtilsEx.copyProperties(item, orderItem);
				if (offerMoney != null) {
					item.setPrice(offerMoney.getPrice()*item.getProductCount());
					String projectImage = "";
					String effectImage = "";
					projectImage = FileUtils.upload(request, "file1", FilePathEnum.PROJECTIMAGE.getPath());
					effectImage = FileUtils.upload(request, "file2", FilePathEnum.PROJECTIMAGE.getPath());
					if ("".equals(projectImage)) {
						projectImage = offerItem.getProjectImage();
					}					
					if ("".equals(effectImage)) {
						effectImage = offerItem.getEffectImage();
					}
					item.setProjectImage(projectImage);
					item.setEffectImage(effectImage);
				}
			}
		}
		JsonUtils.writeJson(response);
	}

	/**
	 * 从session中删除
	 * 
	 * @param orderItemid
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping("removeTempOrderItem.html")
	public void removeTempOrderItem(Integer orderItemid, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		JsonUtils.writeJson(response, model);
		@SuppressWarnings("unchecked")
		Set<OrderItem> orderItems = (Set<OrderItem>) SessionManager.getAttribute(request, "orderItems");
		for (OrderItem item : orderItems) {
			if (item.getId().intValue() == orderItemid.intValue()) {
				orderItems.remove(item);
			}
		}
		JsonUtils.writeJson(response, model);
	}
}
