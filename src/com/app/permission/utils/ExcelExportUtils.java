package com.app.permission.utils;

import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.VerticalAlignment;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

/**
 * 导出excel的工具类
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-1-18 下午10:16:40
 */
public class ExcelExportUtils {

	/**
	 * 标题的样式
	 * 
	 * @return
	 */
	public static WritableCellFormat titleFormat() {
		WritableFont font = new WritableFont(WritableFont.TIMES, 16, WritableFont.NO_BOLD);
		WritableCellFormat format = new WritableCellFormat(font);
		try {
			format.setAlignment(Alignment.CENTRE);
		} catch (WriteException e) {
			e.printStackTrace();
		}
		return format;
	}

	/**
	 * 居中
	 */
	public static WritableCellFormat centerFormat() {
		WritableCellFormat format = new WritableCellFormat();
		try {
			format.setAlignment(Alignment.CENTRE);
			format.setVerticalAlignment(VerticalAlignment.CENTRE);
		} catch (WriteException e) {
			e.printStackTrace();
		}
		return format;
	}

	/**
	 * 居上
	 */
	public static WritableCellFormat topFormat() {
		WritableCellFormat format = new WritableCellFormat();
		try {
			format.setVerticalAlignment(VerticalAlignment.TOP);
		} catch (WriteException e) {
			e.printStackTrace();
		}
		return format;
	}

	/**
	 * 居中并居上
	 */
	public static WritableCellFormat centerAndTopFormat() {
		WritableCellFormat format = new WritableCellFormat();
		try {
			format.setAlignment(Alignment.CENTRE);
			format.setVerticalAlignment(VerticalAlignment.TOP);
		} catch (WriteException e) {
			e.printStackTrace();
		}
		return format;
	}

	/**
	 * 
	 * @param response
	 *            response
	 * @param title
	 *            标题
	 * @param labels
	 *            数据
	 * @param mergeCells
	 *            合并单元格的参数，如果要合并，需要传n个长度为4的int数组
	 */
	public static void export(HttpServletResponse response, String title, List<WritableCell> labels, List<int[]> mergeCells) {
		try {
			OutputStream out = null;
			out = response.getOutputStream();
			response.setCharacterEncoding("utf-8");
			response.reset();
			response.setContentType("application/msexcel;charset=utf-8");// 定义输出类型
			response.setHeader("Content-disposition", "attachment; filename=" + java.net.URLEncoder.encode(title + ".xls", "UTF-8"));// 设定输出文件头
			WritableWorkbook wbook = Workbook.createWorkbook(out); // 建立excel文件
			WritableSheet sheet = wbook.createSheet("工作簿", 0);

			// 填充数据
			for (WritableCell label : labels) {
				sheet.addCell(label);
			}

			if (mergeCells != null) {
				// 合并单元格
				for (int[] arr : mergeCells) {
					sheet.mergeCells(arr[0], arr[1], arr[2], arr[3]);
				}
			}
			wbook.write(); // 写入文件
			wbook.close();
			out.close(); // 关闭流
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
