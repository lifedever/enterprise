package com.app.meibo.finace.expenditure.model.vo;

import java.util.Date;

/**
 * 收支，用于自定义收入和支出的model,只是条目而已
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-1-10 下午9:50:08
 */
public class ExpenditureVO {
	private Integer id;// id
	private int inOrOut;// 收入还是支出？0:支出，1:收入
	private Date changeDate;// 更改时间(收入或支出时间)
	private Date createDate;// 记录创建时间
	private String accountantName;// 相关科目
	private String remark;// 备注
	private int isDelete;// 是否删除
	private String accountName;// 相关账户
	private double money;// 金额
	private Integer entityId;// 实体ID
	private String type;// 实体类型 0:样品费 1预付款 2全款 

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

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

	public String getAccountantName() {
		return accountantName;
	}

	public String getRemark() {
		return remark;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public String getAccountName() {
		return accountName;
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

	public void setAccountantName(String accountantName) {
		this.accountantName = accountantName;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
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

}
