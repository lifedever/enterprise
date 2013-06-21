package com.app.permission.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * 角色
 * 
 * @author ccj
 * 
 */
@Entity
@Table(name="role")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Role {
	private Integer id;
	private String roleName;
	private String roleEngName;
	private String roleDescription;
	private Set<Function> functions;
	private List<Menu> menus;
	private Integer orderIndex;
	private Integer activeFlag = 1;// 是否有效 1：有效，0：无效
	private String homePage = "main/userMain";
	private String roleSecurity;// 角色密级
	private List<Permission> permissions;

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
	 * 角色名称
	 * 
	 * @return
	 */
	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	/**
	 * 角色英文名称 在生成视图的时候，用目录分开
	 * 
	 * @return the roleEngName
	 */
	public String getRoleEngName() {
		return roleEngName;
	}

	/**
	 * @param roleEngName
	 *            the roleEngName to set
	 */
	public void setRoleEngName(String roleEngName) {
		this.roleEngName = roleEngName;
	}

	/**
	 * 角色描述
	 * 
	 * @return
	 */
	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	/**
	 * 角色拥有的功能
	 * 
	 * @return
	 */
	@ManyToMany(fetch = FetchType.EAGER)
	public Set<Function> getFunctions() {
		return functions;
	}

	public void setFunctions(Set<Function> functions) {
		this.functions = functions;
	}

	/**
	 * 角色菜单
	 * 
	 * @return
	 */
	@ManyToMany
	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	/**
	 * 排序
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
	 * 登录后显示的主界面
	 * 
	 * 2010-05-04 添加
	 * 
	 * @return
	 */
	public String getHomePage() {
		return homePage;
	}

	public void setHomePage(String homePage) {
		this.homePage = homePage;
	}

	/**
	 * 角色密级 2012-09-19 添加
	 * 
	 * @return
	 */
	public String getRoleSecurity() {
		return roleSecurity;
	}

	public void setRoleSecurity(String roleSecurity) {
		this.roleSecurity = roleSecurity;
	}

	@OneToMany(mappedBy = "role",fetch=FetchType.LAZY)
	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}
}
