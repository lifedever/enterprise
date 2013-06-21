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
import com.app.permission.model.Page;
import com.app.permission.model.Role;
import com.app.permission.model.User;
import com.app.permission.model.vo.UserVO;
import com.app.permission.service.DepartmentManager;
import com.app.permission.service.RoleManager;
import com.app.permission.service.UserManager;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;

/**
 * 用户管理
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-11-4 下午07:29:41
 */
@Controller
@RequestMapping("/user/*.html")
public class UserController {
	@Autowired
	private UserManager userManager;
	@Autowired
	private RoleManager roleManager;
	@Autowired
	private DepartmentManager departmentManager;

	@RequestMapping
	public void index(ModelMap map) {
		List<Role> roles = roleManager.list("from Role");
		map.addAttribute("roles", roles);
	}

	@RequestMapping
	public void listContent(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {

		modelMap.clear();// 必须的，否则容易出异常
		Page<User> page = new Page<User>();
		page.setQueryDatas(request, page);// 将前台request传来的查询参数绑定的page对象，进行查询
		SpringUtils.bind(page);// page前台数据绑定
		// userManager.search(page);// 要查询请调用search()方法，如调用了list，默认是没有查询功能的
		page.search(page, "User", userManager);
		List<UserVO> list = new ArrayList<UserVO>();
		for (User user : page.getResult()) {
			UserVO vo = new UserVO();
			BeanUtilsEx.copyProperties(vo, user);
			if (user.getRole() != null) {
				vo.setRoleName(user.getRole().getRoleName());
				vo.setRoleId(user.getRole().getId());
			}
			if (user.getDepartment() != null) {
				vo.setDepartmentId(user.getDepartment().getId());
				vo.setDepartmentCode(user.getDepartment().getDepartmentCode());
				vo.setDepartmentName(user.getDepartment().getDepartmentName());
			}
			list.add(vo);
		}
		modelMap.put("total", page.getTotalCount());
		modelMap.put("rows", list);
		JsonUtils.writeJson(response, modelMap);
	}

	/**
	 * 添加用户
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping
	public void addUser(HttpServletResponse response, User user, ModelMap model, Integer departId) {
		model.clear(); // 必须的，否则容易出异常
		if (user.getId() == null && userManager.getUserByUsername(user.getUsername()) != null) {
			model.put("result", false);
			model.put("message", "用户名已存在，请重新添加");
		} else {
			if (user.getId() != null) {
				user = userManager.get(user.getId());
				SpringUtils.bind(user);
			}
			if (departId != null) {
				Department department = departmentManager.get(departId);
				user.setDepartment(department);
			}
			userManager.save(user);
			model.put("result", true);
		}
		JsonUtils.writeJson(response, model);
	}

	/**
	 * 删除用户
	 * 
	 * @param user
	 * @param model
	 * @return
	 */
	@RequestMapping
	public void deleteUser(HttpServletResponse response, String idsString, ModelMap model) {
		if (idsString.contains(",")) {
			String[] ids = idsString.split(",");
			for (String str : ids) {
				int id = Integer.parseInt(str);
				User user = userManager.get(id);
				// userManager.delete(id);
				user.setIsDelete(1);
				userManager.update(user);
			}
		}
		JsonUtils.writeJson(response);
	}

	/**
	 * 清除用户的角色信息
	 */
	@RequestMapping
	public void removeRoleOfUser(HttpServletResponse response, String ids, ModelMap model) {
		model.clear(); // 必须的，否则容易出异常
		if (ids.contains(",")) {
			String[] idArr = ids.split(",");
			for (String str : idArr) {
				int id = Integer.parseInt(str);
				User user = userManager.get(id);
				user.setRole(null);
				userManager.update(user);
			}
		}
		model.put("success", true);
		JsonUtils.writeJson(response, model);
	}

	/**
	 * 检查用户密码
	 */
	@RequestMapping
	public void checkPass(HttpServletResponse response, Integer id, String oldPassword, String newPassword, ModelMap model) {
		model.clear(); // 必须的，否则容易出异常
		User user = userManager.get(id);
		if (oldPassword.equals(user.getPassword())) {
			user.setPassword(newPassword);
			// userManager.save(user);
			model.put("success", true);
		} else {
			model.put("success", false);
		}
		JsonUtils.writeJson(response, model);
	}

	/**
	 * 保存用户密码
	 */
	@RequestMapping
	public void savePass(HttpServletResponse response, Integer id, String oldPassword, String newPassword, ModelMap model) {
		model.clear(); // 必须的，否则容易出异常
		User user = userManager.get(id);
		if (oldPassword.equals(user.getPassword())) {
			user.setPassword(newPassword);
			userManager.save(user);
		}
		JsonUtils.writeJson(response, true);
	}

	/**
	 * 将用户从部门移除
	 */
	@RequestMapping
	public void removeUserFromDept(HttpServletResponse response, String idsString, ModelMap model) {
		if (idsString.contains(",")) {
			String[] ids = idsString.split(",");
			for (String str : ids) {
				int id = Integer.parseInt(str);
				User user = userManager.get(id);
				user.setDepartment(null);
				userManager.save(user);
			}
		}
		model.clear(); // 必须的，否则容易出异常
		model.put("success", true);
		JsonUtils.writeJson(response, model);
	}

	/**
	 * 通过前台传过来的角色名称查询该角色下的所有用户
	 * 
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param roleName
	 */
	@RequestMapping
	public void listByRoleName(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
		String roleName = request.getParameter("roleName");
		modelMap.clear();// 必须的，否则容易出异常
		List<User> users = userManager.listUsersByRoleName(roleName);
		List<UserVO> list = new ArrayList<UserVO>();
		for (User user : users) {
			UserVO userVO = new UserVO();
			BeanUtilsEx.copyProperties(userVO, user);
			list.add(userVO);
		}
		JsonUtils.writeJson(response, list);
	}

	/**
	 * 向角色中添加用户
	 */
	@RequestMapping
	public void addUsersToRole(HttpServletResponse response, String idsString, Integer roleId) {
		Role role = roleManager.get(roleId);
		if (idsString.contains(",")) {
			String[] ids = idsString.split(",");
			for (String str : ids) {
				int id = Integer.parseInt(str);
				User user = userManager.get(id);
				user.setRole(role);
				userManager.update(user);
				JsonUtils.writeJson(response);
			}
		}
	}

	/**
	 * 向部门中添加用户
	 */
	@RequestMapping
	public void addUsersToDepartment(HttpServletResponse response, String idsString, Integer deptId) {
		Department department = departmentManager.get(deptId);
		if (idsString.contains(",")) {
			String[] ids = idsString.split(",");
			for (String str : ids) {
				int id = Integer.parseInt(str);
				User user = userManager.get(id);
				user.setDepartment(department);
				userManager.update(user);
				JsonUtils.writeJson(response);
			}
		}
	}
}
