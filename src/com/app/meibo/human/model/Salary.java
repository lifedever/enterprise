package com.app.meibo.human.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.app.meibo.finace.account.model.Account;

/**
 * 工资
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-1-17 下午12:52:14
 */
@Entity
@Table(name = "salary")
public class Salary {
	private Integer id;// Id
	private Double mustSalary;// 应发工资
	private Double realSalary;// 实发工资
	private Double baseSalary;// 基本工资
	private Double allowance;// 职务津贴
	private Double jobSubsidy;// 工种补助
	private Double overtimeSubsidy;// 加班补助
	private Double overtimeSalary;// 加班费
	// private Double bonus;// 奖金
	// private Double pieceWages;// 计件工资
	private Double leaveUnpay;// 请加扣款
	private Double forfeit;// 罚款
	private Double otherUnpay;// 其它罚款
	// private Double tax;// 保险及个人所得税
	private Employee employee;// 员工
	private Account account;// 银行账户
	private Date createDate = new Date();// 添加时间
	private int isDelete = 0;

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

	@ManyToOne
	@JoinColumn(name = "employeeId")
	public Employee getEmployee() {
		return employee;
	}

	@ManyToOne
	@JoinColumn(name = "accountId")
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Double getMustSalary() {
		return mustSalary;
	}

	public Double getRealSalary() {
		return realSalary;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public Double getAllowance() {
		return allowance;
	}

	public Double getJobSubsidy() {
		return jobSubsidy;
	}

	public Double getOvertimeSubsidy() {
		return overtimeSubsidy;
	}

	public Double getOvertimeSalary() {
		return overtimeSalary;
	}

	public Double getLeaveUnpay() {
		return leaveUnpay;
	}

	public Double getForfeit() {
		return forfeit;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMustSalary(Double mustSalary) {
		this.mustSalary = mustSalary;
	}

	public void setRealSalary(Double realSalary) {
		this.realSalary = realSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public void setAllowance(Double allowance) {
		this.allowance = allowance;
	}

	public void setJobSubsidy(Double jobSubsidy) {
		this.jobSubsidy = jobSubsidy;
	}

	public void setOvertimeSubsidy(Double overtimeSubsidy) {
		this.overtimeSubsidy = overtimeSubsidy;
	}

	public void setOvertimeSalary(Double overtimeSalary) {
		this.overtimeSalary = overtimeSalary;
	}

	public void setLeaveUnpay(Double leaveUnpay) {
		this.leaveUnpay = leaveUnpay;
	}

	public void setForfeit(Double forfeit) {
		this.forfeit = forfeit;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
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

	public Double getOtherUnpay() {
		return otherUnpay;
	}

	public void setOtherUnpay(Double otherUnpay) {
		this.otherUnpay = otherUnpay;
	}

}
