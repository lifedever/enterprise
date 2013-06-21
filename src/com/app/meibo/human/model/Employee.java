package com.app.meibo.human.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.permission.model.Department;

/**
 * 员工考勤薪水
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-12-15 下午3:25:10
 */
@Entity
@Table(name = "employee")
public class Employee {

	private Integer id;
	private String empNo;// 员工编号
	private String empName;// 员工姓名
	private String empSex;// 员工性别
	private Department empDept;// 员工部门
	private Position empPosition;// 员工职位
	private String empEdu;// 学历
	private String empID;// 员工身份证
	private String empOrigin;// 员工籍贯
	private String empContact;// 员工联系方式
	private Date createDate;// 入职时间--创建时间
	private int isDelete = 0;// 是否删除,是否离职
	private String image;

	/**
	 * 主键ID
	 * 
	 * @return
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getEmpNo() {
		return empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public String getEmpID() {
		return empID;
	}

	public String getEmpOrigin() {
		return empOrigin;
	}

	public String getEmpContact() {
		return empContact;
	}

	public String getEmpSex() {
		return empSex;
	}

	public String getEmpEdu() {
		return empEdu;
	}

	@ManyToOne
	@JoinColumn(name = "empDeptId")
	public Department getEmpDept() {
		return empDept;
	}

	@ManyToOne
	@JoinColumn(name = "empPositionId")
	public Position getEmpPosition() {
		return empPosition;
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

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public void setEmpOrigin(String empOrigin) {
		this.empOrigin = empOrigin;
	}

	public void setEmpContact(String empContact) {
		this.empContact = empContact;
	}

	public void setEmpSex(String empSex) {
		this.empSex = empSex;
	}

	public void setEmpEdu(String empEdu) {
		this.empEdu = empEdu;
	}

	public void setEmpDept(Department empDept) {
		this.empDept = empDept;
	}

	public void setEmpPosition(Position empPosition) {
		this.empPosition = empPosition;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

}
