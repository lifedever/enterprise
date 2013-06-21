package com.app.meibo.customer.model.vo;

import java.util.Date;

public class CustomerVO {
	private Integer id; // 客户ID
	private String company; // 单位名称
	private String customerName; // 客户姓名
	private String mobile; // 手机
	private String address;// 地址
	private String fax;// 传真
	private String telphone; // 电话
	private String webSite; // 网站
	private String email; // 邮箱
	private String QQ; // QQ
	private String MSN; // MSN
	private String wangWang; // 旺旺
	private String feiXin; // 飞信
	private String remark;// 备注
	private Date visitTime = new Date(); // 询单时间
	private Date createDate = new Date(); // 创建时间
	private int isDelete = 0;
	private Integer userId;// 业务员Id
	private String userName;// 业务员名字
	private Date offerDate;// 最近一次询价时间
	private String modifyUsername;// 修改人信息（重新指定业务员的业务经理的名字）

	public String getModifyUsername() {
		return modifyUsername;
	}

	public void setModifyUsername(String modifyUsername) {
		this.modifyUsername = modifyUsername;
	}

	public Integer getId() {
		return id;
	}

	public String getCompany() {
		return company;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getMobile() {
		return mobile;
	}

	public String getTelphone() {
		return telphone;
	}

	public String getWebSite() {
		return webSite;
	}

	public String getEmail() {
		return email;
	}

	public String getQQ() {
		return QQ;
	}

	public String getMSN() {
		return MSN;
	}

	public String getWangWang() {
		return wangWang;
	}

	public String getFeiXin() {
		return feiXin;
	}

	public String getRemark() {
		return remark;
	}

	public Date getVisitTime() {
		return visitTime;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public Integer getUserId() {
		return userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setTelphone(String telphone) {
		this.telphone = telphone;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setQQ(String qQ) {
		QQ = qQ;
	}

	public void setMSN(String mSN) {
		MSN = mSN;
	}

	public void setWangWang(String wangWang) {
		this.wangWang = wangWang;
	}

	public void setFeiXin(String feiXin) {
		this.feiXin = feiXin;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setVisitTime(Date visitTime) {
		this.visitTime = visitTime;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Date getOfferDate() {
		return offerDate;
	}

	public void setOfferDate(Date offerDate) {
		this.offerDate = offerDate;
	}

	public String getAddress() {
		return address;
	}

	public String getFax() {
		return fax;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

}
