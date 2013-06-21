package com.app.meibo.message.model;

/**
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-11-30 下午10:57:01
 */
public enum MessageType {
	SYSTEM("系统提示", 1), USER("用户信息", 2);
	private String typeName;
	private int typeValue;

	/**
	 * 消息类型名称
	 * 
	 * @return
	 */
	public String getTypeName() {
		return typeName;
	}

	/**
	 * 消息类型值
	 * 
	 * @return
	 */
	public int getTypeValue() {
		return typeValue;
	}

	/**
	 * 根据类型值获取类型名
	 * 
	 * @param typeName
	 */
	public static String getTypeNameByValue(int value) {
		String typeName = "";
		for (MessageType type : MessageType.values()) {
			if (type.typeValue == value) {
				typeName = type.typeName;
				break;
			}
		}
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void setTypeValue(int typeValue) {
		this.typeValue = typeValue;
	}

	private MessageType(String typeName, int typeValue) {
		this.typeName = typeName;
		this.typeValue = typeValue;
	}

	public static void main(String[] args) {
		System.out.println(USER.typeName);
	}
}
