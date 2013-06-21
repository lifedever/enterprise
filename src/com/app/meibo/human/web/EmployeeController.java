package com.app.meibo.human.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.constant.FilePathEnum;
import com.app.meibo.human.model.Employee;
import com.app.meibo.human.model.Position;
import com.app.meibo.human.model.vo.EmployeeVO;
import com.app.meibo.human.service.EmployeeManager;
import com.app.meibo.human.service.PositionManager;
import com.app.permission.model.Department;
import com.app.permission.model.Page;
import com.app.permission.service.DepartmentManager;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.FileUtils;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;

/**
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-12-16 下午1:13:20
 */
@Controller
@RequestMapping("/human/employee/*.html")
@GlobalAutowired
public class EmployeeController {
	private PositionManager positionManager;
	private EmployeeManager employeeManager;
	private DepartmentManager departmentManager;

	@RequestMapping
	public void index() {

	}

	@RequestMapping
	public void listContent(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
		Page<Employee> page = new Page<Employee>();
		page.setQueryDatas(request, page);// 将前台request传来的查询参数绑定的page对象，进行查询
		SpringUtils.bind(page);// page前台数据绑定
		page.search(page, "Employee", employeeManager);
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

	@RequestMapping
	public void listContentForLeaveEmp(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
		Page<Employee> page = new Page<Employee>();
		page.setQueryDatas(request, page);// 将前台request传来的查询参数绑定的page对象，进行查询
		SpringUtils.bind(page);// page前台数据绑定
		page.searchWithOutIsdelete(page, "Employee", employeeManager);
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

	@RequestMapping
	public void saveEmployee(HttpServletResponse response, HttpServletRequest request, Employee employee, Integer empDeptId, Integer positionId) throws IOException {
		Department department = null;
		Position position = null;
		if (empDeptId != null)
			department = departmentManager.get(empDeptId);
		if (positionId != null)
			position = positionManager.get(positionId);
		if (employee.getId() != null) {
			employee = employeeManager.get(employee.getId());
			SpringUtils.bind(employee);
		} else {
			employee.setCreateDate(new Date());
		}
		String path = FileUtils.upload(request, "file", FilePathEnum.EMPLOYEE_IMAGE.getPath());
		if (path != null && !("").equals(path)) {
			employee.setImage(path);
		}
		employee.setEmpPosition(position);
		employee.setEmpDept(department);
		employeeManager.save(employee);
		JsonUtils.writeJson(response);
	}

	/**
	 * 删除
	 * 
	 * @param response
	 * @param id
	 */
	@RequestMapping
	public void deleteEmployee(HttpServletResponse response, Integer id) {
		employeeManager.delete(id);
		JsonUtils.writeJson(response);
	}

	/**
	 * 离职
	 * 
	 * @param response
	 * @param id
	 */
	@RequestMapping
	public void leaveJob(HttpServletResponse response, Integer id) {
		Employee employee = employeeManager.get(id);
		employee.setEmpDept(null);
		employee.setEmpPosition(null);
		employee.setIsDelete(1);
		employeeManager.update(employee);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void viewEmployee(Integer id, ModelMap model) {
		Employee employee = employeeManager.get(id);
		model.addAttribute("employee", employee);
	}
}
