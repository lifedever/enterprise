package com.app.permission.utils.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.app.permission.model.Page;

import net.sf.json.JSONObject;
/**
 * 将
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createtime 2012-11-1 下午11:04:33
 */
public class ResultToJsonUtils {
	public static <T> void getJson(HttpServletResponse response, Page<T> page) {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("total", page.getTotalCount());
			jsonObject.put("rows", page.getResult());
			out.print(jsonObject.toString());
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
		// JSONObject纯对象
	}
}
