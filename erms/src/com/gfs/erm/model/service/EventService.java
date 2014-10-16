package com.gfs.erm.model.service;

import com.gfs.erm.dto.EventTO;
import com.gfs.erm.exception.BusinessException;

public interface EventService {
   
    public EventTO insertEvent(int type, String summary, String content, String username, Throwable e) throws BusinessException;

    public EventTO getEvent(int type, String summary, String content, String username, Throwable e) ;
    
   
}
