package com.app.meibo.finace.auditbuyrequest.web;

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
import org.springframework.web.bind.annotation.RequestParam;

import com.app.meibo.constant.ExpenditureEnum;
import com.app.meibo.finace.account.model.Account;
import com.app.meibo.finace.account.service.AccountManager;
import com.app.meibo.finace.expenditure.model.Expenditure;
import com.app.meibo.finace.expenditure.service.ExpenditureManager;
import com.app.meibo.storeroom.buyrequest.model.BuyRequest;
import com.app.meibo.storeroom.buyrequest.model.BuyRequestItem;
import com.app.meibo.storeroom.buyrequest.model.vo.BuyRequestVO;
import com.app.meibo.storeroom.buyrequest.service.BuyRequestItemManager;
import com.app.meibo.storeroom.buyrequest.service.BuyRequestManager;
import com.app.permission.model.Page;
import com.app.permission.model.User;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;
import com.sqds.util.ParamUtils;
import com.sqds.util.SessionManager;

/**
 * 
 * @author MSQ
 * @email gefangshuai@163.com
 * @createdata 2013-3-4 下午9:39:54
 */
@Controller
@GlobalAutowired
@RequestMapping("/finace/auditbuyrequest/*.html")
public class AuditBuyRequestController {

	private BuyRequestManager buyRequestManager;
	
	private BuyRequestItemManager buyRequestItemManager;
	
	private ExpenditureManager expenditureManager;
	
	private AccountManager accountManager;
	
	/**
	 * 页面跳转
	 * @param request
	 * @param model
	 */
	@RequestMapping
	public void index(HttpServletRequest request, ModelMap model){
		
	}
	
	/**
	 * 列表加载数据
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping
	public void listContent(HttpServletRequest request, HttpServletResponse response, ModelMap model){
		Page<BuyRequest> page = new Page<BuyRequest>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);// page前台数据绑定
		page.search(page, "BuyRequest", buyRequestManager);
		List<BuyRequest> buyRequests = page.getResult();
		List<BuyRequestVO> buyRequestVOs = new ArrayList<BuyRequestVO>();
		for(BuyRequest buyRequest : buyRequests){
			BuyRequestVO vo = new BuyRequestVO();
			BeanUtilsEx.copyProperties(vo, buyRequest);
			buyRequestVOs.add(vo);
		}
		model.put("total", page.getTotalCount());
		model.put("rows", buyRequestVOs);
		JsonUtils.writeJson(response, model);
	}
	
	/**
	 * 添加页面跳转
	 * @param buyRequestId
	 * @param model
	 */
	@RequestMapping
	public void addForm(@RequestParam(defaultValue = "0") int buyRequestId, ModelMap model, HttpServletRequest request){
		SessionManager.removeAttribute(request, "buyRequestItems");
		BuyRequest buyRequest = null;
		if (buyRequestId == 0) {
			buyRequest = new BuyRequest();
		} else {
			buyRequest = buyRequestManager.get(buyRequestId);
		}
		model.addAttribute("buyRequest", buyRequest);
	}
	
	/**
	 * 修改页面跳转
	 * @param buyRequestId
	 * @param model
	 */
	@RequestMapping
	public void editForm(int buyRequestId, ModelMap model, HttpServletRequest request){
		BuyRequest buyRequest = null;
		buyRequest = buyRequestManager.get(buyRequestId);
		model.addAttribute("buyRequest", buyRequest);
	}
	
	/**
	 * 保存
	 * @param buyRequest
	 * @param response
	 * @param request
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping
	public void saveForm(BuyRequest buyRequest, HttpServletResponse response, HttpServletRequest request){
		if(buyRequest.getId() != null && buyRequest.getId().intValue() != 0){
			buyRequest = buyRequestManager.get(buyRequest.getId());
			SpringUtils.bind(buyRequest);
		}else {
			User user = (User) SessionManager.getAttribute(request, "user");
			buyRequest.setRequester(user.getRealName());
			buyRequest.setBuyRequestNo(buyRequestManager.generateBuyRequestNo());
		}
		List<BuyRequestItem> buyRequestItems = (List<BuyRequestItem>) SessionManager.getAttribute(request, "buyRequestItems");
		if (buyRequestItems != null) {
			for (BuyRequestItem item : buyRequestItems) {
				item.setBuyRequestNo(buyRequest.getBuyRequestNo());
				buyRequestItemManager.save(item);
			}
		}
		buyRequestManager.save(buyRequest);
		JsonUtils.writeJson(response, true);
	}
	
	/**
	 * 删除
	 * @param response
	 * @param ids
	 */
	@RequestMapping
	public void deleteBuyRequest(HttpServletResponse response, String ids){
		String[] idStrings = ids.split(",");
		for (String str : idStrings) {
			Integer id = Integer.parseInt(str);
			buyRequestManager.delete(id);
		}
		JsonUtils.writeJson(response, true);
	}
	
	/**
	 * 查看请购单条目页面跳转
	 * @param request
	 * @param buyRequestNo
	 * @param model
	 */
	@RequestMapping
	public void detailIndex(HttpServletRequest request, String buyRequestNo, ModelMap model){
		BuyRequest buyRequest = new BuyRequest();
		buyRequest = buyRequestManager.getByBuyRequestNo(buyRequestNo);
		model.addAttribute("buyrequest", buyRequest);
	}
	
	/**
	 * 条目列表
	 * @param response
	 * @param request
	 * @param model
	 */
	@RequestMapping
	public void viewListContent(HttpServletResponse response, HttpServletRequest request, ModelMap model){
		
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
	
	/**
	 * 审批跳转页面
	 * @param request
	 * @param model
	 */
	@RequestMapping
	public void auditForm(Integer buyRequestId, HttpServletRequest request, ModelMap model){
		model.addAttribute("buyRequestId", buyRequestId);
	}
	
	/**
	 * 保存审批信息
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping
	public void saveAuditForm(HttpServletRequest request, HttpServletResponse response, ModelMap model){
		Integer buyRequestId = ParamUtils.getInteger("buyRequestId", 0);
		double totalPrice = ParamUtils.getDouble("totalPrice", 0);
		Integer accountId = ParamUtils.getInteger("accountIdNo", 0);
		BuyRequest buyRequest = null;
		if(buyRequestId != 0){
			buyRequest = buyRequestManager.get(buyRequestId);
			buyRequest.setTotalPrice(buyRequest.getTotalPrice() + totalPrice);
			buyRequestManager.save(buyRequest);
		}
		
		// 加入收支统计
		Expenditure expenditure = expenditureManager.getByEntityId(buyRequest.getId(), ExpenditureEnum.BUYREQUEST.getType());
		if (expenditure == null) {
			expenditure = new Expenditure();
			expenditure.setEntityId(buyRequest.getId());
			expenditure.setType(ExpenditureEnum.BUYREQUEST.getType());
			expenditure.setInOrOut(0);
		}
		Account account = accountManager.get(accountId);
		expenditure.setChangeDate(expenditure.getCreateDate());
		expenditure.setAccountId(account.getId());
		expenditure.setMoney(expenditure.getMoney() + totalPrice);
		expenditure.setRemark("<span style=\"color:red\">【请购单】</span>" + buyRequest.getBuyRequestNo());
		expenditureManager.save(expenditure);
		
		JsonUtils.writeJson(response, true);
	}
}
