package com.gfs.erm.model.service;

import java.util.List;

import com.gfs.erm.model.bo.Branch;
import com.gfs.erm.model.bo.IncidentLog;
import com.gfs.erm.model.bo.IncidentType;
import com.gfs.erm.dto.IncidentLogTO;
import com.gfs.erm.exception.BusinessException;
import com.gfs.erm.util.Pager;

public interface IncidentService {
	
	public List<IncidentLog> getIncidentLogList() throws BusinessException;
	
	/**
	  * Returns list of IncidentLog for a given search criteria.
	  * @return
	  * @throws BusinessException
	  */
	public Pager<IncidentLogTO> findByCriteria(IncidentLogTO searchCriteria, Pager<IncidentLogTO> page) throws BusinessException;
	
	public List<IncidentLog> getIncidentLogList(int start, int end,String order, String sort) throws BusinessException;
	
	public List<IncidentLog> getIncidentLogList(Integer incStatus) throws BusinessException;
	
	public IncidentLog getIncidentLog(Long id) throws BusinessException;
	
	
	public List<IncidentType> getIncidentTypeList() throws BusinessException;
	
	public List<Branch> getBranchList() throws BusinessException;
	
	public Boolean saveIncidentLog(IncidentLog incLog) throws BusinessException;
	
	public Branch getBranch(Long branchId) throws BusinessException;
	
	public IncidentType getIncidentType(Long incTypeId) throws BusinessException;
	
	public Integer incidentLogCount() throws BusinessException;
	
	
}
