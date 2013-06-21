package com.app.meibo.constant;

/**
 * 文件存放的相对路径
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-12-8 上午11:23:23
 */
public enum FilePathEnum {
	PROJECTIMAGE("projectImage", "/upload/image/projectImage/"), // 工程图
	EFFECTIMAGE("effectImage", "/upload/image/effectImage/"), // 效果图
	EMPLOYEE_IMAGE("employeeImage", "/upload/image/employee/"),// 员工照片
	CONTRACT_ATTA("contractAtta", "/upload/atta/contract/");// 合同附件
	FilePathEnum(String type, String path) {
		this.type = type;
		this.path = path;
	}

	private String type;
	private String path;

	public String getType() {
		return type;
	}

	public String getPath() {
		return path;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
