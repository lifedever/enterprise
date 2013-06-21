package com.app.meibo.storeroom.inoutstore.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.storeroom.inoutstore.model.ProductInOutstore;
import com.app.meibo.storeroom.inoutstore.model.vo.ProductInOutstoreVO;
import com.app.meibo.storeroom.inoutstore.service.ProductInOutstoreManager;
import com.app.permission.model.Page;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;

/**
 * 
 * @author MSQ
 * @email gefangshuai@163.com
 * @createdata 2013-2-25 下午10:36:33
 */
@Controller
@GlobalAutowired
@RequestMapping("/meibo/storeroom/productinoutstore/*.html")
public class ProductInOutstoreController {
	private ProductInOutstoreManager productInOutstoreManager;
	
	@RequestMapping
	public void index(HttpServletRequest request, ModelMap model){
		
	}
	
	@RequestMapping
	public void listContent(HttpServletRequest request, HttpServletResponse response, ModelMap model){
		Page<ProductInOutstore> page = new Page<ProductInOutstore>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);// page前台数据绑定
		page.search(page, "ProductInOutstore", productInOutstoreManager);
		List<ProductInOutstore> productInOutstores = page.getResult();
		List<ProductInOutstoreVO> productInOutstoreVOs = new ArrayList<ProductInOutstoreVO>();
		for(ProductInOutstore productInOutstore : productInOutstores){
			ProductInOutstoreVO vo = new ProductInOutstoreVO();
			BeanUtilsEx.copyProperties(vo, productInOutstore);
			productInOutstoreVOs.add(vo);
		}
		model.put("total", page.getTotalCount());
		model.put("rows", productInOutstoreVOs);
		JsonUtils.writeJson(response, model);
	}
}
