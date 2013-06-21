package com.app.meibo.finace.dayAccount.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.meibo.finace.dayAccount.model.TotalAccount;
import com.sqds.hibernate.HibernateDao;

@Service
public class TotalAccountManager extends HibernateDao<TotalAccount> {
	public TotalAccount getLastTotalAccount(Integer accountId) {
		List<TotalAccount> totalAccounts = list("from TotalAccount ta where ta.account.id = ? order by ta.createDate desc", accountId);
		if (totalAccounts != null && totalAccounts.size() > 0) {
			return totalAccounts.get(0);
		} else {
			return null;
		}
	}
}
