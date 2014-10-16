package com.gfs.erm.model.dao;

import java.util.List;

import com.gfs.erm.dto.IncidentLogTO;
import com.gfs.erm.exception.DataAccessException;
import com.gfs.erm.util.Page;
import com.gfs.erm.model.bo.IncidentLog;

public interface IncidentLogDao extends GeneralDao<IncidentLog, Long>{
	  
	public List<IncidentLog> getList(Integer incStatusId) throws DataAccessException;
	public List<IncidentLog> getList(int start, int end,String order, String sort) throws DataAccessException;
	/**
	  * Returns search results for a given search criteria.
	  * @param searchCriteria
	  * @param page
	  * @return
	  * @throws DataAccessException
	  */
	  public Page<IncidentLog> findByCriteria(IncidentLogTO searchCriteria, Page<IncidentLog> page) throws DataAccessException;
}
