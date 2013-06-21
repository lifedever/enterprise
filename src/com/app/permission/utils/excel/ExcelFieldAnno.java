package com.app.permission.utils.excel;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 用来定义生成excel的字段，配合ExcelClassAnnoUtils使用。
 * 
 * @see ExcelClassAnno
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-1-31 下午3:54:25
 */
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface ExcelFieldAnno {

	/**
	 * cell的中文
	 * 
	 * @return
	 */
	public String cellName() default "列表";

	/**
	 * cell的横坐标
	 * 
	 */
	public int cellX() default 0;

	/**
	 * cell的纵坐标
	 */
	public int cellY() default 0;

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
