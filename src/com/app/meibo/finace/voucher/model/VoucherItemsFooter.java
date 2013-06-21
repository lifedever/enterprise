package com.app.meibo.finace.voucher.model;

public class VoucherItemsFooter {
	private String accountantName;
	private double debtor;
	private double credit;

	public VoucherItemsFooter() {
	}

	public VoucherItemsFooter(String accountantName, double debtor, double credit) {
		super();
		this.accountantName = accountantName;
		this.debtor = debtor;
		this.credit = credit;
	}

	public String getAccountantName() {
		return accountantName;
	}

	public double getDebtor() {
		return debtor;
	}

	public double getCredit() {
		return credit;
	}

	public void setAccountantName(String accountantName) {
		this.accountantName = accountantName;
	}

	public void setDebtor(double debtor) {
		this.debtor = debtor;
	}

	public void setCredit(double credit) {
		this.credit = credit;
	}

}
