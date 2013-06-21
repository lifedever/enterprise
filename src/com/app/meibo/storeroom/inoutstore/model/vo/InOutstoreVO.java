package com.app.meibo.storeroom.inoutstore.model.vo;

import java.util.Date;

public class InOutstoreVO {

	private Integer id;// id

	private String productNo; // 加工单号

	private String pickinger;// 领料人

	private String name;// 材料名称

	private Integer commodityId;// 材料Id

	private String recorder;// 记录人

	private int count;// 数量

	private int isDelete = 0; // 0:未删除 1:已删除

	private Date createDate = new Date(); // 创建时间

	private int operation = 0;// 操作标识 0 入库 1 出库
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProductNo() {
		return productNo;
	}

	public void setProductNo(String productNo) {
		this.productNo = productNo;
	}

	public String getPickinger() {
		return pickinger;
	}

	public void setPickinger(String pickinger) {
		this.pickinger = pickinger;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCommodityId() {
		return commodityId;
	}

	public void setCommodityId(Integer commodityId) {
		this.commodityId = commodityId;
	}

	public String getRecorder() {
		return recorder;
	}

	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

}
