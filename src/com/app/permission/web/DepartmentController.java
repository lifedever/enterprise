package com.app.permission.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.permission.model.Department;
import com.app.permission.model.User;
import com.app.permission.model.vo.DepartmentJson;
import com.app.permission.model.vo.DepartmentVO;
import com.app.permission.service.DepartmentManager;
import com.app.permission.service.UserManager;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;

/**
 * 部门
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-11-12 下午10:25:10
 */
@Controller
@RequestMapping("/department/*.html")
public class DepartmentController {
	@Autowired
	private DepartmentManager departmentManager;
	@Autowired
	private UserManager userManager;

	@RequestMapping
	public void index(HttpServletRequest request, ModelMap map) {

	}

	@RequestMapping
	public void listContent(HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		Department root = departmentManager.getRootDepartment();
		DepartmentJson json = new DepartmentJson();
		json.setId(root.getId());
		json.setText(root.getDepartmentName());
		// 递归调用，获得部门树列表
		this.getDeptTree(root, json);
		JsonUtils.writeJson(response, json, false);
	}

	/**
	 * 组装前台树控件
	 * 
	 * @param parentDept
	 *            父节点
	 * @param parentJson
	 *            父节点
	 */
	private void getDeptTree(Department parentDept, DepartmentJson parentJson) {
		List<Department> childList = departmentManager.list(parentDept.getId());
		if (childList != null && childList.size() > 0) {
			List<DepartmentJson> jsons = new ArrayList<DepartmentJson>();
			for (Department dept : childList) {
				DepartmentJson json = new DepartmentJson();
				json.setId(dept.getId());
				json.setText(dept.getDepartmentName());
				jsons.add(json);
				getDeptTree(dept, json);
			}
			parentJson.setChildren(jsons);
		}
	}

	/**
	 * 添加部门
	 * 
	 * @param department
	 * @param parentId
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 */

	@RequestMapping
	public void addDept(Department department, Integer parentId, HttpServletRequest request, HttpServletResponse response) {
		if (department.getId() == null) {
			Department department2 = departmentManager.get(parentId);
			department.setParentDepartment(department2);
		} else {
			department = departmentManager.get(department.getId());
			SpringUtils.bind(department);
		}
		departmentManager.save(department);
		JsonUtils.writeJson(response);
	}

	/**
	 * 删除部门
	 * 
	 * @param department
	 * @param parentId
	 * @param request
	 * @param response
	 * @param map
	 * @return
	 */
	@RequestMapping
	public void delDept(Integer id, HttpServletRequest request, HttpServletResponse response, ModelMap map) {
		User user = userManager.findUnique("from User u where u.department.id = ?", id);
		map.clear();
		if (user != null) {
			map.addAttribute("success", false);
			map.addAttribute("message", "删除失败，请先移除部门下的用户！");
		} else {
			Department department = departmentManager.get(id);
			if (departmentManager.list(department.getId()).size() > 0) {
				map.addAttribute("success", false);
				map.addAttribute("message", "删除失败，请先删除下级部门！");
			} else {
				departmentManager.delete(id);
				map.addAttribute("success", true);
				map.addAttribute("message", "删除成功");
			}
		}
		JsonUtils.writeJson(response, map);
	}

	@RequestMapping
	public void getDept(HttpServletResponse response, Integer id, ModelMap map) {
		Department department = departmentManager.get(id);
		map.addAttribute("departmentName", department.getDepartmentName());
		map.addAttribute("departmentCode", department.getDepartmentCode());
		JsonUtils.writeJson(response, map);
	}

	/**
	 * 为部门combobox控件加载数据
	 * 
	 * @param response
	 * @return
	 */
	@RequestMapping
	public void loadCombobox(HttpServletResponse response) {
		List<Department> departments = departmentManager.listAll();
		List<DepartmentVO> depts = new ArrayList<DepartmentVO>();
		BeanUtilsEx.copyDOListToVOList(DepartmentVO.class, departments, depts);
		JsonUtils.writeJson(response, depts);
	}

	/**
	 * 根据上级部门名称获得下级部门
	 */
	@RequestMapping
	public void listByParent(HttpServletResponse response, String parentName) {
		List<Department> departments = departmentManager.list("from Department d where d.parentDepartment.departmentCode = ?", parentName);
		List<DepartmentVO> depts = new ArrayList<DepartmentVO>();
		BeanUtilsEx.copyDOListToVOList(DepartmentVO.class, departments, depts);
		JsonUtils.writeJson(response, depts);
	}

	/**
	 * 树的拖拽
	 */
	@RequestMapping
	public void onDrop(Integer targetId, Integer sourceId, String point, HttpServletResponse response) {
		departmentManager.onDrop(targetId, sourceId, point);
		JsonUtils.writeJson(response);
	}
}
