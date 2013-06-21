package com.app.permission.service;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.Vector;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.permission.model.Page;
import com.app.permission.model.Role;
import com.app.permission.model.User;
import com.sqds.hibernate.HibernateDao;

/**
 * 用户管理
 * 
 * @author ccj
 * 
 */
@SuppressWarnings("unchecked")
@Service
public class UserManager extends HibernateDao<User> {
	@Autowired
	private RoleManager roleManager;

	/**
	 * 用户查询
	 * 
	 * @param pageInfo
	 * @return
	 */
	public List<User> userList(Integer departmentId) {
		String hql = "from User u where u.department.id = ? and isDelete=1 order by u.id desc";
		return super.list(hql, departmentId);
	}

	/**
	 * 根据用户名查询用户信息
	 * 
	 * @param username
	 * @return
	 */
	public User getUserByUsername(String username) {
		String hql = " from User u where u.username=? and isDelete != 1";
		return super.findUnique(hql, username);
	}

	/**
	 * 用户搜索
	 * 
	 * @param pageInfo
	 * @return
	 */
	public Page<User> search(Page<User> page) {
		// String username = (String) pageInfo.getParameter("username");
		// String realName = (String) pageInfo.getParameter("realName");
		// String sex = (String) pageInfo.getParameter("sex");
		// StringBuffer hql = new StringBuffer();
		// hql.append("from User u where 1=1 ");
		// // 用户名
		// if (StringUtils.isNotEmpty(username)) {
		// hql.append(" and u.username like '%" + username + "%'");
		// }
		// // 人员姓名
		// if (StringUtils.isNotEmpty(realName)) {
		// hql.append(" and u.realName like '%" + realName + "%'");
		// }
		// // 性别
		// if (StringUtils.isNotEmpty(sex)) {
		// hql.append(" and u.sex like '%" + sex + "%'");
		// }
		// // 角色
		// if (StringUtils.isNotEmpty((String) pageInfo.getParameter("roleId")))
		// {
		// Integer roleId = Integer.parseInt((String)
		// pageInfo.getParameter("roleId"));
		// if (roleId != null && roleId != 0) {
		// hql.append(" and u.role.id = " + roleId);
		// } else {
		// hql.append(" and u.role.id is null");
		// }
		// }
		// // 部门
		// if (StringUtils.isNotEmpty((String) pageInfo.getParameter("deptId")))
		// {
		// Integer deptId = Integer.parseInt((String)
		// pageInfo.getParameter("deptId"));
		// if (deptId != null && deptId != 0) {
		// hql.append(" and u.department.id = " + deptId);
		// }else {
		// hql.append(" and u.department.id is null");
		// }
		// }
		// // 是否删除
		// if (pageInfo.getParameter("isDelete") != null) {
		// hql.append(" and isDelete=" + Integer.parseInt((String)
		// pageInfo.getParameter("isDelete")) + " order by u.createDate desc	");
		// } else {
		// hql.append(" and isDelete!=1 order by u.createDate desc	");
		// }
		// return super.list(pageInfo, hql.toString());
		page.search(page, "User", this);
		return page;
	}

	/**
	 * 更改用户的角色
	 * 
	 * @param user
	 * @param roleId
	 */
	public void changeRoleInfo(User user, String[] roleId) {
		String securityStr = "";
		Set<String> set = new TreeSet<String>();
		List<Role> roleList = new Vector<Role>();
		boolean isHaveSecurity = false;// 是否已经设置了密级
		String s = user.getUserSecurity();
		if ((s != null) && (!"".equals(s))) {
			// isHaveSecurity=true;//表示已经该用户已经设置了密级，不需要用角色的密级了
			securityStr = s;
		}
		for (String id : roleId) {
			Role role = roleManager.get(new Integer(id));
			roleList.add(role);
			String security = role.getRoleSecurity();
			// 当用户本身没有设置密级时，则默认用角色的密级
			if (!isHaveSecurity) {

				if ((security != null) && (!"".equals(security))) {

					int num = security.lastIndexOf(",");
					security = security.substring(0, num);
					String[] ss = security.split(",");
					for (int i = 0; i < ss.length; i++) {
						set.add(ss[i]);
					}
				}
			}
		}

		if (!isHaveSecurity) {

			for (String str : set) {
				securityStr = securityStr + str + ",";
			}
			user.setUserSecurity(securityStr);
		} else {
			user.setUserSecurity(s);
		}
		// user.setRoles(roleList);

		super.save(user);
	}

	/**
	 * 取得指定部门、指定角色的用户
	 * 
	 * @param departmentId
	 * @param roleId
	 * @return
	 */

	public List<User> list(Integer departmentId, Integer roleId) {
		Criteria criteria = super.getSession().createCriteria(User.class);
		criteria.setFetchMode("department", FetchMode.JOIN);
		criteria.setFetchMode("roles", FetchMode.JOIN);
		// 部门
		if (departmentId != null && departmentId != 0) {
			criteria.add(Restrictions.eq("department.id", departmentId));
		}
		if (roleId != null && roleId != 0) {
			// criteria.add( Restrictions.eq("roles.id", roleId) );
		}
		criteria.setResultTransformer(CriteriaSpecification.DISTINCT_ROOT_ENTITY);
		return criteria.list();
	}

	/**
	 * 模糊查询用户信息
	 * 
	 * @param username
	 * @return
	 */
	public List<User> serachUserByUsername(String username) {
		String hql = "from User u inner join fetch u.department where u.username like ?  and isDelete!=1";
		return super.list(hql, "%" + username + "%");
	}

	/**
	 * 根据用户编号，取得用户信息及用户所在部门信息
	 * 
	 * @param userId
	 * @return
	 */
	public User getUserAndDepartmentInfo(Integer userId) {
		String hql = "from User u inner join fetch u.department where u.id=?  and isDelete!=1 ";
		return super.findUnique(hql, userId);
	}

	/**
	 * 查询用户列表根据角色
	 */
	public List<User> listUsersByRole(Role role) {
		String hql = "from User u where u.role.id = ? and isDelete != 1";
		return super.list(hql, role.getId());
	}

	/**
	 * 查询用户列表根据角色名
	 */
	public List<User> listUsersByRoleName(String roleName) {
		String hql = "from User u where u.role.roleName = ? and isDelete != 1";
		return super.list(hql, roleName);
	}
}
