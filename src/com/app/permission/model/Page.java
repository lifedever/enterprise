package com.app.permission.model;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import com.app.permission.service.PermissionManager;
import com.app.permission.utils.web.RequestUtils;
import com.sqds.hibernate.HibernateDao;
import com.sqds.page.PageInfo;
import com.sqds.spring.SpringUtils;
import com.sqds.util.ParamUtils;
import com.sqds.util.SessionManager;

/**
 * 继承了PageInfo，分页请直接使用这个
 * 
 * @author gefangshuai
 * @email gefangshuai@163.com
 * @createtime 2012-10-30 下午5:26:29
 * @param <T>
 */
public class Page<T> extends PageInfo<T> {
	private String pageNavigation;

	public Page() {
	}

	public Page(int pageSize) {
		this.setPageSize(pageSize);
	}

	public String getPageNavigation() {
		int pageCount = getTotalPages();
		StringBuffer sb = new StringBuffer();
		sb.append("<div class='pagination'>");
		sb.append("<ul>");
		if (getPageNo() <= 1) {
			sb.append("<li><a href='#' onclick='goPage(\"" + (getPageNo()) + "\")'>上一页</a></li>");
		} else {
			sb.append("<li><a href='#' onclick='goPage(\"" + (getPageNo() - 1) + "\")'>上一页</a></li>");
		}
		for (int i = 1; i < pageCount + 1; i++) {
			sb.append("<li><a href='#' onclick='goPage(\"" + i + "\")'>" + (i) + "</a></li>");
		}
		if (getPageNo() >= pageCount) {
			sb.append("<li><a href='#' onclick='goPage(\"" + (getPageNo()) + "\")'>下一页</a></li>");
		} else {
			sb.append("<li><a href='#' onclick='goPage(\"" + (getPageNo() + 1) + "\")'>下一页</a></li>");
		}
		sb.append("</ul>");
		sb.append("</div>");
		sb.append("<script type='text/javascript'>");
		sb.append("function goPage(pageNo){");
		sb.append("var pathname = window.location.pathname;");
		Map<String, Object> queryDatas = getPostValue();
		Set<String> keySet = queryDatas.keySet();
		if (keySet.size() > 0) {
			StringBuffer datas = new StringBuffer();
			for (String key : keySet) {
				datas.append(key);
				datas.append("=");
				datas.append(queryDatas.get(key));
				datas.append("&");
			}
			sb.append("window.location.href=pathname+'?'+'pageNo='+pageNo+'&" + datas.toString() + "';");
		} else {
			sb.append("window.location.href=pathname+'?'+'pageNo='+pageNo;");
		}
		// sb.append("alert(window.location.href)");
		sb.append("}");
		sb.append("</script>");
		pageNavigation = sb.toString();
		return pageNavigation;
	}

	/**
	 * 包装前台request传来的参数作为查询条件
	 */
	public void setQueryDatas(HttpServletRequest request, Page<T> page) {
		Map<String, Object> queryData = RequestUtils.getSearchParameter(request);
		// 传递表单数据
		Iterator<String> keys = queryData.keySet().iterator();
		while (keys.hasNext()) {
			String key = keys.next();
			Object value = queryData.get(key);
			// 过滤无效记录
			page.addParameter(key, value);
		}
		// 将easyUI的rows及page参数绑定给page对象
		page.setPageNo(ParamUtils.getInt("page", 1));
		page.setPageSize(ParamUtils.getInt("rows", 10));
	}

