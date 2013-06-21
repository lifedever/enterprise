package com.app.meibo.storeroom.provider.model.vo;

import java.util.Date;

/**
 * 供应的产品分类VO
 * 
 * @author mashiqiang
 * @email qq1005913089@163.com
 * @createdate 2012-12-6 下午9:28:34
 */
public class CommodityClassifyVO {
	private Integer id;
	private String classifyName;
	private String classifyCode;
	private Date createDate = new Date();
	private int isDelete = 0;

	public Integer getId() {
		return id;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClassifyName() {
		return classifyName;
	}

	public void setClassifyName(String classifyName) {
		this.classifyName = classifyName;
	}

	public String getClassifyCode() {
		return classifyCode;
	}

	public void setClassifyCode(String classifyCode) {
		this.classifyCode = classifyCode;
	}
	
}
