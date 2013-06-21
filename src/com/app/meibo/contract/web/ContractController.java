package com.app.meibo.contract.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.constant.FilePathEnum;
import com.app.meibo.contract.model.Contract;
import com.app.meibo.contract.model.vo.ContractVO;
import com.app.meibo.contract.service.ContractManager;
import com.app.meibo.order.model.Order;
import com.app.meibo.order.service.OrderManager;
import com.app.permission.model.Page;
import com.app.permission.model.User;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.FileUtils;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;
import com.sqds.util.SessionManager;

@Controller
@RequestMapping("/meibo/contract/*.html")
@GlobalAutowired
public class ContractController {
	private OrderManager orderManager;
	private ContractManager contractManager;

	@RequestMapping
	public void index() {

	}

	@RequestMapping
	public void listContent(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Page<Contract> page = new Page<Contract>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);
		page.search(page, "Contract", contractManager);
		List<ContractVO> contractVOs = new ArrayList<ContractVO>();
		for (Contract contract : page.getResult()) {
			ContractVO vo = new ContractVO();
			BeanUtilsEx.copyProperties(vo, contract);
			vo.setOrderNo(contract.getOrder().getOrderNo());
			vo.setOrderId(contract.getOrder().getId());
			contractVOs.add(vo);
		}
		model.put("total", page.getTotalCount());
		model.put("rows", contractVOs);
		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void signForm(String orderNo, ModelMap model) {
		model.addAttribute("contractNo", contractManager.generateOrderNo());
		model.addAttribute("orderNo", orderNo);
	}

	/**
	 * 保存
	 * 
	 * @param contract
	 * @param response
	 * @param model
	 * @throws IOException 
	 */
	@RequestMapping
	public void saveContract(Contract contract, HttpServletResponse response,String orderNo, ModelMap model, HttpServletRequest request) throws IOException {
		Order order = orderManager.getByOrderNo(orderNo);
		contract.setOrder(order);
		
			String path = FileUtils.upload(request, "atta", FilePathEnum.CONTRACT_ATTA.getPath());
			contract.setContractAtta(path);
		User user = (User) SessionManager.getAttribute(request, "user");
		contract.setUserId(user.getId());
		contract.setDepartmentId(user.getDepartment().getId());
		contractManager.save(contract);
		order.setSignState(1);
		orderManager.update(order);
		JsonUtils.writeJson(response);
	}

	/**
	 * 取消签单
	 */
	@RequestMapping
	public void cancelSign(String orderNo, HttpServletResponse response) {
		Order order = orderManager.getByOrderNo(orderNo);
		Contract contract = contractManager.getByOrderId(order.getId());
		contractManager.deleteObject(contract);
		order.setSignState(0);
		orderManager.update(order);
		JsonUtils.writeJson(response);
	}

	/**
	 * 查看签单
	 */
	@RequestMapping
	public void viewSign(String orderNo, ModelMap model) {
		Order order = orderManager.getByOrderNo(orderNo);
		Contract contract = contractManager.getByOrderId(order.getId());
		model.addAttribute("order", order);
		model.addAttribute("contract", contract);
	}

	/**
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, true));
	}
}
