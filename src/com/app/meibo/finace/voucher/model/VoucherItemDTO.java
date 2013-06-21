package com.app.meibo.finace.voucher.model;

import java.util.List;

/**
 * 用于绑定表单,向后台传输数据
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-3-25 下午9:32:28
 */
public class VoucherItemDTO {
	private List<VoucherItem> voucherItems;

	public List<VoucherItem> getVoucherItems() {
		return voucherItems;
	}

	public void setVoucherItems(List<VoucherItem> voucherItems) {
		this.voucherItems = voucherItems;
	}

}
