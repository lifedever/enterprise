package com.app.meibo.finace.model.vo;

import java.util.Date;

public class FinishedFeeVO {
	
	private Integer id;
	
	private String orderNo; //订单编号
	
	private double allCount; //全款
	
	private double hasCount; //已收款
	
	private int isDelete = 0; //是否删除 0未删除 1 已删除
	
	private String payee; //收款人
	
	private String payer; //付款方
	
	private String accountNo; //银行账户
	
	private String accountName; //银行名称
	
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getPayee() {
		return payee;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public String getPayer() {
		return payer;
	}

	public void setPayer(String payer) {
		this.payer = payer;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
}
