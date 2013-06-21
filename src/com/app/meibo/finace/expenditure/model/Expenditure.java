package com.app.meibo.finace.expenditure.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.app.meibo.finace.account.model.Account;
import com.app.meibo.finace.accountant.model.Accountant;

/**
 * 收支，用于自定义收入和支出的model,只是条目而已
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-1-10 下午9:50:08
 */
@Entity
@Table(name = "expenditure")
public class Expenditure {
	private Integer id;// id
	private int inOrOut;// 收入还是支出？0:支出，1:收入
	private Date changeDate;// 更改时间(收入或支出时间)
	private Date createDate = new Date();// 记录创建时间
	private double money = 0;// 金额
	private Integer accountantId;
	private String remark;// 备注
	private int isDelete = 0;// 是否删除
	private Integer accountId;//
	private Integer entityId;// 实体ID
	private String type;// 费用类型 0：样品费 1：预付款 2全款

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public int getInOrOut() {
		return inOrOut;
	}

	public Date getChangeDate() {
		return changeDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public String getRemark() {
		return remark;
	}

	public int getIsDelete() {
		return isDelete;
	}



	public void setId(Integer id) {
		this.id = id;
	}

	public void setInOrOut(int inOrOut) {
		this.inOrOut = inOrOut;
	}

	public void setChangeDate(Date changeDate) {
		this.changeDate = changeDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Integer getEntityId() {
		return entityId;
	}

	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getAccountantId() {
		return accountantId;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountantId(Integer accountantId) {
		this.accountantId = accountantId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

}
