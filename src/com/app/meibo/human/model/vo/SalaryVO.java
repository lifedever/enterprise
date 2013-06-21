package com.app.meibo.human.model.vo;

import java.util.Date;

public class SalaryVO {
	private Integer id;// Id
	private double mustSalary = 0;// 应发工资
	private double realSalary = 0;// 实发工资
	private double baseSalary = 0;// 基本工资
	private double allowance = 0;// 职务津贴
	private double jobSubsidy = 0;// 工种补助
	private double overtimeSubsidy = 0;// 加班补助
	private double overtimeSalary = 0;// 加班费
	// private double bonus = 0;// 奖金
	// private double pieceWages = 0;// 计件工资
	private double leaveUnpay = 0;// 请加扣款
	private double forfeit = 0;// 罚款
	// private double tax = 0;// 保险及个人所得税
	private Double otherUnpay;// 其它罚款
	private Integer employeeId;// 员工
	private String employeeName;// 员工名
	private String employeeNo;// 员工编号
	private String deptName;// 所在部门
	private Integer accountId;// 银行账户
	private String accountName;// 账户名称
	private Date createDate;// 添加时间

	public double getRealSalaryAuto() {
		return (baseSalary + allowance + jobSubsidy + overtimeSubsidy + overtimeSalary - leaveUnpay - forfeit - otherUnpay);
	}

	public Integer getId() {
		return id;
	}

	public double getMustSalary() {
		return mustSalary;
	}

	public double getRealSalary() {
		return realSalary;
	}

	public double getBaseSalary() {
		return baseSalary;
	}

	public double getAllowance() {
		return allowance;
	}

	public double getJobSubsidy() {
		return jobSubsidy;
	}

	public double getOvertimeSubsidy() {
		return overtimeSubsidy;
	}

	public double getOvertimeSalary() {
		return overtimeSalary;
	}

	public double getLeaveUnpay() {
		return leaveUnpay;
	}

	public double getForfeit() {
		return forfeit;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public String getEmployeeNo() {
		return employeeNo;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMustSalary(double mustSalary) {
		this.mustSalary = mustSalary;
	}

	public void setRealSalary(double realSalary) {
		this.realSalary = realSalary;
	}

	public void setBaseSalary(double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public void setAllowance(double allowance) {
		this.allowance = allowance;
	}

	public void setJobSubsidy(double jobSubsidy) {
		this.jobSubsidy = jobSubsidy;
	}

	public void setOvertimeSubsidy(double overtimeSubsidy) {
		this.overtimeSubsidy = overtimeSubsidy;
	}

	public void setOvertimeSalary(double overtimeSalary) {
		this.overtimeSalary = overtimeSalary;
	}

	public void setLeaveUnpay(double leaveUnpay) {
		this.leaveUnpay = leaveUnpay;
	}

	public void setForfeit(double forfeit) {
		this.forfeit = forfeit;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public Double getOtherUnpay() {
		return otherUnpay;
	}

	public void setOtherUnpay(Double otherUnpay) {
		this.otherUnpay = otherUnpay;
	}

}
