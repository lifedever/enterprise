package com.app.meibo.offer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.meibo.offer.model.Offer;
import com.sqds.hibernate.HibernateDao;

@Service
public class OfferManager extends HibernateDao<Offer> {

	public Offer getLastOffer(Integer customerId) {
		List<Offer> offers = list("from Offer o where o.customer.id = ? order by o.createDate desc", customerId);
		return (offers == null || offers.size() == 0 ? null : offers.get(0));
	}

	public Offer getByOrderNo(String orderNo) {
		return findUnique("from Offer o where o.orderNo = ?", orderNo);
	}

	public List<Offer> listByCustomer(Integer customerId) {
		return list("from Offer o where o.customer.id = ?", customerId);
	}
}
