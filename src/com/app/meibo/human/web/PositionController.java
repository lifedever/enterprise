package com.app.meibo.human.web;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.meibo.human.model.Employee;
import com.app.meibo.human.model.Position;
import com.app.meibo.human.service.EmployeeManager;
import com.app.meibo.human.service.PositionManager;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;
import com.sqds.spring.annotation.GlobalAutowired;

/**
 * 职位管理
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-12-16 下午1:12:47
 */
@Controller
@RequestMapping("/human/position/*.html")
@GlobalAutowired
public class PositionController {
	private PositionManager positionManager;
	private EmployeeManager employeeManager;

	@RequestMapping
	public void index() {

	}

	@RequestMapping
	public void listContent(HttpServletResponse response, ModelMap modelMap) {
		List<Position> positions = positionManager.listPosition();
		modelMap.put("rows", positions);
		JsonUtils.writeJson(response, modelMap);
	}

	/**
	 * 添加
	 * 
	 * @param response
	 * @param position
	 */
	@RequestMapping
	public void savePosition(HttpServletResponse response, Position position) {
		if (position.getId() == null) {
			position.setCreateDate(new Date());
		} else {
			position = positionManager.get(position.getId());
			SpringUtils.bind(position);
		}
		positionManager.save(position);
		JsonUtils.writeJson(response);
	}

	/**
	 * 删除
	 */
	@RequestMapping
	public void deletePosition(HttpServletResponse response, Integer id) {
		List<Employee> employees = employeeManager.listByPosition(id);
		if (employees != null && employees.size() > 0) {
			JsonUtils.writeJson(response, false);
		} else {
			positionManager.delete(id);
			JsonUtils.writeJson(response, true);
		}
	}

	/**
	 * 向下拉列表中加载数据
	 * 
	 * @param response
	 */
	@RequestMapping
	public void loadCombobox(HttpServletResponse response) {
		List<Position> positions = positionManager.listPosition();
		JsonUtils.writeJson(response, positions);
	}
}
