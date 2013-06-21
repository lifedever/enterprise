package com.app.meibo.finace.salary.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import jxl.write.Label;
import jxl.write.Number;
import jxl.write.WritableCell;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.app.meibo.human.model.Salary;
import com.app.permission.utils.ExcelExportUtils;
import com.sqds.hibernate.HibernateDao;
import com.sqds.page.PageInfo;
import com.sqds.util.DateUtils;

@Service
public class SalaryManager extends HibernateDao<Salary> {

	/**
	 * 获得每月的工资列表
	 * 
	 * @param pageInfo
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public PageInfo<Object[]> getMonthSalarys(PageInfo<Object[]> pageInfo) {
		String sql = "select sum(mustSalary) ,SUM(realSalary),DATE_FORMAT(s.createDate, '%Y%m') as date from salary  s GROUP BY DATE_FORMAT(s.createDate, '%Y%m')";
		Session session = this.getSession();
		Query query = session.createSQLQuery(sql).setFirstResult(pageInfo.getFirst()).setMaxResults(pageInfo.getPageSize());
		List<Object[]> result = query.list();
		pageInfo.setResult(result);
		return pageInfo;
	}

	/**
	 * 将一个月的工资明细导出到excel中
	 * 
	 * @param response
	 */
	@SuppressWarnings("unchecked")
	public void exportMonthExcel(HttpServletResponse response, Date startDate, Date endDate) {
		String title = DateUtils.date2ChineseString(startDate) + "至" + DateUtils.date2ChineseString(endDate) + "工资明细";
		StringBuffer hql = new StringBuffer("from Salary s where 1=1");
		if (startDate != null) {
			hql.append(" and s.createDate >= :startDate");
		}
		if (endDate != null) {
			hql.append(" and s.createDate <= :endDate");
		}
		Session session = this.getSession();
		Query query = session.createQuery(hql.toString());
		if (startDate != null) {
			query.setDate("startDate", startDate);
		}
		if (endDate != null) {
			query.setDate("endDate", endDate);
		}
		List<Salary> salaries = query.list();
		List<WritableCell> labels = new ArrayList<WritableCell>();
		Label labelTitle = new Label(0, 0, title, ExcelExportUtils.titleFormat());
		Label label1 = new Label(0, 2, "序号", ExcelExportUtils.centerFormat());
		Label label2 = new Label(1, 2, "姓名", ExcelExportUtils.centerFormat());
		Label label3 = new Label(2, 2, "岗位说明", ExcelExportUtils.centerFormat());
		Label label4 = new Label(2, 3, "所在部门");
		Label label5 = new Label(3, 3, "职位");
		Label label6 = new Label(4, 2, "考勤说明", ExcelExportUtils.centerFormat());
		Label label7 = new Label(4, 3, "应出勤天数");
		Label label8 = new Label(5, 3, "实际出勤天数");
		Label label9 = new Label(6, 3, "事假天数");
		Label label10 = new Label(7, 2, "应发工资", ExcelExportUtils.centerFormat());
		Label label11 = new Label(7, 3, "基本工资");
		Label label12 = new Label(8, 3, "职务津贴");
		Label label13 = new Label(9, 3, "工种补助");
		Label label14 = new Label(10, 3, "加班费");
		Label label15 = new Label(11, 3, "加班补助");
		Label label16 = new Label(12, 3, "工资合计");
		Label label17 = new Label(13, 2, "各项扣款", ExcelExportUtils.centerFormat());
		Label label18 = new Label(13, 3, "事假扣款");
		Label label19 = new Label(14, 3, "罚款");
		Label label20 = new Label(15, 3, "其它扣款");
		Label label21 = new Label(16, 3, "扣款合计");
		Label label22 = new Label(17, 2, "实发工资", ExcelExportUtils.centerFormat());
		Label label23 = new Label(18, 2, "备注", ExcelExportUtils.centerFormat());

		labels.add(labelTitle);
		labels.add(label1);
		labels.add(label2);
		labels.add(label3);
		labels.add(label4);
		labels.add(label5);
		labels.add(label6);
		labels.add(label7);
		labels.add(label8);
		labels.add(label9);
		labels.add(label10);
		labels.add(label11);
		labels.add(label12);
		labels.add(label13);
		labels.add(label14);
		labels.add(label15);
		labels.add(label16);
		labels.add(label17);
		labels.add(label18);
		labels.add(label19);
		labels.add(label20);
		labels.add(label21);
		labels.add(label22);
		labels.add(label23);

		int[] mergeCell1 = { 0, 0, 18, 1 };
		int[] mergeCell2 = { 0, 2, 0, 3 };
		int[] mergeCell3 = { 1, 2, 1, 3 };
		int[] mergeCell4 = { 2, 2, 3, 2 };
		int[] mergeCell5 = { 4, 2, 6, 2 };
		int[] mergeCell6 = { 7, 2, 12, 2 };
		int[] mergeCell9 = { 13, 2, 16, 2 };
		int[] mergeCell10 = { 17, 2, 17, 3 };
		int[] mergeCell11 = { 18, 2, 18, 3 };

		// 填充数据
		for (int i = 0; i < salaries.size(); i++) {
			Salary salary = salaries.get(i);
			Label dLabel0 = new Label(0, i + 4, (i + 1) + "");
			Label dLabel1 = new Label(1, i + 4, salary.getEmployee().getEmpName());
			Label dLabel2 = new Label(2, i + 4, salary.getEmployee().getEmpDept().getDepartmentName());
			Label dLabel3 = new Label(3, i + 4, salary.getEmployee().getEmpPosition().getPositionName());

			Number number1 = new Number(7, i + 4, (salary.getBaseSalary() != null) ? salary.getBaseSalary() : 0);
			Number number2 = new Number(8, i + 4, salary.getAllowance() != null ? salary.getAllowance() : 0);
			Number number3 = new Number(9, i + 4, salary.getJobSubsidy() != null ? salary.getJobSubsidy() : 0);
			Number number4 = new Number(10, i + 4, salary.getOvertimeSalary() != null ? salary.getOvertimeSalary() : 0);
			Number number5 = new Number(11, i + 4, salary.getOvertimeSubsidy() != null ? salary.getOvertimeSubsidy() : 0);
			Number number6 = new Number(12, i + 4, salary.getMustSalary() != null ? salary.getMustSalary() : 0);
			Number number7 = new Number(13, i + 4, salary.getLeaveUnpay() != null ? salary.getLeaveUnpay() : 0);
			Number number8 = new Number(14, i + 4, salary.getForfeit() != null ? salary.getForfeit() : 0);
			Number number9 = new Number(15, i + 4, salary.getOtherUnpay() != null ? salary.getOtherUnpay() : 0);
			Number number10 = new Number(16, i + 4, (salary.getLeaveUnpay() != null ? salary.getLeaveUnpay() : 0) + (salary.getForfeit() != null ? salary.getForfeit() : 0)
					+ (salary.getOtherUnpay() != null ? salary.getOtherUnpay() : 0));
			Number number11 = new Number(17, i + 4, salary.getRealSalary() != null ? salary.getRealSalary() : 0);
			labels.add(dLabel0);
			labels.add(dLabel1);
			labels.add(dLabel2);
			labels.add(dLabel3);
			labels.add(number1);
			labels.add(number2);
			labels.add(number3);
			labels.add(number4);
			labels.add(number5);
			labels.add(number6);
			labels.add(number7);
			labels.add(number8);
			labels.add(number9);
			labels.add(number10);
			labels.add(number11);
		}
		Label label = new Label(0, salaries.size() + 6, "经理签字：");
		labels.add(label);
		List<int[]> mergeCells = new ArrayList<int[]>();
		mergeCells.add(mergeCell1);
		mergeCells.add(mergeCell2);
		mergeCells.add(mergeCell3);
		mergeCells.add(mergeCell4);
		mergeCells.add(mergeCell5);
		mergeCells.add(mergeCell6);
		mergeCells.add(mergeCell9);
		mergeCells.add(mergeCell10);
		mergeCells.add(mergeCell11);

		ExcelExportUtils.export(response, title, labels, mergeCells);
	}

	/**
	 * 根据员工id获得salary
	 */
	public Salary getByEmpId(Integer empId) {
		return this.findUnique("from Salary s where s.employee.id = ?", empId);
	}
}
