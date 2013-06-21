package com.app.meibo.contract.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.app.meibo.contract.model.Contract;
import com.sqds.hibernate.HibernateDao;

@Service
public class ContractManager extends HibernateDao<Contract> {
	/**
	 * 生成编号，规则：20120101000001
	 * 
	 * @return
	 */
	public String generateOrderNo() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		DecimalFormat format = new DecimalFormat("00000000");
		//int count = this.list("from Contract") == null || this.list("from Contract").size() == 0 ? 1 : this.list("from Contract").size()+1;
		int count = this.list("from Contract order by id desc") == null || this.list("from Contract order by id desc").size() == 0 ? 1 : this.list("from Contract order by id desc").get(0)
				.getId() + 1;
		return sdf.format(date) + format.format(count);
	}
	
	public Contract getByOrderId(Integer orderId){
		return findUnique("from Contract c where c.order.id = ?", orderId);
	}
}
