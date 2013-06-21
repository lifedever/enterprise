package com.app.meibo.order.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.meibo.customer.model.Customer;

/**
 * 订单
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-17 下午9:23:23
 */
@Entity
@Table(name = "t_order")
public class Order {
	private Integer id;
	private Date startDate;// 开始时间
	private Date endDate;// 结束时间
	private Integer userId;// 业务员Id
	private Integer departmentId;// 业务员部门Id
	private Customer customer;// 对应客户
	private String orderNo;// 订单编号
	private int isDelete = 0; // 0:未删除 1:已删除
	private int isProof = 0;// 是否是样品，1：是，0：不是
	private int signState = 0;// 是否签单
	private int isAudit = 0;// 是否审批
	private String orderStatus;//订单状态
	private String auditUser;// 审批人
	private Date createDate = new Date();

	/**
	 * 主键
	 * 
	 * @return
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

	public Integer getDepartmentId() {
		return departmentId;
	}

	@ManyToOne
	@JoinColumn(name = "customerId")
	public Customer getCustomer() {
		return customer;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public int getIsDelete() {
		return isDelete;
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

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public int getSignState() {
		return signState;
	}

	public void setSignState(int signState) {
		this.signState = signState;
	}

	public int getIsAudit() {
		return isAudit;
	}

	public void setIsAudit(int isAudit) {
		this.isAudit = isAudit;
	}

	public int getIsProof() {
		return isProof;
	}

	public void setIsProof(int isProof) {
		this.isProof = isProof;
	}

	public String getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

}
