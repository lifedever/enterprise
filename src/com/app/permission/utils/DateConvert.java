package com.app.permission.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.commons.beanutils.Converter;

/**
 * DateCovert
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-11-8 下午10:19:36
 */
public class DateConvert implements Converter {

	@SuppressWarnings("rawtypes")
	public Object convert(Class arg0, Object arg1) {
		String p = null;
		if (arg1 == null || (p = arg1.toString()).trim().length() == 0) {
			return null;
		}
		try {
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			return df.parse(p.trim());
		} catch (Exception e) {
			try {
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
				return df.parse(p.trim());
			} catch (ParseException ex) {
				return null;
			}
		}

	}

}