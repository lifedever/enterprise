package com.app.meibo.finace.dayAccount.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.meibo.finace.dayAccount.model.DayAccount;
import com.sqds.hibernate.HibernateDao;

@Service
public class DayAccountManager extends HibernateDao<DayAccount> {
	public List<DayAccount> listByTotalAccountId(Integer totalAccountId) {
		return list("from DayAccount da where da.totalAccount.id = ?", totalAccountId);
	}

	/**
	 * 获得记账次数
	 * 
	 * @param totalAccountId
	 * @return
	 */
	public Long getDayAccountCount(Integer totalAccountId) {
		return (Long) getSession().createQuery("select count(*) from DayAccount where totalAccount.id = ?").setInteger(0, totalAccountId).uniqueResult();
	}
}
