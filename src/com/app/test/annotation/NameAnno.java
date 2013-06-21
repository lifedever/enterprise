package com.app.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface NameAnno {
	/**
	 * 字段中文名称
	 * 
	 * @return
	 */
	public String name() default "";

	/**
	 * 字段类型
	 */
	public String type();
}