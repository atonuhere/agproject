package com.gfs.erm.model.dao;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gfs.erm.exception.DataAccessException;
import com.gfs.erm.model.bo.IncidentStatus;

@Repository("incidentStatusDao")
public class IncidentStatusDaoImpl extends AbstractFacade<IncidentStatus> implements IncidentStatusDao{

	protected IncidentStatusDaoImpl() {
		super(IncidentStatus.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional(readOnly = true)
	public List<IncidentStatus> getList() throws DataAccessException{
		// TODO Auto-generated method stub
		try{
			return findAll(Order.asc("id"));
		}catch(Exception e){
			throw new DataAccessException(e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public IncidentStatus get(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return find(id);
	}

	@Override
	public Boolean saveEntity(IncidentStatus t) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer count() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
