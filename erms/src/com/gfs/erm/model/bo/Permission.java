package com.gfs.erm.model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name = "Permission")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Permission extends BaseEntity{
	
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 4808734015387028218L;
		
	@Id
	@SequenceGenerator(name="permission_seq", sequenceName="permission_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "permission_seq")
    @Column(name = "permissionId")
	private Long id;
	
	@ManyToOne
    @JoinColumn(name="role_id",nullable=false,referencedColumnName="roleId")
	private Role role;
	
	@Column(name = "menu_id",nullable=false)
	private String menuId;
	
	@Column(name = "submenu_id",nullable=false)
	private String submenuId;
	
	@Column(name = "function_id")
	private String functionId;
	
	
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the role
	 */
	public Role getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(Role role) {
		this.role = role;
	}
	/**
	 * @return the menuId
	 */
	public String getMenuId() {
		return menuId;
	}
	/**
	 * @param menuId the menuId to set
	 */
	public void setMenuId(String menuId) {
		this.menuId = menuId;
	}
	/**
	 * @return the submenuId
	 */
	public String getSubmenuId() {
		return submenuId;
	}
	/**
	 * @param submenuId the submenuId to set
	 */
	public void setSubmenuId(String submenuId) {
		this.submenuId = submenuId;
	}
	/**
	 * @return the functionId
	 */
	public String getFunctionId() {
		return functionId;
	}
	/**
	 * @param functionId the functionId to set
	 */
	public void setFunctionId(String functionId) {
		this.functionId = functionId;
	}
	
	
	
	
}
