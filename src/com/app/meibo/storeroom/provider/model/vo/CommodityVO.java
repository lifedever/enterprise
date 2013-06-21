package com.app.meibo.storeroom.provider.model.vo;

import java.util.Date;

/**
 * 供应的产品
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-12-6 下午9:28:34
 */
public class CommodityVO {
	private Integer id;
	private String name;// 产品名称
	private double price;// 产品单价
	private String image;// 产品图片
	private String providerName;// 供应商名称
	private Integer providerId;// 供应商名称
	private String standard;// 商品规格
	private String unit;// 商品单位
	private int count;// 数量
	private String classifyName;// 分类
	private Integer classifyId;//分类Id
	private String thickness; // 厚度
	private String color;// 颜色
	private Date createDate;
	private String pickinger;

	public Integer getId() {
		return id;
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

	public String getProviderName() {
		return providerName;
	}

	public void setProviderName(String providerName) {
		this.providerName = providerName;
	}

	public Integer getProviderId() {
		return providerId;
	}

	public void setProviderId(Integer providerId) {
		this.providerId = providerId;
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

	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
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

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getClassifyId() {
		return classifyId;
	}

	public void setClassifyId(Integer classifyId) {
		this.classifyId = classifyId;
	}

	public String getPickinger() {
		return pickinger;
	}

	public void setPickinger(String pickinger) {
		this.pickinger = pickinger;
	}
}
