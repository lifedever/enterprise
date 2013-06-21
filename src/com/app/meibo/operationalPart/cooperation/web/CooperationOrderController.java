package com.app.meibo.operationalPart.cooperation.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.constant.ExpenditureEnum;
import com.app.meibo.constant.FilePathEnum;
import com.app.meibo.finace.expenditure.model.Expenditure;
import com.app.meibo.finace.expenditure.service.ExpenditureManager;
import com.app.meibo.operationalPart.cooperation.model.CooperationOrder;
import com.app.meibo.operationalPart.cooperation.model.vo.CooperationOrderVO;
import com.app.meibo.operationalPart.cooperation.service.CooperationOrderManager;
import com.app.meibo.order.model.OrderItem;
import com.app.meibo.order.service.OrderItemManager;
import com.app.permission.model.Page;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.FileUtils;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;
import com.sqds.util.ParamUtils;

/**
 * 外发
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-27 下午9:41:01
 */
@Controller
@GlobalAutowired
@RequestMapping("/meibo/operationalPart/cooperation/order/*.html")
public class CooperationOrderController {
	private OrderItemManager orderItemManager;
	private CooperationOrderManager cooperationOrderManager;
	private ExpenditureManager expenditureManager;

	@RequestMapping
	public void index() {

	}

	@RequestMapping
	public void listContent(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		
		Page<CooperationOrder> page = new Page<CooperationOrder>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);
		page.search(page, "CooperationOrder", cooperationOrderManager);
		List<CooperationOrderVO> cooperationOrderVOs = new ArrayList<CooperationOrderVO>();
		for (CooperationOrder worksheet : page.getResult()) {
			CooperationOrderVO vo = new CooperationOrderVO();
			BeanUtilsEx.copyProperties(vo, worksheet);
			vo.setIdLogistics(worksheet.getId());
			vo.setIdVehicle(worksheet.getId());
			cooperationOrderVOs.add(vo);
		}

		model.put("total", page.getTotalCount());
		model.put("rows", cooperationOrderVOs);
		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void listAllContent(HttpServletRequest request,String[] query, ModelMap model) {
		Page<CooperationOrder> page = new Page<CooperationOrder>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);
		page.setPageSize(1);
		List<CooperationOrderVO> cooperationOrderVOs = new ArrayList<CooperationOrderVO>();
		page.search(page, "CooperationOrder", cooperationOrderManager);
		for (CooperationOrder worksheet : page.getResult()) {
			CooperationOrderVO vo = new CooperationOrderVO();
			BeanUtilsEx.copyProperties(vo, worksheet);
			cooperationOrderVOs.add(vo);
		}
		for (int i = 2; i <= page.getTotalCount(); i++) {
			page.setPageNo(i);
			page.search(page, "CooperationOrder", cooperationOrderManager);
			for (CooperationOrder worksheet : page.getResult()) {
				CooperationOrderVO vo = new CooperationOrderVO();
				BeanUtilsEx.copyProperties(vo, worksheet);
				cooperationOrderVOs.add(vo);
			}
		}
		model.put("rows", cooperationOrderVOs);
	}

	@RequestMapping
	public void generateCooperationOrder(Integer orderId, ModelMap model) {
		model.addAttribute("orderId", orderId);
	}

	@RequestMapping
	public void createCooperationOrder(Integer orderItemId, ModelMap model) {
		OrderItem orderItem = orderItemManager.get(orderItemId);
		model.addAttribute("orderItem", orderItem);
	}

	@RequestMapping
	public void saveCooperationOrder(String image1, CooperationOrder cooperationOrder, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String image = "";
		if ("1".equals(image1)) {
			image = FileUtils.upload(request, "file", FilePathEnum.PROJECTIMAGE.getPath());
		} else {
			image = image1;
		}
		cooperationOrder.setImage(image);
		cooperationOrderManager.save(cooperationOrder);

		// 加入收支统计
		Expenditure expenditure = expenditureManager.getByEntityId(cooperationOrder.getId(), ExpenditureEnum.TOTALCOST.getType());
		if (expenditure == null) {
			expenditure = new Expenditure();
			expenditure.setEntityId(cooperationOrder.getId());
			expenditure.setType(ExpenditureEnum.COOPERATIONORDER.getType());
			expenditure.setInOrOut(0);
		}
		expenditure.setChangeDate(expenditure.getCreateDate());
		expenditure.setMoney(cooperationOrder.getPrice() * cooperationOrder.getProductCount());
		expenditure.setRemark("<span style=\"color:red\">【外发】</span>" + cooperationOrder.getProductNo());
		expenditureManager.save(expenditure);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void viewCooperationOrder(String productNo, ModelMap model) {
		CooperationOrder cooperationOrder = cooperationOrderManager.getByProductNo(productNo);
		model.addAttribute("cooperationOrder", cooperationOrder);
	}

	@RequestMapping
	public void delCooperationOrder(Integer cooperationOrderId, HttpServletResponse response) {
		cooperationOrderManager.delete(cooperationOrderId);
		Expenditure expenditure = expenditureManager.getByEntityId(cooperationOrderId, ExpenditureEnum.COOPERATIONORDER.getType());
		expenditureManager.deleteObject(expenditure);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void payStatus(Integer orderId, ModelMap model) {
		CooperationOrder order = cooperationOrderManager.get(orderId);
		model.addAttribute("order", order);
	}

	@RequestMapping
	public void saveStatus(Integer id, HttpServletResponse response) {
		CooperationOrder cooperationOrder = cooperationOrderManager.get(id);
		SpringUtils.bind(cooperationOrder);
		cooperationOrderManager.save(cooperationOrder);
		JsonUtils.writeJson(response);

		/* 为了兼容老数据，更新payStatus的null为0 */
		List<CooperationOrder> cooperationOrders = cooperationOrderManager.list("from CooperationOrder c where c.payStatus = null and c.isDelete != 1");
		for (CooperationOrder cooperationOrder2 : cooperationOrders) {
			cooperationOrder2.setPayStatus(0);
			cooperationOrderManager.save(cooperationOrder2);
		}
	}

	/**
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, true));
	}
}
