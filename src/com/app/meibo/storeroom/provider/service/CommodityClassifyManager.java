package com.app.meibo.storeroom.provider.service;

import org.springframework.stereotype.Service;

import com.app.meibo.storeroom.provider.model.CommodityClassify;
import com.sqds.hibernate.HibernateDao;
import com.sqds.page.PageInfo;

@Service
public class CommodityClassifyManager extends HibernateDao<CommodityClassify> {

	public PageInfo<CommodityClassify> search(PageInfo<CommodityClassify> pageInfo) {
		return super.list(pageInfo,"from CommodityClassify c where c.isDelete != 1");
	}
}
