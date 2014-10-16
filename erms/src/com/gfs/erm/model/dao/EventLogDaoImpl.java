package com.gfs.erm.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.gfs.erm.model.bo.EventLog;

@Repository("eventLogDao")
public class EventLogDaoImpl extends AbstractFacade<EventLog> implements EventLogDao {
    
	protected EventLogDaoImpl() {
		super(EventLog.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("rawtypes")
	@Override
	public List getAuditableFields() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPrimaryField() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAuditMessage() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
