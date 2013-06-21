package com.app.meibo.offer.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.offer.model.Offer;
import com.app.meibo.offer.model.OfferItem;
import com.app.meibo.offer.model.OfferMoney;
import com.app.meibo.offer.model.vo.OfferMoneyVO;
import com.app.meibo.offer.service.OfferItemManager;
import com.app.meibo.offer.service.OfferManager;
import com.app.meibo.offer.service.OfferMoneyManager;
import com.app.permission.model.Page;
import com.app.permission.model.User;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;
import com.sqds.util.SessionManager;

/**
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-10 下午11:52:58
 */
@Controller
@RequestMapping("meibo/offer/offerMoney/*.html")
@GlobalAutowired
public class OfferMoneyController {
	private OfferMoneyManager offerMoneyManager;
	private OfferItemManager offerItemManager;
	private OfferManager offerManager;

	@RequestMapping
	public void listContent(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Page<OfferMoney> page = new Page<OfferMoney>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);
		page.search(page, "OfferMoney", offerMoneyManager);
		List<OfferMoneyVO> offerMoneyVOs = new ArrayList<OfferMoneyVO>();
		for (OfferMoney offerMoney : page.getResult()) {
			OfferMoneyVO vo = new OfferMoneyVO();
			BeanUtilsEx.copyProperties(vo, offerMoney);
			offerMoneyVOs.add(vo);
		}

		model.put("total", page.getTotalCount());
		model.put("rows", offerMoneyVOs);
		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void offerItemAudit(Integer itemId, ModelMap model) {
		OfferItem item = offerItemManager.get(itemId);
		model.addAttribute("item", item);
	}

	@RequestMapping
	public void showAuditOffer(Integer offerItemId, ModelMap model) {
		OfferItem offerItem = offerItemManager.get(offerItemId);
		model.addAttribute("item", offerItem);
	}

	@RequestMapping
	public void auditForm(Integer itemId, ModelMap model) {
		OfferItem item = offerItemManager.get(itemId);
		model.addAttribute("item", item);
	}

	@RequestMapping
	public void askForm(Integer offerMoneyId, ModelMap model) {
		OfferMoney money = offerMoneyManager.get(offerMoneyId);
		model.addAttribute("offerMoney", money);
	}

	@RequestMapping
	public void saveAudit(Integer itemId, OfferMoney offerMoney, HttpServletRequest request, HttpServletResponse response) {
		OfferItem item = offerItemManager.get(itemId);
		User user = (User) SessionManager.getAttribute(request, "user");
		offerMoney.setAuditUser(user.getRealName());
		offerMoney.setOfferItem(item);
		Offer offer = item.getOffer();
		offer.setOfferUser(user.getRealName());
		offerManager.update(offer);
		offerMoneyManager.save(offerMoney);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void saveAskAudit(OfferMoney offerMoney, HttpServletResponse response) {
		offerMoney = offerMoneyManager.get(offerMoney.getId());
		SpringUtils.bind(offerMoney);
		offerMoneyManager.save(offerMoney);
		JsonUtils.writeJson(response, true);
	}
}
