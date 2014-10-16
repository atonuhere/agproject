package com.gfs.erm.model.service;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  

import com.gfs.erm.dto.EventTO;
import com.gfs.erm.exception.BusinessException;
import com.gfs.erm.model.dao.EventLogDao;

@Service("eventService")   
public class EventServiceImpl implements EventService {  
    
	@Autowired
	private EventLogDao eventLogDao;

	@Override
	public EventTO insertEvent(int type, String summary, String content,
			String username, Throwable e) throws BusinessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventTO getEvent(int type, String summary, String content,
			String username, Throwable e) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the eventLogDao
	 */
	public EventLogDao getEventLogDao() {
		return eventLogDao;
	}

	/**
	 * @param eventLogDao the eventLogDao to set
	 */
	public void setEventLogDao(EventLogDao eventLogDao) {
		this.eventLogDao = eventLogDao;
	}

	
}
