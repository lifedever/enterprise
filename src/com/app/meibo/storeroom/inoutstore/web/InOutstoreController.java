package com.app.meibo.storeroom.inoutstore.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.storeroom.inoutstore.model.InOutstore;
import com.app.meibo.storeroom.inoutstore.model.vo.InOutstoreVO;
import com.app.meibo.storeroom.inoutstore.service.InOutstoreManager;
import com.app.permission.model.Page;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;

/**
 * 
 * @author MSQ
 * @email gefangshuai@163.com
 * @createdata 2013-2-25 下午9:40:00
 */
@Controller
@GlobalAutowired
@RequestMapping("/meibo/storeroom/inoutstore/*.html")
public class InOutstoreController {
	
	private InOutstoreManager inOutstoreManager;
	
	@RequestMapping
	public void index(HttpServletRequest request, ModelMap model){
		
	}
	
	@RequestMapping
	public void listContent(HttpServletRequest request, HttpServletResponse response, ModelMap model){
		Page<InOutstore> page = new Page<InOutstore>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);// page前台数据绑定
		page.search(page, "InOutstore", inOutstoreManager);
		List<InOutstore> inOutstores = page.getResult();
		List<InOutstoreVO> inOutstoreVOs = new ArrayList<InOutstoreVO>();
		for(InOutstore inOutstore : inOutstores){
			InOutstoreVO vo = new InOutstoreVO();
			BeanUtilsEx.copyProperties(vo, inOutstore);
			inOutstoreVOs.add(vo);
		}
		model.put("total", page.getTotalCount());
		model.put("rows", inOutstoreVOs);
		JsonUtils.writeJson(response, model);
	}
	
	@RequestMapping
	public void detailIndex(HttpServletRequest request, String productNo, ModelMap model){
		List<InOutstore> inOutstores =  inOutstoreManager.getByProductNo(productNo);
		model.put("rows", inOutstores);
//		JsonUtils.writeJson(response, model);
	}
}
