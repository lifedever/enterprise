package com.app.meibo.finace.model.vo;

import java.util.Date;

/**
 * 订单
 * 
 * @author mashiqiang QQ:1005913089
 * @date 2012-11-13下午9:49:42
 */
public class ProrderCostVO {

	private int id;
	private String customerName;
	private String startDate;
	private String endDate;
	private Date createDate;
	private String userName;
	private double proofMoney;
	private int customerId;
	private int userId;
	private int isDelete; // 0:未删除 1:已删除
	private int proofConut;
	private String orderNo;
	private double proofCost;// 样品销售总价
	private double realCost;// 样品销售实收金额
	private int isManagerAuditFinish;// 厂长审批是否完成 0：未完成 1：完成

	/**
	 * 主键ID
	 * 
	 * @return
	 */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 制作开始时间
	 * 
	 * @return
	 */
	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	/**
	 * 制作结束时间
	 * 
	 * @return
	 */
	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	/**
	 * 创建时间
	 * 
	 * @return
	 */
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	/**
	 * 客户姓名
	 * 
	 * @return
	 */
	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	/**
	 * 业务员姓名
	 * 
	 * @return
	 */
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * 客户ID
	 * 
	 * @return
	 */
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	/**
	 * 业务员ID
	 * 
	 * @return
	 */
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public double getProofMoney() {
		return proofMoney;
	}

	public void setProofMoney(double proofMoney) {
		this.proofMoney = proofMoney;
	}

	/**
	 * 是否删除
	 * 
	 * @return
	 */
	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public int getProofConut() {
		return proofConut;
	}

	public void setProofConut(int proofConut) {
		this.proofConut = proofConut;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProrderCostVO other = (ProrderCostVO) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public double getProofCost() {
		return proofCost;
	}

	public void setProofCost(double proofCost) {
		this.proofCost = proofCost;
	}

	public int getIsManagerAuditFinish() {
		return isManagerAuditFinish;
	}

	public void setIsManagerAuditFinish(int isManagerAuditFinish) {
		this.isManagerAuditFinish = isManagerAuditFinish;
	}

	public double getRealCost() {
		return realCost;
	}

	public void setRealCost(double realCost) {
		this.realCost = realCost;
	}

}
