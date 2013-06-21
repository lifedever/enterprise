package com.app.meibo.offer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.meibo.offer.model.MaterialDetail;
import com.sqds.hibernate.HibernateDao;

@Service
public class MaterialDetailManager extends HibernateDao<MaterialDetail>{
	
	public List<MaterialDetail> listByItemId(Integer itemId){
		String hql = "from MaterialDetail m where m.itemId = ?";
		return list(hql, itemId);
	}
}
