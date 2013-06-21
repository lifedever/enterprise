package com.app.permission.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.app.permission.model.Function;
import com.app.permission.model.FunctionJson;
import com.app.permission.model.Role;
import com.app.permission.model.vo.FunctionJsonVO;
import com.app.permission.model.vo.FunctionVO;
import com.app.permission.service.FunctionManager;
import com.app.permission.service.RoleManager;
import com.app.permission.utils.BeanUtilsEx;
import com.app.permission.utils.web.JsonUtils;
import com.sqds.spring.SpringUtils;

/**
 * 功能管理
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createdate 2012-11-3 下午12:30:40
 */
@Controller
@RequestMapping("/function/*.html")
public class FunctionController {
	@Autowired
	private FunctionManager functionManager;
	@Autowired
	private RoleManager roleManager;

	@RequestMapping
	public void index() {

	}

	/**
	 * 获得所有顶级功能列表
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping
	public void listParentContent(HttpServletResponse response,
			ModelMap modelMap) {
		modelMap.clear();// 必须的，否则容易出异常
		List<Function> functions = functionManager.functionCategoryList();
		List<FunctionVO> functionVOs = new ArrayList<FunctionVO>();
		BeanUtilsEx
				.copyDOListToVOList(FunctionVO.class, functions, functionVOs);
		modelMap.put("rows", functionVOs);
		JsonUtils.writeJson(response, modelMap);
	}

	/**
	 * 根据获得某个功能下的所有连接表
	 * 
	 * @param funId
	 * @param modelMap
	 * @return
	 */
	@RequestMapping
	public void listContentByParent(HttpServletResponse response,
			Integer funId, ModelMap modelMap) {
		if (funId != null) {
			modelMap.clear();// 必须的，否则容易出异常
			List<Function> functions = functionManager.functionList(funId);
			List<FunctionVO> functionVOs = new ArrayList<FunctionVO>();
			BeanUtilsEx.copyDOListToVOList(FunctionVO.class, functions,
					functionVOs);
			modelMap.put("rows", functionVOs);
			JsonUtils.writeJson(response, modelMap);
		}
	}

	@RequestMapping
	public void addFunction(HttpServletResponse response, Integer funId,
			Function function, ModelMap model) {
		model.clear();
		if (function.getId() != null) {
			// 更新操作
			function = functionManager.get(function.getId());
		} else {
			function.setOrderIndex(functionManager.findMaxOrderIndex() + 1);
		}
		SpringUtils.bind(function);
		if (funId != null) {
			Function function2 = functionManager.get(funId);
			function.setParentFunction(function2);
		}
		functionManager.save(function);
		JsonUtils.writeJson(response);
	}

	@RequestMapping
	public void deleteFunction(HttpServletResponse response, Function function,
			ModelMap model) {
		model.clear();
		function = functionManager.get(function.getId());
		if (function.getFunctions() != null
				&& function.getFunctions().size() > 0) {
			model.addAttribute("success", false);
			model.addAttribute("message", "功能下已有连接表，无法删除！");
		} else if (function.getRoles() != null
				&& function.getRoles().size() > 0) {
			model.addAttribute("message", "功能下已配置角色信息，无法删除！");
			model.addAttribute("success", false);
		} else {
			functionManager.delete(function.getId());
			model.addAttribute("success", true);
		}
		JsonUtils.writeJson(response, model);
	}

	/**
	 * 升序排序
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping
	public void sortUpParentContent(HttpServletResponse response,
			Function function, ModelMap modelMap) {
		modelMap.clear();// 必须的，否则容易出异常
		function = functionManager.get(function.getId());
		List<Function> functions = null;
		List<FunctionVO> functionVOs = new ArrayList<FunctionVO>();
		if (function.getParentFunction() == null) {
			functions = functionManager.functionCategoryList();
			functionManager.sortUpFunctions(function, functions);
			functionManager.saveOjbects(functions);
			BeanUtilsEx.copyDOListToVOList(FunctionVO.class, functions,
					functionVOs);
		} else {
			functions = functionManager.functionList(function
					.getParentFunction().getId());
			functionManager.sortUpFunctions(function, functions);
			functionManager.saveOjbects(functions);
			BeanUtilsEx.copyDOListToVOList(FunctionVO.class, functions,
					functionVOs);
		}
		modelMap.put("rows", functionVOs);
		JsonUtils.writeJson(response, modelMap);
	}

	/**
	 * 降序排序
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping
	public void sortDownParentContent(HttpServletResponse response,
			Function function, ModelMap modelMap) {
		modelMap.clear();// 必须的，否则容易出异常
		function = functionManager.get(function.getId());
		List<Function> functions = null;
		List<FunctionVO> functionVOs = new ArrayList<FunctionVO>();
		if (function.getParentFunction() == null) {
			functions = functionManager.functionCategoryList();
			functionManager.sortDownFunctions(function, functions);
			functionManager.saveOjbects(functions);
			BeanUtilsEx.copyDOListToVOList(FunctionVO.class, functions,
					functionVOs);
		} else {
			functions = functionManager.functionList(function
					.getParentFunction().getId());
			functionManager.sortDownFunctions(function, functions);
			functionManager.saveOjbects(functions);
			BeanUtilsEx.copyDOListToVOList(FunctionVO.class, functions,
					functionVOs);
		}
		modelMap.put("rows", functionVOs);
		JsonUtils.writeJson(response, modelMap);
	}

	/**
	 * 获得tree
	 * 
	 * @param response
	 * @param map
	 * @return
	 */
	@RequestMapping
	public void getFunTree(Integer roleId, HttpServletResponse response,
			ModelMap map) {
		Role role = roleManager.get(roleId);
		Set<Function> roleFuns = role.getFunctions();
		List<Function> functions = functionManager.functionCategoryList();
		List<FunctionJson> jsons = new ArrayList<FunctionJson>();
		for (Function function : functions) {
			FunctionJson json = new FunctionJson();
			json.setId(function.getId());
			json.setText(function.getFunctionName());
			// 子列表
			List<FunctionJson> subJons = new ArrayList<FunctionJson>();
			for (Function subFunction : function.getFunctions()) {
				FunctionJson subJson = new FunctionJson();
				subJson.setId(subFunction.getId());
				subJson.setText(subFunction.getFunctionName());
				// 判断默认将与当前角色关联的fun勾选
				if (roleFuns.contains(subFunction)) {
					subJson.setChecked("true");
				}
				subJons.add(subJson);
			}
			json.setChildren(subJons);
			jsons.add(json);
		}
		JsonUtils.writeJson(response, jsons);
	}

	/**
	 * 获得当前角色下的treegrid
	 * 
	 * @param map
	 * @param roleId
	 * @return
	 */
	@RequestMapping
	public void listContentByRole(HttpServletResponse response, ModelMap map,
			Integer roleId) {
		map.clear();
		Role role = roleManager.get(roleId);
		Set<Function> functions = role.getFunctions();
		List<FunctionJsonVO> functionJsonVOs = new ArrayList<FunctionJsonVO>();
		for (Function function : functions) {
			FunctionJsonVO vo = new FunctionJsonVO();
			BeanUtilsEx.copyProperties(vo, function);
			if (function.getParentFunction() != null) {
				vo.set_parentId(function.getParentFunction().getId());
			} else {
				vo.setState("closed");
			}
			functionJsonVOs.add(vo);

		}
		map.put("rows", functionJsonVOs);
		JsonUtils.writeJson(response, map);
	}
}
