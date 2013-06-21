package com.app.permission.model.vo;

public class FunctionVO {
	private Integer id;
	private String functionName;
	private String functionUrl;
	private Integer classId;
	private Integer activeFlag;
	private Integer orderIndex;
	private String imageButtonUrl;
	private String description;

	public Integer getId() {
		return id;
	}

	public String getFunctionName() {
		return functionName;
	}

	public String getFunctionUrl() {
		return functionUrl;
	}

	public Integer getClassId() {
		return classId;
	}

	public Integer getActiveFlag() {
		return activeFlag;
	}

	public Integer getOrderIndex() {
		return orderIndex;
	}

	public String getImageButtonUrl() {
		return imageButtonUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public void setFunctionUrl(String functionUrl) {
		this.functionUrl = functionUrl;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	public void setActiveFlag(Integer activeFlag) {
		this.activeFlag = activeFlag;
	}

	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}

	public void setImageButtonUrl(String imageButtonUrl) {
		this.imageButtonUrl = imageButtonUrl;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
