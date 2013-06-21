package com.app.meibo.offer.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.offer.model.MaterialDetail;
import com.app.meibo.offer.service.MaterialDetailManager;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.util.SessionManager;

@Controller
@RequestMapping("/meibo/offer/materialdetail/*.html")
public class MaterialDetailController {
	
	@Autowired
	private MaterialDetailManager materialDetailManager;
	
	/**
	 * 
	 * @param itemId
	 * @param model
	 */
	@RequestMapping
	public void addDetailForm(Integer itemId, ModelMap model, HttpServletRequest request) {
//		SessionManager.removeAttribute(request, "details");
		model.addAttribute("itemId", itemId);
	}
	
	/**
	 * 列表跳转
	 * @param itemId
	 * @param model
	 */
	@RequestMapping
	public void list(Integer itemId, ModelMap model){
		model.addAttribute("itemId", itemId);
	}
	
	@RequestMapping
	public void index(Integer itemId, ModelMap model){
		model.addAttribute("itemId", itemId);
	}
	
	/**
	 * 列表数据加载
	 * @param response
	 * @param request
	 * @param model
	 * @param itemId
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping
	public void listTempByItemId(HttpServletResponse response, HttpServletRequest request, ModelMap model, Integer itemId){
		List<MaterialDetail> mds = (List<MaterialDetail>) SessionManager.getAttribute(request, "details");
		mds = (mds == null ? new ArrayList<MaterialDetail>() : mds);
		List<MaterialDetail> tempMds = new ArrayList<MaterialDetail>();
		for(MaterialDetail md : mds){
			if(md.getItemId().intValue() == itemId.intValue()){
				tempMds.add(md);
			}
		}
		model.put("total", tempMds.size());
		model.put("rows", tempMds);
		JsonUtils.writeJson(response, model);
	}
	
	/**
	 * 列表数据加载
	 * @param response
	 * @param request
	 * @param model
	 * @param itemId
	 */
	@RequestMapping
	public void listByItemId(HttpServletResponse response, HttpServletRequest request, ModelMap model, Integer itemId){
		List<MaterialDetail> mds = materialDetailManager.listByItemId(itemId);
		model.put("total", mds.size());
		model.put("rows", mds);
		JsonUtils.writeJson(response, model);
	}
	
	/**
	 * 保存到session
	 * @param materialDetail
	 * @param response
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping
	public void saveTempDetail(MaterialDetail materialDetail, HttpServletResponse response, HttpServletRequest request){
		List<MaterialDetail> details = (List<MaterialDetail>) SessionManager.getAttribute(request, "details");
		details = (details == null ? new ArrayList<MaterialDetail>() : details);
		details.add(materialDetail);
		SessionManager.setAttribute(request, "details", details);
		JsonUtils.writeJson(response);
	}
	
}
