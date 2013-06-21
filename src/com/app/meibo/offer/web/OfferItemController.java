package com.app.meibo.offer.web;

import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.constant.FilePathEnum;
import com.app.meibo.offer.model.OfferItem;
import com.app.meibo.offer.model.OfferMoney;
import com.app.meibo.offer.model.vo.OfferItemVO;
import com.app.meibo.offer.service.OfferItemManager;
import com.app.meibo.offer.service.OfferMoneyManager;
import com.app.permission.model.Page;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.FileUtils;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;
import com.sqds.util.SessionManager;

/**
 * 管理询价条目
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-8 下午8:00:14
 */
@Controller
@RequestMapping("/meibo/offer/offerItem/*.html")
@GlobalAutowired
public class OfferItemController {
	private OfferItemManager offerItemManager;
	private OfferMoneyManager offerMoneyManager;

	@RequestMapping
	public void listContent(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Page<OfferItem> page = new Page<OfferItem>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);
		page.search(page, "OfferItem", offerItemManager);
		List<OfferItemVO> offerItemVOs = new ArrayList<OfferItemVO>();
		for (OfferItem offerItem : page.getResult()) {
			OfferItemVO vo = new OfferItemVO();
			BeanUtilsEx.copyProperties(vo, offerItem);

			List<OfferMoney> offerMoneys = offerMoneyManager.listByItemId(offerItem.getId());
			OfferMoney offerMoney = offerMoneyManager.getLast(offerItem.getId());
			if (offerMoney != null) {
				vo.setProductPrice(offerMoney.getPrice());
			}
			if (offerMoneys != null) {
				vo.setOfferCount(offerMoneys.size());
			}
			offerItemVOs.add(vo);
		}

		model.put("total", page.getTotalCount());
		model.put("rows", offerItemVOs);
		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void list(Integer offerId, ModelMap model) {
		model.addAttribute("offerId", offerId);
	}

	@RequestMapping
	public void showList(Integer offerId, ModelMap model){
		model.addAttribute("offerId", offerId);
	}
	@RequestMapping
	public void addItemForm() {

	}

	/**
	 * 保存到session
	 * 
	 * @throws IOException
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping
	public void saveTempOfferItem(OfferItem offerItem, HttpServletResponse response, HttpServletRequest request) throws IOException {
		String projectImage = FileUtils.upload(request, "file1", FilePathEnum.PROJECTIMAGE.getPath());
		String effectImage = FileUtils.upload(request, "file2", FilePathEnum.EFFECTIMAGE.getPath());
		offerItem.setProjectImage(projectImage);
		offerItem.setEffectImage(effectImage);
		
		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("hhmmss");
		String idStr = sdf.format(date);
		
		offerItem.setId(Integer.parseInt(idStr));
		
		
		List<OfferItem> offerItems = (List<OfferItem>) SessionManager.getAttribute(request, "offerItems");
		offerItems = (offerItems == null ? new ArrayList<OfferItem>() : offerItems);
		offerItems.add(offerItem);
		SessionManager.setAttribute(request, "offerItems", offerItems);
		JsonUtils.writeJson(response);
	}

	/**
	 * 从session中显示列表
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping
	public void listTempContent(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		List<OfferItem> offerItems = (List<OfferItem>) SessionManager.getAttribute(request, "offerItems");
		offerItems = (offerItems == null ? new ArrayList<OfferItem>() : offerItems);
		model.put("total", offerItems.size());
		model.put("rows", offerItems);
		JsonUtils.writeJson(response, model);
	}
}
