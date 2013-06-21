package com.app.permission.model.vo;

import java.util.Date;

public class UserVO {
	private Integer id;
	private String username;
	private String password = "123456";
	private String realName;
	private String roleName; // 角色名
	private Integer roleId; // 角色ID
	private String departmentName;
	private Integer departmentId;
	private String departmentCode;
	private String sex;
	private Integer activeFlag = 1;// 是否有效:1有效，0无效
	private String tel;
	private String email;
	private String description;
	private Date createDate = new Date();
	private String idcard;
	private Date loginTime;//
	private String userSecurity;// 用户密级
	private String address;// 现住址
	private String mobileTel;// 手机号
	private String homeTel;// 家庭电话

	public Integer getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getRealName() {
		return realName;
	}

	public String getSex() {
		return sex;
	}

	public Integer getActiveFlag() {
		return activeFlag;
	}

	public String getTel() {
		return tel;
	}

	public String getEmail() {
		return email;
	}

	public String getDescription() {
		return description;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public String getIdcard() {
		return idcard;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public String getUserSecurity() {
		return userSecurity;
	}

	public String getAddress() {
		return address;
	}

	public String getMobileTel() {
		return mobileTel;
	}

	public String getHomeTel() {
		return homeTel;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public void setActiveFlag(Integer activeFlag) {
		this.activeFlag = activeFlag;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public void setUserSecurity(String userSecurity) {
		this.userSecurity = userSecurity;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setMobileTel(String mobileTel) {
		this.mobileTel = mobileTel;
	}

	public void setHomeTel(String homeTel) {
		this.homeTel = homeTel;
	}

	public void getObj() {

	}

	public String getRoleName() {
		return roleName;
	}

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public String getDepartmentCode() {
		return departmentCode;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}

}