	/**
	 * 有限制条件：isDelete=1的查询
	 * 
	 * page封装的查询：s_开头：模糊字符串查询；f_开头：具体=查询；n_开头：不等于查询！=；d_开头：范围查询；
	 * 
	 * @param page
	 * @param className
	 * @param hibernateDao
	 */
	public void search(Page<T> page, String className, HibernateDao<T> hibernateDao) {
		System.out.println(page.getPostValue());
		StringBuffer sb = new StringBuffer("from " + className + " where 1=1");
		Map<String, Object> queryMap = page.getPostValue();
		String orderBy = (String) page.getParameter("orderBy");
		String order = (String) page.getParameter("order");
		Set<String> keys = queryMap.keySet();
		for (String key : keys) {
			if (key.startsWith("s_")) {// 字符串模糊查询
				sb.append(" and " + key.substring(2) + " like '%" + queryMap.get(key) + "%' ");
			}
			if (key.startsWith("f_")) {// 具体值查询
				sb.append(" and " + key.substring(2) + " = " + queryMap.get(key) + " ");
			}
			if (key.startsWith("n_")) {// 具体值查询
				sb.append(" and " + key.substring(2) + " != " + queryMap.get(key) + " ");
			}
			if (key.startsWith("q_")) {// 等号匹配查询
				sb.append(" and " + key.substring(2) + " " + queryMap.get(key));
			}
			if (key.startsWith("d_")) {// 时间范围查询
				if (queryMap.get(key).toString().contains(",") && !",".equals(queryMap.get(key).toString())) {
					String[] date = queryMap.get(key).toString().split(",");
					if (date[0].length() > 2) {
						sb.append(" and " + key.substring(2) + " >= '" + date[0].substring(2) + "'");
					}
					if (date[1].length() > 2) {
						sb.append(" and " + key.substring(2) + " <= '" + date[1].substring(2) + "'");
					}
				}
			}
		}
		User user = (User) SessionManager.getAttribute(SpringUtils.getRequest(), "user");
		// 权限控制
		PermissionManager permissionManager = (PermissionManager) SpringUtils.getBean("permissionManager");
		List<Permission> permissions = permissionManager.listPermissionByRole(user.getRole().getId());
		for (Permission permission : permissions) {
			if (className.equals(permission.getClassName())) {
				if ("userId".equals(permission.getCause())) {
					sb.append(" and userId = " + user.getId());
				}
				if ("departmentId".equals(permission.getCause())) {
					sb.append(" and departmentId = " + user.getDepartment().getId());
				}
			}
		}
		sb.append(" and isDelete!=1 ");
		if (orderBy!=null&&!"".equals(orderBy)) {
			if (order!=null&&!"".equals(order)) {
				sb.append("order by "+orderBy+" "+order);
			}else {
				sb.append("order by "+orderBy+" desc");
			}
		}else {
			String sort = (String) page.getParameter("sort");
			String order2 = (String) page.getParameter("order");
			if(sort!=null&&order!=null){
				sb.append(" order by "+sort+" "+order2);
			}else {
				sb.append(" order by createDate desc");
			}
		}
		hibernateDao.list(page, sb.toString());
	}

	/**
	 * 没有限制条件：isDelete=1的查询
	 * page封装的查询：s_开头：模糊字符串查询；f_开头：具体=查询；n_开头：不等于查询！=；d_开头：范围查询；
	 * 
	 * @param page
	 * @param className
	 * @param hibernateDao
	 */
	public void searchWithOutIsdelete(Page<T> page, String className, HibernateDao<T> hibernateDao) {
		System.out.println(page.getPostValue());
		StringBuffer sb = new StringBuffer("from " + className + " where 1=1");
		Map<String, Object> queryMap = page.getPostValue();
		Set<String> keys = queryMap.keySet();
		for (String key : keys) {
			if (key.startsWith("s_")) {// 字符串模糊查询
				sb.append(" and " + key.substring(2) + " like '%" + queryMap.get(key) + "%' ");
			}
			if (key.startsWith("f_")) {// 具体值查询
				sb.append(" and " + key.substring(2) + " = " + queryMap.get(key) + " ");
			}
			if (key.startsWith("n_")) {// 具体值查询
				sb.append(" and " + key.substring(2) + " != " + queryMap.get(key) + " ");
			}
			if (key.startsWith("q_")) {// 等号匹配查询
				sb.append(" and " + key.substring(2) + " " + queryMap.get(key));
			}
			if (key.startsWith("d_")) {// 时间范围查询
				if (queryMap.get(key).toString().contains(",") && !",".equals(queryMap.get(key).toString())) {
					String[] date = queryMap.get(key).toString().split(",");
					if (date[0].length() > 2) {
						sb.append(" and " + key.substring(2) + " >= '" + date[0].substring(2) + "'");
					}
					if (date[1].length() > 2) {
						sb.append(" and " + key.substring(2) + " <= '" + date[1].substring(2) + "'");
					}
				}
			}
		}
		User user = (User) SessionManager.getAttribute(SpringUtils.getRequest(), "user");
		// 权限控制
		PermissionManager permissionManager = (PermissionManager) SpringUtils.getBean("permissionManager");
		List<Permission> permissions = permissionManager.listPermissionByRole(user.getRole().getId());
		for (Permission permission : permissions) {
			if (className.equals(permission.getClassName())) {
				if ("userId".equals(permission.getCause())) {
					sb.append(" and userId = " + user.getId());
				}
				if ("departmentId".equals(permission.getCause())) {
					sb.append(" and departmentId = " + user.getDepartment().getId());
				}
			}
		}
		String sort = (String) page.getParameter("sort");
		String order = (String) page.getParameter("order");
		if(sort!=null&&order!=null){
			sb.append(" order by "+sort+" "+order);
		}else {
			sb.append(" order by createDate desc");
		}
		hibernateDao.list(page, sb.toString());
	}
}
