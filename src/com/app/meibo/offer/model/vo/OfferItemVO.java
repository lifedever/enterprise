package com.app.meibo.offer.model.vo;

import java.util.Date;

/**
 * 报价单条目
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-8 下午8:00:37
 */
public class OfferItemVO {
	private Integer id;
	private String productName;// 产品名称
	private String contourSize;// 外形尺寸
	private int productCount = 0;// 产品数量
	private String qualityRequire;// 质量要求
	private String printColor;// 印刷几色
	private String printRequire;// 印刷要求
	private String projectImage;// 工程图
	private String effectImage;// 效果图
	private int offerCount;// 报价次数
	private double productPrice;// 已报价格
	private Date createDate = new Date();

	public Integer getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public String getContourSize() {
		return contourSize;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setContourSize(String contourSize) {
		this.contourSize = contourSize;
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

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getOfferCount() {
		return offerCount;
	}

	public void setOfferCount(int offerCount) {
		this.offerCount = offerCount;
	}

	public double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

}
