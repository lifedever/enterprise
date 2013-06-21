package com.app.meibo.finace.auditbuyrequestitem.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.meibo.storeroom.buyrequest.model.BuyRequestItem;
import com.app.meibo.storeroom.buyrequest.model.vo.BuyRequestItemVO;
import com.app.meibo.storeroom.buyrequest.service.BuyRequestItemManager;
import com.app.permission.model.Page;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;
import com.sqds.util.SessionManager;

/**
 * 
 * @author MSQ
 * @email gefangshuai@163.com
 * @createdata 2013-3-4 下午10:59:27
 */
@Controller
@GlobalAutowired
@RequestMapping("/finace/auditbuyrequestitem/*.html")
public class AuditBuyRequestItemController {
	
	private BuyRequestItemManager buyRequestItemManager;
	
	/**
	 * 跳转列表
	 * @param request
	 * @param model
	 */
	@RequestMapping
	public void index(HttpServletRequest request, ModelMap model){
		
	}
	
	@RequestMapping
	public void listContent(HttpServletResponse response, HttpServletRequest request, ModelMap model){
		Page<BuyRequestItem> page = new Page<BuyRequestItem>();
		page.setQueryDatas(request, page);//
		SpringUtils.bind(page);//
		page.search(page, "BuyRequestItem", buyRequestItemManager);
		List<BuyRequestItem> buyItems = page.getResult();
		List<BuyRequestItemVO> vos = new ArrayList<BuyRequestItemVO>();
		for(BuyRequestItem item : buyItems){
			BuyRequestItemVO vo = new BuyRequestItemVO();
			BeanUtilsEx.copyProperties(vo, item);
			vos.add(vo);
		}
		model.put("total", page.getTotalCount());
		model.put("rows", vos);
		JsonUtils.writeJson(response, model);
	}
	
	/**
	 * 新增请购条目跳转页面
	 * @param buyRequestItemId
	 * @param model
	 */
	@RequestMapping
	public void addItemForm(@RequestParam(defaultValue = "0") int buyRequestItemId, ModelMap model){
		BuyRequestItem item = null;
		if (buyRequestItemId == 0) {
			item = new BuyRequestItem();
		} else {
			item = buyRequestItemManager.get(buyRequestItemId);
		}
		model.addAttribute("buyRequestItem", item);
	}
	
	
	/**
	 * 保存到 Session中
	 * @param buyRequestItem
	 * @param response
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping
	public void saveTempForm(BuyRequestItem buyRequestItem, HttpServletResponse response, HttpServletRequest request){
		List<BuyRequestItem> buyRequestItems = (List<BuyRequestItem>) SessionManager.getAttribute(request, "buyRequestItems");
		buyRequestItems = (buyRequestItems == null ? new ArrayList<BuyRequestItem>() : buyRequestItems);
		buyRequestItems.add(buyRequestItem);
		SessionManager.setAttribute(request, "buyRequestItems", buyRequestItems);
		JsonUtils.writeJson(response);
	}
	
	/**
	 * Session列表显示
	 * @param request
	 * @param response
	 * @param model
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping
	public void listTempContent(HttpServletRequest request, HttpServletResponse response, ModelMap model){
		List<BuyRequestItem> buyRequestItems = (List<BuyRequestItem>) SessionManager.getAttribute(request, "buyRequestItems");
		buyRequestItems = (buyRequestItems == null ? new ArrayList<BuyRequestItem>() : buyRequestItems);
		model.put("total", buyRequestItems.size());
		model.put("rows", buyRequestItems);
		JsonUtils.writeJson(response, model);
	}
	
	
	/**
	 * 删除
	 * @param response
	 * @param ids
	 */
	@RequestMapping
	public void deleteBuyRequestItem(HttpServletResponse response, String ids){
		String[] idStrings = ids.split(",");
		for (String str : idStrings) {
			Integer id = Integer.parseInt(str);
			buyRequestItemManager.delete(id);
		}
		JsonUtils.writeJson(response, true);
	}
}
