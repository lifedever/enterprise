package com.app.permission.model;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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
 * 功能
 * 
 * @author ccj
 * 
 */
@Entity
@Table(name="function")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Function {

	private Integer id;
	private String functionName;
	private String functionUrl;
	private Integer classId;
	private Integer activeFlag;
	private Function parentFunction;
	private Integer orderIndex;
	private List<Function> functions;
	private Set<Role> roles;
	private String imageButtonUrl;
	private String description;

	/**
	 * 主键
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
	 * 功能名称
	 * 
	 * @return
	 */
	public String getFunctionName() {
		return functionName;
	}

	public void setFunctionName(String functionName) {
		this.functionName = functionName;
	}

	/**
	 * 功能链接
	 * 
	 * @return
	 */
	public String getFunctionUrl() {
		return functionUrl;
	}

	public void setFunctionUrl(String functionUrl) {
		this.functionUrl = functionUrl;
	}

	/**
	 * 类别：0:树形链接 1:页面链接
	 * 
	 * @return
	 */
	public Integer getClassId() {
		return classId;
	}

	public void setClassId(Integer classId) {
		this.classId = classId;
	}

	/**
	 * 此功能是否有效 1:有效 0:无效
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
	 * 父功能编号
	 * 
	 * @return
	 */
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parentFunctionId")
	public Function getParentFunction() {
		return parentFunction;
	}

	public void setParentFunction(Function parentFunction) {
		this.parentFunction = parentFunction;
	}

	/**
	 * 排序号
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
	 * 子功能
	 * 
	 * @return
	 */
	@OneToMany(mappedBy = "parentFunction",fetch = FetchType.EAGER)
	public List<Function> getFunctions() {
		return functions;
	}

	public void setFunctions(List<Function> functions) {
		this.functions = functions;
	}

	/**
	 * 功能被哪些角色使用
	 * 
	 * @return
	 */
	@ManyToMany(mappedBy = "functions" )
	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * homepage按钮图片文件url 2010-05-04添加
	 * 
	 * @return
	 */
	public String getImageButtonUrl() {
		return imageButtonUrl;
	}

	public void setImageButtonUrl(String imageButtonUrl) {
		this.imageButtonUrl = imageButtonUrl;
	}

	/**
	 * 功能菜单描述
	 * 
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
