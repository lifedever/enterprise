package com.app.meibo.operationalPart.cooperation.model.vo;

import java.util.Date;

/**
 * 外发单
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-27 下午11:00:32
 */
public class CooperationOrderVO {
	private Integer id;
	private String cooperationFactory;// 加工单位
	private String cooperationAddress;// 加工单位地址
	private String callMan;// 联系人
	private String phone;// 联系电话
	private String productName;// 产品名称
	private Integer productCount;// 数量
	private Integer payStatus;
	private String productNo;// 加工单号
	private String sendMan;// 派单员
	private Date setOrderDate;// 下单时间
	private Date returnProductDate;// 交货时间
	private Date linkDate;// 联系时间
	private double price;// 单价
	private String required;// 材质要求
	private String image;// 图像
	private String factoryName;
	private String factoryTel;
	private String factoryAddress;
	private String factorySite;
	private String factoryEmail;
	private int instoreCount;// 剩余入库数量
	private Integer idVehicle;//加工单ID 目的：车辆管理使用
	private Integer idLogistics;//加工单ID 目的：物流管理使用

	public Integer getId() {
		return id;
	}

	public String getCooperationFactory() {
		return cooperationFactory;
	}

	public String getCallMan() {
		return callMan;
	}

	public String getPhone() {
		return phone;
	}

	public String getProductName() {
		return productName;
	}

	public Integer getProductCount() {
		return productCount;
	}

	public String getCooperationAddress() {
		return cooperationAddress;
	}

	public void setCooperationAddress(String cooperationAddress) {
		this.cooperationAddress = cooperationAddress;
	}

	public String getProductNo() {
		return productNo;
	}

	public Integer getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(Integer payStatus) {
		this.payStatus = payStatus;
	}

	public String getSendMan() {
		return sendMan;
	}

	public Date getSetOrderDate() {
		return setOrderDate;
	}

	public Date getReturnProductDate() {
		return returnProductDate;
	}

	public Date getLinkDate() {
		return linkDate;
	}

	public double getPrice() {
		return price;
	}

	public String getRequired() {
		return required;
	}

	public String getImage() {
		return image;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public String getFactoryTel() {
		return factoryTel;
	}

	public String getFactoryAddress() {
		return factoryAddress;
	}

	public String getFactorySite() {
		return factorySite;
	}

	public String getFactoryEmail() {
		return factoryEmail;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCooperationFactory(String cooperationFactory) {
		this.cooperationFactory = cooperationFactory;
	}

	public void setCallMan(String callMan) {
		this.callMan = callMan;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setProductCount(Integer productCount) {
		this.productCount = productCount;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public void setSendMan(String sendMan) {
		this.sendMan = sendMan;
	}

	public void setSetOrderDate(Date setOrderDate) {
		this.setOrderDate = setOrderDate;
	}

	public void setReturnProductDate(Date returnProductDate) {
		this.returnProductDate = returnProductDate;
	}

	public void setLinkDate(Date linkDate) {
		this.linkDate = linkDate;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setRequired(String required) {
		this.required = required;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public void setFactoryTel(String factoryTel) {
		this.factoryTel = factoryTel;
	}

	public void setFactoryAddress(String factoryAddress) {
		this.factoryAddress = factoryAddress;
	}

	public void setFactorySite(String factorySite) {
		this.factorySite = factorySite;
	}

	public void setFactoryEmail(String factoryEmail) {
		this.factoryEmail = factoryEmail;
	}

	public int getInstoreCount() {
		return instoreCount;
	}

	public void setInstoreCount(int instoreCount) {
		this.instoreCount = instoreCount;
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

}
