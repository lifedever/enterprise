package com.app.meibo.storeroom.buyrequest.model.vo;

import java.util.Date;

/**
 * 请购单
 * @author MSQ
 * @email gefangshuai@163.com
 * @createdata 2013-3-4 下午9:17:52
 */
public class BuyRequestVO {
	
	private Integer id; //id
	
	private String requester; //请购人
	
	private String buyer; //采购人
	
	private Date createDate = new Date();
	
	private int isDelete = 0;
	
	private String buyRequestNo;//请购单号
	
	private Date buyDate;//采购日期
	
	private double totalPrice; //采购总价 主要用于财务拨款

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRequester() {
		return requester;
	}

	public void setRequester(String requester) {
		this.requester = requester;
	}

	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public String getBuyRequestNo() {
		return buyRequestNo;
	}

	public void setBuyRequestNo(String buyRequestNo) {
		this.buyRequestNo = buyRequestNo;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

}
