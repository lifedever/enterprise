package com.app.meibo.contract.model.vo;

import java.util.Date;

public class ContractVO {
	private Integer id;
	private String contractNo;// 合同编号
	private Date signDate;// 签订日期
	private Date validateDate;// 有效期
	private String content;// 内容
	private String provider;// 供方
	private String buyer;// 需方
	private int isAudit = 0;// 0 :未审核 1:审核
	private String contractAtta;// 合同附件
	private Date createDate = new Date();
	private int isDelete = 0; // 0:未删除 1:已删除
	private String orderNo;
	private Integer orderId;// 订单Id

	public Integer getId() {
		return id;
	}

	public String getContractNo() {
		return contractNo;
	}

	public Date getSignDate() {
		return signDate;
	}

	public Date getValidateDate() {
		return validateDate;
	}

	public String getContent() {
		return content;
	}

	public String getProvider() {
		return provider;
	}

	public String getContractAtta() {
		return contractAtta;
	}

	public void setContractAtta(String contractAtta) {
		this.contractAtta = contractAtta;
	}

	public String getBuyer() {
		return buyer;
	}

	public int getIsAudit() {
		return isAudit;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public void setValidateDate(Date validateDate) {
		this.validateDate = validateDate;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public void setIsAudit(int isAudit) {
		this.isAudit = isAudit;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

}
