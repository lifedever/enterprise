package com.app.meibo.operationalPart.cooperation.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.meibo.operationalPart.cooperation.model.CooperationFactory;
import com.app.meibo.operationalPart.cooperation.model.vo.CooperationFactoryVO;
import com.app.meibo.operationalPart.cooperation.service.CooperationFactoryManager;
import com.app.permission.model.Page;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;

/**
 * 外发工厂
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-27 下午9:41:15
 */
@Controller
@GlobalAutowired
@RequestMapping("/meibo/operationalPart/cooperation/factory/*.html")
public class CooperationFactoryController {
	private CooperationFactoryManager cooperationFactoryManager;

	@RequestMapping
	public void index() {

	}

	@RequestMapping
	public void listFactorys(){
		
	}
	
	@RequestMapping
	public void listContent(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Page<CooperationFactory> page = new Page<CooperationFactory>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);
		page.search(page, "CooperationFactory", cooperationFactoryManager);
		List<CooperationFactoryVO> cooperationFactories = new ArrayList<CooperationFactoryVO>();
		for (CooperationFactory cooperationFactory : page.getResult()) {
			CooperationFactoryVO vo = new CooperationFactoryVO();
			BeanUtilsEx.copyProperties(vo, cooperationFactory);
			cooperationFactories.add(vo);
		}
		model.put("total", page.getTotalCount());
		model.put("rows", cooperationFactories);
		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void newFactory(@RequestParam(defaultValue = "0") int factoryId, ModelMap model) {
		CooperationFactory cooperationFactory = null;
		if (factoryId == 0) {
			cooperationFactory = new CooperationFactory();
		} else {
			cooperationFactory = cooperationFactoryManager.get(factoryId);
		}
		model.addAttribute("factory", cooperationFactory);
	}

	@RequestMapping
	public void saveFactory(CooperationFactory factory, HttpServletResponse response) {
		cooperationFactoryManager.save(factory);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void delFactory(Integer factoryId, HttpServletResponse response) {
		cooperationFactoryManager.delete(factoryId);
		JsonUtils.writeJson(response);
	}
}
