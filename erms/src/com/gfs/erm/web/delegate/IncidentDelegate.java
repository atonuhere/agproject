package com.gfs.erm.web.delegate;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.gfs.erm.dto.IncidentLogTO;
import com.gfs.erm.model.bo.Branch;
import com.gfs.erm.model.bo.IncidentLog;
import com.gfs.erm.model.bo.IncidentType;
import com.gfs.erm.model.service.IncidentService;
import com.gfs.erm.web.common.WebConstants;
import com.gfs.erm.web.delegate.GeneralDelegate;
import com.gfs.erm.exception.BusinessException;
import com.gfs.erm.util.DateUtil;

@Repository("incidentDelegate")
@Scope("singleton")
public class IncidentDelegate extends GeneralDelegate {
	
	/** The Business object related with current delegate */
	@Autowired
	private IncidentService incidentService;
	
	public List<IncidentLogTO> getIncidentLogList() throws BusinessException{
		List<IncidentLogTO> incLog=new ArrayList<IncidentLogTO>();
		try {
			List<IncidentLog> incList = incidentService.getIncidentLogList();
			
			for(int i=0; i < incList.size(); i++){
				IncidentLogTO incto= new IncidentLogTO();
				incto.setId(incList.get(i).getId());
				incto.setIncNumber(incList.get(i).getIncNumber());
				incto.setBranchName(incList.get(i).getBranch().getName());
				incto.setIncidentStatus(WebConstants.INCIDENT_STATUS[incList.get(i).getIncstatus()]);
				incto.setIncidentType(incList.get(i).getIncType().getName());
				incto.setIncLocation(incList.get(i).getIncLocation());
				incto.setIncidentDate(DateUtil.formatDate(incList.get(i).getIncDate()));
				
				incLog.add(incto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e);
		}
		
		return incLog;
		
	}
	public List<IncidentLogTO> getIncidentLogList(int start, int end,String order, String sort) throws BusinessException{
		List<IncidentLogTO> incLog=new ArrayList<IncidentLogTO>();
		try {
			List<IncidentLog> incList = incidentService.getIncidentLogList(start, end,order, sort);
			
			for(int i=0; i < incList.size(); i++){
				IncidentLogTO incto= new IncidentLogTO();
				incto.setId(incList.get(i).getId());
				incto.setIncNumber(incList.get(i).getIncNumber());
				incto.setBranchName(incList.get(i).getBranch().getName());
				incto.setIncidentStatus(WebConstants.INCIDENT_STATUS[incList.get(i).getIncstatus()]);
				incto.setIncidentType(incList.get(i).getIncType().getName());
				incto.setIncLocation(incList.get(i).getIncLocation());
				incto.setIncidentDate(DateUtil.formatDate(incList.get(i).getIncDate()));
				
				incLog.add(incto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e);
		}
		
		return incLog;
		
	}
	
	
	
	
	public Integer count() throws BusinessException{
		Integer count=0;
		try {
			count = incidentService.incidentLogCount();
		}catch(Exception e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e);
		}
		return count; 
	}
	
	
	
	public List<IncidentLogTO> getIncidentLogList(Integer incStatus) throws BusinessException{
		List<IncidentLogTO> incLog=new ArrayList<IncidentLogTO>();
		try {
			List<IncidentLog> incList = incidentService.getIncidentLogList(incStatus);
			
			for(int i=0; i < incList.size(); i++){
				IncidentLogTO incto= new IncidentLogTO();
				incto.setId(incList.get(i).getId());
				incto.setIncNumber(incList.get(i).getIncNumber());
				incto.setBranchName(incList.get(i).getBranch().getName());
				incto.setIncidentStatus(WebConstants.INCIDENT_STATUS[incList.get(i).getIncstatus()]);
				incto.setIncidentType(incList.get(i).getIncType().getName());
				incto.setIncLocation(incList.get(i).getIncLocation());
				incto.setIncidentDate(DateUtil.formatDate(incList.get(i).getIncDate()));
				
				incLog.add(incto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e);
		}
		
		return incLog;
		
	}
	
	public IncidentLogTO getIncidentLog(Long id) throws BusinessException{
		IncidentLogTO incident=new IncidentLogTO();
		try {
			IncidentLog incLog = incidentService.getIncidentLog(id);
			
				incident.setId(incLog.getId());
				incident.setIncNumber(incLog.getIncNumber());
				
				incident.setBranchName(incLog.getBranch().getName());
				incident.setIncidentStatus(WebConstants.INCIDENT_STATUS[incLog.getIncstatus()]);
				incident.setIncidentType(incLog.getIncType().getName());
				incident.setBranchId(incLog.getBranch().getId());
				incident.setIncidentStatusId(incLog.getIncstatus());
				incident.setIncidentTypeId(incLog.getIncType().getId());
				
				incident.setIncLocation(incLog.getIncLocation());
				incident.setIncidentDate(DateUtil.formatDate(incLog.getIncDate()));
				incident.setIncDate(incLog.getIncDate());
				incident.setReportedBy(incLog.getReportedBy());
				incident.setReporterDetails(incLog.getReporterDetails());
				incident.setReportedOn(incLog.getReportedOn());
									
				incident.setIncCategory(incLog.getIncCategory());
				incident.setDescriptions(incLog.getDescriptions());
				incident.setActionTaken(incLog.getActionTaken());
				incident.setRemarks(incLog.getRemarks());
				incident.setLoggedBy(incLog.getLoggedBy());
				incident.setActive(incLog.isActive());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e);
		}
		
		return incident;
		
	}
	
	public List<IncidentType> getIncidentTypeList() throws BusinessException{
		List<IncidentType> incTypeList=null;
		try {
			incTypeList = incidentService.getIncidentTypeList();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e);
		}
		
		return incTypeList;
		
	}
	
