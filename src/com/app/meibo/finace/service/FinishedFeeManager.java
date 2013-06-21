package com.app.meibo.finace.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.meibo.finace.model.FinishedFee;
import com.sqds.hibernate.HibernateDao;

@Service
public class FinishedFeeManager extends HibernateDao<FinishedFee>{
	
	public List<FinishedFee> getListByOrderNo(String orderNo){
		String hql = " from FinishedFee f where f.orderNo = ?";
		return list(hql, orderNo);
	}
}
