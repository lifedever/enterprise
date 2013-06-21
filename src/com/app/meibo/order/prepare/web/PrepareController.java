package com.app.meibo.order.prepare.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.order.model.Order;
import com.app.meibo.order.model.OrderItem;
import com.app.meibo.order.prepare.model.Material;
import com.app.meibo.order.prepare.model.PrepareOrder;
import com.app.meibo.order.prepare.service.PrepareMaterialManager;
import com.app.meibo.order.prepare.service.PrepareOrderManager;
import com.app.meibo.order.service.OrderItemManager;
import com.app.meibo.order.service.OrderManager;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.annotation.GlobalAutowired;
import com.sqds.util.ParamUtils;
import com.sqds.util.SessionManager;

/**
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-23 下午4:47:57
 */
@SuppressWarnings("unchecked")
@Controller
@RequestMapping("/meibo/order/prepare/*.html")
@GlobalAutowired
public class PrepareController {
	private OrderManager orderManager;
	private OrderItemManager orderItemManager;
	private PrepareOrderManager prepareOrderManager;
	private PrepareMaterialManager prepareMaterialManager;

	@RequestMapping
	public void prepareMaterialForm(Integer orderId, ModelMap model) {
		Order order = orderManager.get(orderId);
		model.addAttribute("order", order);
	}

	@RequestMapping
	public void prepareMaterialAdd(Integer orderItemId, HttpServletRequest request, ModelMap model) {
		SessionManager.removeAttribute(request, "materials");
		OrderItem orderItem = orderItemManager.get(orderItemId);
		model.addAttribute("orderItem", orderItem);
	}

	@RequestMapping
	public void addMaterial(Integer prepareOrderId, ModelMap model) {
	}

	@RequestMapping
	public void listTempMaterials(HttpServletResponse response, ModelMap model, HttpServletRequest request) {
		List<Material> materials = (List<Material>) SessionManager.getAttribute(request, "materials");
		if (materials == null)
			materials = new ArrayList<Material>();
		model.put("rows", materials);
		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void saveTempMaterial(Material material, HttpServletResponse response, HttpServletRequest request) {
		List<Material> materials = (List<Material>) SessionManager.getAttribute(request, "materials");
		if (materials == null)
			materials = new ArrayList<Material>();
		materials.add(material);
		SessionManager.setAttribute(request, "materials", materials);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void savePrepareOrder(PrepareOrder prepareOrder, HttpServletResponse response, HttpServletRequest request) {
		Integer orderItemId = ParamUtils.getInteger("orderItemId", 0);
		prepareOrder.setOrderItem(orderItemManager.get(orderItemId));
		prepareOrder.setPrepareNo(prepareOrderManager.generatePrepareNo());
		prepareOrderManager.save(prepareOrder);
		List<Material> materials = (List<Material>) SessionManager.getAttribute(request, "materials");
		if (materials != null) {
			for (Material material : materials) {
				material.setPrepareOrder(prepareOrder);
				prepareMaterialManager.save(material);
			}
		}
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void viewPrepare(String prepareNo, ModelMap model) {

		PrepareOrder prepareOrder = prepareOrderManager.findByPrepareNo(prepareNo);
		List<Material> materials = prepareMaterialManager.findbyPrepareOrder(prepareOrder.getId());
		Set<String> classifies = new HashSet<String>();
		Map<String,Set<Material>> materMap = new HashMap<String, Set<Material>>();
		for (Material material : materials) {
			Set<Material> mSet = materMap.get(material.getClassify());
			if(mSet==null){
				mSet = new HashSet<Material>();
				mSet.add(material);
				materMap.put(material.getClassify(), mSet);
			}else {
				materMap.get(material.getClassify()).add(material);
			}
			classifies.add(material.getClassify());
		}
		model.addAttribute("materMap",materMap);
		model.addAttribute("classifies", classifies);
		model.addAttribute("prepareOrder", prepareOrder);
	}
}
