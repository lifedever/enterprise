package com.app.meibo.storeroom.provider.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.meibo.storeroom.provider.model.CommodityClassify;
import com.app.meibo.storeroom.provider.model.vo.CommodityClassifyVO;
import com.app.meibo.storeroom.provider.service.CommodityClassifyManager;
import com.app.permission.model.Page;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;

/**
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-12-6 下午9:39:39
 */
@Controller
@RequestMapping("/meibo/storeroom/commodity/commodityClassify/*.html")
@GlobalAutowired
public class CommodityClassifyController {
	private CommodityClassifyManager commodityClassifyManager;

	/**
	 * 
	 * @param request
	 * @param model
	 */
	@RequestMapping
	public void index(HttpServletRequest request, ModelMap model) {

	}

	/**
	 * 
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping
	public void listContent(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		Page<CommodityClassify> page = new Page<CommodityClassify>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);// page前台数据绑定
		commodityClassifyManager.search(page);
		List<CommodityClassifyVO> vos = new ArrayList<CommodityClassifyVO>();
		BeanUtilsEx.copyDOListToVOList(CommodityClassifyVO.class,
				page.getResult(), vos);
		model.put("total", page.getTotalCount());
		model.put("rows", vos);
		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void loadCombobox(HttpServletResponse response) {
		List<CommodityClassify> providers = commodityClassifyManager
				.list("from CommodityClassify c where c.isDelete != 1");
		List<CommodityClassifyVO> vos = new ArrayList<CommodityClassifyVO>();
		BeanUtilsEx.copyDOListToVOList(CommodityClassifyVO.class, providers,
				vos);
		JsonUtils.writeJson(response, vos);
	}

	@RequestMapping
	public void saveClassify(HttpServletResponse response,
			CommodityClassify commodity, HttpServletRequest request) {
		if (commodity.getId() != null && commodity.getId().intValue() != 0) {
			commodity = commodityClassifyManager.get(commodity.getId());
			SpringUtils.bind(commodity);
		}
		commodityClassifyManager.save(commodity);
		JsonUtils.writeJson(response, true);
	}

	@RequestMapping
	public void deleteClassify(HttpServletResponse response, String ids) {
		String[] idStrings = ids.split(",");
		for (String str : idStrings) {
			Integer id = Integer.parseInt(str);
			CommodityClassify commodity = commodityClassifyManager.get(id);
			commodity.setIsDelete(1);
			commodityClassifyManager.update(commodity);
		}
		JsonUtils.writeJson(response, true);
	}
	
	@RequestMapping
	public void addForm(@RequestParam(defaultValue = "0")int connodityClassifyId, ModelMap model){
		CommodityClassify commodityClassify = null;
		if(connodityClassifyId == 0){
			commodityClassify = new CommodityClassify();
		}else {
			commodityClassify = commodityClassifyManager.get(connodityClassifyId);
		}
		model.addAttribute("commodityClassify", commodityClassify);
	}

}
