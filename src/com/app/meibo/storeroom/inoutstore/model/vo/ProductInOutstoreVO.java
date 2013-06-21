package com.app.meibo.storeroom.inoutstore.model.vo;

import java.util.Date;

/**
 * 
 * @author MSQ
 * @email gefangshuai@163.com
 * @createdata 2013-2-25 下午10:37:53
 */
public class ProductInOutstoreVO {
	private Integer id;//id
	
	private String orderNo; //订单号
	
	private String pickinger;//领取人
	
	private String finishedProductName;//成品名称
	
	private Integer finishedProductId;//成品Id
	
	private String recorder;//记录人
	
	private int count;//数量
	
	private int isDelete = 0; // 0:未删除 1:已删除
	
	private Date createDate = new Date(); //创建时间
	
	private int operation = 0;//操作标识 0 入库 1 出库

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPickinger() {
		return pickinger;
	}

	public void setPickinger(String pickinger) {
		this.pickinger = pickinger;
	}

	public String getRecorder() {
		return recorder;
	}

	public void setRecorder(String recorder) {
		this.recorder = recorder;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getFinishedProductId() {
		return finishedProductId;
	}

	public void setFinishedProductId(Integer finishedProductId) {
		this.finishedProductId = finishedProductId;
	}

	public String getFinishedProductName() {
		return finishedProductName;
	}

	public void setFinishedProductName(String finishedProductName) {
		this.finishedProductName = finishedProductName;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}
	
}
