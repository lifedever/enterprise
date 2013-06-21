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
import com.app.meibo.human.model.Employee;
import com.app.meibo.human.service.EmployeeManager;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.annotation.GlobalAutowired;

/**
 * 员工薪水统计
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-1-22 上午11:55:03
 */
@Controller
@RequestMapping("/statistics/salary/*.html")
@GlobalAutowired
public class SalaryStatisticsController {
	private ExpenditureManager expenditureManager;
	private EmployeeManager employeeManager;

	@RequestMapping
	public void index() {
	}

	@RequestMapping
	public void empIndex(Integer empId, ModelMap model) {
		Employee emp = employeeManager.get(empId);
		model.addAttribute("emp", emp);
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
	 * 年统计
	 */
	@RequestMapping
	public void empYears(Integer empId, ModelMap model) {
		Employee emp = employeeManager.get(empId);
		model.addAttribute("emp", emp);
	}

	/**
	 * 月统计
	 * 
	 * @param year
	 * @param model
	 */
	@RequestMapping
	public void empMonths(int year, Integer empId, ModelMap model) {
		Employee emp = employeeManager.get(empId);
		model.addAttribute("emp", emp);
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
		Map<String, Double> outData = expenditureManager.getYearData(0, ExpenditureEnum.SALARY.getType());
		Set<String> set = outData.keySet();
		List<Double> outMoney = new ArrayList<Double>();
		for (String string : set) {
			outMoney.add(outData.get(string));
		}
		model.put("year", set);
		model.put("out", outMoney);
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
		double[] outData = expenditureManager.getMonthData(year, 0, ExpenditureEnum.SALARY.getType());
		model.put("out", outData);
		JsonUtils.writeJson(response, model);
	}

	/**
	 * 统计年
	 * 
	 * @param response
	 * @param model
	 * @param year
	 */
	@RequestMapping
	public void getYearDataForEmp(Integer empId, HttpServletResponse response, ModelMap model) {
//		Salary salary = salaryManager.getByEmpId(empId);
//		if (salary != null) {
			Map<String, Double> outData = expenditureManager.getYearData(0, ExpenditureEnum.SALARY.getType(), empId);
			Set<String> set = outData.keySet();
			List<Double> outMoney = new ArrayList<Double>();
			for (String string : set) {
				outMoney.add(outData.get(string));
			}
			model.put("year", set);
			model.put("out", outMoney);
//		} else {
//			model.put("error", "error");
//		}
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
	public void getMonthDataForEmp(Integer empId, HttpServletResponse response, ModelMap model, int year) {
//		Salary salary = salaryManager.getByEmpId(empId);
//		if (salary!=null) {
			//double[] outData = expenditureManager.getMonthData(year, 0, ExpenditureEnum.SALARY.getType(), salary.getId());
			double[] outData = expenditureManager.getMonthData(year, 0, ExpenditureEnum.SALARY.getType(), empId);
			model.put("out", outData);
//		}
		JsonUtils.writeJson(response, model);
	}
}
