package com.gfs.erm.model.bo;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "IncidentLog")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class IncidentLog  extends BaseEntity {

	@Transient
	private static final long serialVersionUID = -8284943839594692270L;
	
	
	@Id
	@SequenceGenerator(name="incLog_seq", sequenceName="incLog_seq")
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "incLog_seq")
	@Column(name = "incId")
	private Long id;
	
	@Column(name = "inc_number", unique = true, nullable = false, length = 50)
	private String incNumber;
	
	@Column(name = "reported_by", nullable = false)
	private String reportedBy;
	
	@Column(name = "reporter_details")
	private String reporterDetails;
	
	@Column(name = "reported_on", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date reportedOn;
	
	@Column(name = "inc_location")
	private String incLocation;
	
	@Column(name = "inc_date", columnDefinition="DATETIME")
	@Temporal(TemporalType.TIMESTAMP)
	private Date incDate;
	
	@Column(name = "inc_category")
	private String incCategory;
	
	@Column(name = "descriptions", columnDefinition="TEXT")
	private String descriptions;
	
	@Column(name = "action_taken")
	private String actionTaken;
	
	@Column(name = "remarks", columnDefinition="TEXT")
	private String remarks;
	
	@Column(name = "logged_by")
	private Long loggedBy;
	
	@Column(nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean active=false;
		
	@Column(name = "inc_status")
	private Integer incstatus;
	
	@ManyToOne
    @JoinColumn(name = "inc_type", nullable = false, referencedColumnName="incTypeId")
	private IncidentType  incType;
	
	@ManyToOne
    @JoinColumn(name = "branch_id", nullable = false, referencedColumnName="branchId")
	private Branch branch;
	
	
	
		
	public IncidentLog(){
		
	}


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
	 * @return the incNumber
	 */
	public String getIncNumber() {
		return incNumber;
	}


	/**
	 * @param incNumber the incNumber to set
	 */
	public void setIncNumber(String incNumber) {
		this.incNumber = incNumber;
	}


	/**
	 * @return the reportedBy
	 */
	public String getReportedBy() {
		return reportedBy;
	}


	/**
	 * @param reportedBy the reportedBy to set
	 */
	public void setReportedBy(String reportedBy) {
		this.reportedBy = reportedBy;
	}


	/**
	 * @return the reporterDetails
	 */
	public String getReporterDetails() {
		return reporterDetails;
	}


	/**
	 * @param reporterDetails the reporterDetails to set
	 */
	public void setReporterDetails(String reporterDetails) {
		this.reporterDetails = reporterDetails;
	}


	/**
	 * @return the reportedOn
	 */
	public Date getReportedOn() {
		return reportedOn;
	}


	/**
	 * @param reportedOn the reportedOn to set
	 */
	public void setReportedOn(Date reportedOn) {
		this.reportedOn = reportedOn;
	}


	/**
	 * @return the incLocation
	 */
	public String getIncLocation() {
		return incLocation;
	}


	/**
	 * @param incLocation the incLocation to set
	 */
	public void setIncLocation(String incLocation) {
		this.incLocation = incLocation;
	}


	/**
	 * @return the incDate
	 */
	public Date getIncDate() {
		return incDate;
	}


	/**
	 * @param incDate the incDate to set
	 */
	public void setIncDate(Date incDate) {
		this.incDate = incDate;
	}


	/**
	 * @return the incType
	 */
	public IncidentType getIncType() {
		return incType;
	}


	/**
	 * @param incType the incType to set
	 */
	public void setIncType(IncidentType incType) {
		this.incType = incType;
	}


	/**
	 * @return the branch
	 */
	public Branch getBranch() {
		return branch;
	}


	/**
	 * @param branch the branch to set
	 */
	public void setBranch(Branch branch) {
		this.branch = branch;
	}


	/**
	 * @return the incCategory
	 */
	public String getIncCategory() {
		return incCategory;
	}


	/**
	 * @param incCategory the incCategory to set
	 */
	public void setIncCategory(String incCategory) {
		this.incCategory = incCategory;
	}


	/**
	 * @return the descriptions
	 */
	public String getDescriptions() {
		return descriptions;
	}


	/**
	 * @param descriptions the descriptions to set
	 */
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}


	/**
	 * @return the actionTaken
	 */
	public String getActionTaken() {
		return actionTaken;
	}


	/**
	 * @param actionTaken the actionTaken to set
	 */
	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}


	/**
	 * @return the remarks
	 */
	public String getRemarks() {
		return remarks;
	}


	/**
	 * @param remarks the remarks to set
	 */
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}


	/**
	 * @return the loggedBy
	 */
	public Long getLoggedBy() {
		return loggedBy;
	}


	/**
	 * @param loggedBy the loggedBy to set
	 */
	public void setLoggedBy(Long loggedBy) {
		this.loggedBy = loggedBy;
	}


	
	/**
	 * @return the active
	 */
	public boolean isActive() {
		return active;
	}


	/**
	 * @param active the active to set
	 */
	public void setActive(boolean active) {
		this.active = active;
	}


	public Integer getIncstatus() {
		return incstatus;
	}


	public void setIncstatus(Integer incstatus) {
		this.incstatus = incstatus;
	}


	

	

	
}
