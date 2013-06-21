package com.app.meibo.order.model.vo;

import java.util.Date;

public class OrderVO {
	private Integer id;
	private Date startDate;// 开始时间
	private Date endDate;// 结束时间
	private Integer userId;// 业务员Id
	private String username;// 业务员Id
	private Integer departmentId;// 业务员部门Id
	private String customerName;
	private Integer customerId;
	private String orderNo;// 订单编号
	private String contractNo;// 合同编号
	private int signState;// 是否签单
	private int isDelete; // 0:未删除 1:已删除
	private int isProof = 0;// 是否是样品，1：是，0：不是
	private Date createDate = new Date();
	private int isAudit = 0;// 是否审批
	private String auditUser;// 审批人
	private double allCount;// 全款
	private double hasCount;// 已收款
	private String orderStatus;

	public String getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	public Integer getId() {
		return id;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public Integer getUserId() {
		return userId;
	}

	public int getIsAudit() {
		return isAudit;
	}

	public void setIsAudit(int isAudit) {
		this.isAudit = isAudit;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getSignState() {
		return signState;
	}

	public void setSignState(int signState) {
		this.signState = signState;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public int getIsProof() {
		return isProof;
	}

	public void setIsProof(int isProof) {
		this.isProof = isProof;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getAllCount() {
		return allCount;
	}

	public double getHasCount() {
		return hasCount;
	}

	public void setAllCount(double allCount) {
		this.allCount = allCount;
	}

	public void setHasCount(double hasCount) {
		this.hasCount = hasCount;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

}
