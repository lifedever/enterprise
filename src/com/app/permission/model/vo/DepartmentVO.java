package com.app.permission.model.vo;

public class DepartmentVO {
	private Integer id;
	private String departmentName;
	private String departmentCode;
	private Integer departmentLevel;
	private Integer activeFlag;
	private String levelCode;
	private Integer orderIndex;

	public Integer getId() {
		return id;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public Integer getDepartmentLevel() {
		return departmentLevel;
	}

	public Integer getActiveFlag() {
		return activeFlag;
	}

	public String getLevelCode() {
		return levelCode;
	}

	public Integer getOrderIndex() {
		return orderIndex;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

	public void setDepartmentLevel(Integer departmentLevel) {
		this.departmentLevel = departmentLevel;
	}

	public void setActiveFlag(Integer activeFlag) {
		this.activeFlag = activeFlag;
	}

	public void setLevelCode(String levelCode) {
		this.levelCode = levelCode;
	}

	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}

}
