package com.gfs.erm.web.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.gfs.erm.model.service.MasterService;
import com.gfs.erm.web.delegate.MasterDelegate;

public class MasterAction extends BaseAction{
    
	private static final long serialVersionUID = -389833745243649130L;

	@Autowired
	private MasterDelegate masterDelegate;
	
	@Autowired
	private MasterService masterService;
	
	public MasterAction(){
		
	}
	
	public String execute()
    {
		menu="master";
		return SUCCESS;
    	
    }
	public String roles()
    {
		
		return SUCCESS;
    	
    }
	public String branches()
    {
		
		return SUCCESS;
    	
    }
	public String modules()
    {
		
		return SUCCESS;
    	
    }
	public String permissions()
    {
		
		return SUCCESS;
    	
    }
	public String system()
    {
		
		return SUCCESS;
    	
    }
	public String view()
    {
		
		return SUCCESS;
    	
    }
	public String update()
    {
		
		return SUCCESS;
    	
    }
	public String delete()
    {
		
		return SUCCESS;
    	
    }
	public String add()
    {
		
		return SUCCESS;
    	
    }
	
	
   
    
}
