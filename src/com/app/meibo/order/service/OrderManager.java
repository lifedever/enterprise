package com.app.meibo.order.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.meibo.order.model.Order;
import com.sqds.hibernate.HibernateDao;

@Service
public class OrderManager extends HibernateDao<Order> {

	/**
	 * 生成订单编号，规则：20120101000001
	 * 
	 * @return
	 */
	public String generateOrderNo() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		DecimalFormat format = new DecimalFormat("00000000");
		// int count = this.list("from Order") == null ||
		// this.list("from Order").size() == 0 ? 1 :
		// this.list("from Order").size() + 1;
		int count = this.list("from Order order by id desc") == null || this.list("from Order order by id desc").size() == 0 ? 1 : this.list("from Order order by id desc").get(0)
				.getId() + 1;
		return sdf.format(date) + format.format(count);
	}

	public Order getByOrderNo(String orderNo) {
		return findUnique("from Order o where o.orderNo = ?", orderNo);
	}

	public List<Order> listByCustomer(Integer customerId) {
		return list("from Order o where o.customer.id = ?", customerId);
	}
}
