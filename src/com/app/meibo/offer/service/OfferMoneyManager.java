package com.app.meibo.offer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.meibo.offer.model.OfferMoney;
import com.sqds.hibernate.HibernateDao;

@Service
public class OfferMoneyManager extends HibernateDao<OfferMoney> {

	public List<OfferMoney> listByItemId(Integer itemId) {
		return list("from OfferMoney om where om.offerItem.id = ?", itemId);
	}

	public OfferMoney getLast(Integer itemId) {
		List<OfferMoney> offerMoneys = this.list("from OfferMoney om where om.offerItem.id = ? order by om.createDate desc", itemId);
		if (offerMoneys != null && offerMoneys.size() > 0) {
			return offerMoneys.get(0);
		} else {
			return null;
		}
	}
}
