package com.app.meibo.finace.model.vo;

import java.util.Date;

public class WorksheetCostItemVO {
	private Integer id;
	private double cost;// 花费
	private String remark;// 备注
	private String productNo;// 加工单号
	private Date createDate = new Date();
	private int isDelete = 0;//

	/**
	 * 主键ID
	 * 
	 * @return
	 */
	public Integer getId() {
		return id;
	}

	public double getCost() {
		return cost;
	}

	public String getRemark() {
		return remark;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
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

}
