package com.app.meibo.storeroom.buyrequest.service;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.app.meibo.storeroom.buyrequest.model.BuyRequest;
import com.sqds.hibernate.HibernateDao;
/**
 * 
 * @author MSQ
 * @email gefangshuai@163.com
 * @createdata 2013-3-4 下午9:39:41
 */
@Service
public class BuyRequestManager extends HibernateDao<BuyRequest>{

	
	/**
	 * 生成请购单编号，规则：20120101000001
	 * 
	 * @return
	 */
	public String generateBuyRequestNo() {
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		DecimalFormat format = new DecimalFormat("000000");
		//int count = this.list("from BuyRequest") == null || this.list("from BuyRequest").size() == 0 ? 1 : this.list("from BuyRequest").size()+1;
		int count = this.list("from BuyRequest order by id desc") == null || this.list("from BuyRequest order by id desc").size() == 0 ? 1 : this.list("from BuyRequest order by id desc").get(0)
				.getId() + 1;
		return sdf.format(date) + format.format(count);
	}
	
	/**
	 * 通过请购单号查询请购单
	 * @param buyRequestNo
	 * @return
	 */
	public BuyRequest getByBuyRequestNo(String buyRequestNo){
		String hql = " from BuyRequest b where b.buyRequestNo = ?";
		return findUnique(hql, buyRequestNo);
	}
}
