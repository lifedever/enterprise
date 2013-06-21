package com.app.meibo.storeroom.finishedProduct.model.vo;

import java.util.Date;

/**
 * 
 * @author MSQ
 * @email gefangshuai@163.com
 * @createdata 2013-2-23 上午11:57:12
 */
public class FinishedProductVO {
	private Integer id;
	private String productName;// 产品名称
	private String productNo;// 产品编号
	private int productCount = 0;// 产品数量
	private String contourSize;// 外形尺寸
	private String qualityRequire;// 质量要求
	private String printColor;// 印刷几色
	private String printRequire;// 印刷要求
	private String projectImage;// 工程图
	private String effectImage;// 效果图
	private String orderNo;// 订单编号
	private double price;// 单价
	private Integer offerState = 0;// 是否要求报价 1:要求 0：不要求
	private Integer isComplete = 0;// 是否完成 1:完成 0：未完成
	private Date createDate = new Date();
	private String producer; // 生产者
	private int isDelete = 0; // 0:未删除 1:已删除
	private int isProof = 0;// 是否为样品

	public Integer getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductNo() {
		return productNo;
	}

	public int getProductCount() {
		return productCount;
	}

	public String getQualityRequire() {
		return qualityRequire;
	}

	public String getPrintColor() {
		return printColor;
	}

	public String getPrintRequire() {
		return printRequire;
	}

	public String getProjectImage() {
		return projectImage;
	}

	public String getEffectImage() {
		return effectImage;
	}

	public double getPrice() {
		return price;
	}

	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Integer getOfferState() {
		return offerState;
	}

	public Integer getIsComplete() {
		return isComplete;
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

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public void setQualityRequire(String qualityRequire) {
		this.qualityRequire = qualityRequire;
	}

	public void setPrintColor(String printColor) {
		this.printColor = printColor;
	}

	public void setPrintRequire(String printRequire) {
		this.printRequire = printRequire;
	}

	public void setProjectImage(String projectImage) {
		this.projectImage = projectImage;
	}

	public void setEffectImage(String effectImage) {
		this.effectImage = effectImage;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setOfferState(Integer offerState) {
		this.offerState = offerState;
	}

	public void setIsComplete(Integer isComplete) {
		this.isComplete = isComplete;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public String getContourSize() {
		return contourSize;
	}

	public void setContourSize(String contourSize) {
		this.contourSize = contourSize;
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
}
