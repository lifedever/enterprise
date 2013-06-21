package com.app.meibo.offer.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.contract.model.Contract;
import com.app.meibo.contract.service.ContractManager;
import com.app.meibo.customer.model.Customer;
import com.app.meibo.customer.service.CustomerManager;
import com.app.meibo.offer.model.MaterialDetail;
import com.app.meibo.offer.model.Offer;
import com.app.meibo.offer.model.OfferItem;
import com.app.meibo.offer.model.OfferMoney;
import com.app.meibo.offer.model.vo.OfferVO;
import com.app.meibo.offer.service.MaterialDetailManager;
import com.app.meibo.offer.service.OfferItemManager;
import com.app.meibo.offer.service.OfferManager;
import com.app.meibo.offer.service.OfferMoneyManager;
import com.app.meibo.order.model.Order;
import com.app.meibo.order.service.OrderManager;
import com.app.permission.model.Page;
import com.app.permission.model.User;
import com.app.permission.service.UserManager;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;
import com.sqds.util.SessionManager;

/**
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdata 2013-2-8 下午2:08:02
 */
@Controller
@GlobalAutowired
@RequestMapping("/meibo/offer")
public class OfferController {
	private CustomerManager customerManager;
	private OfferManager offerManager;
	private OfferItemManager offerItemManager;
	private OfferMoneyManager offerMoneyManager;
	private OrderManager orderManager;
	private ContractManager contractManager;
	private UserManager userManager;
	private MaterialDetailManager materialDetailManager;

	@RequestMapping("index.html")
	public void index() {

	}

	/**
	 * 业务员查看审批
	 * 
	 * @param customerId
	 * @param model
	 */
	@RequestMapping("showAuditOffer.html")
	public void showAuditOffer(Integer offerId, ModelMap model, HttpServletRequest request) {
		Offer offer = offerManager.get(offerId);
		model.addAttribute("offer", offer);
	}

	@RequestMapping("list.html")
	public void list(Integer customerId, ModelMap model) {
		Customer customer = customerManager.get(customerId);
		model.addAttribute("customer", customer);
	}

	@RequestMapping("listContent.html")
	public void listContent(ModelMap model, HttpServletRequest request, HttpServletResponse response) {
		Page<Offer> page = new Page<Offer>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);
		page.search(page, "Offer", offerManager);
		List<OfferVO> offerVOs = new ArrayList<OfferVO>();
		for (Offer offer : page.getResult()) {
			OfferVO vo = new OfferVO();
			BeanUtilsEx.copyProperties(vo, offer);
			List<OfferItem> items = offerItemManager.listByOfferId(offer.getId());
			if (items != null) {
				vo.setItemCount(items.size());
			}
			boolean flag1 = true;
			for (OfferItem item : items) {
				OfferMoney offerMoney = offerMoneyManager.getLast(item.getId());
				if (offerMoney != null) {
					vo.setMoneyState(1);
				}
				if (offerMoney == null || offerMoney.getAskState() != 1) {
					flag1 = flag1 & false;
				}
			}
			if (flag1) {
				vo.setOfferState(1);
			} else {
				vo.setOfferState(0);
			}
			Order order = orderManager.getByOrderNo(offer.getOrderNo());
			if (order != null) {
				vo.setSignState(order.getSignState());
				if (order.getSignState() == 1 && order.getIsProof() == 0) {
					Contract contract = contractManager.getByOrderId(order.getId());
					if (contract != null) {
						vo.setContractNo(contract.getContractNo());
					}
				}
			}
			vo.setUsername(userManager.get(offer.getUserId()).getRealName());
			vo.setCustomerId(offer.getCustomer().getId());
			vo.setCustomerName(offer.getCustomer().getCustomerName());
			offerVOs.add(vo);
		}

		model.put("total", page.getTotalCount());
		model.put("rows", offerVOs);
		JsonUtils.writeJson(response, model);
	}

	@RequestMapping("askOffer.html")
	public void askOffer(Integer customerId, ModelMap model, HttpServletRequest request) {
		SessionManager.removeAttribute(request, "offerItems");
		SessionManager.removeAttribute(request, "details");
		Customer customer = customerManager.get(customerId);
		model.addAttribute("customer", customer);
	}

	@SuppressWarnings("unchecked")
	@RequestMapping("saveOffer.html")
	public void saveOffer(Integer customerId, Offer offer, HttpServletRequest request, HttpServletResponse response) {
		Customer customer = customerManager.get(customerId);
		offer.setCustomer(customer);
		List<OfferItem> offerItems = (List<OfferItem>) SessionManager.getAttribute(request, "offerItems");
		List<MaterialDetail> mds = (List<MaterialDetail>) SessionManager.getAttribute(request, "details");
		User user = (User) SessionManager.getAttribute(request, "user");
		offer.setUserId(user.getId());
		offer.setDepartmentId(user.getDepartment().getId());
		offerManager.save(offer);
		if (offerItems != null) {
			for (OfferItem item : offerItems) {
				Integer itemId = item.getId();
				item.setOffer(offer);
				item.setId(null);
				offerItemManager.save(item);
				List<MaterialDetail> rls = getDetailById(mds ,itemId);
				for(MaterialDetail md : rls){
					md.setItemId(item.getId());
					materialDetailManager.save(md);
				}
			}
		}
		JsonUtils.writeJson(response);
	}

	/**
	 * 生成订单
	 */
	@RequestMapping("generateOrder.html")
	public void generateOrder(ModelMap model, Integer offerId, Integer customerId, HttpServletRequest request) {
		Offer offer = offerManager.get(offerId);
		SessionManager.removeAttribute(request, "orderItems");
		model.addAttribute("offer", offer);
		model.addAttribute("customerId", customerId);
	}

	/**
	 * 删除报价
	 */
	@RequestMapping("delOffer.html")
	public void delOffer(Integer offerId, HttpServletResponse response) {
		List<OfferItem> offerItems = offerItemManager.listByOfferId(offerId);
		for (OfferItem item : offerItems) {
			List<OfferMoney> offerMoneys = offerMoneyManager.listByProperty("offerItem", item);
			offerMoneyManager.removeObjects(offerMoneys);
		}
		offerItemManager.removeObjects(offerItems);
		offerManager.delete(offerId);
		JsonUtils.writeJson(response);
	}
	
	private List<MaterialDetail> getDetailById(List<MaterialDetail> mds, Integer itemId){
		List<MaterialDetail> rls = new ArrayList<MaterialDetail>();
		for(MaterialDetail md : mds){
			if(md.getItemId().intValue() == itemId.intValue()){
				rls.add(md);
			}
		}
		return rls;
		
	}
}
