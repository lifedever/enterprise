package com.app.meibo.finace.voucher.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-3-22 下午10:27:43
 */
@Entity
@Table(name = "voucher_item")
public class VoucherItem {
	private Integer id;
	private String remark;// 摘要
	private String accountantType;
	private String accountantName;
	private Double debtor;// 借方
	private Double credit;// 贷方
	private Voucher voucher;
	private Date createDate = new Date();
	private int isDelete;

	/**
	 * 主键
	 * 
	 * @return
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	@ManyToOne
	@JoinColumn(name = "voucherId")
	public Voucher getVoucher() {
		return voucher;
	}

	public void setVoucher(Voucher voucher) {
		this.voucher = voucher;
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

	public int getIsDelete() {
		return isDelete;
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

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		VoucherItem other = (VoucherItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
