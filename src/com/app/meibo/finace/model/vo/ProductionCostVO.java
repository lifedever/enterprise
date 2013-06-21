package com.app.meibo.finace.model.vo;

public class ProductionCostVO {
	
	private String productNo; //加工单号
	
	private String productName; //产品名称
	
	private double singleCost; //单个成品成本费
	
	private int productCount = 0;// 产品数量
	
	private String contourSize;// 外形尺寸/规格
	
	private String craftwork;// 工艺
	
	private String projectImage;// 工程图
	
	private String effectImage;// 效果图
	
	private double totalCost;//该加工单总费用
	
	private int isProof;// 样品还是产品：1：样品。0：产品

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public double getSingleCost() {
		return singleCost;
	}

	public void setSingleCost(double singleCost) {
		this.singleCost = singleCost;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getIsProof() {
		return isProof;
	}

	public void setIsProof(int isProof) {
		this.isProof = isProof;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public String getContourSize() {
		return contourSize;
	}

	public void setContourSize(String contourSize) {
		this.contourSize = contourSize;
	}

	public String getCraftwork() {
		return craftwork;
	}

	public void setCraftwork(String craftwork) {
		this.craftwork = craftwork;
	}

	public String getProjectImage() {
		return projectImage;
	}

	public void setProjectImage(String projectImage) {
		this.projectImage = projectImage;
	}

	public String getEffectImage() {
		return effectImage;
	}

	public void setEffectImage(String effectImage) {
		this.effectImage = effectImage;
	}
	
}
