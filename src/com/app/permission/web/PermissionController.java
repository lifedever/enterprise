package com.app.permission.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.permission.model.Permission;
import com.app.permission.model.Role;
import com.app.permission.model.vo.PermissionVO;
import com.app.permission.service.PermissionManager;
import com.app.permission.service.RoleManager;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.util.ParamUtils;

/**
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-12-11 下午9:11:56
 */
@Controller
@RequestMapping("/permission/*.html")
public class PermissionController {
	@Autowired
	private PermissionManager permissionManager;
	@Autowired
	private RoleManager roleManager;

	@RequestMapping
	public void index() {

	}

	@RequestMapping
	public void listContent(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap) {
		modelMap.clear();// 必须的，否则容易出异常
		List<PermissionVO> permissionVOs = new ArrayList<PermissionVO>();
		List<Permission> permissions = permissionManager.list("from Permission where roleId = "
				+ ParamUtils.getInt("roleId", 0));
		BeanUtilsEx.copyDOListToVOList(PermissionVO.class, permissions, permissionVOs);
		modelMap.put("rows", permissionVOs);
		JsonUtils.writeJson(response, modelMap);
	}

	@RequestMapping
	public void savePermission(Permission permission, HttpServletResponse response) {
		Integer roleId = ParamUtils.getInt("roleId", 0);
		Permission permission2 = permissionManager.findUnique(
				"from Permission p where p.className = ? and p.operation = ? and p.cause = ? and roleId = ?",
				permission.getClassName(), permission.getOperation(), permission.getCause(),roleId);
		if (permission2 != null) {
			JsonUtils.writeJson(response, false);
		} else {
			Role role = roleManager.get(roleId);
			permission.setRole(role);
			permissionManager.save(permission);
			JsonUtils.writeJson(response, true);
		}
	}

	@RequestMapping
	public void removePermission(Integer id, HttpServletResponse response) {
		permissionManager.delete(id);
		JsonUtils.writeJson(response);
	}
}
