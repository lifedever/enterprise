package com.app.meibo.worksheet.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.order.model.OrderItem;
import com.app.meibo.order.prepare.model.Material;
import com.app.meibo.order.prepare.model.PrepareOrder;
import com.app.meibo.order.prepare.service.PrepareMaterialManager;
import com.app.meibo.order.prepare.service.PrepareOrderManager;
import com.app.meibo.order.service.OrderItemManager;
import com.app.meibo.worksheet.model.Worksheet;
import com.app.meibo.worksheet.model.vo.WorksheetVO;
import com.app.meibo.worksheet.service.WorksheetManager;
import com.app.permission.model.Page;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;

/**
 * 加工单控制器
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-25 下午9:39:35
 */
@Controller
@GlobalAutowired
@RequestMapping("/meibo/worksheet/*.html")
public class WorksheetController {
	private OrderItemManager orderItemManager;
	private PrepareOrderManager prepareOrderManager;
	private PrepareMaterialManager prepareMaterialManager;
	private WorksheetManager worksheetManager;

	@RequestMapping
	public void index() {

	}

	@RequestMapping
	public void generateWorksheet(Integer orderId, ModelMap model) {
		model.addAttribute("orderId", orderId);
	}

	@RequestMapping
	public void listContent(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Page<Worksheet> page = new Page<Worksheet>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);
		page.search(page, "Worksheet", worksheetManager);
		List<WorksheetVO> worksheetVOs = new ArrayList<WorksheetVO>();
		for (Worksheet worksheet : page.getResult()) {
			WorksheetVO vo = new WorksheetVO();
			BeanUtilsEx.copyProperties(vo, worksheet);
			vo.setIdVehicle(worksheet.getId());
			vo.setIdLogistics(worksheet.getId());
			worksheetVOs.add(vo);
		}

		model.put("total", page.getTotalCount());
		model.put("rows", worksheetVOs);
		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void createWorksheet(Integer orderItemId, ModelMap model) {
		OrderItem orderItem = orderItemManager.get(orderItemId);
		PrepareOrder prepareOrder = prepareOrderManager.findByOrderItem(orderItemId);
		if (prepareOrder != null) {
			List<Material> materials = prepareMaterialManager.findbyPrepareOrder(prepareOrder.getId());
			Set<String> classifies = new HashSet<String>();
			Map<String, Set<Material>> materMap = new HashMap<String, Set<Material>>();
			for (Material material : materials) {
				Set<Material> mSet = materMap.get(material.getClassify());
				if (mSet == null) {
					mSet = new HashSet<Material>();
					mSet.add(material);
					materMap.put(material.getClassify(), mSet);
				} else {
					materMap.get(material.getClassify()).add(material);
				}
				classifies.add(material.getClassify());
			}
			model.addAttribute("materMap", materMap);
			model.addAttribute("classifies", classifies);
		}
		model.addAttribute("prepareOrder", prepareOrder);
		model.addAttribute("orderItem", orderItem);
	}

	@RequestMapping
	public void editWorksheet(String productNo, Integer worksheetId, ModelMap model) {
		Worksheet worksheet = null;
		if (worksheetId != null) {
			worksheet = worksheetManager.get(worksheetId);
		} else {
			worksheet = worksheetManager.getByProductNo(productNo);
		}
		PrepareOrder prepareOrder = prepareOrderManager.findByworksheetId(worksheetId);
		if (prepareOrder != null) {
			List<Material> materials = prepareMaterialManager.findbyPrepareOrder(prepareOrder.getId());
			Set<String> classifies = new HashSet<String>();
			Map<String, Set<Material>> materMap = new HashMap<String, Set<Material>>();
			for (Material material : materials) {
				Set<Material> mSet = materMap.get(material.getClassify());
				if (mSet == null) {
					mSet = new HashSet<Material>();
					mSet.add(material);
					materMap.put(material.getClassify(), mSet);
				} else {
					materMap.get(material.getClassify()).add(material);
				}
				classifies.add(material.getClassify());
			}
			model.addAttribute("materMap", materMap);
			model.addAttribute("classifies", classifies);
		}
		model.addAttribute("prepareOrder", prepareOrder);
		model.addAttribute("worksheet", worksheet);
	}

	@RequestMapping
	public void saveWorksheet(Worksheet worksheet, HttpServletResponse response) {
		OrderItem orderItem = orderItemManager.getByProductNo(worksheet.getProductNo());
		worksheet.setIsProof(orderItem.getOrder().getIsProof());
		PrepareOrder prepareOrder = prepareOrderManager.findByOrderItem(orderItem.getId());
		if (prepareOrder != null) {
			prepareOrder.setWorksheet(worksheet);
		}
		orderItemManager.getSession().clear();
		worksheetManager.save(worksheet);
		prepareOrderManager.update(prepareOrder);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void viewWorksheet(String productNo, ModelMap model) {
		Worksheet worksheet = worksheetManager.getByProductNo(productNo);
		PrepareOrder prepareOrder = prepareOrderManager.findByworksheetId(worksheet.getId());
		if (prepareOrder != null) {
			List<Material> materials = prepareMaterialManager.findbyPrepareOrder(prepareOrder.getId());
			Set<String> classifies = new HashSet<String>();
			Map<String, Set<Material>> materMap = new HashMap<String, Set<Material>>();
			for (Material material : materials) {
				Set<Material> mSet = materMap.get(material.getClassify());
				if (mSet == null) {
					mSet = new HashSet<Material>();
					mSet.add(material);
					materMap.put(material.getClassify(), mSet);
				} else {
					materMap.get(material.getClassify()).add(material);
				}
				classifies.add(material.getClassify());
			}
			model.addAttribute("materMap", materMap);
			model.addAttribute("classifies", classifies);
		}
		model.addAttribute("prepareOrder", prepareOrder);
		model.addAttribute("worksheet", worksheet);
	}

	@RequestMapping
	public void delWorksheet(Integer worksheetId, HttpServletResponse response) {
		PrepareOrder prepareOrder = prepareOrderManager.findByworksheetId(worksheetId);
		if (prepareOrder != null) {
			prepareOrder.setWorksheet(null);
			prepareOrderManager.update(prepareOrder);
		}
		prepareOrderManager.getSession().clear();
		worksheetManager.delete(worksheetId);
		JsonUtils.writeJson(response);
	}

	/**
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日hh时");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, true));
	}
}
