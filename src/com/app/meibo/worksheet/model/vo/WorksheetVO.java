package com.app.meibo.worksheet.model.vo;

import java.util.Date;

/**
 * 加工单
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-25 下午9:39:15
 */
public class WorksheetVO {
	private Integer id;
	private String productName;// 产品名称
	private String productNo;// 产品编号
	private String contourSize;// 外形尺寸/规格
	private int productCount = 0;// 产品数量
	private int instoreCount = 0;//入库数量
	private String projectImage;// 工程图
	private String effectImage;// 效果图
	private String craftwork;// 工艺
	private Date startDate;// 开始时间
	private Date endDate;// 结束时间
	private int isProof;// 样品还是产品：1：样品。0：产品
	private Date createDate = new Date();
	private Integer idVehicle;//加工单ID 目的：车辆管理使用
	private Integer idLogistics;//加工单ID 目的：物流管理使用

	public Integer getId() {
		return id;
	}

	public String getProductName() {
		return productName;
	}

	public String getProductNo() {
		return productNo;
	}

	public String getContourSize() {
		return contourSize;
	}

	public int getProductCount() {
		return productCount;
	}

	public String getProjectImage() {
		return projectImage;
	}

	public String getEffectImage() {
		return effectImage;
	}

	public String getCraftwork() {
		return craftwork;
	}

	public Date getStartDate() {
		return startDate;
	}

	public Date getEndDate() {
		return endDate;
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

	public void setContourSize(String contourSize) {
		this.contourSize = contourSize;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public void setProjectImage(String projectImage) {
		this.projectImage = projectImage;
	}

	public void setEffectImage(String effectImage) {
		this.effectImage = effectImage;
	}

	public void setCraftwork(String craftwork) {
		this.craftwork = craftwork;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	

	public Integer getIdVehicle() {
		return idVehicle;
	}

	public void setIdVehicle(Integer idVehicle) {
		this.idVehicle = idVehicle;
	}

	public Integer getIdLogistics() {
		return idLogistics;
	}

	public void setIdLogistics(Integer idLogistics) {
		this.idLogistics = idLogistics;
	}

	public int getIsProof() {
		return isProof;
	}

	public void setIsProof(int isProof) {
		this.isProof = isProof;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getInstoreCount() {
		return instoreCount;
	}

	public void setInstoreCount(int instoreCount) {
		this.instoreCount = instoreCount;
	}

}
