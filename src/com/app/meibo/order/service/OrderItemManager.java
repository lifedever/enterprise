package com.app.meibo.order.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.meibo.order.model.OrderItem;
import com.sqds.hibernate.HibernateDao;

@Service
public class OrderItemManager extends HibernateDao<OrderItem> {
	/**
	 * 生成订单编号，规则：20120101000001
	 * 
	 * @return
	 */
	public String generateOrderItemNo() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		DecimalFormat format = new DecimalFormat("00000000");
		//int count = this.list("from OrderItem") == null || this.list("from OrderItem").size() == 0 ? 1 : this.list("from OrderItem").size() + 1;
		int count = this.list("from OrderItem order by id desc") == null || this.list("from OrderItem order by id desc").size() == 0 ? 1 : this.list("from OrderItem order by id desc").get(0)
				.getId() + 1;
		return sdf.format(date) + format.format(count);
	}
	public List<OrderItem> getListByOrderNo(String orderNo){
		String hql = " from OrderItem o where o.order.orderNo = ?";
		return list(hql, orderNo);
	}

	public OrderItem getByProductNo(String productNo) {
		return findUnique("from OrderItem oi where oi.productNo = ?", productNo);
	}
}
