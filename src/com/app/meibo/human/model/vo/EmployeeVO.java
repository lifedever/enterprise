package com.app.meibo.human.model.vo;

import java.util.Date;

/**
 * 员工考勤薪水
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-12-15 下午3:25:10
 */
public class EmployeeVO {

	private Integer id;
	private String empNo;// 员工编号
	private String empName;// 员工姓名
	private String empID;// 员工身份证
	private String empOrigin;// 员工籍贯
	private String empContact;// 员工联系方式
	private String empSex;// 员工性别
	private String empEdu;// 学历
	private String empDeptName;// 员工部门
	private Integer empDeptId;// 部门id
	private String empPositionName;// 员工职位
	private Date createDate;// 入职时间--创建时间

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmpOrigin() {
		return empOrigin;
	}

	public void setEmpOrigin(String empOrigin) {
		this.empOrigin = empOrigin;
	}

	public String getEmpContact() {
		return empContact;
	}

	public void setEmpContact(String empContact) {
		this.empContact = empContact;
	}

	public String getEmpSex() {
		return empSex;
	}

	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}

	public String getEmpEdu() {
		return empEdu;
	}

	public void setEmpEdu(String empEdu) {
		this.empEdu = empEdu;
	}

	public String getEmpDeptName() {
		return empDeptName;
	}

	public void setEmpDeptName(String empDeptName) {
		this.empDeptName = empDeptName;
	}

	public String getEmpPositionName() {
		return empPositionName;
	}

	public void setEmpPositionName(String empPositionName) {
		this.empPositionName = empPositionName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getEmpDeptId() {
		return empDeptId;
	}

	public void setEmpDeptId(Integer empDeptId) {
		this.empDeptId = empDeptId;
	}

}
