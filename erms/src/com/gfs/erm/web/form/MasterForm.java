package com.gfs.erm.web.form;

import org.springframework.beans.factory.annotation.Autowired;

import com.gfs.erm.web.delegate.MasterDelegate;

/**
 * This class handle the data of Master Form 
 */

public class MasterForm extends BaseForm{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 9134914650899505946L;
	
   	
	@Autowired
	private MasterDelegate masterDelegate;
      
    public String execute()
    {
    	        
        
        return SUCCESS;
    	
    }

	/**
	 * @return the masterDelegate
	 */
	public MasterDelegate getMasterDelegate() {
		return masterDelegate;
	}

	/**
	 * @param masterDelegate the masterDelegate to set
	 */
	public void setMasterDelegate(MasterDelegate masterDelegate) {
		this.masterDelegate = masterDelegate;
	}

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		
	}
    
    

	
}
