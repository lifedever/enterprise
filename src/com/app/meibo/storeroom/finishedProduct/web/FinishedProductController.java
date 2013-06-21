package com.app.meibo.storeroom.finishedProduct.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.meibo.constant.FilePathEnum;
import com.app.meibo.operationalPart.cooperation.model.CooperationOrder;
import com.app.meibo.operationalPart.cooperation.service.CooperationOrderManager;
import com.app.meibo.order.service.OrderManager;
import com.app.meibo.storeroom.finishedProduct.model.FinishedProduct;
import com.app.meibo.storeroom.finishedProduct.model.vo.FinishedProductVO;
import com.app.meibo.storeroom.finishedProduct.service.FinishedProductManager;
import com.app.meibo.storeroom.inoutstore.model.ProductInOutstore;
import com.app.meibo.storeroom.inoutstore.service.ProductInOutstoreManager;
import com.app.meibo.worksheet.model.Worksheet;
import com.app.meibo.worksheet.service.WorksheetManager;
import com.app.permission.model.Page;
import com.app.permission.model.User;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.FileUtils;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;
import com.sqds.util.SessionManager;

@Controller
@RequestMapping("/meibo/storeroom/finishedproduct/*.html")
@GlobalAutowired
public class FinishedProductController {

	private FinishedProductManager finishedProductManager;
	private ProductInOutstoreManager productInOutstoreManager;
	private OrderManager orderManager;
	private WorksheetManager worksheetManager;
	private CooperationOrderManager cooperationOrderManager;

	/**
	 * 成品首页面
	 * 
	 * @param request
	 * @param model
	 */
	@RequestMapping
	public void index(HttpServletRequest request, ModelMap model) {

	}

	/**
	 * 成品首页面
	 * 
	 * @param request
	 * @param model
	 */
	@RequestMapping
	public void indexForOperationPart(HttpServletRequest request, ModelMap model) {

	}

	/**
	 * 成品首页面
	 * 
	 * @param request
	 * @param model
	 */
	@RequestMapping
	public void indexForInstore(HttpServletRequest request, ModelMap model,
			@RequestParam(defaultValue = "0") int workId,
			@RequestParam(defaultValue = "0") int coopId) {
		model.addAttribute("workId", workId);
		model.addAttribute("coopId", coopId);
	}

	/**
	 * 业务系统中成品首页面
	 * 
	 * @param request
	 * @param model
	 */
	@RequestMapping
	public void indexForBussiness(HttpServletRequest request, ModelMap model) {

	}

	/**
	 * 成品列表
	 * 
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping
	public void listContent(HttpServletRequest request,
			HttpServletResponse response, ModelMap model) {
		Page<FinishedProduct> page = new Page<FinishedProduct>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);// page前台数据绑定
		page.search(page, "FinishedProduct", finishedProductManager);
		List<FinishedProduct> finishedProducts = page.getResult();
		List<FinishedProductVO> finishedProductVOs = new ArrayList<FinishedProductVO>();
		for (FinishedProduct finishedProduct : finishedProducts) {
			FinishedProductVO finishedProductVO = new FinishedProductVO();
			BeanUtilsEx.copyProperties(finishedProductVO, finishedProduct);
			finishedProductVOs.add(finishedProductVO);
		}
		model.put("total", page.getTotalCount());
		model.put("rows", finishedProductVOs);
		JsonUtils.writeJson(response, model);
	}

	/**
	 * 跳转添加、编辑页面
	 * 
	 * @param finishedproductId
	 * @param model
	 */
	@RequestMapping
	public void addForm(
			@RequestParam(defaultValue = "0") int finishedproductId,
			ModelMap model) {
		FinishedProduct finishedPorduct = null;
		if (finishedproductId == 0) {
			finishedPorduct = new FinishedProduct();
		} else {
			finishedPorduct = finishedProductManager.get(finishedproductId);
		}
		model.addAttribute("finishedPorduct", finishedPorduct);
	}

