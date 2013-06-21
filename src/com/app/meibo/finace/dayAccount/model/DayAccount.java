package com.app.meibo.finace.dayAccount.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * 银行日记账
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-3-20 下午10:20:46
 */
@Entity
public class DayAccount {
	private Integer id;
	private String remark;// 摘要
	private Double debtor;// 借方
	private Double lender;// 贷方
	private Double balance;// 余额
	private Date createDate = new Date();
	private TotalAccount totalAccount;
	private int isDelete = 0;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public String getRemark() {
		return remark;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public Double getBalance() {
		return balance;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Double getDebtor() {
		return debtor;
	}

	public Double getLender() {
		return lender;
	}

	public void setDebtor(Double debtor) {
		this.debtor = debtor;
	}

	public void setLender(Double lender) {
		this.lender = lender;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@ManyToOne
	@JoinColumn(name = "totalAccountId")
	public TotalAccount getTotalAccount() {
		return totalAccount;
	}

	public void setTotalAccount(TotalAccount totalAccount) {
		this.totalAccount = totalAccount;
	}

}
