package com.app.meibo.finace.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.app.meibo.finace.accountant.model.Accountant;

/**
 * 会计科目类型
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-11-25 下午9:05:24
 */
@Entity
@Table(name = "accounttype")
public class AccountType {
	private Integer id;
	private String typeName;
	private Date createDate;

	private List<Accountant> accountants;

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

	public String getTypeName() {
		return typeName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Transient
	public List<Accountant> getAccountants() {
		return accountants;
	}

	public void setAccountants(List<Accountant> accountants) {
		this.accountants = accountants;
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
