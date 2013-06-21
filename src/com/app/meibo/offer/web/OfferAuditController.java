package com.app.meibo.offer.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.offer.model.Offer;
import com.app.meibo.offer.service.OfferManager;
import com.sqds.spring.annotation.GlobalAutowired;

/**
 * 审批模块
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-8 下午2:08:02
 */
@Controller
@GlobalAutowired
@RequestMapping("/meibo/offer/audit")
public class OfferAuditController {
	private OfferManager offerManager;

	@RequestMapping("audit.html")
	public void audit() {

	}

	/**
	 * 业务经理审批报价
	 */
	@RequestMapping("managerAuditOffer.html")
	public void managerAuditOffer(Integer offerId, ModelMap model, HttpServletRequest request) {
		Offer offer = offerManager.get(offerId);
		model.addAttribute("offer", offer);
	}
}
