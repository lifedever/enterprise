package com.app.permission.web;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.permission.model.Function;
import com.app.permission.model.Role;
import com.app.permission.service.FunctionManager;
import com.app.permission.service.RoleManager;
import com.app.permission.utils.web.JsonUtils;

/**
 * 权限管理
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-11-4 下午08:21:55
 */
@Controller
@RequestMapping("/right/*.html")
public class RightsController {
	@Autowired
	private FunctionManager functionManager;
	@Autowired
	private RoleManager roleManager;

	@RequestMapping
	public void index() {

	}

	/**
	 * 保存与角色关联的function
	 * 
	 * @param funIds
	 * @param rowId
	 * @param model
	 * @return
	 */
	@RequestMapping
	public void saveRight(HttpServletResponse response, String funIds,
			Integer rowId, ModelMap model) {
		model.clear();
		Role role = roleManager.get(rowId);
		Set<Role> roles = new HashSet<Role>();
		roles.add(role);
		Set<Function> functions = new HashSet<Function>();
		if (!"".equals(funIds)) {
			String[] funIdString = funIds.split(",");
			for (String str : funIdString) {
				Function function = new Function();
				Integer funId = Integer.parseInt(str);
				function = functionManager.get(funId);
				function.setRoles(roles);
				// 如果有一个子功能被选，则默认父功能即被选
				int i = 0;
				if (function.getParentFunction() != null && i == 0) {
					function.getParentFunction().setRoles(roles);
					functions.add(function.getParentFunction());
				}
				functions.add(function);
			}
		} else {
			role.setFunctions(null);
		}
		role.setFunctions(functions);
		roleManager.update(role);
		JsonUtils.writeJson(response);
	}
}
