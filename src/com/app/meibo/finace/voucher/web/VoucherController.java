package com.app.meibo.finace.voucher.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.meibo.finace.accountant.model.Accountant;
import com.app.meibo.finace.accountant.service.AccountantManager;
import com.app.meibo.finace.model.AccountType;
import com.app.meibo.finace.service.AccountTypeManager;
import com.app.meibo.finace.voucher.model.Voucher;
import com.app.meibo.finace.voucher.model.VoucherItem;
import com.app.meibo.finace.voucher.model.VoucherItemsFooter;
import com.app.meibo.finace.voucher.service.VoucherItemManager;
import com.app.meibo.finace.voucher.service.VoucherManager;
import com.app.permission.model.Page;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;
import com.sqds.util.SessionManager;

@Controller
@RequestMapping("/finace/voucher/*.html")
@GlobalAutowired
@SuppressWarnings("unchecked")
public class VoucherController {
	private VoucherManager voucherManager;
	private VoucherItemManager voucherItemManager;
	private AccountantManager accountantManager;
	private AccountTypeManager accountTypeManager;

	@RequestMapping
	public void index() {

	}

	@RequestMapping
	public void listContent(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Page<Voucher> page = new Page<Voucher>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);
		page.search(page, "Voucher", voucherManager);
		model.put("total", page.getResult().size());
		model.put("rows", page.getResult());
		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void listVoucherItem(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		List<VoucherItem> voucherItems = (List<VoucherItem>) SessionManager.getAttribute(request, "voucherItems");
		double debtorS = 0;//
		double creditS = 0;
		int total = 0;
		if (voucherItems != null) {
			for (VoucherItem item : voucherItems) {
				if (item.getDebtor() != null) {
					debtorS += item.getDebtor();
				}
				if (item.getCredit() != null) {
					creditS += item.getCredit();
				}
			}
		} else {
			voucherItems = new ArrayList<VoucherItem>();
		}
		List<VoucherItemsFooter> footers = new ArrayList<VoucherItemsFooter>();
		footers.add(new VoucherItemsFooter("合计：", debtorS, creditS));

		model.put("footer", footers);
		model.put("total", total);
		model.put("rows", voucherItems);
		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void addForm(@RequestParam(defaultValue = "0") int id, ModelMap model, HttpSession session) {
		// 清除已存在的voucherItems值。
		session.removeAttribute("voucherItems");
		Voucher voucher = null;
		if (id == 0) {
			voucher = new Voucher();
			voucher.setCreateDate(new Date());
		} else {
			voucher = voucherManager.get(id);
			List<VoucherItem> voucherItems = voucherItemManager.getItemsByVoucher(id);
			session.setAttribute("voucherItems", voucherItems);
			model.addAttribute("voucherItems", voucherItems);
		}
		model.addAttribute("voucher", voucher);
	}

	@RequestMapping
	public void editVoucher() {

	}

	@RequestMapping
	public void saveVoucher(Voucher voucher, HttpServletResponse response, HttpSession session) {
		voucherManager.save(voucher);
		if (voucher.getId().intValue() != 0) {
			List<VoucherItem> voucherItems = voucherItemManager.getItemsByVoucher(voucher.getId());
			voucherItemManager.removeObjects(voucherItems);
		}
		voucherManager.getSessionFactory().openSession().clear();
		List<VoucherItem> voucherItems = session.getAttribute("voucherItems") != null ? (List<VoucherItem>) session.getAttribute("voucherItems") : new ArrayList<VoucherItem>();
		for (VoucherItem voucherItem : voucherItems) {
			voucherItem.setId(null);
			voucherItem.setVoucher(voucher);
		}
		voucherItemManager.saveOjbects(voucherItems);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void deleteVoucher(int id, ModelMap model, HttpServletResponse response) {
		List<VoucherItem> voucherItems = voucherItemManager.getItemsByVoucher(id);
		voucherItemManager.removeObjects(voucherItems);
		voucherManager.delete(id);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void addItemForm(@RequestParam(defaultValue = "0") int id, ModelMap model, HttpSession session) {
		List<VoucherItem> voucherItems = session.getAttribute("voucherItems") != null ? (List<VoucherItem>) session.getAttribute("voucherItems") : new ArrayList<VoucherItem>();
		VoucherItem voucherItem = voucherItemManager.getVoucherItemFromSession(id, voucherItems);
		model.addAttribute("voucherItem", voucherItem);
	}

	@RequestMapping
	public void listAccountant1() {

	}

	@RequestMapping
	public void listAccountant2() {

	}

	@RequestMapping
	public void saveVoucherItem(VoucherItem voucherItem, HttpServletRequest request, HttpServletResponse response, HttpSession session) {
		List<VoucherItem> voucherItems = session.getAttribute("voucherItems") != null ? (List<VoucherItem>) session.getAttribute("voucherItems") : new ArrayList<VoucherItem>();
		if (voucherItem.getId() != null && voucherItem.getId().intValue() != 0) {
			VoucherItem tempItem = voucherItemManager.getVoucherItemFromSession(voucherItem.getId(), voucherItems);
			voucherItems.remove(tempItem);
		}
		voucherItem.setId(voucherItems.size() + 1);
		voucherItems.add(voucherItem);
		session.setAttribute("voucherItems", voucherItems);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void delVoucherItem(Integer voucherItemId, HttpServletResponse response, HttpSession session) {
		List<VoucherItem> voucherItems = session.getAttribute("voucherItems") != null ? (List<VoucherItem>) session.getAttribute("voucherItems") : new ArrayList<VoucherItem>();
		VoucherItem tempItem = voucherItemManager.getVoucherItemFromSession(voucherItemId, voucherItems);
		voucherItems.remove(tempItem);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void summary(Date startDate, Date endDate, ModelMap model) {
		List<AccountType> accountTypes = accountTypeManager.list("from AccountType");
		int count = accountTypes.size();
		for (AccountType accountType : accountTypes) {
			List<Accountant> accountants = accountantManager.listAccountantsByTypeId(accountType.getId());
			this.generate(accountType, accountants, startDate, endDate);
			accountType.setAccountants(accountants);
			count += accountants.size();
		}
		model.addAttribute("accountTypes", accountTypes);
		model.addAttribute("count", count);
	}

	/**
	 * 
	 * @param accountType
	 * @param accountants
	 */
	private void generate(AccountType accountType, List<Accountant> accountants, Date startDate, Date endDate) {
		double d = 0;
		double c = 0;
		for (Accountant accountant : accountants) {
			List<VoucherItem> voucherItems = voucherItemManager.findByTypeAndAccountantName(accountant.getAccountName(), startDate, endDate);
			double debtor = 0;
			double credit = 0;
			for (VoucherItem item : voucherItems) {
				debtor += item.getDebtor() == null ? 0 : item.getDebtor();
				credit += item.getCredit() == null ? 0 : item.getCredit();
			}
			accountant.setDebtor(debtor);
			accountant.setCredit(credit);
			d += debtor;
			c += credit;
		}
		accountType.setDebtor(d);
		accountType.setCredit(c);
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日");
		dateFormat.setLenient(false);
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
