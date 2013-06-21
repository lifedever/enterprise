package com.app.permission.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.permission.model.Menu;
import com.app.permission.model.User;
import com.sqds.hibernate.HibernateDao;
/**
 * 菜单管理
 * @author ccj
 *
 */
@Service
public class MenuManager extends HibernateDao<Menu> {
	
	/**
	 * 取得所有菜单
	 * @return
	 */
	public List<Menu> getMenuList() {
		String hql = "from Menu m left join fetch m.parentMenu left join fetch m.function order by m.orderIndex,m.id";
		return super.list(hql);
	}
	/**
	 * 取得指定角色的菜单
	 * @param roleId
	 * @return
	 */
	public List<Menu> listByRole(int roleId) {
		String hql = "from Menu m left join fetch m.roles r where r.id=?";
		return list(hql,roleId);
	}
	/**
	 * 取得用户拥有的所有菜单
	 * 部分用户级别
	 * @param dbUser
	 * @return
	 */
	public List<Menu> getMenu(User dbUser) {
		String hql = "select m from Menu m inner join m.roles r left join  r.users u " +
			" where r.activeFlag=? and m.activeFlag=? and u.activeFlag=? and u.id=? order by m.orderIndex";
		//  
		return super.list(hql,1,1,1,dbUser.getId());
	}
	public List<Menu> getAllMenu(User dbUser){
		String hql = "select m from Menu m inner join fetch m.function inner join m.roles r left join  r.users u " +
		" where r.activeFlag=? and m.activeFlag=? and u.activeFlag=? and u.id=? order by m.orderIndex";
		return super.list(hql,1,1,1,dbUser.getId());
	}
	/**
	 * 取得根菜单信息
	 * @return
	 */
	public Menu getRootMenu() {
        String hql = "from Menu m where m.parentMenu is null ";
        return (Menu)super.findUnique(hql);
	}
	/**
	 * 取得制定菜单的下一级菜单
	 * @param dbUser
	 * @param rootMenu
	 * @return
	 */
	public List<?> getPlanMenu(User dbUser, Menu parentMenu) {
		String hql = 
			"select m from Menu m inner join m.roles r inner join r.users u " +
			"where  r.activeFlag=? and u.activeFlag=? and m.activeFlag=? and u.id=? and m.parentMenu.id=? " +
			"order  by m.orderIndex";
		return super.list(hql, 1,1,1,dbUser.getId(),parentMenu.getId());
	}

	/**
	 * 取得指定节点下的菜单
	 * @param parentMenuId
	 * @return
	 */
	public List<Menu> getMenuList(int parentMenuId){
		String hql = "from Menu m left join fetch m.function where m.parentMenu.id=? order by m.orderIndex,m.id";
		return super.list(hql, parentMenuId);
	}
	/**
	 * 取得指定角色指定节点下的菜单信息
	 * @param parentMenuId
	 * @param roleId
	 * @return
	 */
	public List<Menu> getMenuList(int parentMenuId, int roleId){
		String hql = "from Menu m left join fetch m.function f left join fetch m.roles r where m.parentMenu.id=? and r.id=? order by m.orderIndex,m.id";
		return super.list(hql, parentMenuId, roleId);
	}
}
