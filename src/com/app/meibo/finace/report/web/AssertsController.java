package com.app.meibo.finace.report.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.finace.report.model.Asserts;
import com.app.meibo.finace.report.model.Profit;
import com.app.meibo.finace.report.service.AssertsManager;
import com.app.meibo.finace.report.service.Asserts_aManager;
import com.app.meibo.finace.report.service.Asserts_bManager;
import com.app.permission.model.Page;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;

@Controller
@RequestMapping("/finace/report/asserts/*.html")
@GlobalAutowired
public class AssertsController {
	private AssertsManager assertsManager;
	private Asserts_aManager asserts_aManager;
	private Asserts_bManager asserts_bManager;

	@RequestMapping
	public void listContent(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		Page<Asserts> page = new Page<Asserts>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);
		page.search(page, "Asserts", assertsManager);

		model.put("total", page.getTotalCount());
		model.put("rows", page.getResult());
		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void addForm(Integer id, ModelMap model) {
		Asserts asserts = null;
		if (null == id || id == 0) {
			asserts = new Asserts();
		} else {
			asserts = assertsManager.get(id);
		}
		model.addAttribute("asserts", asserts);
	}

	@RequestMapping
	public void saveAsserts(Asserts asserts, HttpServletResponse response, ModelMap model) {
		assertsManager.save(asserts);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void delAsserts(Integer id, ModelMap model, HttpServletResponse response) {
		Asserts asserts = assertsManager.get(id);
		int aid = asserts.getAsserts_a().getId();
		int bid = asserts.getAsserts_b().getId();
		assertsManager.delete(id);
		asserts_aManager.delete(aid);
		asserts_bManager.delete(bid);
		JsonUtils.writeJson(response);
	}
}