	/**
	 * 入库跳转页面
	 * 
	 * @param productId
	 * @param workId
	 * @param coopId
	 * @param model
	 */
	@RequestMapping
	public void addInstoreForm(@RequestParam(defaultValue = "0") int productId,
			@RequestParam(defaultValue = "0") int workId,
			@RequestParam(defaultValue = "0") int coopId, ModelMap model) {
		model.addAttribute("productId", productId);
		model.addAttribute("workId", workId);
		model.addAttribute("coopId", coopId);
	}

	/**
	 * 保存确认选择
	 * @param productId
	 * @param workId
	 * @param coopId
	 * @param response
	 * @param count
	 */
	@RequestMapping
	public void saveInstoreRoom(
			@RequestParam(defaultValue = "0") int productId,
			@RequestParam(defaultValue = "0") int workId,
			@RequestParam(defaultValue = "0") int coopId,
			HttpServletResponse response, int count) {
		FinishedProduct finishedProduct = null;
		Worksheet worksheet = null;
		if (workId != 0) {
			worksheet = worksheetManager.get(workId);
			if (worksheet.getInstoreCount() < count) {
				JsonUtils.writeJson(response, false);
				return;
			}
			worksheet.setInstoreCount(worksheet.getInstoreCount() - count);
			worksheetManager.update(worksheet);
		}else {
			CooperationOrder coop = cooperationOrderManager.get(coopId);
			if(coop.getInstoreCount() < count){
				JsonUtils.writeJson(response, false);
				return;
			}
			coop.setInstoreCount(coop.getInstoreCount() - count);
			cooperationOrderManager.update(coop);
		}
		if (productId != 0) {
			finishedProduct = finishedProductManager.get(productId);
			finishedProduct.setProductCount(finishedProduct.getProductCount()
					+ count);
		}
		finishedProductManager.save(finishedProduct);
		JsonUtils.writeJson(response, true);
	}

	/**
	 * 保存
	 * 
	 * @param finishedProduct
	 * @param response
	 * @param request
	 * @throws IOException
	 */
	@RequestMapping
	public void saveFinishedProduct(FinishedProduct finishedProduct,
			HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		int flag = 0;
		if (finishedProduct.getId() != null) {
			flag = finishedProduct.getId().intValue();
		}
		User user = (User) SessionManager.getAttribute(request, "user");
		ProductInOutstore productInOutstore = new ProductInOutstore();
		String projectImage = FileUtils.upload(request, "file1",
				FilePathEnum.PROJECTIMAGE.getPath());
		String effectImage = FileUtils.upload(request, "file2",
				FilePathEnum.EFFECTIMAGE.getPath());
		finishedProduct.setProjectImage(projectImage);
		finishedProduct.setEffectImage(effectImage);
		if (finishedProduct.getId() != null
				&& finishedProduct.getId().intValue() != 0) {
			finishedProduct = finishedProductManager.get(finishedProduct
					.getId());
			if (!"".equals(projectImage)) {
				finishedProduct.setProjectImage(projectImage);
			}
			if (!"".equals(effectImage)) {
				finishedProduct.setEffectImage(effectImage);
			}

		}
		finishedProductManager.save(finishedProduct);
		if (flag == 0) {
			productInOutstore.setRecorder(user.getRealName());
			productInOutstore.setFinishedProductId(finishedProduct.getId());
			productInOutstore.setFinishedProductName(finishedProduct
					.getProductName());
			productInOutstore.setPickinger(finishedProduct.getProducer());
			productInOutstore.setRecorder(user.getRealName());
			productInOutstore.setCount(finishedProduct.getProductCount());
			productInOutstoreManager.save(productInOutstore);
		}
		JsonUtils.writeJson(response, true);
	}

	/**
	 * 删除
	 * 
	 * @param response
	 * @param ids
	 */
	@RequestMapping
	public void delFinishedProduct(HttpServletResponse response, String ids) {
		String[] idStrings = ids.split(",");
		for (String str : idStrings) {
			Integer id = Integer.parseInt(str);
			finishedProductManager.delete(id);
		}
		JsonUtils.writeJson(response, true);
	}

