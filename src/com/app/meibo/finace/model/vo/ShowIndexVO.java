package com.app.meibo.finace.model.vo;

import java.util.Date;

public class ShowIndexVO {
	
	private Integer id;
	
	private String orderNo; //订单编号
	
	private double allCount; //全款
	
	private double hasCount; //已收款
	
	private int isDelete = 0; //是否删除 0未删除 1 已删除
	
	private String customerName; //客户姓名
	
	private String payee; //收款人
	
	private int isProof = 0;// 是否是样品，1：是，0：不是
	
	private Date createDate;// 创建日期

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public double getAllCount() {
		return allCount;
	}

	public void setAllCount(double allCount) {
		this.allCount = allCount;
	}

	public double getHasCount() {
		return hasCount;
	}

	public void setHasCount(double hasCount) {
		this.hasCount = hasCount;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getIsProof() {
		return isProof;
	}

	public void setIsProof(int isProof) {
		this.isProof = isProof;
	}
	
}
