package com.app.meibo.storeroom.provider.service;

import org.springframework.stereotype.Service;

import com.app.meibo.storeroom.provider.model.Provider;
import com.sqds.hibernate.HibernateDao;
import com.sqds.page.PageInfo;

@Service
public class ProviderManager extends HibernateDao<Provider> {

	public PageInfo<Provider> search(PageInfo<Provider> pageInfo) {
		return super.list(pageInfo, "from Provider p where p.isDelete != 1");
	}

	public Provider getByProviderName(String name) {
		return findUnique("from Provider p where p.companyName = ? and p.isDelete = 0", name);
	}
}
