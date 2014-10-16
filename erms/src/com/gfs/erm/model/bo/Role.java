package com.gfs.erm.model.bo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name ="Role")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Role extends BaseEntity{
	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 1l;
	
	@Id
	@SequenceGenerator(name="role_seq", sequenceName="role_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "role_seq")
	@Column(name = "roleId")
	private Long id;
	
	@Column(name="roleName",nullable = false)
	private String name;
	
	@Column(name="designation")
	private String designation;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}
	/**
	 * @param designation the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	
	
}
