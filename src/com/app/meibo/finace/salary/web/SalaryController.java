package com.app.meibo.finace.salary.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.constant.ExpenditureEnum;
import com.app.meibo.finace.account.model.Account;
import com.app.meibo.finace.account.service.AccountManager;
import com.app.meibo.finace.expenditure.model.Expenditure;
import com.app.meibo.finace.expenditure.service.ExpenditureManager;
import com.app.meibo.finace.salary.service.SalaryManager;
import com.app.meibo.human.model.Employee;
import com.app.meibo.human.model.Salary;
import com.app.meibo.human.model.vo.EmployeeVO;
import com.app.meibo.human.model.vo.SalaryVO;
import com.app.meibo.human.service.EmployeeManager;
import com.app.permission.model.Page;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.page.PageInfo;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;
import com.sqds.util.DateUtils;
import com.sqds.util.ParamUtils;

@Controller
@RequestMapping("/finace/salary/*.html")
@GlobalAutowired
public class SalaryController {
	private SalaryManager salaryManager;
	private EmployeeManager employeeManager;
	private AccountManager accountManager;
	private ExpenditureManager expenditureManager;

	@RequestMapping
	public void index() {

	}

	@RequestMapping
	public void listEmployee() {

	}

	@RequestMapping
	public void listAccount() {

	}

	@RequestMapping
	public void listMonths() {

	}

	@RequestMapping
	public void listOneMonth(ModelMap modelMap) {
		modelMap.addAttribute("date", ParamUtils.getString("date", ""));
	}

	@RequestMapping
	public void listContent(ModelMap modelMap, HttpServletRequest request, HttpServletResponse response) {
		modelMap.clear();// 必须的，否则容易出异常
		Page<Salary> page = new Page<Salary>();
		page.setQueryDatas(request, page);//
		SpringUtils.bind(page);//
		page.search(page, "Salary", salaryManager);
		List<Salary> salaries = page.getResult();
		List<SalaryVO> salaryVOs = new ArrayList<SalaryVO>();
		for (Salary salary : salaries) {
			SalaryVO vo = new SalaryVO();
			BeanUtilsEx.copyProperties(vo, salary);
			if (salary.getEmployee() != null) {
				vo.setEmployeeName(salary.getEmployee().getEmpName());
				vo.setEmployeeNo(salary.getEmployee().getEmpNo());
			}
			if (salary.getAccount() != null) {
				vo.setAccountName(salary.getAccount().getAccountName());
			}
			salaryVOs.add(vo);
		}
		modelMap.put("total", page.getTotalCount());
		modelMap.put("rows", salaryVOs);
		JsonUtils.writeJson(response, modelMap);
	}

