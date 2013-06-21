package com.app.meibo.storeroom.inoutstore.model;

public class InOutstoreFooter {
	private String name;// 材料名称
	private double price;

	public InOutstoreFooter(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}
}
