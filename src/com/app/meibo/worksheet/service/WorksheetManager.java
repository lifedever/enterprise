package com.app.meibo.worksheet.service;

import org.springframework.stereotype.Service;

import com.app.meibo.worksheet.model.Worksheet;
import com.sqds.hibernate.HibernateDao;

@Service
public class WorksheetManager extends HibernateDao<Worksheet> {
	public Worksheet getByProductNo(String productNo) {
		return findUnique("from Worksheet w where w.productNo = ?", productNo);
	}
}
