package com.app.permission.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 菜单
 * 
 * @author ccj
 * 
 */
@Entity
@Table(name="menu")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Menu {
	private Integer id;
	private String name;
	private Integer orderIndex;
	private Integer activeFlag;
	private List<Menu> menus;
	private Menu parentMenu;
	private Function function;
	private List<Role> roles;

	/**
	 * 流水号
	 * 
	 * @return
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * 菜单节点名称
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 菜单排序号
	 * 
	 * @return
	 */
	public Integer getOrderIndex() {
		return orderIndex;
	}

	public void setOrderIndex(Integer orderIndex) {
		this.orderIndex = orderIndex;
	}

	/**
	 * 是否有效 1有效 0无效
	 * 
	 * @return
	 */
	public Integer getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Integer activeFlag) {
		this.activeFlag = activeFlag;
	}

	/**
	 * 子菜单
	 * 
	 * @return
	 */
	@OneToMany(mappedBy = "parentMenu")
	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	/**
	 * 父菜单
	 * 
	 * @return
	 */
	@ManyToOne
	@JoinColumn(name = "parentMenuId")
	public Menu getParentMenu() {
		return parentMenu;
	}

	public void setParentMenu(Menu parentMenu) {
		this.parentMenu = parentMenu;
	}

	/**
	 * 关联功能
	 * 
	 * @return
	 */
	@ManyToOne
	@JoinColumn(name = "functionId")
	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	/**
	 * 拥有此菜单的角色
	 * 
	 * @return
	 */
	@ManyToMany(mappedBy = "menus")
	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
