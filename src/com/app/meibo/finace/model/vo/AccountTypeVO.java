package com.app.meibo.finace.model.vo;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 会计科目类型
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-11-25 下午9:05:24
 */
public class AccountTypeVO {
	private Integer id;
	private String typeName;
	private Date createDate;

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
}
