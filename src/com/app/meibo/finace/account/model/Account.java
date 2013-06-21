package com.app.meibo.finace.account.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 银行账户
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-12-17 下午11:04:12
 */
@Entity
@Table(name = "account")
public class Account {
	private Integer id;
	private String accountName;// 账户名
	private String accountNo;// 卡号
	private Integer accountType = 0;// 类型，0或null：现金，1：银行

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

	public String getAccountName() {
		return accountName;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public Integer getAccountType() {
		return accountType;
	}

	public void setAccountType(Integer accountType) {
		this.accountType = accountType;
	}

}
