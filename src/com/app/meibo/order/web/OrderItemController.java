package com.app.meibo.order.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.operationalPart.cooperation.model.CooperationOrder;
import com.app.meibo.operationalPart.cooperation.service.CooperationOrderManager;
import com.app.meibo.order.model.OrderItem;
import com.app.meibo.order.model.vo.OrderItemVO;
import com.app.meibo.order.prepare.model.PrepareOrder;
import com.app.meibo.order.prepare.service.PrepareOrderManager;
import com.app.meibo.order.service.OrderItemManager;
import com.app.meibo.worksheet.model.Worksheet;
import com.app.meibo.worksheet.service.WorksheetManager;
import com.app.permission.model.Page;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;

/**
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-17 下午8:33:17
 */
@Controller
@RequestMapping("/meibo/order/orderItem")
@GlobalAutowired
public class OrderItemController {
	private OrderItemManager orderItemManager;
	private PrepareOrderManager prepareOrderManager;
	private WorksheetManager worksheetManager;
	private CooperationOrderManager cooperationOrderManager;

	@RequestMapping("listContent.html")
	public void listContent(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Page<OrderItem> page = new Page<OrderItem>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);
		page.search(page, "OrderItem", orderItemManager);
		List<OrderItemVO> orderItemVOs = new ArrayList<OrderItemVO>();
		for (OrderItem orderItem : page.getResult()) {
			OrderItemVO vo = new OrderItemVO();
			BeanUtilsEx.copyProperties(vo, orderItem);
			PrepareOrder prepareOrder = prepareOrderManager.findByOrderItem(orderItem.getId());
			if (prepareOrder != null) {
				vo.setIsPrepared(1);
				vo.setPrepareNo(prepareOrder.getPrepareNo());
			}
			Worksheet worksheet = worksheetManager.getByProductNo(orderItem.getProductNo());
			if (worksheet != null) {
				vo.setIsWorksheet(1);
			}
			CooperationOrder cooperationOrder = cooperationOrderManager.getByProductNo(orderItem.getProductNo());
			if (cooperationOrder != null) {
				vo.setIsCooperate(1);
			}
			orderItemVOs.add(vo);
		}

		model.put("total", page.getTotalCount());
		model.put("rows", orderItemVOs);
		JsonUtils.writeJson(response, model);
	}
	
	@RequestMapping("packingForm.html")
	public void packingForm(ModelMap model, Integer itemId){
		OrderItem item = orderItemManager.get(itemId);
		int count = item.getProductCount();
		int single = item.getSinglebox();
		if(single != 0){
			if(count % single == 0){
				item.setTotalbox(count/single);
			}else {
				item.setTotalbox((int)(count/single)+1);
			}
		}
		model.put("orderItem", item);
	}
	
	/**
	 * 装箱
	 * @param orderItem
	 * @param response
	 * @param request
	 */
	@RequestMapping("packing.html")
	public void packing(OrderItem orderItem, HttpServletResponse response, HttpServletRequest request){
		if(orderItem.getId() != null && orderItem.getId().intValue() != 0){
			orderItem = orderItemManager.get(orderItem.getId());
			SpringUtils.bind(orderItem);
			orderItemManager.update(orderItem);
			JsonUtils.writeJson(response, true);
		}
	}
}
