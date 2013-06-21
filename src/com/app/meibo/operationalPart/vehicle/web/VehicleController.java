package com.app.meibo.operationalPart.vehicle.web;

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
import com.app.meibo.operationalPart.vehicle.model.Vehicle;
import com.app.meibo.operationalPart.vehicle.service.VehicleManager;
import com.app.meibo.worksheet.model.Worksheet;
import com.app.meibo.worksheet.service.WorksheetManager;
import com.app.permission.model.Page;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;

/**
 * 车辆
 * 
 * @author MSQ
 * @email gefangshuai@163.com
 * @createdata 2013-3-21 下午10:40:12
 */
@Controller
@RequestMapping("/meibo/operationalPart/vehicle/*.html")
public class VehicleController {
	@Autowired
	private VehicleManager vehicleManager;
	@Autowired
	private WorksheetManager worksheetManager;
	@Autowired
	private CooperationOrderManager cooperationOrderManager;
	
	@RequestMapping
	public void index() {

	}

	/**
	 * 加工单管理查看车辆
	 * 
	 * @param productId
	 * @param model
	 */
	@RequestMapping
	public void indexForWorksheet(String productNo, ModelMap model) {
		model.addAttribute("productNo", productNo);
	}
	
	/**
	 * 外发单查看车辆
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
	public void listContent(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		Page<Vehicle> page = new Page<Vehicle>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);
		page.search(page, "Vehicle", vehicleManager);
		List<Vehicle> vehicles = page.getResult();

		model.put("total", page.getTotalCount());
		model.put("rows", vehicles);
		JsonUtils.writeJson(response, model);
	}

	/**
	 * 添加页面跳转
	 * 
	 * @param productId
	 * @param vehicleId
	 * @param request
	 * @param model
	 */
	@RequestMapping
	public void addForm(@RequestParam(defaultValue = "0") int productId,
			@RequestParam(defaultValue = "0") int cooperationOrderId,
			@RequestParam(defaultValue = "0") int vehicleId,
			HttpServletRequest request, ModelMap model) {
		Vehicle vehicle = null;
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
		if (vehicleId == 0) {
			vehicle = new Vehicle();
		} else {
			vehicle = vehicleManager.get(vehicleId);
		}
		model.addAttribute("vehicle", vehicle);
	}

	/**
	 * 保存
	 * 
	 * @param vehicle
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping
	public void saveForm(Vehicle vehicle, HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		if (vehicle.getId() != null && vehicle.getId() != 0) {
			vehicle = vehicleManager.get(vehicle.getId());
			SpringUtils.bind(vehicle);
		}
		vehicleManager.save(vehicle);
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
			vehicleManager.delete(id);
		}
		JsonUtils.writeJson(response, true);
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
