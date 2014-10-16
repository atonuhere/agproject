package com.gfs.erm.model.bo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.InheritanceType;

@Entity
@Table(name="MasterBranch")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Branch extends BaseEntity{

	/**
	 * 
	 */
	@Transient
	private static final long serialVersionUID = 7003291668720121107L;
	
	@Id
	@SequenceGenerator(name="branch_seq", sequenceName="branch_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "branch_seq")
	@Column(name = "branchId")
	private Long id;
	
	@Column(name = "code", unique=true, nullable = false)
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "btype",columnDefinition="INT(1) DEFAULT 1")
	private Integer type=1; //1-HO, 2-Factory etc
	
	@Column(name = "description", nullable = false)
	private String description;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="comp_id", nullable = false, referencedColumnName="compId")
	private Company company;
	
	@Column(name = "cont_address", columnDefinition="TEXT")
	private String address;
	
	@Column(name = "contactNo")
	private String contactNo;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "pan")
	private String pan;
	
	@Column(name = "fax")
	private String fax;
	
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the description
	 */
	
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the contactNo
	 */
	public String getContactNo() {
		return contactNo;
	}
	/**
	 * @param contactNo the contactNo to set
	 */
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the pan
	 */
	public String getPan() {
		return pan;
	}
	/**
	 * @param pan the pan to set
	 */
	public void setPan(String pan) {
		this.pan = pan;
	}
	/**
	 * @return the fax
	 */
	public String getFax() {
		return fax;
	}
	/**
	 * @param fax the fax to set
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the type
	 */
	public Integer getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(Integer type) {
		this.type = type;
	}
	

	
}
