package com.app.meibo.constant;

/**
 * 文件存放的相对路径
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-12-8 上午11:23:23
 */
public enum ExpenditureEnum {
	PROOF("0"), // 样品费0
	PREPAY("1"), // 预付款
	TOTALCOST("2"), // 订单全款
	COOPERATIONORDER("3"), // 外发
	SALARY("4"), // 工资
	BUYREQUEST("5"), // 请购
	WORKSHEET("6");// 加工单
	ExpenditureEnum(String type) {
		this.type = type;
	}

	private String type;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
