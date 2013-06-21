package com.app.meibo.finace.productioncost.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.constant.ExpenditureEnum;
import com.app.meibo.finace.expenditure.model.Expenditure;
import com.app.meibo.finace.expenditure.service.ExpenditureManager;
import com.app.meibo.finace.model.WorksheetCostItem;
import com.app.meibo.finace.model.WorksheetCostItemFooter;
import com.app.meibo.finace.model.vo.ProductionCostVO;
import com.app.meibo.finace.model.vo.WorksheetCostItemVO;
import com.app.meibo.finace.service.WorksheetCostItemManager;
import com.app.meibo.storeroom.inoutstore.model.InOutstore;
import com.app.meibo.storeroom.inoutstore.model.InOutstoreFooter;
import com.app.meibo.storeroom.inoutstore.model.vo.InOutstoreVO;
import com.app.meibo.storeroom.inoutstore.service.InOutstoreManager;
import com.app.meibo.storeroom.provider.model.Commodity;
import com.app.meibo.storeroom.provider.service.CommodityManager;
import com.app.meibo.worksheet.model.Worksheet;
import com.app.meibo.worksheet.service.WorksheetManager;
import com.app.permission.model.Page;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;

/**
 * 加工成本管理
 * 
 * @author MSQ
 * @email gefangshuai@163.com
 * @createdata 2013-3-3 下午1:38:48
 */
@Controller
@GlobalAutowired
@RequestMapping("/finace/productioncost/*.html")
public class ProductionCostColtroller {

	private WorksheetManager worksheetManager;
	private InOutstoreManager inOutstoreManager;
	private CommodityManager commodityManager;
	private WorksheetCostItemManager worksheetCostItemManager;
	private ExpenditureManager expenditureManager;

	/**
	 * 首页
	 * 
	 * @param request
	 * @param model
	 */
	@RequestMapping
	public void index(HttpServletRequest request, ModelMap model) {

	}

	@RequestMapping
	public void listContent(HttpServletResponse response, HttpServletRequest request, ModelMap model) {
		Page<Worksheet> page = new Page<Worksheet>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);
		page.search(page, "Worksheet", worksheetManager);
		List<ProductionCostVO> productionCostVOs = new ArrayList<ProductionCostVO>();
		for (Worksheet worksheet : page.getResult()) {
			ProductionCostVO vo = new ProductionCostVO();
			BeanUtilsEx.copyProperties(vo, worksheet);
			vo.setTotalCost(getSingleCost(worksheet.getProductNo()));
			productionCostVOs.add(vo);
		}
		model.put("total", page.getTotalCount());
		model.put("rows", productionCostVOs);
		JsonUtils.writeJson(response, model);
	}

	/**
	 * 获取加工单号下费用
	 * 
	 * @param productNo
	 * @return
	 */
	private double getSingleCost(String productNo) {
		// 计算用料详细
		List<InOutstore> inOutstores = inOutstoreManager.getByProductNo(productNo);
		double totalCost = 0;
		for (InOutstore io : inOutstores) {
			Commodity commodity = commodityManager.get(io.getCommodityId());
			if (io.getOperation() == 1) { // operation 1:出库 0:入库
				totalCost += commodity.getPrice() * io.getCount();
			} else {
				totalCost -= commodity.getPrice() * io.getCount();
			}
		}
		// 计算其他花费详细
		List<WorksheetCostItem> worksheetCostItems = worksheetCostItemManager.listByProperty("productNo", productNo);
		for (WorksheetCostItem costItem : worksheetCostItems) {
			totalCost += costItem.getCost();
		}
		return totalCost;
	}

	@RequestMapping
	public void detailIndex(HttpServletRequest request, String productNo, ModelMap model) {
		model.addAttribute("productNo", productNo);
	}

	@RequestMapping
	public void detailListContent(String productNo, HttpServletResponse response, HttpServletRequest request, ModelMap model) {
		List<InOutstore> inOutstores = inOutstoreManager.listByProperty("productNo", productNo);
		List<InOutstoreVO> inOutstoreVOs = new ArrayList<InOutstoreVO>();
		for (InOutstore inOutstore : inOutstores) {
			InOutstoreVO vo = new InOutstoreVO();
			BeanUtilsEx.copyProperties(vo, inOutstore);
			inOutstoreVOs.add(vo);
		}
		double totalCost = 0;
		for (InOutstore io : inOutstores) {
			if (io.getOperation() == 1) { // operation 1:出库 0:入库
				totalCost += io.getPrice() * io.getCount();
			} else {
				totalCost -= io.getPrice() * io.getCount();
			}
		}
		List<InOutstoreFooter> footers = new ArrayList<InOutstoreFooter>();
		footers.add(new InOutstoreFooter("合计", totalCost));

		model.put("footer", footers);
		model.put("rows", inOutstoreVOs);
		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void extraCostForm(String productNo, ModelMap model) {
		model.addAttribute("productNo", productNo);
	}

	/**
	 * 统计加工单额外支出
	 * 
	 * @param worksheetCostItem
	 * @param response
	 */
	@RequestMapping
	public void saveItemCost(WorksheetCostItem worksheetCostItem, HttpServletResponse response) {
		worksheetCostItemManager.save(worksheetCostItem);
		// 加入收支统计
		Worksheet worksheet = worksheetManager.getByProductNo(worksheetCostItem.getProductNo());
		Expenditure expenditure = expenditureManager.getByEntityId(worksheet.getId(), ExpenditureEnum.WORKSHEET.getType());
		if (expenditure == null) {
			expenditure = new Expenditure();
			expenditure.setEntityId(worksheet.getId());
			expenditure.setType(ExpenditureEnum.WORKSHEET.getType());
			expenditure.setInOrOut(0);
		}
		List<WorksheetCostItem> worksheetCostItems = worksheetCostItemManager.listByProperty("productNo", worksheetCostItem.getProductNo());
		double allCost = 0;
		for (WorksheetCostItem cost : worksheetCostItems) {
			allCost += cost.getCost();
		}
		expenditure.setChangeDate(expenditure.getCreateDate());
		expenditure.setMoney(expenditure.getMoney() + allCost);
		expenditure.setRemark("<span style=\"color:red\">【加工】</span>" + worksheetCostItem.getProductNo());
		expenditureManager.save(expenditure);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void extraCostListContent(String productNo, HttpServletResponse response, HttpServletRequest request, ModelMap model) {
		List<WorksheetCostItem> worksheetCostItems = worksheetCostItemManager.list("from WorksheetCostItem wc where wc.productNo = ?", productNo);
		List<WorksheetCostItemVO> worksheetCostItemVOs = new ArrayList<WorksheetCostItemVO>();
		double allCost = 0;
		for (WorksheetCostItem costItem : worksheetCostItems) {
			WorksheetCostItemVO vo = new WorksheetCostItemVO();
			BeanUtilsEx.copyProperties(vo, costItem);
			allCost += costItem.getCost();
			worksheetCostItemVOs.add(vo);
		}
		List<WorksheetCostItemFooter> footers = new ArrayList<WorksheetCostItemFooter>();
		footers.add(new WorksheetCostItemFooter(allCost, "合计"));
		model.put("rows", worksheetCostItemVOs);
		model.put("footer", footers);
		JsonUtils.writeJson(response, model);
	}
}
