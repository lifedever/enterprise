package com.app.meibo.finace.dayAccount.model.vo;

import java.util.Date;

/**
 * 银行日记账
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-3-20 下午10:20:46
 */
public class DayAccountVO {
	private Integer id;
	private String remark;// 摘要
	private String debtor;// 借方
	private String lender;// 贷方
	private Double balance;// 余额
	private Date createDate;
	private Integer accountId;//
	private String accountName;

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

	public Integer getId() {
		return id;
	}

	public String getRemark() {
		return remark;
	}

	public String getDebtor() {
		return debtor;
	}

	public String getLender() {
		return lender;
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

	public void setDebtor(String debtor) {
		this.debtor = debtor;
	}

	public void setLender(String lender) {
		this.lender = lender;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
