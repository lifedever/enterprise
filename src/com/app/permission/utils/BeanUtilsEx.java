package com.app.permission.utils;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;

/**
 * 重写的copyProperties方法
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-11-8 下午10:19:55
 */
public class BeanUtilsEx extends BeanUtils {
	static {
		ConvertUtils.register(new DateConvert(), java.util.Date.class);
		ConvertUtils.register(new DateConvert(), java.sql.Date.class);
	}

	/**
	 * 复制对象属性
	 * 
	 * @param dest
	 *            目标对象
	 * @param orig
	 *            源对象
	 */
	public static void copyProperties(Object dest, Object orig) {
		try {
			BeanUtils.copyProperties(dest, orig);
		} catch (IllegalAccessException ex) {
			ex.printStackTrace();
		} catch (InvocationTargetException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 将do的list 复制的vo的list
	 * 
	 * @param clazz
	 *            vo对应的Class
	 * @param doList
	 *            do列表
	 * @param voList
	 *            vo列表
	 */
	public static <T1, T2> void copyDOListToVOList(Class<T2> clazz,
			List<T1> doList, List<T2> voList) {
		for (T1 t1 : doList) {
			T2 vo = null;
			try {
				vo = (T2) clazz.newInstance();
				BeanUtilsEx.copyProperties(vo, t1);
				voList.add(vo);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}