package com.app.permission.model.vo;

/**
 * 操作权限
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-12-10 下午10:52:48
 */
public class PermissionVO {
	private Integer id;// id
	public String title;// 标题
	private String className;// 类名
	private String operation;// 操作
	private String cause;// 条件
	private Integer roleId;

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

	public String getCause() {
		return cause;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
