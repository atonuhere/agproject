package com.gfs.erm.dto;

import java.util.Date;

import com.gfs.erm.model.bo.Branch;
import com.gfs.erm.model.bo.IncidentType;

public class IncidentLogTO extends BaseTO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 690646871068205444L;
	private String incNumber;
	private String reportedBy;
	private String reporterDetails;
	private Date reportedOn;
	private String incLocation;
	private Date incDate;
	private String incCategory;
	private String descriptions;
	private String actionTaken;
	private String remarks;
	private Long loggedBy;
	private String incidentStatus;
	private Integer incidentStatusId;
	private boolean active;
	
	private String branchName;
	private String incidentType;
	
	private String incidentDate;
	
	private Long branchId;
	private Long incidentTypeId;
	
	private IncidentType  incType;
	private Branch branch;
		
	
	public String getIncNumber() {
		return incNumber;
	}
	public void setIncNumber(String incNumber) {
		this.incNumber = incNumber;
	}
	public String getReportedBy() {
		return reportedBy;
	}
	public void setReportedBy(String reportedBy) {
		this.reportedBy = reportedBy;
	}
	public String getReporterDetails() {
		return reporterDetails;
	}
	public void setReporterDetails(String reporterDetails) {
		this.reporterDetails = reporterDetails;
	}
	public Date getReportedOn() {
		return reportedOn;
	}
	public void setReportedOn(Date reportedOn) {
		this.reportedOn = reportedOn;
	}
	public String getIncLocation() {
		return incLocation;
	}
	public void setIncLocation(String incLocation) {
		this.incLocation = incLocation;
	}
	public Date getIncDate() {
		return incDate;
	}
	public void setIncDate(Date incDate) {
		this.incDate = incDate;
	}
	public IncidentType getIncType() {
		return incType;
	}
	public void setIncType(IncidentType incType) {
		this.incType = incType;
	}
	public Branch getBranch() {
		return branch;
	}
	public void setBranch(Branch branch) {
		this.branch = branch;
	}
	public String getIncCategory() {
		return incCategory;
	}
	public void setIncCategory(String incCategory) {
		this.incCategory = incCategory;
	}
	public String getDescriptions() {
		return descriptions;
	}
	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}
	public String getActionTaken() {
		return actionTaken;
	}
	public void setActionTaken(String actionTaken) {
		this.actionTaken = actionTaken;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public Long getLoggedBy() {
		return loggedBy;
	}
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
	/**
	 * @return the branchName
	 */
	public String getBranchName() {
		return branchName;
	}
	/**
	 * @param branchName the branchName to set
	 */
	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}
	/**
	 * @return the incidentType
	 */
	public String getIncidentType() {
		return incidentType;
	}
	/**
	 * @param incidentType the incidentType to set
	 */
	public void setIncidentType(String incidentType) {
		this.incidentType = incidentType;
	}
	/**
	 * @return the incidentStatus
	 */
	public String getIncidentStatus() {
		return incidentStatus;
	}
	/**
	 * @param incidentStatus the incidentStatus to set
	 */
	public void setIncidentStatus(String incidentStatus) {
		this.incidentStatus = incidentStatus;
	}
	/**
	 * @return the incidentDate
	 */
	public String getIncidentDate() {
		return incidentDate;
	}
	/**
	 * @param incidentDate the incidentDate to set
	 */
	public void setIncidentDate(String incidentDate) {
		this.incidentDate = incidentDate;
	}
	public Long getBranchId() {
		return branchId;
	}
	public void setBranchId(Long branchId) {
		this.branchId = branchId;
	}
	public Long getIncidentTypeId() {
		return incidentTypeId;
	}
	public void setIncidentTypeId(Long incidentTypeId) {
		this.incidentTypeId = incidentTypeId;
	}
	public Integer getIncidentStatusId() {
		return incidentStatusId;
	}
	public void setIncidentStatusId(Integer incidentStatusId) {
		this.incidentStatusId = incidentStatusId;
	}
	
}
