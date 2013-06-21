package com.app.permission.utils;

import javax.servlet.http.HttpServletRequest;

import com.app.exception.UserNoLogonException;
import com.app.permission.model.Department;
import com.app.permission.model.User;
import com.app.permission.service.DepartmentManager;
import com.app.permission.service.RoleManager;
import com.app.permission.service.UserManager;
import com.sqds.exception.SqdsException;
import com.sqds.spring.SpringUtils;
import com.sqds.util.CookieUtils;
import com.sqds.util.SessionManager;

/**
 * 用户会话管理
 * 
 * @author ccj
 * 
 */
public class UserSessionManager {
	/**
	 * 从session中取得用户信息，如果用户未登录，则抛出异常
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	public static User getUserFromSession() {
		HttpServletRequest request = SpringUtils.getRequest();
		if (request == null) {
			throw new SqdsException("Request不能正常获取");
		}
		// 用户登录时将userId保存到cookie中
		String userIdStr = CookieUtils.getCookieValue(request, "userId");
		if (userIdStr == null) {
			userIdStr = "0";
		}
		int userId = 0;
		try {
			userId = Integer.parseInt(userIdStr);
		} catch (Exception e) {
		}

		// 从session取得siteId，如果siteId!=null，则表明用户在前台访问数据
		// 当用户从前台访问数据的时候，有下列的数据逻辑
		// 1.如果用户未登录，则系统分配一个默认的用户，并赋予guest游客的角色
		// 2.如果用户已经登录，则使用当前用户的身份和角色信息
		// 3.根据当前用户访问的站点编号，取得站点的管理部门信息。并将这个部门赋予当前用户
		// 如果session中siteId不存在，则表明用户在后台，不需要进行特别的处理

		// ========开始进行处理
		UserManager userManager = (UserManager) SpringUtils
				.getBean("userManager");
		DepartmentManager departmentManager = (DepartmentManager) SpringUtils
				.getBean("departmentManager");
		RoleManager roleManager = (RoleManager) SpringUtils
				.getBean("roleManager");

		Integer siteId = (Integer) SessionManager.getAttribute(request,
				"siteId");
		Integer currentRoleId = (Integer) SessionManager.getAttribute(request,
				"currentRoleId");
		User user = null;
		if (siteId == null || siteId == 0) {
			// 从spring中取得bean

			user = userManager.getUserAndDepartmentInfo(userId);
			if (user == null) {
				throw new UserNoLogonException();
			}

			// List<Role> roles = roleManager.listByUser(user.getId());
			//
			// // 如果当前选择的角色不为空
			// if (currentRoleId != null) {
			// int i = 0;
			// Role zeroRole;
			// // 遍历所有的角色
			// for (Role role : roles) {
			// // 判断当前角色列表中是否有选定的角色ID
			// if (role.getId() == currentRoleId.intValue()) {
			// // 如果当前角色在列表的首位,退出循环
			// if (i == 0) {
			// break;
			// }
			// // 将选择的角色,放到角色列表的第一个
			// zeroRole = roles.get(0);
			// roles.set(0, role);
			// roles.set(i, zeroRole);
			// break;
			// }
			// i++;
			// }
			// } else {
			// if (roles.size() > 0) {
			// SessionManager.setAttribute(request, "currentRoleId", roles
			// .get(0).getId());
			// }
			// }
			//
			// user.setRoles(roles);
			// if (user.getRoles() == null) {
			// user.setRoles(new Vector<Role>());
			// }
			// } else {
			// //
			// if (userId != 0) {
			// user = userManager.getUserAndDepartmentInfo(userId);
			// List<Role> roles = roleManager.listByUser(user.getId());
			// user.setRoles(roles);
			// if (user.getRoles() == null) {
			// user.setRoles(new Vector<Role>());
			// }
			// } else {
			// user = new User();
			// user.setId(0);
			// user.setUsername("guest");
			// user.setRealName("guest");
			// Role role = roleManager.findUniqueByProperty("roleEngName",
			// "guest");
			// List<Role> roleList = new Vector();
			// roleList.add(role);
			// user.setRoles(roleList);
			// }
			// 重新设定部门
			Department department = departmentManager.get(siteId);
			if (department == null) {
				throw new SqdsException("部门信息指定错误。请确认siteId是否正确。");
			}
			user.setDepartment(department);
		}
		return user;
	}

	/**
	 * 从当前session中取得用户信息，如果用户未登录，则返回null
	 * 
	 * @return
	 */
	@SuppressWarnings("unused")
	public static User getUserFromSession1() {
		HttpServletRequest request = SpringUtils.getRequest();
		if (request == null) {
			throw new SqdsException("Request不能正常获取");
		}
		// 用户登录时将userId保存到cookie中
		String userIdStr = CookieUtils.getCookieValue(request, "userId");
		if (userIdStr == null) {
			userIdStr = "0";
		}
		int userId = 0;
		try {
			userId = Integer.parseInt(userIdStr);
		} catch (Exception e) {
		}
		// 从spring中取得bean
		UserManager userManager = (UserManager) SpringUtils
				.getBean("userManager");
		DepartmentManager departmentManager = (DepartmentManager) SpringUtils
				.getBean("departmentManager");
		RoleManager roleManager = (RoleManager) SpringUtils
				.getBean("roleManager");

		User user = userManager.getUserAndDepartmentInfo(userId);
		if (user == null) {
			return null;
		}

		// List<Role> roles = roleManager.listByUser(user.getId());
		// user.setRoles(roles);
		// if(user.getRoles()==null){
		// user.setRoles(new Vector<Role>());
		// }
		return user;
	}

}
