package com.app.meibo.offer.model.vo;

import java.util.Date;

public class OfferVO {
	private Integer id;
	private String remark;// 备注信息
	private int itemCount;// 条目个数
	private String username;//
	private Integer customerId;
	private String customerName;
	private int offerState;// 0：未同意报价，1：已同意报价
	private int moneyState;// 0：已报价，1：未报价
	private int isOrder = 0;// 是否生成了订单
	private int isProof = 0;// 是否是样品，1：是，0：不是
	private String orderNo;// 订单编号
	private Date createDate = new Date();
	private String offerUser;// 审批人
	private int signState = 0;// 签单状态
	private String contractNo;

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public Integer getId() {
		return id;
	}

	public String getRemark() {
		return remark;
	}

	public int getItemCount() {
		return itemCount;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getOfferState() {
		return offerState;
	}

	public void setOfferState(int offerState) {
		this.offerState = offerState;
	}

	public int getMoneyState() {
		return moneyState;
	}

	public void setMoneyState(int moneyState) {
		this.moneyState = moneyState;
	}

	public int getIsOrder() {
		return isOrder;
	}

	public void setIsOrder(int isOrder) {
		this.isOrder = isOrder;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public int getIsProof() {
		return isProof;
	}

	public void setIsProof(int isProof) {
		this.isProof = isProof;
	}

	public String getOfferUser() {
		return offerUser;
	}

	public void setOfferUser(String offerUser) {
		this.offerUser = offerUser;
	}

	public int getSignState() {
		return signState;
	}

	public void setSignState(int signState) {
		this.signState = signState;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
