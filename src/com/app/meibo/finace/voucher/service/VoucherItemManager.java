package com.app.meibo.finace.voucher.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.meibo.finace.voucher.model.VoucherItem;
import com.sqds.hibernate.HibernateDao;

@Service
public class VoucherItemManager extends HibernateDao<VoucherItem> {
	public VoucherItem getVoucherItemFromSession(int id, List<VoucherItem> voucherItems) {
		VoucherItem voucherItem = new VoucherItem();
		for (VoucherItem item : voucherItems) {
			if (id == item.getId().intValue()) {
				voucherItem = item;
				break;
			}
		}
		return voucherItem;
	}

	public List<VoucherItem> getItemsByVoucher(Integer voucherId) {
		return this.list("from VoucherItem vi where vi.voucher.id=?", voucherId);
	}

	public List<VoucherItem> findByTypeAndAccountantName(String accountName, Date startDate, Date endDate) {
		StringBuffer hql = new StringBuffer("from VoucherItem vi where vi.accountantType = ?");
		List<Object> dataObjects = new ArrayList<Object>();
		dataObjects.add(accountName);

		if (startDate != null) {
			hql.append(" and vi.createDate >= ?");
			dataObjects.add(startDate);
		}
		
		if (endDate != null) {
			hql.append(" and vi.createDate <= ?");
			dataObjects.add(endDate);
		}
		return list(hql.toString(), dataObjects.toArray());
	}
}
