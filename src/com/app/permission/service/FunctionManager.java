package com.app.permission.service;

import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.permission.model.Function;
import com.app.permission.model.vo.FunctionVO;
import com.app.permission.utils.BeanUtilsEx;
import com.sqds.hibernate.HibernateDao;

/**
 * 功能业务操作
 * 
 * @author ccj
 * 
 */
@Service
public class FunctionManager extends HibernateDao<Function> {
	/**
	 * 取得功能分类
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Function> functionCategoryList() {
		String hql = "from Function f where f.parentFunction is null order by f.orderIndex";
		return super.list(hql);
	}

	/**
	 * 取得某功能分类下的所有功能
	 * 
	 * @param parentFunctionId
	 *            父功能编号
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<Function> functionList(int parentFunctionId) {
		String hql = "from Function f where f.parentFunction.id = ? order by f.orderIndex";
		return super.list(hql, parentFunctionId);
	}

	@Transactional(readOnly = true)
	public List<Function> allFunctionList() {
		String hql = "from Function f inner join fetch f.parentFunction fid  where fid is not null order by f.orderIndex, f.id";
		return super.list(hql);
	}

	/**
	 * 对功能模块进行排序
	 * 
	 * @param ids
	 */
	public void categoryOrder(int[] ids) {
		for (int i = 0; i < ids.length; i++) {
			if (ids[i] == 0) {
				continue;
			}
			Function function = super.get(ids[i]);
			function.setOrderIndex(i);
			super.update(function);
		}
	}

	/**
	 * 取得指定用户所有的功能信息
	 * 
	 * @param userId
	 * @return
	 */
	public List<Function> getUserFunctions(int userId) {
		String hql = "select f from Function f inner join f.roles order by f.orderIndex";
		// "inner join f.roles r inner join r.users u " ;
		// "where u.id=?" ;
		// " and f.activeFlag=? and r.activeFlag=?";
		return list(hql);
	}

	/**
	 * 取得所有的功能
	 * 
	 * @return
	 */
	public List<Function> getFunctionList() {
		String hql = "from Function f order by f.functionUrl asc,f.id asc";
		return super.list(hql);
	}

	/**
	 * 上移排序
	 * 
	 * @param currFun
	 *            当前移动的功能
	 * @param functions
	 *            所有功能列表
	 */
	public void sortUpFunctions(Function currFun, List<Function> functions) {
		int currOrderIndex = currFun.getOrderIndex();
		int currIndex = functions.indexOf(currFun);
		if (currIndex != 0) {
			Function tempFunction = functions.get(currIndex - 1);
			functions.get(currIndex)
					.setOrderIndex(tempFunction.getOrderIndex());
			tempFunction.setOrderIndex(currOrderIndex);
			Collections.swap(functions, currIndex, currIndex - 1);// 集合交换位置
		}
	}

	/**
	 * 下移排序
	 * 
	 * @param currFun
	 *            当前移动的功能
	 * @param functions
	 *            所有功能列表
	 */
	public void sortDownFunctions(Function currFun, List<Function> functions) {
		int currOrderIndex = currFun.getOrderIndex();
		int currIndex = functions.indexOf(currFun);
		if (currIndex < functions.size() - 1) {
			Function tempFunction = functions.get(currIndex + 1);
			functions.get(currIndex)
					.setOrderIndex(tempFunction.getOrderIndex());
			tempFunction.setOrderIndex(currOrderIndex);
			Collections.swap(functions, currIndex, currIndex + 1);// 集合交换位置
		}
	}

	public void copyDOListToVOList(List<Function> dos, List<FunctionVO> vos) {
		for (Function function : dos) {
			FunctionVO vo = new FunctionVO();
			BeanUtilsEx.copyProperties(vo, function);
			vos.add(vo);
		}
	}

	/**
	 * 查询最大的排序号，用于排序
	 * 
	 * @return
	 */
	public int findMaxOrderIndex() {
		String hql = "select max(fun.orderIndex) from Function fun";
		int max = super.findInt(hql);
		return max;
	}
}
