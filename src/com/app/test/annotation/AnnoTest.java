package com.app.test.annotation;

import java.lang.reflect.Field;

public class AnnoTest {
	public static void main(String[] args) {
		if (NameModel.class.isAnnotationPresent(ClassAnno.class)) { // 判断是否为注解类型
			ClassAnno anotation = NameModel.class.getAnnotation(ClassAnno.class);
			System.out.println(anotation.name());
			for (Field field : NameModel.class.getDeclaredFields()) {
				NameAnno anno = field.getAnnotation(NameAnno.class);
				System.out.println(anno.name());
				System.out.println(anno.type());
			}
		}
	}

}
