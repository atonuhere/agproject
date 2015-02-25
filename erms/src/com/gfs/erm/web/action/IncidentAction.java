package com.gfs.erm.web.action;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gfs.erm.dto.IncidentLogTO;
import com.gfs.erm.model.bo.Branch;
import com.gfs.erm.model.bo.IncidentType;
import com.gfs.erm.model.bo.Role;
import com.gfs.erm.model.bo.User;
import com.gfs.erm.model.service.IncidentService;
import com.gfs.erm.web.common.WebConstants;
import com.gfs.erm.web.delegate.IncidentDelegate;
import com.gfs.erm.web.delegate.MasterDelegate;
import com.gfs.erm.web.delegate.UserDelegate;
import com.gfs.erm.util.Pager;

public class IncidentAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7000324054316258355L;

	@Autowired
	private IncidentDelegate incidentDelegate;

	@Autowired
	private IncidentService incidentService;

	@Autowired
	private UserDelegate userDelegate;

	@Autowired
	private MasterDelegate masterDelegate;

	private IncidentLogTO incident = new IncidentLogTO();

	public IncidentAction() {
		menu = "incident";
	}

	@Override
	public String execute() {
		// TODO Auto-generated method stub
		try {
			// get all Incident Logs
			setSubmenu("incidentLog");
			setControl("incidentLog");
			
			ajaxPath = rootpath + "incident/index.html"; // initialize page
			dataPage = incidentService.findByCriteria(incident, getRequestedPage());
			
			if (ajax) {
				return WebConstants.ACTION_AJAX;
			} else {
				return SUCCESS;
			}
		} catch (Exception e) {
			this.setErrorSession("Incident List Error", e);
			return ERROR;
		}

	}

	public String add() {

		try {
			// get all Incident Logs
			control = "incidentLog";
			submenu = "incidentAdd";
			clearMessages();
			incident = new IncidentLogTO();
			List<IncidentType> incTypeList = incidentDelegate.getIncidentTypeList();
			dataArr.put("incidentTypeList", incTypeList);
			List<Branch> branchList = masterDelegate.branchList();
			dataArr.put("branchList", branchList);

		} catch (Exception e) {
			this.setErrorSession("Incident Add Error", e);
		}
		
		return SUCCESS;
	}

	public String update() {

		try {

			control = "incidentLog";
			incident = incidentDelegate.getIncidentLog(id);
			List<IncidentType> incTypeList = incidentDelegate
					.getIncidentTypeList();
			dataArr.put("incidentTypeList", incTypeList);
			List<Branch> branchList = masterDelegate.branchList();
			dataArr.put("branchList", branchList);

		} catch (Exception e) {
			this.setErrorSession("Incident Update Error", e);

		}

		return SUCCESS;
	}

	public String delete() {

		try {
			// get all Incident Logs

		} catch (Exception e) {
			this.setErrorSession("Incident Add Error", e);
		}
		return SUCCESS;
	}

	public String view() {

		try {
			// get all Incident Logs
			control = "incidentlog";
			incident = incidentDelegate.getIncidentLog(id);
		} catch (Exception e) {
			this.setErrorSession("Incident View Error", e);
		}
		return SUCCESS;
	}

	public String assignInvestigation() {

		try {
			// get all Incident Logs
			control = "incidentAssign";
			submenu = "incidentAssign";
			// showinf status 2 only
			ajaxPath = rootpath + "incident/assignInvestigation.html"; // initialize page
			incident= new IncidentLogTO();
			incident.setIncidentStatusId(1);
			dataPage = incidentService.findByCriteria(incident, getRequestedPage());

		} catch (Exception e) {
			this.setErrorSession("Incident Assign Error", e);
		}
		return SUCCESS;
	}

	public String assignMember() {

		try {
			System.out.println("in assignMember ");
			List<Role> roleList = masterDelegate.roleList();
			dataArr.put("roleList", roleList);
			List<User> userList = userDelegate.userList();
			dataArr.put("userList", userList);
			System.out.println("Size of list is" + userList.size());

		} catch (Exception e) {
			this.setErrorSession("Incident Assign Error", e);
		}
		return SUCCESS;
	}

	public String submitInvestigationReports() {

		try {

			control = "submitInvestigationReports";
			submenu = "submitInvestigationReports";
			ajaxPath = rootpath + "incident/assignInvestigation.html"; // initialize page
			incident= new IncidentLogTO();
			incident.setIncidentStatusId(2);
			dataPage = incidentService.findByCriteria(incident, getRequestedPage());

		} catch (Exception e) {
			this.setErrorSession("Incident Submit Investigation Report Error",
					e);
		}
		return SUCCESS;
	}

	public String submitInvestigationReport() {

		try {
			// get all Incident Logs
			control = "submitInvestigationReport";
			submenu = "submitInvestigationReport";

		} catch (Exception e) {
			this.setErrorSession("Incident Submit Investigation Report Error",
					e);
		}
		return SUCCESS;
	}

	public String reviewInvestigationReports() {

		try {
			// get all Incident Logs
			control = "reviewInvestigationReports";
			submenu = "reviewInvestigationReports";
			ajaxPath = rootpath + "incident/assignInvestigation.html"; // initialize page
			incident= new IncidentLogTO();
			incident.setIncidentStatusId(4);
			dataPage = incidentService.findByCriteria(incident, getRequestedPage());

		} catch (Exception e) {
			this.setErrorSession("Incident Review Investigation Report  Error",
					e);
		}
		return SUCCESS;
	}

	public String addReport() {

		try {

			control = "";
			submenu = "";
			incident = new IncidentLogTO();
			List<IncidentType> incTypeList = incidentDelegate.getIncidentTypeList();
			dataArr.put("incidentTypeList", incTypeList);
			List<Branch> branchList = masterDelegate.branchList();
			dataArr.put("branchList", branchList);

		} catch (Exception e) {
			this.setErrorSession("Incident Add Error", e);
		}

		return SUCCESS;
	}

	public String updateReport() {

		try {

			control = "incidentLog";
			incident = incidentDelegate.getIncidentLog(id);
			List<IncidentType> incTypeList = incidentDelegate.getIncidentTypeList();
			dataArr.put("incidentTypeList", incTypeList);
			List<Branch> branchList = masterDelegate.branchList();
			dataArr.put("branchList", branchList);

		} catch (Exception e) {
			this.setErrorSession("Incident Update Error", e);
		}

		return SUCCESS;
	}

	public String viewReport() {

		try {
			// get all Incident Logs
			control = "incidentlog";
			incident = incidentDelegate.getIncidentLog(id);
		} catch (Exception e) {
			this.setErrorSession("Incident View Error", e);
		}
		return SUCCESS;
	}
	
	/**
	  * Returns generic Page instance.
	  * @param domain
	  * @param DTO
	  * @return
	  */
	 protected Pager<IncidentLogTO> getRequestedPage(){
	      Pager<IncidentLogTO> requestedPage = new Pager<IncidentLogTO>(); 
	      requestedPage.setPage(page);
	      //requestedPage.setRows(WebConstants.RECORDS_PER_PAGE);
	      requestedPage.setAjaxPath(ajaxPath);
	      requestedPage.setElementId(elementId);
	      requestedPage.setOrder(order);
	      requestedPage.setSort(sort);
	      requestedPage.setSearchString(searchString);
	     
	      
	      return requestedPage;
	 }

	/**
	 * @return the incidentDelegate
	 */
	public IncidentDelegate getIncidentDelegate() {
		return incidentDelegate;
	}

	/**
	 * @param incidentDelegate
	 *            the incidentDelegate to set
	 */
	public void setIncidentDelegate(IncidentDelegate incidentDelegate) {
		this.incidentDelegate = incidentDelegate;
	}

	public IncidentLogTO getIncident() {
		return incident;
	}

	public void setIncident(IncidentLogTO incident) {
		this.incident = incident;
	}

	/**
	 * @return the userDelegate
	 */
	public UserDelegate getUserDelegate() {
		return userDelegate;
	}

	/**
	 * @param userDelegate
	 *            the userDelegate to set
	 */
	public void setUserDelegate(UserDelegate userDelegate) {
		this.userDelegate = userDelegate;
	}

	/**
	 * @return the masterDelegate
	 */
	public MasterDelegate getMasterDelegate() {
		return masterDelegate;
	}

	/**
	 * @param masterDelegate
	 *            the masterDelegate to set
	 */
	public void setMasterDelegate(MasterDelegate masterDelegate) {
		this.masterDelegate = masterDelegate;
	}

	/**
	 * @return the incidentService
	 */
	public IncidentService getIncidentService() {
		return incidentService;
	}

	/**
	 * @param incidentService
	 *            the incidentService to set
	 */
	public void setIncidentService(IncidentService incidentService) {
		this.incidentService = incidentService;
	}

	

}
