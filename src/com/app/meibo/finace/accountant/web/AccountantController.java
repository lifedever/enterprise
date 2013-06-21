package com.app.meibo.finace.accountant.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.finace.accountant.model.Accountant;
import com.app.meibo.finace.accountant.model.vo.AccountantVO;
import com.app.meibo.finace.accountant.service.AccountantManager;
import com.app.meibo.finace.model.AccountType;
import com.app.meibo.finace.model.vo.AccountTypeVO;
import com.app.meibo.finace.service.AccountTypeManager;
import com.app.permission.model.Page;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;

/**
 * 会计科目
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-12-3 下午9:04:41
 */
@Controller
@RequestMapping("/finace/accountant/*.html")
@GlobalAutowired
public class AccountantController {
	private AccountTypeManager accountTypeManager;
	private AccountantManager accountantManager;

	@RequestMapping
	public void index() {

	}

	/**
	 * 科目类别列表
	 * 
	 * @param response
	 */
	@RequestMapping
	public void listAccountTypes(HttpServletResponse response, ModelMap modelMap) {
		List<AccountType> accountTypes = accountTypeManager.listAll();
		List<AccountTypeVO> accountTypeVOs = new ArrayList<AccountTypeVO>();
		BeanUtilsEx.copyDOListToVOList(AccountTypeVO.class, accountTypes, accountTypeVOs);
		modelMap.put("rows", accountTypeVOs);
		JsonUtils.writeJson(response, modelMap);
	}

	/**
	 * 科目列表
	 * 
	 * @param request
	 * @param response
	 * @param modelMap
	 * @param typeId
	 */
	@RequestMapping
	public void listAccountants(HttpServletRequest request, HttpServletResponse response, ModelMap modelMap, Integer typeId) {
		Page<Accountant> page = new Page<Accountant>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);
		accountantManager.search(page, typeId);
		List<Accountant> accountants = page.getResult();
		List<AccountantVO> accountantVOs = new ArrayList<AccountantVO>();
		for (Accountant accountant : accountants) {
			AccountantVO vo = new AccountantVO();
			BeanUtilsEx.copyProperties(vo, accountant);
			vo.setAccountTypeId(accountant.getAccountType().getId());
			vo.setAccountTypeName(accountant.getAccountType().getTypeName());
			accountantVOs.add(vo);
		}
		modelMap.put("total", page.getTotalCount());
		modelMap.put("rows", accountantVOs);
		JsonUtils.writeJson(response, modelMap);
	}

	/**
	 * 添加类别
	 * 
	 * @param response
	 * @param accountType
	 */
	@RequestMapping
	public void addType(HttpServletResponse response, AccountType accountType) {
		if (accountType.getId() == null)
			accountType.setCreateDate(new Date());
		accountTypeManager.save(accountType);
		JsonUtils.writeJson(response, true, true);
	}

	/**
	 * 删除类别
	 * 
	 * @param response
	 * @param typeId
	 */
	@RequestMapping
	public void deleteType(HttpServletResponse response, Integer typeId) {
		List<Accountant> accountants = accountantManager.listAccountantsByTypeId(typeId);
		if (accountants != null && accountants.size() > 0) {
			JsonUtils.writeJson(response, false);
		} else {
			accountTypeManager.delete(typeId);
			JsonUtils.writeJson(response, true);
		}
	}

	/**
	 * 添加科目
	 * 
	 * @param response
	 * @param accountant
	 * @param typeId
	 */
	@RequestMapping
	public void addAccount(HttpServletResponse response, Accountant accountant, Integer typeId) {
		if (accountant.getId() == null) {
			AccountType accountType = accountTypeManager.get(typeId);
			accountant.setAccountType(accountType);
		} else {
			accountant = accountantManager.get(accountant.getId());
			SpringUtils.bind(accountant);
		}
		accountantManager.save(accountant);
		JsonUtils.writeJson(response, true, true);
	}

	/**
	 * 删除科目
	 * 
	 * @param response
	 * @param typeId
	 */
	@RequestMapping
	public void deleteAccount(HttpServletResponse response, Integer id) {
		accountantManager.delete(id);
		JsonUtils.writeJson(response, true);
	}
}
