package com.app.meibo.storeroom.provider.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.meibo.constant.ExpenditureEnum;
import com.app.meibo.finace.expenditure.model.Expenditure;
import com.app.meibo.finace.expenditure.service.ExpenditureManager;
import com.app.meibo.storeroom.inoutstore.model.InOutstore;
import com.app.meibo.storeroom.inoutstore.service.InOutstoreManager;
import com.app.meibo.storeroom.provider.model.Commodity;
import com.app.meibo.storeroom.provider.model.vo.CommodityVO;
import com.app.meibo.storeroom.provider.service.CommodityManager;
import com.app.meibo.worksheet.model.Worksheet;
import com.app.meibo.worksheet.service.WorksheetManager;
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
 * @createdate 2012-12-6 下午9:39:39
 */
@Controller
@GlobalAutowired
@RequestMapping("/meibo/storeroom/commodity/*.html")
public class CommodityController {
	private CommodityManager commodityManager;
	private InOutstoreManager inOutstoreManager;
	private WorksheetManager worksheetManager;
	private ExpenditureManager expenditureManager;

	@RequestMapping
	public void index(HttpServletRequest request, ModelMap model) {

	}

	@RequestMapping
	public void indexForSelect() {

	}

	@RequestMapping
	public void listContent(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		Page<Commodity> page = new Page<Commodity>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);// page前台数据绑定
		page.search(page, "Commodity", commodityManager);
		List<Commodity> commodities = page.getResult();
		List<CommodityVO> commodityVOs = new ArrayList<CommodityVO>();
		for (Commodity commodity : commodities) {
			CommodityVO vo = new CommodityVO();
			BeanUtilsEx.copyProperties(vo, commodity);
			if (commodity.getProvider() != null) {
				vo.setProviderName(commodity.getProvider().getCompanyName());
				vo.setProviderId(commodity.getProvider().getId());
			}
			if (commodity.getCommodityClassify() != null) {
				vo.setClassifyName(commodity.getCommodityClassify().getClassifyName());
				vo.setClassifyId(commodity.getCommodityClassify().getId());
			}
			commodityVOs.add(vo);
		}
		model.put("total", page.getTotalCount());
		model.put("rows", commodityVOs);
		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void listByProvider(HttpServletResponse response, ModelMap model, Integer providerId) {
		List<Commodity> commodities = commodityManager.list("from Commodity c where c.provider.id = ? and c.isDelete != 1", providerId);
		List<CommodityVO> commodityVOs = new ArrayList<CommodityVO>();
		BeanUtilsEx.copyDOListToVOList(CommodityVO.class, commodities, commodityVOs);
		model.put("rows", commodityVOs);
		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void addForm(@RequestParam(defaultValue = "0") int commodityId, ModelMap model) {
		Commodity commodity = null;
		if (commodityId == 0) {
			commodity = new Commodity();
		} else {
			commodity = commodityManager.get(commodityId);
		}
		model.addAttribute("commodity", commodity);
	}

	@RequestMapping
	public void saveCommodity(Commodity commodity, HttpServletResponse response, HttpServletRequest request) {
		User user = (User) SessionManager.getAttribute(request, "user");
		InOutstore inOutstore = new InOutstore();
		if (commodity.getId() != null && commodity.getId().intValue() != 0) {
			commodity = commodityManager.get(commodity.getId());
		}
		commodityManager.save(commodity);
		if (commodity.getId() != null && commodity.getId().intValue() != 0) {
			inOutstore.setPickinger(commodity.getPickinger());
			inOutstore.setOperation(0);
			inOutstore.setRecorder(user.getRealName());
			inOutstore.setCommodityId(commodity.getId());
			inOutstore.setName(commodity.getName());
			inOutstore.setCount(commodity.getCount());
			inOutstoreManager.save(inOutstore);
		}
		JsonUtils.writeJson(response, true);
	}

	@RequestMapping
	public void deleteCommodity(HttpServletResponse response, String ids) {
		String[] idStrings = ids.split(",");
		for (String str : idStrings) {
			Integer id = Integer.parseInt(str);
			commodityManager.delete(id);
		}
		JsonUtils.writeJson(response, true);
	}

	/**
	 * 加载货源
	 * 
	 * @param commodityId
	 * @param response
	 */
	@RequestMapping
	public void loadSalary(Integer commodityId, HttpServletResponse response) {
		Commodity commodity = commodityManager.get(commodityId);
		if (commodity != null) {
			JsonUtils.writeJson(response, commodity, true);
		}
	}

	@RequestMapping
	public void checkCommodity(String name, HttpServletResponse response) {
		Commodity commodity = commodityManager.getByCommodityName(name);
		if (commodity != null) {
			JsonUtils.writeJson(response, false);
		} else {
			JsonUtils.writeJson(response, true);
		}
	}

	@RequestMapping
	public void listContentForMaterial(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void listContentForMaterialProduct(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void listContentForAccessory(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		JsonUtils.writeJson(response, model);
	}

	@RequestMapping
	public void listContentForStockAccessory(HttpServletRequest request, HttpServletResponse response, ModelMap model) {

		JsonUtils.writeJson(response, model);
	}

	/**
	 * 入库页面跳转
	 * 
	 * @param commodityId
	 * @param model
	 */
	@RequestMapping
	public void inStore(int commodityId, ModelMap model) {
		InOutstore inOutstore = new InOutstore();
		Commodity commodity = commodityManager.get(commodityId);
		model.addAttribute("inOutstore", inOutstore);
		model.addAttribute("commodityId", commodityId);
		model.addAttribute("commodityName", commodity.getName());
	}

	/**
	 * 出库页面跳转
	 * 
	 * @param commodityId
	 * @param model
	 */
	@RequestMapping
	public void outStore(int commodityId, ModelMap model) {
		InOutstore inOutstore = new InOutstore();
		Commodity commodity = commodityManager.get(commodityId);
		model.addAttribute("inOutstore", inOutstore);
		model.addAttribute("commodityId", commodityId);
		model.addAttribute("commodityName", commodity.getName());
		model.addAttribute("commodityCount", commodity.getCount());
	}

	/**
	 * 保存材料出入库
	 * 
	 * @param inOutstore
	 * @param response
	 * @param request
	 */
	@RequestMapping
	public void saveOutStore(InOutstore inOutstore, HttpServletResponse response, HttpServletRequest request) {
		User user = (User) SessionManager.getAttribute(request, "user");
		if (inOutstore.getId() != null && inOutstore.getId().intValue() != 0) {
			inOutstore = inOutstoreManager.get(inOutstore.getId());
			SpringUtils.bind(inOutstore);
		}
		Commodity commodity = commodityManager.get(inOutstore.getCommodityId());
		if (inOutstore.getOperation() == 1) {
			if (worksheetManager.getByProductNo(inOutstore.getProductNo()) == null) {
				JsonUtils.writeJson(response, false);
				return;
			}
			commodity.setCount(commodity.getCount() - inOutstore.getCount());
		} else {
			if (inOutstore.getProductNo() != null && !inOutstore.getProductNo().equals("") && worksheetManager.getByProductNo(inOutstore.getProductNo()) == null) {
				JsonUtils.writeJson(response, false);
				return;
			}
			commodity.setCount(commodity.getCount() + inOutstore.getCount());
		}
		commodityManager.update(commodity);
		inOutstore.setPrice(commodity.getPrice());
		inOutstore.setRecorder(user.getRealName());
		inOutstoreManager.save(inOutstore);

		if (inOutstore.getProductNo() != null && !"".equals(inOutstore.getProductNo())) {// 加入收支统计
			Worksheet worksheet = worksheetManager.getByProductNo(inOutstore.getProductNo());
			Expenditure expenditure = expenditureManager.getByEntityId(worksheet.getId(), ExpenditureEnum.WORKSHEET.getType());
			if (expenditure == null) {
				expenditure = new Expenditure();
				expenditure.setEntityId(worksheet.getId());
				expenditure.setType(ExpenditureEnum.WORKSHEET.getType());
				expenditure.setInOrOut(0);
			}
			List<InOutstore> inOutstores = inOutstoreManager.listByProperty("productNo", inOutstore.getProductNo());
			double allCost = 0;
			for (InOutstore io : inOutstores) {
				if (io.getOperation() == 1) { // operation 1:出库 0:入库
					allCost += io.getPrice() * io.getCount();
				} else {
					allCost -= io.getPrice() * io.getCount();
				}
			}
			expenditure.setChangeDate(expenditure.getCreateDate());
			expenditure.setMoney(expenditure.getMoney() + allCost);
			expenditure.setRemark("<span style=\"color:red\">【加工】</span>" + inOutstore.getProductNo());
			expenditureManager.save(expenditure);
		}
		JsonUtils.writeJson(response, true);
	}

}
