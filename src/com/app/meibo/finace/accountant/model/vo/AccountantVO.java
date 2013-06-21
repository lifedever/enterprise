package com.app.meibo.finace.accountant.model.vo;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 会计科目
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-11-25 下午9:04:41
 */
public class AccountantVO {
	private Integer id;
	private String accountNo;
	private String accountName;
	private String accountDesc;
	private Integer accountTypeId;
	private String accountTypeName;
	private int activeFlag;

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

	public int getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(int activeFlag) {
		this.activeFlag = activeFlag;
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

	public Integer getAccountTypeId() {
		return accountTypeId;
	}

	public String getAccountTypeName() {
		return accountTypeName;
	}

	public void setAccountTypeId(Integer accountTypeId) {
		this.accountTypeId = accountTypeId;
	}

	public void setAccountTypeName(String accountTypeName) {
		this.accountTypeName = accountTypeName;
	}
}
