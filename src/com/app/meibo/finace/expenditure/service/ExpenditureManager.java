package com.app.meibo.finace.expenditure.service;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.app.meibo.constant.ExpenditureEnum;
import com.app.meibo.finace.expenditure.model.Expenditure;
import com.sqds.hibernate.HibernateDao;
import com.sqds.page.PageInfo;
import com.sqds.util.DateUtils;

@Service
public class ExpenditureManager extends HibernateDao<Expenditure> {

	/**
	 * 获取某一年的数据
	 * 
	 * @param year
	 * @return
	 */
	public List<Expenditure> getListByYear(int year, int inOrOut) {
		Date beginDate = DateUtils.string2Date(year + "-01-01");
		Date endDate = DateUtils.string2Date((year + 1) + "-01-01");
		return this.list("from Expenditure e where e.inOrOut = ? and e.changeDate between ? and ?", inOrOut, beginDate, endDate);
	}

	/**
	 * 获取按年统计的数据
	 * 
	 * @param inOrOut
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Double> getYearData(int inOrOut) {
		Map<String, Double> data = new TreeMap<String, Double>();
		// 获取年
		Session session = this.getSession();
		String sql1 = "select DATE_FORMAT(changeDate, '%Y') AS year FROM expenditure GROUP BY DATE_FORMAT(changeDate, '%Y') order by DATE_FORMAT(changeDate, '%Y')";
		Query query = session.createSQLQuery(sql1);
		List<Object> result = query.list();
		for (Object object : result) {
			String year = object.toString();
			String sqlString = "select SUM(e.money) AS sum " + "FROM expenditure e " + "WHERE e.inOrOut = " + inOrOut + " AND DATE_FORMAT(e.changeDate, '%Y') = " + year;
			Object r = session.createSQLQuery(sqlString).uniqueResult();
			double sum = 0;
			if (r != null) {
				sum = (Double) r;
			}
			data.put(year, sum);
		}
		return data;
	}

	/**
	 * 获取按年统计的数据(具体花费)
	 * 
	 * @param inOrOut
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Double> getYearData(int inOrOut, String type, Integer entityId) {
		Map<String, Double> data = new TreeMap<String, Double>();
		// 获取年
		Session session = this.getSession();
		String sql1 = "select DATE_FORMAT(changeDate, '%Y') AS year FROM expenditure where entityId=" + entityId + " and type='" + type
				+ "' GROUP BY DATE_FORMAT(changeDate, '%Y') order by DATE_FORMAT(changeDate, '%Y')";
		Query query = session.createSQLQuery(sql1);
		List<Object> result = query.list();
		for (Object object : result) {
			String year = object.toString();
			String sqlString = "select SUM(e.money) AS sum " + "FROM expenditure e " + "WHERE e.entityId=" + entityId + " and e.inOrOut = " + inOrOut + " and e.type='" + type
					+ "' AND DATE_FORMAT(e.changeDate, '%Y') = " + year;
			Object r = session.createSQLQuery(sqlString).uniqueResult();
			double sum = 0;
			if (r != null) {
				sum = (Double) r;
			}
			data.put(year, sum);
		}
		return data;
	}

	/**
	 * 获取按年统计的数据(具体花费)
	 * 
	 * @param inOrOut
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Double> getYearData(int inOrOut, String type) {
		Map<String, Double> data = new TreeMap<String, Double>();
		// 获取年
		Session session = this.getSession();
		String sql1 = "select DATE_FORMAT(changeDate, '%Y') AS year FROM expenditure where type='" + type
				+ "' GROUP BY DATE_FORMAT(changeDate, '%Y') order by DATE_FORMAT(changeDate, '%Y')";
		Query query = session.createSQLQuery(sql1);
		List<Object> result = query.list();
		for (Object object : result) {
			String year = object.toString();
			String sqlString = "select SUM(e.money) AS sum " + "FROM expenditure e " + "WHERE e.inOrOut = " + inOrOut + " and e.type='" + type
					+ "' AND DATE_FORMAT(e.changeDate, '%Y') = " + year;
			Object r = session.createSQLQuery(sqlString).uniqueResult();
			double sum = 0;
			if (r != null) {
				sum = (Double) r;
			}
			data.put(year, sum);
		}
		return data;
	}

	/**
	 * 获取按年统计的数据(具体数量)
	 * 
	 * @param inOrOut
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public Map<String, Integer> getYearMount(int inOrOut, String type) {
		Map<String, Integer> data = new TreeMap<String, Integer>();
		// 获取年
		Session session = this.getSession();
		String sql1 = "select DATE_FORMAT(changeDate, '%Y') AS year FROM expenditure where type='" + type
				+ "' GROUP BY DATE_FORMAT(changeDate, '%Y') order by DATE_FORMAT(changeDate, '%Y')";
		Query query = session.createSQLQuery(sql1);
		List<Object> result = query.list();
		for (Object object : result) {
			String year = object.toString();
			String sqlString = "select count(*) as m " + "FROM expenditure e " + "WHERE e.inOrOut = " + inOrOut + " and e.type='" + type
					+ "' AND DATE_FORMAT(e.changeDate, '%Y') = " + year;
			Object r = session.createSQLQuery(sqlString).uniqueResult();
			int count = 0;
			if (r != null) {
				count = ((BigInteger) r).intValue();
			}
			data.put(year, count);
		}
		return data;
	}

	/**
	 * 获取某一年12个月的数据数组
	 * 
	 * @param year
	 *            年份
	 * @param inOrOut
	 *            收入：1,支出：0
	 * @return
	 */
	public double[] getMonthData(int year, int inOrOut) {
		double[] data = { 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l };
		Session session = this.getSession();
		for (int i = 1; i <= 12; i++) {
			String sql = "select sum(e.money) from expenditure e where e.inOrOut = " + inOrOut + " and DATE_FORMAT(e.changeDate, '%Y')=" + year + " "
					+ "and DATE_FORMAT(e.changeDate, '%m')>= " + i + " and DATE_FORMAT(e.changeDate, '%m') < " + (i + 1);
			Query query = session.createSQLQuery(sql);
			double sum = 0l;
			Object object = query.uniqueResult();
			if (object != null) {
				sum = (Double) object;
			}
			data[i - 1] = sum;
		}
		return data;
	}

