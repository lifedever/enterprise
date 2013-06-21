package com.app.test.annotation;

@ClassAnno(name = "测试类")
public class NameModel {

	@NameAnno(name = "姓名", type = "java.lang.String")
	private String name;
	@NameAnno(name = "年龄", type = "java.lang.Integer")
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
