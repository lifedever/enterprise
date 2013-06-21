package com.app.permission.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 关于生成编号的工具类
 * @author MSQ
 *
 */
public class NOUtils {
	
	/**
	 * 不含参数，默认年月日时分秒
	 * @return
	 */
	public static String createNo(){
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");
		return sdf.format(date);
	}
	
	/**
	 * 含参数，前缀+年月日时分秒
	 * @param prefix
	 * @return
	 */
	public static String createNo(String prefix){
		StringBuffer sb = new StringBuffer();
		Date date = new Date();
		sb.append(prefix);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSS");
		sb.append(sdf.format(date));
		return sb.toString();
	}
	
	public static void main(String[] args){
		System.out.println(createNo());
		System.out.println(createNo("ht"));
	}
}
