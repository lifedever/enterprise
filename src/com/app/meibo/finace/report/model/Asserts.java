package com.app.meibo.finace.report.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "asserts")
public class Asserts {
	private Integer id;

	private Asserts_a asserts_a;

	private Asserts_b asserts_b;

	private int isDelete = 0;
	private Date createDate = new Date();

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "aid")
	public Asserts_a getAsserts_a() {
		return asserts_a;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "bid")
	public Asserts_b getAsserts_b() {
		return asserts_b;
	}

	public Date getCreateDate() {
		return createDate;
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

	public void setAsserts_a(Asserts_a asserts_a) {
		this.asserts_a = asserts_a;
	}

	public void setAsserts_b(Asserts_b asserts_b) {
		this.asserts_b = asserts_b;
	}

	public static void main(String[] args) {
		// int length = 33;
		for (int i = 34; i <= 65; i++) {
			System.out.println("private String c2" + "r" + i + ";");
			System.out.println("private String c3" + "r" + i + ";");
		}

	}
}
