package com.app.meibo.finace.dayAccount.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.meibo.finace.account.model.Account;
import com.app.meibo.finace.account.service.AccountManager;
import com.app.meibo.finace.dayAccount.model.DayAccount;
import com.app.meibo.finace.dayAccount.model.TotalAccount;
import com.app.meibo.finace.dayAccount.model.vo.DayAccountVO;
import com.app.meibo.finace.dayAccount.model.vo.TotalAccountVO;
import com.app.meibo.finace.dayAccount.service.DayAccountManager;
import com.app.meibo.finace.dayAccount.service.TotalAccountManager;
import com.app.permission.model.Page;
import com.app.permission.model.User;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;
import com.sqds.util.SessionManager;

/**
 * 银行日记账
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-3-20 下午10:21:14
 */
@Controller
@RequestMapping("/finace/dayAccount/*.html")
@GlobalAutowired
public class DayAccountController {
	private DayAccountManager dayAccountManager;
	private AccountManager accountManager;
	private TotalAccountManager totalAccountManager;

	/**
	 * 银行日记账:总额
	 */
	@RequestMapping
	public void newTotalAccount(Integer accountId, ModelMap model) {
		model.addAttribute("accountId", accountId);
	}

	/**
	 * 银行日记账:总额
	 */
	@RequestMapping
	public void newDayAccount(Integer totalAccountId, ModelMap model) {
		TotalAccount totalAccount = totalAccountManager.get(totalAccountId);
		model.addAttribute("totalAccount", totalAccount);
	}

	/**
	 * 总额列表
	 * 
	 * @param request
	 * @param model
	 * @param response
	 */
	@RequestMapping
	public void listTotalAccountContent(HttpServletRequest request, ModelMap model, HttpServletResponse response) {
		Page<TotalAccount> page = new Page<TotalAccount>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);
		page.search(page, "TotalAccount", totalAccountManager);
		List<TotalAccountVO> totalAccountVOs = new ArrayList<TotalAccountVO>();
		for (TotalAccount totalAccount : page.getResult()) {
			TotalAccountVO vo = new TotalAccountVO();
			BeanUtilsEx.copyProperties(vo, totalAccount);
			vo.setCount(dayAccountManager.getDayAccountCount(totalAccount.getId()).intValue());
			totalAccountVOs.add(vo);
		}

		model.put("total", page.getTotalCount());
		model.put("rows", totalAccountVOs);
		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void listContent(HttpServletRequest request, ModelMap model, HttpServletResponse response) {
		Page<DayAccount> page = new Page<DayAccount>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);
		page.search(page, "DayAccount", dayAccountManager);
		List<DayAccountVO> dayAccountVOs = new ArrayList<DayAccountVO>();
		for (DayAccount dayAccount : page.getResult()) {
			DayAccountVO vo = new DayAccountVO();
			BeanUtilsEx.copyProperties(vo, dayAccount);
			dayAccountVOs.add(vo);
		}

		model.put("total", page.getTotalCount());
		model.put("rows", dayAccountVOs);
		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void totalAccountForm(@RequestParam(defaultValue = "0") int id, Integer accountId, ModelMap model) {
		TotalAccount totalAccount = null;
		if (id == 0) {
			totalAccount = new TotalAccount();
		} else {
			totalAccount = totalAccountManager.get(id);
		}
		TotalAccount tAccount = totalAccountManager.getLastTotalAccount(accountId);
		model.addAttribute("tAccount", tAccount);
		model.addAttribute("accountId", accountId);
		model.addAttribute("totalAccount", totalAccount);
	}

	@RequestMapping
	public void dayAccountForm(@RequestParam(defaultValue = "0") int id, Integer totalAccountId, ModelMap model) {
		DayAccount dayAccount = null;
		if (id == 0) {
			dayAccount = new DayAccount();
		} else {
			dayAccount = dayAccountManager.get(id);
		}
		TotalAccount totalAccount = totalAccountManager.get(totalAccountId);
		model.addAttribute("totalAccount", totalAccount);
		model.addAttribute("dayAccount", dayAccount);
	}

	@RequestMapping
	public void saveTotalAccount(TotalAccount totalAccount, HttpServletRequest request, Integer accountId, HttpServletResponse response) {
		Account account = accountManager.get(accountId);
		User user = (User) SessionManager.getAttribute(request, "user");
		totalAccount.setAccount(account);
		totalAccount.setThisMoney(totalAccount.getAllMoney());
		totalAccount.setAddUser(user.getRealName());
		totalAccountManager.save(totalAccount);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void saveDayAccount(DayAccount dayAccount, HttpServletResponse response) {
		TotalAccount totalAccount = totalAccountManager.get(dayAccount.getTotalAccount().getId());
		double balance = 0;
		balance = totalAccount.getThisMoney() + (dayAccount.getDebtor() == null ? 0 : dayAccount.getDebtor()) - (dayAccount.getLender() == null ? 0 : dayAccount.getLender());
		totalAccount.setThisMoney(balance);
		totalAccountManager.update(totalAccount);
		dayAccount.setBalance(balance);
		dayAccountManager.save(dayAccount);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void removeDayAccoun(HttpServletResponse response, Integer dayAccountId) {
		DayAccount dayAccount = dayAccountManager.get(dayAccountId);
		TotalAccount totalAccount = dayAccount.getTotalAccount();
		double balance = totalAccount.getThisMoney() - dayAccount.getDebtor() + dayAccount.getLender();
		totalAccount.setThisMoney(balance);
		totalAccountManager.update(totalAccount);
		dayAccountManager.deleteObject(dayAccount);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void removeTotalAccount(HttpServletResponse response, Integer totalAccountId) {
		totalAccountManager.delete(totalAccountId);
		JsonUtils.writeJson(response);
	}
}
