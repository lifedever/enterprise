package com.app.meibo.statistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.constant.ExpenditureEnum;
import com.app.meibo.finace.expenditure.service.ExpenditureManager;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.annotation.GlobalAutowired;

/**
 * 订单收入统计
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-1-12 下午8:50:25
 */
@Controller
@RequestMapping("/statistics/prorder/*.html")
@GlobalAutowired
public class ProrderStatisticsController {
	private ExpenditureManager expenditureManager;

	@RequestMapping
	public void index() {

	}

	/**
	 * 年统计
	 */
	@RequestMapping
	public void years() {

	}

	/**
	 * 月统计
	 * 
	 * @param year
	 * @param model
	 */
	@RequestMapping
	public void months(int year, ModelMap model) {
		model.addAttribute("year", year);
	}

	/**
	 * 统计年
	 * 
	 * @param response
	 * @param model
	 * @param year
	 */
	@RequestMapping
	public void getYearData(HttpServletResponse response, ModelMap model) {
		Map<String, Double> outData = expenditureManager.getYearData(1, ExpenditureEnum.TOTALCOST.getType());
		Map<String, Integer> mountDate = expenditureManager.getYearMount(1, ExpenditureEnum.TOTALCOST.getType());
		Set<String> set = outData.keySet();
		List<Double> outMoney = new ArrayList<Double>();
		List<Integer> counts = new ArrayList<Integer>();
		for (String string : set) {
			outMoney.add(outData.get(string) / 10000);
			counts.add(mountDate.get(string));
		}
		model.put("year", set);
		model.put("out", outMoney);
		model.put("counts", counts);
		JsonUtils.writeJson(response, model);
	}

	/**
	 * 统计某年所有月份
	 * 
	 * @param response
	 * @param model
	 * @param year
	 */
	@RequestMapping
	public void getMonthData(HttpServletResponse response, ModelMap model, int year) {
		double[] outData = expenditureManager.getMonthData(year, 1, ExpenditureEnum.TOTALCOST.getType());
		int[] count = expenditureManager.getMonthCount(year, 1, ExpenditureEnum.TOTALCOST.getType());
		for (int i = 0; i < outData.length; i++) {
			outData[i] = outData[i]/10000;
		}
		model.put("out", outData);
		model.put("count", count);
		JsonUtils.writeJson(response, model);
	}
}
