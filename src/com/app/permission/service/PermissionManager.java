package com.app.permission.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.permission.model.Permission;
import com.sqds.hibernate.HibernateDao;

@Service
public class PermissionManager extends HibernateDao<Permission> {
	public List<Permission> listPermissionByRole(Integer roleId) {
		return super.list("from Permission p where p.role.id = ?", roleId);
	}
}