	public Boolean saveIncidentLog(IncidentLogTO incident) throws BusinessException{
		System.out.println("In delegate entered");
		IncidentLog incLog= new IncidentLog();	
		Boolean flag=false;
		try {
				if(incident.getId()==null){
					System.out.println("Inserting");
					
					incLog.setIncNumber(incident.getIncNumber());
					incLog.setReportedBy(incident.getReportedBy());
					incLog.setReporterDetails(incident.getReporterDetails());
					incLog.setReportedOn(incident.getReportedOn());
					incLog.setIncLocation(incident.getIncLocation());
					incLog.setIncDate(incident.getIncDate());					
					incLog.setIncCategory(incident.getIncCategory());
					incLog.setDescriptions(incident.getDescriptions());
					incLog.setActionTaken(incident.getActionTaken());
					incLog.setRemarks(incident.getRemarks());
					incLog.setLoggedBy(incident.getLoggedBy());
					incLog.setActive(incident.isActive());
					
					incLog.setIncstatus(incident.getIncidentStatusId());
					
					Branch branch=incidentService.getBranch(incident.getBranchId());
					incLog.setBranch(branch);
					
					IncidentType incType=incidentService.getIncidentType(incident.getIncidentTypeId());
					incLog.setIncType(incType);
					
					
				}else{
					
					System.out.println("updating");
					incLog.setId(incident.getId());
					incLog.setIncNumber(incident.getIncNumber());
					incLog.setReportedBy(incident.getReportedBy());
					incLog.setReporterDetails(incident.getReporterDetails());
					incLog.setReportedOn(incident.getReportedOn());
					incLog.setIncLocation(incident.getIncLocation());
					incLog.setIncDate(incident.getIncDate());					
					incLog.setIncCategory(incident.getIncCategory());
					incLog.setDescriptions(incident.getDescriptions());
					incLog.setActionTaken(incident.getActionTaken());
					incLog.setRemarks(incident.getRemarks());
					incLog.setLoggedBy(incident.getLoggedBy());
					incLog.setActive(incident.isActive());
					incLog.setIncstatus(incident.getIncidentStatusId());
					
					Branch branch=incidentService.getBranch(incident.getBranchId());
					incLog.setBranch(branch);
					
					IncidentType incType=incidentService.getIncidentType(incident.getIncidentTypeId());
					incLog.setIncType(incType);
					
				}
				
				System.out.println("All data fetched");
				
				flag= incidentService.saveIncidentLog(incLog);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e);
		}
		
		return flag;
		
	}
	
	
	
	public IncidentService getIncidentService() {
		return incidentService;
	}

	public void setIncidentService(IncidentService incidentService) {
		this.incidentService = incidentService;
	}
	
	

}