	/**
	 * 获取某一年12个月的数据数组(具体花费)
	 * 
	 * @param year
	 *            年份
	 * @param inOrOut
	 *            收入：1,支出：0
	 * @return
	 */
	public double[] getMonthData(int year, int inOrOut, String type) {
		double[] data = { 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l };
		Session session = this.getSession();
		for (int i = 1; i <= 12; i++) {
			String sql = "select sum(e.money) from expenditure e where e.inOrOut = " + inOrOut + " and e.type='" + type + "' and DATE_FORMAT(e.changeDate, '%Y')=" + year + " "
					+ "and DATE_FORMAT(e.changeDate, '%m')>= " + i + " and DATE_FORMAT(e.changeDate, '%m') < " + (i + 1);
			Query query = session.createSQLQuery(sql);
			double sum = 0l;
			Object object = query.uniqueResult();
			if (object != null) {
				sum = (Double) object;
			}
			data[i - 1] = sum;
		}
		return data;
	}

	/**
	 * 获取某一年12个月的数据数组(具体交易额)
	 * 
	 * @param year
	 *            年份
	 * @param inOrOut
	 *            收入：1,支出：0
	 * @return
	 */
	public int[] getMonthCount(int year, int inOrOut, String type) {
		int[] data = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		Session session = this.getSession();
		for (int i = 1; i <= 12; i++) {
			String sql = "select count(*) from expenditure e where e.inOrOut = " + inOrOut + " and e.type='" + type + "' and DATE_FORMAT(e.changeDate, '%Y')=" + year + " "
					+ "and DATE_FORMAT(e.changeDate, '%m')>= " + i + " and DATE_FORMAT(e.changeDate, '%m') < " + (i + 1);
			Query query = session.createSQLQuery(sql);
			int sum = 0;
			Object object = query.uniqueResult();
			if (object != null) {
				sum = ((BigInteger) object).intValue();
			}
			data[i - 1] = sum;
		}
		return data;
	}

	/**
	 * 获取某一年12个月的数据数组(具体实体具体花费)
	 * 
	 * @param year
	 *            年份
	 * @param inOrOut
	 *            收入：1,支出：0
	 * @return
	 */
	public double[] getMonthData(int year, int inOrOut, String type, Integer entityId) {
		double[] data = { 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l };
		Session session = this.getSession();
		for (int i = 1; i <= 12; i++) {
			String sql = "select sum(e.money) from expenditure e where e.entityId=" + entityId + " and e.inOrOut = " + inOrOut + " and e.type='" + type
					+ "' and DATE_FORMAT(e.changeDate, '%Y')=" + year + " " + "and DATE_FORMAT(e.changeDate, '%m')>= " + i + " and DATE_FORMAT(e.changeDate, '%m') < " + (i + 1);
			Query query = session.createSQLQuery(sql);
			double sum = 0l;
			Object object = query.uniqueResult();
			if (object != null) {
				sum = (Double) object;
			}
			data[i - 1] = sum;
		}
		return data;
	}

	public Expenditure getByEntityId(int prorderId, String type) {
		return this.findUnique(" from Expenditure e where e.entityId = ? and e.type = ? ", prorderId, type);
	}

	public List<Expenditure> listByEntity(String type) {
		return list("from Expenditure e where e.type = ?", type);
	}

	/**
	 * 获得总出售额和最近三个月的销售额，用在首页展示。
	 * 
	 * @return
	 */
	public double[] getAllAndRecentSales() {
		List<Expenditure> expenditures = this.listByEntity(ExpenditureEnum.TOTALCOST.getType());
		double[] sales = new double[2];
		double allCost = 0;
		double cost = 0;
		for (Expenditure expenditure : expenditures) {
			allCost += expenditure.getMoney();
			Date createDate = expenditure.getCreateDate();
			long day = (new Date().getTime() - createDate.getTime()) / (24 * 60 * 60 * 1000);
			if (day < (3 * 30)) {
				cost += expenditure.getMoney();
			}
		}
		sales[0] = allCost;
		sales[1] = cost;
		return sales;
	}

	public PageInfo<Expenditure> listByAccount(Integer accountId, PageInfo<Expenditure> page) {
		return this.list(page, "form Expenditure e where e.account.id = ?", accountId);
	}
}
