package com.app.test.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.app.permission.utils.excel.ExcelClassAnno;
import com.app.permission.utils.excel.ExcelFieldAnno;

/**
 * 对ExcelClassAnno和ExcelFieldAnno的测试类
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-1-31 下午4:20:11
 */
@Entity
@Table(name = "excel")
@ExcelClassAnno(title = "报表测试类", x = 0, y = 0, xCount = 3)
public class ExcelModel {
	private Integer id;

	@ExcelFieldAnno(cellName = "姓名", cellX = 0, cellY = 1, xCount = 3)
	private String name;

	@ExcelFieldAnno(cellName = "年龄", cellX = 3, cellY = 1, xCount = 2)
	private int age;

	@ExcelFieldAnno(cellName = "邮箱", cellX = 5, cellY = 1)
	private String email;

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

	public int getAge() {
		return age;
	}

	public String getEmail() {
		return email;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 测试方法
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
	}
}
