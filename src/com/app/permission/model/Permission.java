package com.app.permission.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 操作权限
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-12-10 下午10:52:48
 */
@Entity
@Table(name = "permission")
public class Permission {
	public Integer id;// id
	public String title;// 标题
	public String className;// 类名
	public String operation;// 操作
	public String cause;// 条件
	public int isDelete = 0;
	private Role role;// 角色

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public String getClassName() {
		return className;
	}

	public String getOperation() {
		return operation;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "roleId")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
