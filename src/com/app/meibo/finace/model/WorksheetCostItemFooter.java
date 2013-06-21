package com.app.meibo.finace.model;

public class WorksheetCostItemFooter {
	private double cost;// 合计
	private String remark;//

	public WorksheetCostItemFooter(double cost, String remark) {
		super();
		this.cost = cost;
		this.remark = remark;
	}

	public double getCost() {
		return cost;
	}

	public String getRemark() {
		return remark;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
