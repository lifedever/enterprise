package com.app.meibo.finace.account.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.meibo.finace.account.model.Account;
import com.sqds.hibernate.HibernateDao;

@Service
public class AccountManager extends HibernateDao<Account> {

	public List<Account> listAccounts(){
		return list("from Account a order by a.accountType");
	}
	
	/**
	 * 查询银行账户
	 * 
	 * @return
	 */
	public List<Account> listCardAccounts() {
		return list("from Account a where a.accountType = 1");
	}

	/**
	 * 查询现金账户
	 * 
	 * @return
	 */
	public List<Account> listCashAccounts() {
		return list("from Account a where a.accountType = 0");
	}

	public Account getByAccountNo(String accountNo) {
		return findUnique("from Account a where a.accountNo = ?", accountNo);
	}

}
