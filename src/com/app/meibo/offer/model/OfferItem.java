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
 * 报价单条目
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-8 下午8:00:37
 */
@Entity
@Table(name = "offer_item")
public class OfferItem {
	private Integer id;
	private String productName;// 产品名称
	private String contourSize;// 外形尺寸
	private int productCount = 0;// 产品数量
	private String qualityRequire;// 质量要求
	private String printColor;// 印刷几色
	private String printRequire;// 印刷要求
	private String projectImage;// 工程图
	private String effectImage;// 效果图
	private Offer offer;// 相关询价单
	private Date createDate = new Date();
	private int isDelete = 0;

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

	public String getContourSize() {
		return contourSize;
	}

	public String getPrintColor() {
		return printColor;
	}

	public String getQualityRequire() {
		return qualityRequire;
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

	@ManyToOne
	@JoinColumn(name = "offerId")
	public Offer getOffer() {
		return offer;
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

	public void setPrintColor(String printColor) {
		this.printColor = printColor;
	}

	public void setQualityRequire(String qualityRequire) {
		this.qualityRequire = qualityRequire;
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

	public void setOffer(Offer offer) {
		this.offer = offer;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getProductCount() {
		return productCount;
	}

	public void setProductCount(int productCount) {
		this.productCount = productCount;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

}
