package com.app.meibo.offer.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 具体报价
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-8 下午8:00:48
 */
@Entity
@Table(name = "offer_money")
public class OfferMoney {
	private Integer id;
	private double price;// 单价
	private double money;// 总价
	private OfferItem offerItem;
	private int askState = 0;// 同意报价状态：0：未同意，1：同意
	private Date createDate = new Date();
	private String auditRemark;// 报价备注
	private String askRemark;// 询价备注
	private int isDelete = 0;
	private String auditUser;// 审批人

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

	public double getMoney() {
		return money;
	}

	@ManyToOne
	@JoinColumn(name = "offerItemId")
	public OfferItem getOfferItem() {
		return offerItem;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public void setOfferItem(OfferItem offerItem) {
		this.offerItem = offerItem;
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

	public String getAuditRemark() {
		return auditRemark;
	}

	public void setAuditRemark(String auditRemark) {
		this.auditRemark = auditRemark;
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
