package com.app.meibo.order.prepare.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.meibo.order.prepare.model.Material;
import com.sqds.hibernate.HibernateDao;

@Service
public class PrepareMaterialManager extends HibernateDao<Material> {

	public List<Material> findbyPrepareOrder(Integer id) {
		return list("from Material m where m.prepareOrder.id = ?", id);
	}

}
