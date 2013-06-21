package com.app.meibo.finace.report.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.meibo.finace.report.model.Profit;
import com.app.meibo.finace.report.service.ProfitManager;
import com.app.permission.model.Page;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;

@Controller
@RequestMapping("/finace/report/profit/*.html")
@GlobalAutowired
public class ProfitController {
	private ProfitManager profitManager;

	@RequestMapping
	public void listContent(HttpServletRequest request, ModelMap model, HttpServletResponse response) {
		Page<Profit> page = new Page<Profit>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);
		page.search(page, "Profit", profitManager);

		model.put("total", page.getTotalCount());
		model.put("rows", page.getResult());
		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void addForm(@RequestParam(defaultValue = "0") int id, ModelMap model) {
		Profit profit = null;
		if (id == 0) {
			profit = new Profit();
			profit.setCreateDate(new Date());
		} else {
			profit = profitManager.get(id);
		}
		model.addAttribute("profit", profit);
	}

	@RequestMapping
	public void saveProfit(Profit profit, HttpServletResponse response) {
		profitManager.save(profit);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void delProfit(int id,ModelMap model,HttpServletResponse response) {
		profitManager.delete(id);
		JsonUtils.writeJson(response);
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
