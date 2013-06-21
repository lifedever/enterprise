package com.app.meibo.worksheet.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 加工单
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-25 下午9:39:15
 */
@Entity
@Table(name = "worksheet")
public class Worksheet {
	private Integer id;
	private String productName;// 产品名称
	private String productNo;// 产品编号
	private String contourSize;// 外形尺寸/规格
	private int instoreCount = 0;//入库数量
	private int productCount = 0;// 产品数量
	private String projectImage;// 工程图
	private String effectImage;// 效果图
	private String craftwork;// 工艺
	private Date startDate;// 开始时间
	private Date endDate;// 结束时间
	private int isProof;// 样品还是产品：1：样品。0：产品
	private int isDelete = 0;
	private Date createDate = new Date();

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

	public String getProductName() {
		return productName;
	}

	public String getProductNo() {
		return productNo;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
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

	public int getIsProof() {
		return isProof;
	}

	public void setIsProof(int isProof) {
		this.isProof = isProof;
	}

	public int getInstoreCount() {
		return instoreCount;
	}

	public void setInstoreCount(int instoreCount) {
		this.instoreCount = instoreCount;
	}
	
}
