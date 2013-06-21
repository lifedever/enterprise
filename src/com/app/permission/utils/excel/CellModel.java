package com.app.permission.utils.excel;

import jxl.write.WritableCellFormat;

/**
 * 一格的对象
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-1-31 下午5:15:20
 */
public class CellModel {
	private String eName;// 英文（类中字段的名字）
	private String cName;// 中文
	private Object type;// 类型（类中字段的类型）
	private int x;// 横坐标
	private int y;// 纵坐标
	private int xCount;// 横向数量
	private int yCount;// 纵向数量
	private WritableCellFormat format;// 格式

	public String geteName() {
		return eName;
	}

	public String getcName() {
		return cName;
	}

	public Object getType() {
		return type;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public void setcName(String cName) {
		this.cName = cName;
	}

	public void setType(Object type) {
		this.type = type;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getxCount() {
		return xCount;
	}

	public int getyCount() {
		return yCount;
	}

	public void setxCount(int xCount) {
		this.xCount = xCount;
	}

	public void setyCount(int yCount) {
		this.yCount = yCount;
	}

	public WritableCellFormat getFormat() {
		return format;
	}

	public void setFormat(WritableCellFormat format) {
		this.format = format;
	}

}
