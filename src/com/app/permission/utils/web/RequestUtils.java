package com.app.permission.utils.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sqds.util.ParamUtils;

/**
 * http request 常用方法封装
 * 
 */
public class RequestUtils extends ParamUtils {

	/**
	 * 从查询表单中获取数据，按规则对数据值进行转换，并进行封装<br>
	 * 规则：查询表单域名称的命名规则：<br>
	 * i_开头的是int类型<br>
	 * d_开头的是date类型<br>
	 * l_开头的是long类型<br>
	 * b_开头的是bigDecimal类型<br>
	 * begin_ end_ 是范围查询<br>
	 * 通过表单的这些命名规则，在controller类中，根据名称，判断数据类型，并作相应的转换，和数据处理。<br>
	 * 这样的做法，用于简化程序开发的复杂度，生成的表单页面将于定义的模板信息分离，简化二次开发的难度。<br>
	 * 
	 * @param request
	 * @return
	 * @author ccj
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, Object> getSearchParameter(HttpServletRequest request) {
		// 这里定义为TreeMap，将来需要扩展成有序Map
		// 这里获取的参数将来可能用于数据库查询，where字段的顺序对于数据库查询效率有影响
		Map<String, Object> queryData = new TreeMap<String, Object>();
		// 取得表单上所有的域名称
		Enumeration<String> fieldNames = request.getParameterNames();
		while (fieldNames.hasMoreElements()) {
			String fieldName = fieldNames.nextElement();
			String value = ParamUtils.getString(request, fieldName, "");
			if (!value.equals("")) {
				queryData.put(fieldName, value);
			}
		}
		return queryData;
	}

	/**
	 * 通过http response 输出到页面，简化ajax数据输出
	 * 
	 * @param response
	 * @param xml
	 */
	public static void responseXMLString(HttpServletResponse response, String xml) {
		response.setContentType("application/xml");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(xml.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
