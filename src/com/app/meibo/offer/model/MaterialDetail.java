package com.app.meibo.offer.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
/**
 * 用料明细
 * @author MSQ
 * @email gefangshuai@163.com
 * @createdata 2013-3-11 下午9:57:53
 */
@Entity
@Table(name="materialdetail")
public class MaterialDetail {
	
	private Integer id;
	
	private String name;//名称
	
	private String standard;//标准
	
	private String thickness;//颜色厚度
	
	private int count=0;
	
	private String fullPage;//整版
	
	private String remark;
	
	private int type=0;//材料类型 0：用料明细 1：辅料明细
	
	private int idDelete =0;
	
	private Integer itemId;
	
	private Date createDate= new Date();

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

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStandard() {
		return standard;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public String getThickness() {
		return thickness;
	}

	public void setThickness(String thickness) {
		this.thickness = thickness;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getFullPage() {
		return fullPage;
	}

	public void setFullPage(String fullPage) {
		this.fullPage = fullPage;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public int getIdDelete() {
		return idDelete;
	}

	public void setIdDelete(int idDelete) {
		this.idDelete = idDelete;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
}
