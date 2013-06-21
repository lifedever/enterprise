package com.app.meibo.storeroom.provider.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.app.meibo.storeroom.provider.model.Commodity;
import com.sqds.hibernate.HibernateDao;
import com.sqds.page.PageInfo;

@Service
public class CommodityManager extends HibernateDao<Commodity> {

	public PageInfo<Commodity> search(PageInfo<Commodity> pageInfo) {
		String providerId = (String) pageInfo.getParameter("providerId");
		StringBuffer hql = new StringBuffer("from Commodity c where c.isDelete != 1");
		if (StringUtils.isNotEmpty(providerId)) {
			hql.append(" and c.provider.id = " + providerId);
		}
		return super.list(pageInfo, hql.toString());
	}

	public Commodity getByCommodityName(String name) {
		return super.findUnique("from Commodity c where c.name = ?", name);
	}

	/**
	 * 列出
	 * @param page
	 * @param materialIds
	 */
	public PageInfo<Commodity> listcommodityForMaterial(PageInfo<Commodity> pageInfo, List<Integer> commodityIds) {
		String name = (String)pageInfo.getParameter("s_name");
		String standard = (String)pageInfo.getParameter("s_standard");
		String provider = (String)pageInfo.getParameter("s_provider.name");
		StringBuffer hql = new StringBuffer("from Commodity c where 1=1 ");
		List<String> conditions = new ArrayList<String>();
		if(StringUtils.isNotEmpty(name)){
			hql.append(" and c.name like ? ");
			conditions.add(name);
		}
		if(StringUtils.isNotEmpty(standard)){
			hql.append(" and c.standard like ? ");
			conditions.add(standard);
		}
		if(StringUtils.isNotEmpty(provider)){
			hql.append(" and c.provider.companyName like ? ");
			conditions.add(provider);
		}
		if (commodityIds.size()>0) {
			hql.append(" and c.id not in (");
			for(int i=0;i<commodityIds.size();i++){
				if (i==(commodityIds.size()-1)) {
					hql.append("?)");
				}else {
					hql.append("?,");
				}
			}
			if(conditions.size() > 0){
				return super.list(pageInfo, hql.toString(), conditions.toArray(), commodityIds.toArray());
			}else {
				return super.list(pageInfo, hql.toString(), commodityIds.toArray());
			}
		}else {
			return super.list(pageInfo, hql.toString(), conditions.toArray());
		}
	}
	
	/**
	 * 列出
	 * @param page
	 * @param materialIds
	 */
	public PageInfo<Commodity> listcommodityForAccessory(PageInfo<Commodity> pageInfo, List<Integer> commodityIds) {
		String name = (String)pageInfo.getParameter("s_name");
		String standard = (String)pageInfo.getParameter("s_standard");
		String provider = (String)pageInfo.getParameter("s_provider.name");
		StringBuffer hql = new StringBuffer("from Commodity c where 1=1 ");
		List<String> conditions = new ArrayList<String>();
		if(StringUtils.isNotEmpty(name)){
			hql.append(" and c.name like ? ");
			conditions.add(name);
		}
		if(StringUtils.isNotEmpty(standard)){
			hql.append(" and c.standard like ? ");
			conditions.add(standard);
		}
		if(StringUtils.isNotEmpty(provider)){
			hql.append(" and c.provider.companyName like ? ");
			conditions.add(provider);
		}
		if (commodityIds.size()>0) {
			hql.append(" and c.id not in (");
			for(int i=0;i<commodityIds.size();i++){
				if (i==(commodityIds.size()-1)) {
					hql.append("?)");
				}else {
					hql.append("?,");
				}
			}
			if(conditions.size() > 0){
				return super.list(pageInfo, hql.toString(), conditions.toArray(), commodityIds.toArray());
			}else {
				return super.list(pageInfo, hql.toString(), commodityIds.toArray());
			}
		}else {
			return super.list(pageInfo, hql.toString(), conditions.toArray());
		}
	}
	
}