	/**
	 * 成品入库跳转
	 * 
	 * @param finishedproductId
	 * @param model
	 */
	@RequestMapping
	public void productInStore(int finishedproductId, ModelMap model) {
		ProductInOutstore productInOutstore = new ProductInOutstore();
		FinishedProduct finishedPorduct = finishedProductManager
				.get(finishedproductId);
		model.addAttribute("productInOutstore", productInOutstore);
		model.addAttribute("finishedproductId", finishedproductId);
		model.addAttribute("finishedproductName",
				finishedPorduct.getProductName());
		model.addAttribute("finishedproductCount",
				finishedPorduct.getProductCount());
	}

	/**
	 * 成品出库跳转
	 * 
	 * @param finishedproductId
	 * @param model
	 */
	@RequestMapping
	public void productOutStore(int finishedproductId, ModelMap model) {
		ProductInOutstore productInOutstore = new ProductInOutstore();
		FinishedProduct finishedPorduct = finishedProductManager
				.get(finishedproductId);
		model.addAttribute("productInOutstore", productInOutstore);
		model.addAttribute("finishedproductId", finishedproductId);
		model.addAttribute("finishedproductName",
				finishedPorduct.getProductName());
		model.addAttribute("finishedproductCount",
				finishedPorduct.getProductCount());
	}

	/**
	 * 保存成品出入库信息
	 * 
	 * @param productInOutstore
	 * @param response
	 * @param request
	 */
	@RequestMapping
	public void saveStore(ProductInOutstore productInOutstore,
			HttpServletResponse response, HttpServletRequest request) {
		User user = (User) SessionManager.getAttribute(request, "user");
		if (productInOutstore.getId() != null
				&& productInOutstore.getId().intValue() != 0) {
			productInOutstore = productInOutstoreManager.get(productInOutstore
					.getId());
			SpringUtils.bind(productInOutstore);
		}
		FinishedProduct finishedPorduct = finishedProductManager
				.get(productInOutstore.getFinishedProductId());
		if (productInOutstore.getOrderNo() != null) {
			//if (orderManager.getByOrderNo(productInOutstore.getOrderNo()) == null) {
//				JsonUtils.writeJson(response, false);
//				return;
			//}
			finishedPorduct.setProductCount(finishedPorduct.getProductCount()
					- productInOutstore.getCount());
			productInOutstore.setOperation(1);
		} else {
			finishedPorduct.setProductCount(finishedPorduct.getProductCount()
					+ productInOutstore.getCount());
		}
		finishedProductManager.update(finishedPorduct);
		productInOutstore.setRecorder(user.getRealName());
		productInOutstoreManager.save(productInOutstore);
		JsonUtils.writeJson(response, true);
	}

	/**
	 * 成品入库新增
	 * 
	 * @param response
	 * @param workIds
	 * @param coopIds
	 */
	@RequestMapping
	public void add(HttpServletResponse response,
			@RequestParam(defaultValue = "0") int workIds,
			@RequestParam(defaultValue = "0") int coopIds) {
		FinishedProduct finishedProduct = new FinishedProduct();
		if (workIds == 0) {
			CooperationOrder coop = cooperationOrderManager.get(coopIds);
			finishedProduct.setProductName(coop.getProductName());
			finishedProduct.setProducer(coop.getCooperationFactory());
			finishedProduct.setProductCount(coop.getInstoreCount());
			finishedProduct.setQualityRequire(coop.getRequired());
			finishedProduct.setEffectImage(coop.getImage());
			coop.setInstoreCount(0);
			cooperationOrderManager.update(coop);
		} else {
			Worksheet worksheet = worksheetManager.get(workIds);
			BeanUtilsEx.copyProperties(finishedProduct, worksheet);
			finishedProduct.setProductCount(worksheet.getInstoreCount());
			worksheet.setInstoreCount(0);
			worksheetManager.update(worksheet);
		}
		finishedProduct.setId(null);
		finishedProductManager.save(finishedProduct);
		JsonUtils.writeJson(response, true);
	}
}
