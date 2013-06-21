package com.app.meibo.offer.model.vo;

import java.util.Date;

/**
 * 具体报价
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-8 下午8:00:48
 */
public class OfferMoneyVO {
	private Integer id;
	private double money;// 总价
	private double price;// 单价
	private int askState = 0;// 同意报价状态：0：未同意，1：同意
	private Date createDate = new Date();
	private String auditRemark;// 报价备注
	private String askRemark;// 询价备注
	private int isDelete = 0;
	private String auditUser;// 审批人

	public Integer getId() {
		return id;
	}

	public double getMoney() {
		return money;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public String getAuditRemark() {
		return auditRemark;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public String getAuditUser() {
		return auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	public String getAskRemark() {
		return askRemark;
	}

	public void setAskRemark(String askRemark) {
		this.askRemark = askRemark;
	}

	public int getAskState() {
		return askState;
	}

	public void setAskState(int askState) {
		this.askState = askState;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
