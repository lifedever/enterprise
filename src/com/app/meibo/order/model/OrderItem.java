package com.app.meibo.order.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 订单条目
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-17 下午9:53:41
 */
@Entity
@Table(name = "t_order_item")
public class OrderItem {
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
	private Order order;// 所属订单
	private double price;// 单价
	private int totalbox = 0;//箱数
	private int singlebox = 0;// 个/箱
	private Integer offerState = 0;// 是否要求报价 1:要求 0：不要求
	private Integer isComplete = 0;// 是否完成 1:完成 0：未完成
	private Date createDate = new Date();
	private int isDelete = 0; // 0:未删除 1:已删除

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

	@ManyToOne
	@JoinColumn(name = "orderId")
	public Order getOrder() {
		return order;
	}

	public double getPrice() {
		return price;
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

	public void setOrder(Order order) {
		this.order = order;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	public String getContourSize() {
		return contourSize;
	}

	public void setContourSize(String contourSize) {
		this.contourSize = contourSize;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (id != other.id)
			return false;
		return true;
	}

	public int getSinglebox() {
		return singlebox;
	}

	public void setSinglebox(int singlebox) {
		this.singlebox = singlebox;
	}

	public int getTotalbox() {
		return totalbox;
	}

	public void setTotalbox(int totalbox) {
		this.totalbox = totalbox;
	}

	
}
