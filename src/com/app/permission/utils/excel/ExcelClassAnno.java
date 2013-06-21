package com.app.permission.utils.excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <h1>定义excel的注解</h1>
 * <p>
 * 当model类上定义了此注解，代表此model用来导出excel
 * </p>
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-1-31 下午3:51:28
 */
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelClassAnno {
	/**
	 * 报表标题
	 */
	public String title() default "";

	/**
	 * 表头横坐标
	 */
	public int x() default 0;

	/**
	 * 表头纵坐标
	 * 
	 */
	public int y() default 0;

	/**
	 * 横向表格数量（合并单元格）
	 */
	public int xCount() default 1;

	/**
	 * 纵向表格数量（合并单元格）
	 */
	public int yCount() default 1;

	/**
	 * 格式化
	 */
	public String format() default "CENTER";
}
