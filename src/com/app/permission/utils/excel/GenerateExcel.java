package com.app.permission.utils.excel;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jxl.format.Alignment;
import jxl.format.VerticalAlignment;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WriteException;

import com.app.permission.utils.ExcelExportUtils;
import com.sqds.hibernate.HibernateDao;
import com.sqds.util.BeanUtils;
import com.sqds.util.GenericsUtils;

public class GenerateExcel<T> extends HibernateDao<T> {
	protected Class<T> entityClass;

	@SuppressWarnings("unchecked")
	public GenerateExcel() {
		this.entityClass = GenericsUtils.getSuperClassGenricType(getClass());
	}

	/**
	 * 生成Excel
	 * 
	 * @param response
	 * @param title
	 */
	@SuppressWarnings("rawtypes")
	public void generate(HttpServletResponse response, String title) {
		List<CellModel> cells = this.getCellsFromModel();
		List<WritableCell> labels = new ArrayList<WritableCell>();
		List<int[]> mergeCells = new ArrayList<int[]>();
		/**
		 * 标题
		 */
		if (entityClass.isAnnotationPresent(ExcelClassAnno.class)) {
			ExcelClassAnno anno = entityClass.getAnnotation(ExcelClassAnno.class);
			WritableCellFormat format = new WritableCellFormat();
			try {
				if (anno.format().equals(CellAlignEnum.居中.value)) {
					format.setVerticalAlignment(VerticalAlignment.TOP);
					format.setAlignment(Alignment.CENTRE);
				}
				if (anno.format().equals(CellAlignEnum.居右.value)) {
					format.setVerticalAlignment(VerticalAlignment.TOP);
					format.setAlignment(Alignment.RIGHT);
				}
				if (anno.format().equals(CellAlignEnum.居左.value)) {
					format.setVerticalAlignment(VerticalAlignment.TOP);
					format.setAlignment(Alignment.LEFT);
				}
			} catch (WriteException e) {
				e.printStackTrace();
			}
			Label label = new Label(anno.x(), anno.y(), anno.title(), format);
			labels.add(label);
			int[] mergeCell = { anno.x(), anno.y(), anno.x() + anno.xCount() - 1, anno.y() + anno.yCount() - 1 };
			mergeCells.add(mergeCell);
		}
		/**
		 * 表头
		 */
		for (CellModel cell : cells) {
			Label label = new Label(cell.getX(), cell.getY(), cell.getcName(), cell.getFormat());
			labels.add(label);
			int[] mergeCell = { cell.getX(), cell.getY(), cell.getX() + cell.getxCount() - 1, cell.getY() + cell.getyCount() - 1 };
			mergeCells.add(mergeCell);
		}
		List list = list("from " + entityClass.getName());
		for (int i = 0; i < list.size(); i++) {
			for (CellModel cell : cells) {
				try {
					Object value = BeanUtils.getFieldValue(list.get(i), cell.geteName());
					WritableCell label = null;
					if (value instanceof Integer || list.get(i) instanceof Double) {
						label = new jxl.write.Number(cell.getX(), cell.getY() + i + 1, Double.parseDouble(value.toString()), cell.getFormat());
					}
					if (value instanceof String) {
						label = new jxl.write.Label(cell.getX(), cell.getY() + i + 1, (String) value, cell.getFormat());
					}
					labels.add(label);
				} catch (Exception e) {
					e.printStackTrace();
				}
				int[] mergeCell = { cell.getX(), cell.getY() + i + 1, cell.getX() + cell.getxCount() - 1, cell.getY() + i + 1 + cell.getyCount() - 1 };
				mergeCells.add(mergeCell);
			}
		}
		ExcelExportUtils.export(response, title, labels, mergeCells);

	}

	/**
	 * <h1>生成适用于Excel的表头</h1>
	 * 
	 * @return
	 */
	private List<CellModel> getCellsFromModel() {
		List<CellModel> list = new ArrayList<CellModel>();
		for (Field field : entityClass.getDeclaredFields()) {
			if (field.isAnnotationPresent(ExcelFieldAnno.class)) {
				CellModel cell = new CellModel();
				ExcelFieldAnno anno = field.getAnnotation(ExcelFieldAnno.class);
				cell.seteName(field.getName());
				cell.setcName(anno.cellName());
				cell.setType(field.getType());
				cell.setX(anno.cellX());
				cell.setY(anno.cellY());
				cell.setxCount(anno.xCount());
				cell.setyCount(anno.yCount());
				WritableCellFormat format = new WritableCellFormat();
				try {
					if (anno.format().equals(CellAlignEnum.居中.value)) {
						format.setVerticalAlignment(VerticalAlignment.TOP);
						format.setAlignment(Alignment.CENTRE);
					}
					if (anno.format().equals(CellAlignEnum.居右.value)) {
						format.setVerticalAlignment(VerticalAlignment.TOP);
						format.setAlignment(Alignment.RIGHT);
					}
					if (anno.format().equals(CellAlignEnum.居左.value)) {
						format.setVerticalAlignment(VerticalAlignment.TOP);
						format.setAlignment(Alignment.LEFT);
					}
				} catch (WriteException e) {
					e.printStackTrace();
				}
				cell.setFormat(format);
				list.add(cell);
			}
		}
		return list;
	}
}
