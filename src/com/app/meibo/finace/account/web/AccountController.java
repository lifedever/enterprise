package com.app.meibo.finace.account.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.finace.account.model.Account;
import com.app.meibo.finace.account.service.AccountManager;
import com.app.meibo.finace.expenditure.model.Expenditure;
import com.app.meibo.finace.expenditure.model.vo.ExpenditureVO;
import com.app.meibo.finace.expenditure.service.ExpenditureManager;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.page.PageInfo;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;

/**
 * 公司银行账户
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-12-17 下午11:12:59
 */
@Controller
@RequestMapping("/finace/account/*.html")
@GlobalAutowired
public class AccountController {
	private AccountManager accountManager;
	private ExpenditureManager expenditureManager;

	@RequestMapping
	public void indexCard() {

	}

	@RequestMapping
	public void indexCash() {

	}

	@RequestMapping
	public void listContent(HttpServletResponse response, Integer accountType, ModelMap modelMap) {
		List<Account> accounts = null;
		if (accountType.intValue() == 1) {
			accounts = accountManager.listCardAccounts();
		} else {
			accounts = accountManager.listCashAccounts();
		}
		modelMap.put("rows", accounts);
		JsonUtils.writeJson(response, modelMap);
	}

	@RequestMapping
	public void listAllContent(HttpServletResponse response, ModelMap modelMap) {

		List<Account> accounts = null;
		accounts = accountManager.listAccounts();
		modelMap.put("rows", accounts);
		JsonUtils.writeJson(response, modelMap);
	}

	@RequestMapping
	public void addAccount(HttpServletResponse response, Account account) {
		accountManager.save(account);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void deleteAccount(HttpServletResponse response, Integer id) {
		accountManager.delete(id);
		JsonUtils.writeJson(response);
	}

	/**
	 * 查看款项明细
	 */
	@RequestMapping
	public void showItems(Integer id, ModelMap model,HttpServletRequest request) {
		model.put("id", id);
	}
}
