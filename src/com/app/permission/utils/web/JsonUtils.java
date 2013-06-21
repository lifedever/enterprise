package com.app.permission.utils.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 包装response将将结果以json的形式返回前台
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-11-17 下午2:03:44
 */
public class JsonUtils {
	private static boolean SUCCESS = true;
	private static boolean FAILE = false;
	private static String SUCCESS_MSG = "操作成功!";
	private static String FAILE_MSG = "操作失败!";

	/**
	 * 
	 * @param response
	 * @param obj
	 *            返回的对象
	 */
	public static void writeJson(HttpServletResponse response, Object obj,boolean flag) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			if (flag) {
				out.print(JSONObject.fromObject(obj));
			}else{
				out.print(JSONArray.fromObject(obj));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 
	 * @param response
	 * @param list
	 *            返回的对象集合
	 */
	public static void writeJson(HttpServletResponse response, List<?> list) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(JSONArray.fromObject(list));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
	
	/**
	 * 
	 * @param response
	 * @param list
	 *            返回的对象集合
	 */
	public static void writeJson(HttpServletResponse response, Object[] array) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(JSONArray.fromObject(array));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 
	 * @param response
	 * @param result
	 *            结果
	 */
	public static void writeJson(HttpServletResponse response, boolean result) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(result);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 
	 * @param response
	 * @param result
	 *            是否成功,并携带默认结果信息
	 * @param isDefault
	 *            是否使用默认的反馈信息
	 */
	public static void writeJson(HttpServletResponse response, boolean result,
			boolean isDefault) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			Map<String, Object> resultMap = new HashMap<String, Object>();
			if (result) {
				resultMap.put("result", SUCCESS);
				resultMap.put("message", SUCCESS_MSG);
			} else {
				resultMap.put("result", FAILE);
				resultMap.put("message", FAILE_MSG);
			}
			out.print(JSONObject.fromObject(resultMap));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 向前台返回成功结果
	 * 
	 * @param response
	 */
	public static void writeJson(HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(SUCCESS);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 
	 * @param response
	 * @param result
	 *            结果
	 * @param successMsg
	 *            成功的信息
	 * @param faileMsg
	 *            错误的信息
	 */
	public static void writeJson(HttpServletResponse response, boolean result,
			String successMsg, String faileMsg) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			Map<String, Object> resultMap = new HashMap<String, Object>();
			if (result) {
				resultMap.put("result", SUCCESS);
				resultMap.put("message", successMsg);
			} else {
				resultMap.put("result", FAILE);
				resultMap.put("message", faileMsg);
			}
			out.print(JSONObject.fromObject(resultMap));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}

	/**
	 * 
	 * @param response
	 * @param map
	 *            map对象
	 */
	public static void writeJson(HttpServletResponse response, Map<?, ?> map) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = null;
		try {
			out = response.getWriter();
			out.print(JSONObject.fromObject(map));
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				out.close();
			}
		}
	}
}
