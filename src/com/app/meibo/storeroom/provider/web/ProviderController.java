package com.app.meibo.storeroom.provider.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.meibo.storeroom.provider.model.Provider;
import com.app.meibo.storeroom.provider.model.vo.ProviderVO;
import com.app.meibo.storeroom.provider.service.ProviderManager;
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
@RequestMapping("/meibo/storeroom/commodity/provider/*.html")
@GlobalAutowired
public class ProviderController {
	private ProviderManager providerManager;

	@RequestMapping
	public void index(HttpServletRequest request, ModelMap model) {

	}

	/**
	 * 
	 * @param response
	 * @param model
	 */
	@RequestMapping
	public void listContent(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Page<Provider> page = new Page<Provider>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);// page前台数据绑定
		providerManager.search(page);
		List<ProviderVO> providerVOs = new ArrayList<ProviderVO>();
		BeanUtilsEx.copyDOListToVOList(ProviderVO.class, page.getResult(), providerVOs);
		model.put("total", page.getTotalCount());
		model.put("rows", providerVOs);
		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void addForm(@RequestParam(defaultValue = "0") int providerId, ModelMap model){
		Provider provider = null;
		if(providerId == 0){
			provider = new Provider();
		}else {
			provider = providerManager.get(providerId);
		}
		model.addAttribute("provider", provider);
	}
	
	@RequestMapping
	public void saveProvider(Provider provider, HttpServletResponse response, HttpServletRequest request){
		if(provider.getId() != null && provider.getId().intValue() != 0){
			provider = providerManager.get(provider.getId());
			SpringUtils.bind(provider);
		}
		providerManager.save(provider);
		JsonUtils.writeJson(response, true);
	}

	@RequestMapping
	public void deleteProvider(HttpServletResponse response, String ids) {
		String[] idStrings = ids.split(",");
		for (String str : idStrings) {
			Integer id = Integer.parseInt(str);
			Provider provider = providerManager.get(id);
			provider.setIsDelete(1);
			providerManager.update(provider);
		}
		JsonUtils.writeJson(response, true);
	}

	@RequestMapping
	public void loadCombobox(HttpServletResponse response) {
		List<Provider> providers = providerManager.list("from Provider p where p.isDelete != 1");
		List<ProviderVO> vos = new ArrayList<ProviderVO>();
		BeanUtilsEx.copyDOListToVOList(ProviderVO.class, providers, vos);
		JsonUtils.writeJson(response, vos);
	}
}
