package com.app.meibo.storeroom.inoutstore.service;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import com.app.meibo.storeroom.inoutstore.model.ProductInOutstore;
import com.sqds.hibernate.HibernateDao;

@Service
public class ProductInOutstoreManager extends HibernateDao<ProductInOutstore> {

	/**
	 * 获得热销商品，前6个。
	 * 
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<Object[]> getHostList() {
		Session session = this.getSession();
		String sql = "SELECT SUM(t.count) as psun,t.finishedProductName " +
				"from t_productinoutstore t WHERE t.operation = 1 " +
				"GROUP BY t.finishedProductName ORDER BY psun desc limit 6";
		Query sqlQuery = session.createSQLQuery(sql);
		return sqlQuery.list();
	}

}
