package com.app.meibo.finace.dayAccount.model;

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
 * 日记账的总账
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-3-23 下午8:59:59
 */
@Entity
@Table(name = "totalaccount")
public class TotalAccount {
	private Integer id;
	private Double allMoney;// 总额
	private Double thisMoney;// 现余额
	private Account account;
	private String addUser;// 添加人
	private String remark;// 备注
	private Date createDate = new Date();
	private int isDelete = 0;//

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public Double getAllMoney() {
		return allMoney;
	}

	@ManyToOne
	@JoinColumn(name = "accountId")
	public Account getAccount() {
		return account;
	}

	public String getAddUser() {
		return addUser;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public Double getThisMoney() {
		return thisMoney;
	}

	public void setThisMoney(Double thisMoney) {
		this.thisMoney = thisMoney;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setAllMoney(Double allMoney) {
		this.allMoney = allMoney;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public void setAddUser(String addUser) {
		this.addUser = addUser;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
