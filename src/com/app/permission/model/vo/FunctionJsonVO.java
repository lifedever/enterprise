package com.app.permission.model.vo;

/**
 * 用于前台展示treegrid的json对象
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-11-9 下午9:51:35
 */
public class FunctionJsonVO {
	private Integer id;
	private String functionName;
	private String functionUrl;
	private String description;
	private Integer _parentId;
	private String state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFunctionName() {
		return functionName;
	}

	public String getFunctionUrl() {
		return functionUrl;
	}

	public String getDescription() {
		return description;
	}

	public Integer get_parentId() {
		return _parentId;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	public void setFunctionUrl(String functionUrl) {
		this.functionUrl = functionUrl;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void set_parentId(Integer _parentId) {
		this._parentId = _parentId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

}
