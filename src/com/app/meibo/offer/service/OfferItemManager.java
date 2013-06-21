package com.app.meibo.offer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.meibo.offer.model.OfferItem;
import com.sqds.hibernate.HibernateDao;

@Service
public class OfferItemManager extends HibernateDao<OfferItem> {
	public List<OfferItem> listByOfferId(Integer offerId) {
		return list("from OfferItem oi where oi.offer.id = ?", offerId);
	}
}
