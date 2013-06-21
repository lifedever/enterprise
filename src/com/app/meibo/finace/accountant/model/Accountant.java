package com.app.meibo.finace.accountant.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.app.meibo.finace.model.AccountType;

/**
 * 会计科目
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-11-25 下午9:04:41
 */
@Entity
@Table(name = "accountant")
public class Accountant {
	private Integer id;
	private String accountNo;
	private String accountName;
	private String accountDesc;
	private AccountType accountType;
	private int activeFlag = 1;// 是否有效 1：有效，0：无效

	private Double debtor;// 借方
	private Double credit;// 贷方

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

	public String getAccountNo() {
		return accountNo;
	}

	public String getAccountName() {
		return accountName;
	}

	public String getAccountDesc() {
		return accountDesc;
	}

	@ManyToOne
	@JoinColumn(name = "accountTypeId")
	public AccountType getAccountType() {
		return accountType;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public void setAccountDesc(String accountDesc) {
		this.accountDesc = accountDesc;
	}

	public void setAccountType(AccountType accountType) {
		this.accountType = accountType;
	}

	public int getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
	}

	@Transient
	public Double getDebtor() {
		return debtor;
	}

	@Transient
	public Double getCredit() {
		return credit;
	}

	public void setDebtor(Double debtor) {
		this.debtor = debtor;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

}
