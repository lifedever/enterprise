package com.app.meibo.human.service;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.meibo.human.model.Employee;
import com.sqds.hibernate.HibernateDao;

@Service
public class EmployeeManager extends HibernateDao<Employee> {

	public List<Employee> listByPosition(Integer positionId) {
		return list("from Employee e where e.empPosition.id = ?", positionId);
	}

	public List<Employee> listEmployees() {
		return list("from Employee e where e.isDelete !=1");
	}

	/**
	 * 获取员工总数和新加入员工总数
	 * 
	 * @return
	 */
	public int[] getAllCountAndNewCount() {
		int[] arr = { 0, 0 };
		// 员工总数
		List<Employee> employees = this.listEmployees();
		arr[0] = employees == null ? 0 : employees.size();
		// 最近三个月新来的员工数
		for (Employee employee : employees) {
			Date joinDate = employee.getCreateDate();
			long day = (new Date().getTime() - joinDate.getTime()) / (24 * 60 * 60 * 1000);
			if (day < (3 * 30)) {
				arr[1]++;
			}
		}
		return arr;
	}
}
