package com.app.meibo.contract.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.app.meibo.order.model.Order;

/**
 * 合同
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-20 下午10:12:51
 */
@Entity
@Table(name = "contract")
public class Contract {
	private Integer id;
	private String contractNo;// 合同编号
	private Date signDate;// 签订日期
	private Date validateDate;// 有效期
	private String content;// 内容
	private String provider;// 供方
	private String buyer;// 需方
	private int isAudit = 0;// 0 :未审核 1:审核
	private Date createDate = new Date();
	private int isDelete = 0; // 0:未删除 1:已删除
	private Order order;
	private String contractAtta;// 合同附件
	private Integer userId;// 业务员Id
	private Integer departmentId;// 业务员部门Id

	/**
	 * 主键ID
	 * 
	 * @return
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public Date getSignDate() {
		return signDate;
	}

	public String getContractNo() {
		return contractNo;
	}

	public Date getValidateDate() {
		return validateDate;
	}

	public String getContent() {
		return content;
	}

	public int getIsAudit() {
		return isAudit;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public int getIsDelete() {
		return isDelete;
	}

	/**
	 * 订单
	 * 
	 * @return
	 */
	@OneToOne
	@JoinColumn(name = "orderId")
	public Order getOrder() {
		return order;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setSignDate(Date signDate) {
		this.signDate = signDate;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public void setValidateDate(Date validateDate) {
		this.validateDate = validateDate;
	}

	public void setContent(String content) {
		this.content = content;
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

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getProvider() {
		return provider;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public Integer getUserId() {
		return userId;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getContractAtta() {
		return contractAtta;
	}

	public void setContractAtta(String contractAtta) {
		this.contractAtta = contractAtta;
	}

}
