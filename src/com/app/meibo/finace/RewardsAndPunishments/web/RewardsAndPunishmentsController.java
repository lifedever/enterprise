package com.app.meibo.finace.RewardsAndPunishments.web;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.meibo.finace.RewardsAndPunishments.model.RewardsAndPunishments;
import com.app.meibo.finace.RewardsAndPunishments.service.RewardsAndPunishmentsManager;
import com.app.permission.model.Page;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;

/**
 * 奖惩
 * @author MSQ
 * @email gefangshuai@163.com
 * @createdata 2013-3-22 下午10:47:29
 */
@Controller
@RequestMapping("/finace/rp/*.html")
public class RewardsAndPunishmentsController {
	
	@Autowired
	private RewardsAndPunishmentsManager rewardsAndPunishmentsManager;
	
	@RequestMapping
	public void index(){
		
	}
	/**
	 * 列表数据加载
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping
	public void listContent(HttpServletRequest request, HttpServletResponse response, ModelMap model){
		Page<RewardsAndPunishments> page = new Page<RewardsAndPunishments>();
		page.setQueryDatas(request, page);
		SpringUtils.bind(page);
		page.search(page, "RewardsAndPunishments", rewardsAndPunishmentsManager);
		List<RewardsAndPunishments> rps = page.getResult();
		
		model.put("total", page.getTotalCount());
		model.put("rows", rps);
		JsonUtils.writeJson(response, model);
	}
	
	/**
	 * 添加页面跳转
	 * @param rpId
	 * @param request
	 * @param model
	 */
	@RequestMapping
	public void addForm(@RequestParam(defaultValue = "0") int rpId, HttpServletRequest request, ModelMap model){
		RewardsAndPunishments rp = null;
		if(rpId == 0){
			rp = new RewardsAndPunishments();
		}else {
			rp = rewardsAndPunishmentsManager.get(rpId);
		}
		model.addAttribute("rp", rp);
	}
	
	/**
	 * 保存
	 * @param rp
	 * @param request
	 * @param response
	 * @param model
	 */
	@RequestMapping
	public void saveForm(RewardsAndPunishments rp, HttpServletRequest request, HttpServletResponse response, ModelMap model){
		if(rp.getId() != null && rp.getId() != 0){
			rp = rewardsAndPunishmentsManager.get(rp.getId());
			SpringUtils.bind(rp);
		}
		rewardsAndPunishmentsManager.save(rp);
		JsonUtils.writeJson(response, true);
	}
	
	/**
	 * 删除
	 * @param response
	 * @param ids
	 */
	@RequestMapping
	public void delete(HttpServletResponse response, String ids){
		String[] idStrings = ids.split(",");
		for (String str : idStrings) {
			Integer id = Integer.parseInt(str);
			rewardsAndPunishmentsManager.delete(id);
		}
		JsonUtils.writeJson(response, true);
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
}