	@RequestMapping
	public void addSalary(Salary salary, HttpServletResponse response, ModelMap model) {
		Integer employeeId = ParamUtils.getInteger("employeeId", 0);
		Integer accountId = ParamUtils.getInteger("accountId", 0);
		Employee employee = employeeManager.get(employeeId);
		Account account = accountManager.get(accountId);
		salary.setEmployee(employee);
		salary.setAccount(account);
		salaryManager.save(salary);
//		Expenditure expenditure = expenditureManager.getByEntityId(salary.getId(), ExpenditureEnum.SALARY.getType());
//		if (expenditure == null) {
			Expenditure expenditure = new Expenditure();
//			expenditure.setEntityId(salary.getId());
			expenditure.setEntityId(employeeId);
			expenditure.setType(ExpenditureEnum.SALARY.getType());
			expenditure.setInOrOut(0);
//		}
		expenditure.setChangeDate(salary.getCreateDate());
		expenditure.setAccountId(account.getId());
		expenditure.setMoney(salary.getRealSalary());
		expenditure.setRemark("<span style=\"color:red\">【发工资】</span>" + "员工姓名：" + employee.getEmpName());
		expenditureManager.save(expenditure);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void removeSalary(Integer salaryId, HttpServletResponse response) {
		Salary salary = salaryManager.get(salaryId);
		Expenditure expenditure = expenditureManager.findUnique("from Expenditure e where e.changeDate = ?", salary.getCreateDate());
		if (expenditure != null) {
			expenditureManager.deleteObject(expenditure);
		}
		salaryManager.delete(salaryId);
		JsonUtils.writeJson(response);
	}

	/**
	 * 获取员工列表（不包括本月已发工资的列表）
	 * 
	 * @param request
	 * @param response
	 * @param modelMap
	 */
	@SuppressWarnings({ "static-access", "unused" })
	@RequestMapping
	public void listEmployeeContent(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
		Page<Employee> page = new Page<Employee>();
		page.setQueryDatas(request, page);// 将前台request传来的查询参数绑定的page对象，进行查询
		SpringUtils.bind(page);// page前台数据绑定
		Calendar calendar = Calendar.getInstance();
		Date date = DateUtils.string2Date(calendar.get(calendar.YEAR) + "-" + (calendar.get(calendar.MONTH) + 1) + "-01");
//		employeeManager.list(page, "from Employee e where e.id not in (select ee.employee.id from Salary ee where ee.createDate >= ?)", date);
		employeeManager.list(page, "from Employee e where e.isDelete != 1");
		List<EmployeeVO> voList = new ArrayList<EmployeeVO>();
		for (Employee ee : page.getResult()) {
			EmployeeVO vo = new EmployeeVO();
			BeanUtilsEx.copyProperties(vo, ee);
			if (ee.getEmpDept() != null) {
				vo.setEmpDeptId(ee.getEmpDept().getId());
				vo.setEmpDeptName(ee.getEmpDept().getDepartmentName());
			}
			if (ee.getEmpPosition() != null) {
				vo.setEmpPositionName(ee.getEmpPosition().getPositionName());
			}
			voList.add(vo);
		}
		modelMap.put("total", page.getTotalCount());
		modelMap.put("rows", voList);
		JsonUtils.writeJson(response, modelMap);
	}

	/**
	 * 加载员工上一个月的工资
	 * 
	 * @param employeeId
	 */
	@SuppressWarnings("static-access")
	@RequestMapping
	public void loadSalary(Integer employeeId, HttpServletResponse response) {
		Calendar calendar = Calendar.getInstance();
		Date date = DateUtils.string2Date(calendar.get(calendar.YEAR) + "-" + (calendar.get(calendar.MONTH)) + "-01");
		List<Salary> salarys = salaryManager.list("from Salary s where s.employee.id = ? and s.createDate > ?", employeeId, date);
		if (salarys != null && salarys.size() > 0) {
			salarys.get(0).setEmployee(null);
			salarys.get(0).setAccount(null);
			JsonUtils.writeJson(response, salarys.get(0), true);
		}
	}

	/**
	 * 查看月度工资报表
	 */
	@RequestMapping
	public void showMonthSalarys(HttpServletResponse response, ModelMap modelMap) {
		PageInfo<Object[]> pageInfo = new PageInfo<Object[]>();
		SpringUtils.bind(pageInfo);
		salaryManager.getMonthSalarys(pageInfo);
		modelMap.put("total", pageInfo.getTotalCount());
		modelMap.put("rows", pageInfo.getResult());
		JsonUtils.writeJson(response, modelMap);
	}

	/**
	 * 查看一个月的工资情况
	 * 
	 * @throws ParseException
	 */
	@RequestMapping
	public void showOneMonth(HttpServletResponse response, ModelMap modelMap) throws ParseException {
		String dateString = ParamUtils.getString("date", "");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Date beginDate = sdf.parse(dateString + "01");
		Date endDate = sdf.parse(dateString + "31");
		modelMap.clear();// 必须的，否则容易出异常
		Page<Salary> page = new Page<Salary>();
		SpringUtils.bind(page);//
		salaryManager.list(page, "from Salary s where s.createDate >= ? and s.createDate <= ?", beginDate, endDate);
		List<Salary> salaries = page.getResult();
		List<SalaryVO> salaryVOs = new ArrayList<SalaryVO>();
		for (Salary salary : salaries) {
			SalaryVO vo = new SalaryVO();
			BeanUtilsEx.copyProperties(vo, salary);
			if (salary.getEmployee() != null) {
				vo.setEmployeeName(salary.getEmployee().getEmpName());
				vo.setEmployeeNo(salary.getEmployee().getEmpNo());
				vo.setDeptName(salary.getEmployee().getEmpDept().getDepartmentName());
			}
			if (salary.getAccount() != null) {
				vo.setAccountName(salary.getAccount().getAccountName());
			}
			salaryVOs.add(vo);
		}
		modelMap.put("total", page.getTotalCount());
		modelMap.put("rows", salaryVOs);
		JsonUtils.writeJson(response, modelMap);
	}

	/**
	 * 查看工资
	 */
	@RequestMapping
	public void viewSalary(Integer salaryId, ModelMap modelMap) {
		Salary salary = salaryManager.get(salaryId);
		modelMap.addAttribute("salary", salary);
	}

	/**
	 * 导出每月工资详情
	 * 
	 * @throws ParseException
	 */
	@RequestMapping
	public void exportSalaryExcel(HttpServletResponse response,Date startDate,Date endDate) throws ParseException {
//		String startDateStr = ParamUtils.getString("startDate", "");
//		String endDateStr = ParamUtils.getString("endDate", "");
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
//		Date startDate = null;
//		Date endDate = null;
//		if (!"".equals(startDateStr))
//			startDate = format.parse(startDateStr);
//		if (!"".equals(endDateStr))
//			endDate = format.parse(endDateStr);
		salaryManager.exportMonthExcel(response, startDate, endDate);
	}
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
