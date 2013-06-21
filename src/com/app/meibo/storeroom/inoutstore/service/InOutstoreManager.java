package com.app.meibo.storeroom.inoutstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.meibo.storeroom.inoutstore.model.InOutstore;
import com.sqds.hibernate.HibernateDao;

@Service
public class InOutstoreManager extends HibernateDao<InOutstore>  {
	
	public List<InOutstore> getByProductNo(String productNo){
		String hql = " from InOutstore i where i.productNo = ?" ;
		return list(hql, productNo);
	}
}
