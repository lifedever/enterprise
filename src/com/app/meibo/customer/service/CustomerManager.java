package com.app.meibo.customer.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.app.meibo.customer.model.Customer;
import com.sqds.hibernate.HibernateDao;

@Service
public class CustomerManager extends HibernateDao<Customer> {

	/**
	 * 总客户数和三个月内新的客户数
	 * 
	 * @return
	 */
	public int[] getAllCountAndNewCount() {
		int[] arr = { 0, 0 };
		// 员工总数
		List<Customer> customers = this.list("from Customer c where c.isDelete !=1");
		arr[0] = customers == null ? 0 : customers.size();
		// 最近三个月新来的员工数
		for (Customer customer : customers) {
			Date joinDate = customer.getCreateDate();
			long day = (new Date().getTime() - joinDate.getTime()) / (24 * 60 * 60 * 1000);
			if (day < (3 * 30)) {
				arr[1]++;
			}
		}
		return arr;
	}

	/**
	 * 按订单数列出客户，从多到少
	 */
	@SuppressWarnings("unchecked")
	public List<Customer> listCustomers() {
		Session session = this.getSession();
		String sql = "select customerId from t_order group by customerId order by count(*) desc limit 0,5";
		SQLQuery sqlQuery = session.createSQLQuery(sql);
		List<Object> objects = sqlQuery.list();
		List<Customer> customers = new ArrayList<Customer>();
		for (Object object : objects) {
			if (object!=null) {
				customers.add(this.get((Integer) object));
			}
		}
		return customers;
	}
}
