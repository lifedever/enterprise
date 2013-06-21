package com.app.permission.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.permission.model.Role;
import com.app.permission.model.User;
import com.app.permission.model.vo.RoleVO;
import com.app.permission.service.RoleManager;
import com.app.permission.service.UserManager;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;

/**
 * 角色控制
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-11-3下午03:28:32
 */
@Controller
@RequestMapping("/role/*.html")
public class RoleController {
	@Autowired
	private RoleManager roleManager;
	@Autowired
	private UserManager userManager;

	@RequestMapping
	public void index() {

	}

	@RequestMapping
	public void listContent(HttpServletResponse response, ModelMap modelMap) {
		modelMap.clear();// 必须的，否则容易出异常
		List<Role> roles = roleManager.getRoleList();
		List<RoleVO> roleVOs = new ArrayList<RoleVO>();
		for (Role role : roles) {
			RoleVO vo = new RoleVO();
			BeanUtilsEx.copyProperties(vo, role);
			roleVOs.add(vo);
		}
		modelMap.put("rows", roleVOs);
		JsonUtils.writeJson(response, modelMap);
	}

	/**
	 * 为角色的combobox控件加载数据
	 * 
	 * @param response
	 * @return
	 */
	@RequestMapping
	public void loadCombobox(HttpServletResponse response) {
		List<Role> roles = roleManager.getRoleList();
		List<RoleVO> roleVOs = new ArrayList<RoleVO>();
		for (Role role : roles) {
			RoleVO vo = new RoleVO();
			BeanUtilsEx.copyProperties(vo, role);
			roleVOs.add(vo);
		}
		JsonUtils.writeJson(response, roleVOs);
	}

	@RequestMapping
	public void addRole(HttpServletResponse response, Role role, ModelMap model) {
		if (role.getId() != null) {
			role = roleManager.get(role.getId());
			SpringUtils.bind(role);
		}
		roleManager.save(role);
		JsonUtils.writeJson(response, true, true);
	}

	@RequestMapping
	public void deleteRole(HttpServletResponse response, Role role) {
		List<User> users = userManager.listUsersByRole(role);
		if (users != null && users.size() > 0) {
			JsonUtils.writeJson(response, false);
		} else {
			roleManager.delete(role.getId());
			JsonUtils.writeJson(response, true);
		}
	}
}
