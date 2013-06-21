package com.app.meibo.finace.dayAccount.model.vo;

import java.util.Date;

/**
 * 日记账的总账
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-3-23 下午8:59:59
 */
public class TotalAccountVO {
	private Integer id;
	private Double allMoney;// 总额
	private Double lastMoney;// 上次余额
	private Double thisMoney;// 现余额
	private Integer accountId;
	private String accountName;
	private String addUser;// 添加人
	private String remark;// 备注
	private int count;// 记账次数
	private Date createDate;

	public Integer getId() {
		return id;
	}

	public Double getAllMoney() {
		return allMoney;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public String getAddUser() {
		return addUser;
	}

	public String getRemark() {
		return remark;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public Double getLastMoney() {
		return lastMoney;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setLastMoney(Double lastMoney) {
		this.lastMoney = lastMoney;
	}

	public Double getThisMoney() {
		return thisMoney;
	}

	public void setThisMoney(Double thisMoney) {
		this.thisMoney = thisMoney;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setAllMoney(Double allMoney) {
		this.allMoney = allMoney;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
