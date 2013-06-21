package com.app.meibo.storeroom.provider.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 供应的产品
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-12-6 下午9:28:34
 */
@Entity
@Table(name = "commodity")
public class Commodity {
	private Integer id;
	private String name;// 产品名称
	private double price;// 产品单价
	private String image;// 产品图片
	private String standard;// 商品规格
	private String unit;// 商品单位
	private String thickness;// 厚度
	private String color;// 颜色
	private int count;// 数量
	private Provider provider;
	private String pickinger;
	private CommodityClassify commodityClassify;// 分类
	private Date createDate = new Date();
	private int isDelete = 0;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	@ManyToOne()
	@JoinColumn(name = "providerId")
	public Provider getProvider() {
		return provider;
	}

	public void setProvider(Provider provider) {
		this.provider = provider;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getImage() {
		return image;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	@ManyToOne()
	@JoinColumn(name = "commodityClassifyId")
	public CommodityClassify getCommodityClassify() {
		return commodityClassify;
	}

	public void setCommodityClassify(CommodityClassify commodityClassify) {
		this.commodityClassify = commodityClassify;
	}

	public String getThickness() {
		return thickness;
	}

	public void setThickness(String thickness) {
		this.thickness = thickness;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getPickinger() {
		return pickinger;
	}

	public void setPickinger(String pickinger) {
		this.pickinger = pickinger;
	}
	
}
