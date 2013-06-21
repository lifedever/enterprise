package com.app.meibo.operationalPart.cooperation.service;

import org.springframework.stereotype.Service;

import com.app.meibo.operationalPart.cooperation.model.CooperationOrder;
import com.sqds.hibernate.HibernateDao;

@Service
public class CooperationOrderManager extends HibernateDao<CooperationOrder> {
	public CooperationOrder getByProductNo(String productNo) {
		return findUnique("from CooperationOrder w where w.productNo = ?", productNo);
	}
}
