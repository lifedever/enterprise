package com.app.meibo.finace.voucher.model.vo;

import java.util.Date;

public class VoucherItemVO {
	private Integer id;
	private String remark;// 摘要
	private String accountantName;
	private String accountantType;
	private Double debtor;// 借方
	private Double credit;// 贷方
	private Date createDate = new Date();

	public Integer getId() {
		return id;
	}

	public String getRemark() {
		return remark;
	}

	public String getAccountantName() {
		return accountantName;
	}

	public String getAccountantType() {
		return accountantType;
	}

	public Double getDebtor() {
		return debtor;
	}

	public Double getCredit() {
		return credit;
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

	public void setAccountantName(String accountantName) {
		this.accountantName = accountantName;
	}

	public void setAccountantType(String accountantType) {
		this.accountantType = accountantType;
	}

	public void setDebtor(Double debtor) {
		this.debtor = debtor;
	}

	public void setCredit(Double credit) {
		this.credit = credit;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
