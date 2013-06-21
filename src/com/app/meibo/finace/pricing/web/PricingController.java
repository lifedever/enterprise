package com.app.meibo.finace.pricing.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.storeroom.provider.model.Commodity;
import com.app.meibo.storeroom.provider.model.vo.CommodityVO;
import com.app.meibo.storeroom.provider.service.CommodityManager;
import com.app.permission.model.Page;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;

/**
 * 材料定价
 * @author MSQ
 * @email gefangshuai@163.com
 * @createdata 2013-3-1 下午10:11:52
 */
@Controller
@GlobalAutowired
@RequestMapping("/finace/pricing/*.html")
public class PricingController {
	
	private CommodityManager commodityManager;
	
	/**
	 * 跳转材料列表页面
	 * @param request
	 * @param model
	 */
	@RequestMapping
	public void index(HttpServletRequest request, ModelMap model){
		
	}
	
	
	@RequestMapping
	public void listContent(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Page<Commodity> page = new Page<Commodity>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);// page前台数据绑定
		page.search(page, "Commodity", commodityManager);
		List<Commodity> commodities = page.getResult();
		List<CommodityVO> commodityVOs = new ArrayList<CommodityVO>();
		for (Commodity commodity : commodities) {
			CommodityVO vo = new CommodityVO();
			BeanUtilsEx.copyProperties(vo, commodity);
			if (commodity.getProvider()!=null) {
				vo.setProviderName(commodity.getProvider().getCompanyName());
				vo.setProviderId(commodity.getProvider().getId());
			}
			if (commodity.getCommodityClassify() != null) {
				vo.setClassifyName(commodity.getCommodityClassify().getClassifyName());
				vo.setClassifyId(commodity.getCommodityClassify().getId());
			}
			commodityVOs.add(vo);
		}
		model.put("total", page.getTotalCount());
		model.put("rows", commodityVOs);
		JsonUtils.writeJson(response, model);
	}
	
	
	/**
	 * 定价页面跳转
	 * @param request
	 * @param model
	 */
	@RequestMapping
	public void addForm(Integer commodityId, HttpServletRequest request, ModelMap model){
		Commodity commodity = commodityManager.get(commodityId);
		model.put("commodity", commodity);
	}
	
	/**
	 * 保存定价
	 * @param commodity
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping
	public void savePricing(Commodity commodity, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		commodity = commodityManager.get(commodity.getId());
		SpringUtils.bind(commodity);
		commodityManager.save(commodity);
		JsonUtils.writeJson(response, true);
	}
}
