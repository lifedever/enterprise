package com.app.meibo.storeroom.buyrequest.model.vo;

import java.util.Date;

/**
 * 
 * @author MSQ
 * @email gefangshuai@163.com
 * @createdata 2013-3-4 下午9:33:21
 */
public class BuyRequestItemVO {
	
	private Integer id;
	
	private String name;//名称
	
	private String standard;//标准
	
	private int count = 0; //数量
	
	private String unit; //单位
	
	private double valuation;//估价
	
	private String purpose;//用途
	
	private String beizhu;//备注
	
	private int isDelete = 0;
	
	private Date createDate = new Date();
	
	private String buyRequestNo;//请购单号

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public double getValuation() {
		return valuation;
	}

	public void setValuation(double valuation) {
		this.valuation = valuation;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public String getBeizhu() {
		return beizhu;
	}

	public void setBeizhu(String beizhu) {
		this.beizhu = beizhu;
	}

	public Date getCreateDate() {
		return createDate;
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

	public String getBuyRequestNo() {
		return buyRequestNo;
	}

	public void setBuyRequestNo(String buyRequestNo) {
		this.buyRequestNo = buyRequestNo;
	}
	
}
