package com.app.meibo.operationalPart.logistics.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.meibo.operationalPart.cooperation.model.CooperationOrder;
import com.app.meibo.operationalPart.cooperation.service.CooperationOrderManager;
import com.app.meibo.operationalPart.logistics.model.Logistics;
import com.app.meibo.operationalPart.logistics.service.LogisticsManager;
import com.app.meibo.worksheet.model.Worksheet;
import com.app.meibo.worksheet.service.WorksheetManager;
import com.app.permission.model.Page;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;

/**
 * 
 * @author MSQ
 * @email gefangshuai@163.com
 * @createdata 2013-3-21 下午10:40:12
 */
@Controller
@RequestMapping("/meibo/operationalPart/logistics/*.html")
public class LogisticsController {
	@Autowired
	private LogisticsManager logisticeManager;
	@Autowired
	private WorksheetManager worksheetManager;
	@Autowired
	private CooperationOrderManager cooperationOrderManager;
	
	@RequestMapping
	public void index() {

	}
	
	/**
	 * 加工单查看物流列表
	 * @param orderNo
	 * @param model
	 */
	@RequestMapping
	public void indexForWorksheet(String orderNo, ModelMap model){
		model.addAttribute("orderNo", orderNo);
	}
	
	/**
	 * 外发单查看物流列表
	 * @param orderNo
	 * @param model
	 */
	@RequestMapping
	public void indexForCooperation(String orderNo, ModelMap model) {
		model.addAttribute("orderNo", orderNo);
	}

	/**
	 * 列表数据加载
	 * 
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping
	public void listContent(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Page<Logistics> page = new Page<Logistics>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);
		page.search(page, "Logistics", logisticeManager);
		List<Logistics> Logisticses = page.getResult();

		model.put("total", page.getTotalCount());
		model.put("rows", Logisticses);
		JsonUtils.writeJson(response, model);
	}

	/**
	 * 添加页面跳转
	 * 
	 * @param logisticsId
	 * @param request
	 * @param model
	 */
	@RequestMapping
	public void addForm(@RequestParam(defaultValue = "0") int productId,
			@RequestParam(defaultValue = "0") int cooperationOrderId,
			@RequestParam(defaultValue = "0") int logisticsId, HttpServletRequest request, ModelMap model) {
		Logistics logistics = null;
		CooperationOrder cooperationOrder = null;
		Worksheet worksheet = null;
		if (productId != 0) {
			worksheet = worksheetManager.get(productId);
			model.addAttribute("productNo", worksheet.getProductNo());
		}
		if(cooperationOrderId != 0){
			cooperationOrder = cooperationOrderManager.get(cooperationOrderId);
			model.addAttribute("productNo", cooperationOrder.getProductNo());
		}
		if (logisticsId == 0) {
			logistics = new Logistics();
		} else {
			logistics = logisticeManager.get(logisticsId);
		}
		model.addAttribute("logistics", logistics);
	}

	/**
	 * 保存
	 * 
	 * @param logistics
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping
	public void saveForm(Logistics logistics, HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		if (logistics.getId() != null && logistics.getId() != 0) {
			logistics = logisticeManager.get(logistics.getId());
			SpringUtils.bind(logistics);
		}
		logisticeManager.save(logistics);
		JsonUtils.writeJson(response, true);
	}

	/**
	 * 删除
	 * 
	 * @param response
	 * @param ids
	 */
	@RequestMapping
	public void delete(HttpServletResponse response, String ids) {
		String[] idStrings = ids.split(",");
		for (String str : idStrings) {
			Integer id = Integer.parseInt(str);
			logisticeManager.delete(id);
		}
		JsonUtils.writeJson(response, true);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, true));
	}
}
