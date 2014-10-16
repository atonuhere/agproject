package com.gfs.erm.web.action;

public class HomeAction extends BaseAction{
    
	private static final long serialVersionUID = -389833745243649130L;

   
	public HomeAction(){
		
	}
	
	public String execute()
    {
		menu="home";
		return SUCCESS;
    	
    }
	
	public String errorProcess()
    {
		Integer statusCode=0;
		// Analyze the servlet exception
        Throwable throwable = (Throwable) servletRequest.getAttribute("javax.servlet.error.exception");
        statusCode = (Integer) servletRequest.getAttribute("javax.servlet.error.status_code");
        String servletName = (String) servletRequest.getAttribute("javax.servlet.error.servlet_name");
        if (servletName == null) {
            servletName = "Unknown";
        }
        String requestUri = (String) servletRequest.getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }
        if(statusCode != 500){
        	message+="<h3>Error Details</h3>";
        	message+="<strong>Status Code</strong>:"+statusCode+"<br>";
        	message+="<strong>Requested URI</strong>:"+requestUri;
        }else{
        	message+="<h3>Exception Details</h3>";
        	message+="<ul><li>Servlet Name:"+servletName+"</li>";
        	message+="<li>Exception Name:"+throwable.getClass().getName()+"</li>";
        	message+="<li>Requested URI:"+requestUri+"</li>";
        	message+="<li>Exception Message:"+throwable.getMessage()+"</li>";
        	message+="</ul>";
        }
        
        
		return SUCCESS;
    	
    }
	
	public String error404()
    {
		return SUCCESS;
    }
	
	public String errorException()
    {
		return SUCCESS;
    }
   
    
}
