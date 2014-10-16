package com.gfs.erm.model.bo;

import java.sql.Timestamp;
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

import com.gfs.erm.model.bo.Role;

@Entity
@Table(name = "User")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User extends BaseEntity {

	@Transient
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="user_seq", sequenceName="user_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "user_seq")
	@Column(name = "userId")
	private Long id;
	
	@Column(name = "username")
	private String userName;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "email", unique=true)
	private String email;
	
	@Column(name = "fname")
	private String fName;
	
	@Column(name = "lname")
	private String lName;
	
	@ManyToOne
    @JoinColumn(name = "role_id",nullable = false)
	private Role role;
	
	@Column(name = "branchIds")
	private String branchIds="0";
	
	@Column(name = "lastLoggedin")
	private Timestamp lastLoggedin;
	
	@Column(name = "active",columnDefinition = "INT DEFAULT 1")
	private Integer active;
	
	@Column(name = "utype", nullable = true,columnDefinition="INT DEFAULT 1")
	private Integer type;
	
	
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
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getBranchIds() {
		return branchIds;
	}
	public void setBranchIds(String branchIds) {
		this.branchIds = branchIds;
	}
	
	public Integer getActive() {
		return active;
	}
	public void setActive(Integer active) {
		this.active = active;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
	public Timestamp getLastLoggedin() {
		return lastLoggedin;
	}
	public void setLastLoggedin(Timestamp lastLoggedin) {
		this.lastLoggedin = lastLoggedin;
	}
	

}
