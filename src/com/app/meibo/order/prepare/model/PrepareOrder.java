package com.app.meibo.order.prepare.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.meibo.order.model.OrderItem;
import com.app.meibo.worksheet.model.Worksheet;

@Entity
@Table(name = "prepare_order")
public class PrepareOrder {
	private Integer id;
	private String useCondition;// 单个产品用料情况
	private String remark;// 备注
	private String prepareNo;// 备料单号
	private String auditUser;// 审核人
	private OrderItem orderItem;
	private Date createDate = new Date();
	private Worksheet worksheet;
	private int isDelete = 0;//

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

	public String getUseCondition() {
		return useCondition;
	}

	public String getRemark() {
		return remark;
	}

	public String getAuditUser() {
		return auditUser;
	}

	@ManyToOne
	@JoinColumn(name = "orderItemId")
	public OrderItem getOrderItem() {
		return orderItem;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUseCondition(String useCondition) {
		this.useCondition = useCondition;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	public void setOrderItem(OrderItem orderItem) {
		this.orderItem = orderItem;
	}

	public String getPrepareNo() {
		return prepareNo;
	}

	public void setPrepareNo(String prepareNo) {
		this.prepareNo = prepareNo;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	@ManyToOne
	@JoinColumn(name = "worksheetId")
	public Worksheet getWorksheet() {
		return worksheet;
	}

	public void setWorksheet(Worksheet worksheet) {
		this.worksheet = worksheet;
	}

}
