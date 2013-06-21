package com.app.meibo.finace.expenditure.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.finace.account.model.Account;
import com.app.meibo.finace.account.service.AccountManager;
import com.app.meibo.finace.accountant.service.AccountantManager;
import com.app.meibo.finace.expenditure.model.Expenditure;
import com.app.meibo.finace.expenditure.model.vo.ExpenditureVO;
import com.app.meibo.finace.expenditure.service.ExpenditureManager;
import com.app.permission.model.Page;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;
import com.sqds.util.ParamUtils;

/**
 * 收支管理
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-1-10 下午10:06:15
 */
@Controller
@RequestMapping("/finace/expenditure/*.html")
@GlobalAutowired
public class ExpenditureController {
	private ExpenditureManager expenditureManager;
	private AccountManager accountManager;
	private AccountantManager accountantManager;

	@RequestMapping
	public void index() {

	}

	@RequestMapping
	public void listContent(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		Page<Expenditure> page = new Page<Expenditure>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);
		page.search(page, "Expenditure", expenditureManager);
		List<Expenditure> expenditures = page.getResult();
		List<ExpenditureVO> expenditureVOs = new ArrayList<ExpenditureVO>();
		for (Expenditure expenditure : expenditures) {
			ExpenditureVO vo = new ExpenditureVO();
			BeanUtilsEx.copyProperties(vo, expenditure);
			if (expenditure.getAccountId() != null) {
				vo.setAccountName(accountManager.get(expenditure.getAccountId()).getAccountName());
			}
			if (expenditure.getAccountantId() != null) {
				vo.setAccountantName(accountantManager.get(expenditure.getAccountantId()).getAccountName());
			}
			expenditureVOs.add(vo);
		}
		model.put("total", page.getTotalCount());
		model.put("rows", expenditureVOs);
		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void saveExpend(ModelMap model, Expenditure expenditure, HttpServletResponse response) {
		// Integer accountantId = ParamUtils.getInteger("accountantId", 0);
		Integer accountId = ParamUtils.getInteger("accountId", 0);
		// Accountant accountant = accountantManager.get(accountantId);
		Account account = accountManager.get(accountId);
		// expenditure.setAccountant(accountant);
		expenditure.setAccountId(account.getId());
		expenditureManager.save(expenditure);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void deleteExpend(HttpServletResponse response) {
		Integer expendId = ParamUtils.getInteger("expendId", 0);
		Expenditure expenditure = expenditureManager.get(expendId);
		expenditureManager.deleteObject(expenditure);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void listAccountant() {

	}

	@RequestMapping
	public void listAccount() {

	}

	/**
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(dateFormat, true));
	}
}
