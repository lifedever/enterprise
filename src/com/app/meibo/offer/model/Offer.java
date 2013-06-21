package com.app.meibo.offer.model;

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
 * 报价单
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-8 下午8:00:24
 */
@Entity
@Table(name = "offer")
public class Offer {
	private Integer id;
	private String remark;// 备注信息
	private Customer customer;// 相关客户
	private Date createDate = new Date();
	private int isDelete = 0;
	private String orderNo;// 订单编号
	private int isOrder = 0;// 是否生成了订单
	private int isProof = 0;// 是否是样品，1：是，0：不是
	private String offerUser;// 审批人
	private Integer userId;// 业务员Id
	private Integer departmentId;// 业务员部门Id

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

	public String getRemark() {
		return remark;
	}

	@ManyToOne
	@JoinColumn(name = "customerId")
	public Customer getCustomer() {
		return customer;
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

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
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

}
