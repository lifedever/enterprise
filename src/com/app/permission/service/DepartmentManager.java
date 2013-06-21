package com.app.permission.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.permission.model.Department;
import com.sqds.hibernate.HibernateDao;

/**
 * 部门管理
 * 
 * @author ccj
 * 
 */
@Service
public class DepartmentManager extends HibernateDao<Department> {

	/**
	 * 树形取得所有部门一级字部门（这级部问没有父部门）
	 * 
	 * @return
	 */
	public List<Department> getDepartmentList() {
		String hql = "from Department d where d.parentDepartment is null order by d.orderIndex asc, d.id";
		List<Department> list = list(hql);
		list(list);
		return list;
	}

	/**
	 * 取得指定部门下的所有部门
	 * 
	 * @param parentDepartmentId
	 * @return
	 */
	public List<Department> list(int parentDepartmentId) {
		String hql = "from Department d where d.parentDepartment.id=? order by d.orderIndex asc, d.id";
		return list(hql, parentDepartmentId);
	}

	/**
	 * 递归取得子部门信息
	 * 
	 * @param list
	 */
	private void list(List<Department> list) {
		if (list != null && list.size() != 0) {
			for (Department department : list) {
				List<Department> sonDepartment = list(department.getId());
				department.setDepartments(sonDepartment);
				list(sonDepartment);
			}
		}
	}

	/**
	 * 根据部门编号，取得部门信息
	 * 
	 * @param departmentCode
	 * @return
	 */
	public Department getDepartment(String departmentCode) {
		return super.findUniqueByProperty("departmentCode", departmentCode);
	}

	/**
	 * 根据当前部门编号，取得上级部门信息
	 * 
	 * @param departmentId
	 * @return
	 */
	public Department getParentDepartment(int departmentId) {
		String hql = "select d from Department d inner join d.departments son where son.id=? ";
		// String hql = "";
		return super.findUnique(hql, departmentId);
	}

	/**
	 * 取得最顶层档案馆信息
	 * 
	 * @return
	 */
	public Department getRootDepartment() {
		String hql = "from Department d where d.parentDepartment is null";
		return super.findUnique(hql);
	}

	/**
	 * 获得所有部门
	 */
	public List<Department> getDepartments() {
		// String hql = "from Department";
		List<Department> list = super.listAll();
		return list;
	}

	/**
	 * 列出基于orderIndex的上面或下面的所有节点
	 * 
	 * @param orderIndex
	 * @param opeara
	 *            操作符，0：上面，top，1：下面，bottom
	 * @return
	 */
	public List<Department> listTopOrButtom(Integer targetIndex, Integer parentId, int opeara) {
		if (opeara == 0) {
			return list("from Department d where d.orderIndex >= ? and d.parentDepartment.id = ?", targetIndex, parentId);
		} else {
			return list("from Department d where d.orderIndex <= ? and d.parentDepartment.id = ?", targetIndex, parentId);
		}
	}

	/**
	 * 拖拽
	 * 
	 * @param targetId
	 * @param sourceId
	 * @param point
	 */
	public void onDrop(Integer targetId, Integer sourceId, String point) {
		Department targetDept = this.get(targetId);
		Department sourceDept = this.get(sourceId);
		System.out.println(point);
		checkOrderIndex(targetDept);
		checkOrderIndex(sourceDept);

		if ("top".equals(point)) {// 上移到顶部
			dropTop(targetDept, sourceDept);
		} else if ("bottom".equals(point)) {// 下移到底部
			dropBottom(targetDept, sourceDept);
		} else if ("append".equals(point)) {// 追加到子级
			dropAppend(targetDept, sourceDept);
		}
		this.update(targetDept);
		this.update(sourceDept);
	}

	/**
	 * 检查orderIndex，如果为null，则为其赋值
	 * 
	 * @param department
	 */
	private void checkOrderIndex(Department department) {
		if (department.getOrderIndex() == null)
			department.setOrderIndex(department.getId());
	}

	/**
	 * 拖拽到上面
	 */
	private void dropTop(Department targetDept, Department sourceDept) {
		List<Department> departments = this.listTopOrButtom(targetDept.getOrderIndex(), targetDept.getParentDepartment().getId(), 0);
		for (Department department : departments) {
			department.setOrderIndex(department.getOrderIndex() + 1);
		}
		this.updateObjects(departments);
		sourceDept.setOrderIndex(targetDept.getOrderIndex() - 1);
		sourceDept.setParentDepartment(targetDept.getParentDepartment());
	}

	/**
	 * 拖拽到下面
	 */
	private void dropBottom(Department targetDept, Department sourceDept) {

		List<Department> departments = this.listTopOrButtom(targetDept.getOrderIndex(), targetDept.getParentDepartment().getId(), 0);
		for (Department department : departments) {
			department.setOrderIndex(department.getOrderIndex() - 1);
		}
		this.updateObjects(departments);
		sourceDept.setOrderIndex(targetDept.getOrderIndex() + 1);
		sourceDept.setParentDepartment(targetDept.getParentDepartment());
	}

	/**
	 * 拖拽成子节点
	 */
	private void dropAppend(Department targetDept, Department sourceDept) {
		sourceDept.setParentDepartment(targetDept);
	}

}
