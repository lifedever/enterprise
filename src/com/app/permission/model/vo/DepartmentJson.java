package com.app.permission.model.vo;

import java.util.List;

public class DepartmentJson {
	private Integer id;
	private String text;

	private String iconCls;
	private String checked;
	private List<DepartmentJson> children;

	public Integer getId() {
		return id;
	}

	public String getText() {
		return text;
	}

	public String getIconCls() {
		return iconCls;
	}

	public String getChecked() {
		return checked;
	}

	public List<DepartmentJson> getChildren() {
		return children;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setText(String text) {
		this.text = text;
	}

	public void setIconCls(String iconCls) {
		this.iconCls = iconCls;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public void setChildren(List<DepartmentJson> children) {
		this.children = children;
	}

}
