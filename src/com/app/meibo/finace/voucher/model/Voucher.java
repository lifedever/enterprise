package com.app.meibo.finace.voucher.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 记账凭证
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-3-22 下午10:18:36
 */
@Entity
@Table(name = "voucher")
public class Voucher {
	private Integer id;
	private String jizi;// 记字
	private String fdshj;// 附单据数
	private String master;// 主管
	private String voucher;// 记账
	private String auditer;// 审核
	private String systems;// 制单
	private String chahier;// 出纳
	private int isDelete = 0;
	private Date createDate = new Date();

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

	public String getJizi() {
		return jizi;
	}

	public String getFdshj() {
		return fdshj;
	}

	public String getMaster() {
		return master;
	}

	public String getVoucher() {
		return voucher;
	}

	public String getAuditer() {
		return auditer;
	}

	public String getSystems() {
		return systems;
	}

	public String getChahier() {
		return chahier;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setJizi(String jizi) {
		this.jizi = jizi;
	}

	public void setFdshj(String fdshj) {
		this.fdshj = fdshj;
	}

	public void setMaster(String master) {
		this.master = master;
	}

	public void setVoucher(String voucher) {
		this.voucher = voucher;
	}

	public void setAuditer(String auditer) {
		this.auditer = auditer;
	}

	public void setSystems(String systems) {
		this.systems = systems;
	}

	public void setChahier(String chahier) {
		this.chahier = chahier;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
