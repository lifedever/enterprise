package com.app.meibo.operationalPart.cooperation.model.vo;

import java.util.Date;

/**
 * 协作工厂，外发工厂
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-1-7 下午9:23:41
 */
public class CooperationFactoryVO {
	private Integer id;// Id
	private String factoryNo;// 工厂编号
	private String factoryName;// 工厂名称
	private String factoryProp;// 工厂性质
	private Integer factoryStar;// 工厂星级
	private String factorySite;// 工厂网址
	private String contactMan;// 联系人
	private String phone;// 电话
	private String fax;// 传真
	private String mobile;// 手机
	private String qq;// QQ
	private String address;// 地址
	private String remark;// 备注
	private int isDelete = 0;
	private Date createDate = new Date();

	public Integer getId() {
		return id;
	}

	public String getFactoryNo() {
		return factoryNo;
	}

	public String getFactoryName() {
		return factoryName;
	}

	public String getFactoryProp() {
		return factoryProp;
	}

	public Integer getFactoryStar() {
		return factoryStar;
	}

	public String getFactorySite() {
		return factorySite;
	}

	public String getContactMan() {
		return contactMan;
	}

	public String getPhone() {
		return phone;
	}

	public String getFax() {
		return fax;
	}

	public String getMobile() {
		return mobile;
	}

	public String getQq() {
		return qq;
	}

	public String getAddress() {
		return address;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setFactoryNo(String factoryNo) {
		this.factoryNo = factoryNo;
	}

	public void setFactoryName(String factoryName) {
		this.factoryName = factoryName;
	}

	public void setFactoryProp(String factoryProp) {
		this.factoryProp = factoryProp;
	}

	public void setFactoryStar(Integer factoryStar) {
		this.factoryStar = factoryStar;
	}

	public void setFactorySite(String factorySite) {
		this.factorySite = factorySite;
	}

	public void setContactMan(String contactMan) {
		this.contactMan = contactMan;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
