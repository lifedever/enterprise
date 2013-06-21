package com.app.meibo.finace.accountant.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.meibo.finace.accountant.model.Accountant;
import com.sqds.hibernate.HibernateDao;
import com.sqds.page.PageInfo;

@Service
public class AccountantManager extends HibernateDao<Accountant> {

	public PageInfo<Accountant> search(PageInfo<Accountant> page, Integer typeId) {
		return super.list(page, "from Accountant a where a.accountType.id = ?", typeId);
	}
	public List<Accountant> listAccountantsByTypeId(Integer typeId){
		return super.list("from Accountant a where a.accountType.id = ?", typeId);
	}
}
