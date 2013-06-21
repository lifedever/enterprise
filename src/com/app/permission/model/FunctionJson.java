package com.app.permission.model;

import java.util.List;
/**
 * 对应TreeJSON对象
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-11-8 下午10:28:49
 */
public class FunctionJson {
	private Integer id;
	private String text;

	private String iconCls;
	private String checked;
	private List<FunctionJson> children;

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

	public List<FunctionJson> getChildren() {
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

	public void setChildren(List<FunctionJson> children) {
		this.children = children;
	}

}
