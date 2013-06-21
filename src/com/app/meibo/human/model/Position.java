package com.app.meibo.human.model;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 职位
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-12-15 下午5:31:45
 */
@Entity
@Table(name = "position")
public class Position {
	private Integer id;
	private String positionNo;// 职位编号
	private String positionName;// 职位名称
	private Date createDate;// 创建时间

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public String getPositionNo() {
		return positionNo;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setPositionNo(String positionNo) {
		this.positionNo = positionNo;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

}
