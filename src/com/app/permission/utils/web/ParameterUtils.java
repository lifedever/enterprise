package com.app.permission.utils.web;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import com.sqds.util.ParamUtils;
/**
 * 测试request携带信息的工具类，只做测试用
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createtime 2012-11-2 上午10:35:51
 */
public class ParameterUtils {
	public static void getParamters(HttpServletRequest request) {
		StringBuffer parameter = new StringBuffer();
		@SuppressWarnings("unchecked")
		Enumeration<String>  fieldNames = request.getParameterNames();
		while(fieldNames.hasMoreElements()){
			String fieldName = fieldNames.nextElement();
			if(!fieldName.startsWith("_")){
				String value = ParamUtils.getString(request, fieldName, "");
				parameter.append(fieldName);
				parameter.append("=");
				parameter.append(value);
				parameter.append("&");
			}
		}
		System.out.println(parameter);
	}
}
