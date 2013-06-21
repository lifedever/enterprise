package com.app.meibo.order.prepare.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 备料单
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-23 下午2:54:18
 */
@Entity
@Table(name = "material")
public class Material {
	private Integer id;
	private String name;// 名称
	private String standard;// 规格
	private String color;// 颜色
	private String thickness;// 厚度
	private PrepareOrder prepareOrder;
	private double count = 0;// 数量
	private String remark;// 备注,要求
	private int isDelete = 0;
	private String classify;// 分类
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

	public String getName() {
		return name;
	}

	public String getStandard() {
		return standard;
	}

	public String getColor() {
		return color;
	}

	public String getThickness() {
		return thickness;
	}

	public String getRemark() {
		return remark;
	}

	public double getCount() {
		return count;
	}

	public void setCount(double count) {
		this.count = count;
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

	public void setName(String name) {
		this.name = name;
	}

	public void setStandard(String standard) {
		this.standard = standard;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setThickness(String thickness) {
		this.thickness = thickness;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@ManyToOne
	@JoinColumn(name = "prepareOrderId")
	public PrepareOrder getPrepareOrder() {
		return prepareOrder;
	}

	public void setPrepareOrder(PrepareOrder prepareOrder) {
		this.prepareOrder = prepareOrder;
	}

	public String getClassify() {
		return classify;
	}

	public void setClassify(String classify) {
		this.classify = classify;
	}

}
