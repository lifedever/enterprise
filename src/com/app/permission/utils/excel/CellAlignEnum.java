package com.app.permission.utils.excel;

public enum CellAlignEnum {
	居中("CENTER"), 居左("LEFT"), 居右("RIGHT");

	private CellAlignEnum(String value) {
		this.value = value;
	}

	public String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
