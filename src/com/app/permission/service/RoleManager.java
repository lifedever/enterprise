package com.app.permission.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.permission.model.Role;
import com.sqds.hibernate.HibernateDao;

/**
 * 角色管理
 * @author ccj
 *
 */
@Service
public class RoleManager extends HibernateDao<Role> {
	
	/**
	 * 角色列表
	 * @return
	 */
	public List<Role> getRoleList() {
		return super.list("from Role r order by r.orderIndex");
	}

	/**
	 * 角色排序
	 * @param ids
	 */
	public void roleOrder(int[] ids) {
		for(int i=0;i<ids.length;i++){
			if(ids[i]==0){
				continue;
			}
			Role role = get(ids[i]);
			role.setOrderIndex(i);
			update(role);
		}
	}
	
	/**
	 * 取得指定用户拥有的角色
	 * @param userId
	 * @return
	 */
	public List<Role> listByUser(int userId){
		return list("from Role r inner join fetch r.users u where u.id=? order by r.id",userId);
	}

}
