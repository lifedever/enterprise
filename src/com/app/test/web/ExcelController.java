package com.app.test.web;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.test.model.ExcelModel;
import com.app.test.service.ExcelManager;

/**
 * 测试Excel导出
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-1-31 下午5:55:06
 */
@Controller
@RequestMapping("/test/excel/*.html")
public class ExcelController {
	@Autowired
	public ExcelManager excelManager;

	@SuppressWarnings("unused")
	@RequestMapping
	public void index(HttpServletResponse response) {
		List<ExcelModel> list = excelManager.listAll();
		excelManager.generate(response, "testExcel");
	}
}
