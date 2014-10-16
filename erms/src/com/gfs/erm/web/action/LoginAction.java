package com.gfs.erm.web.action;

import java.util.Map;

import org.apache.struts2.interceptor.CookiesAware;

import com.gfs.erm.util.SessionUtil;
import com.gfs.erm.web.common.WebConstants;

public class LoginAction extends BaseAction implements CookiesAware{
    
	private static final long serialVersionUID = -389833745243649130L;
	/** Current username */
    private String username;
    /** Current password of user */
    private String password;
    /** Remeber mer */
    private boolean rememberMe;
    
	public String execute()
    {
		
		return SUCCESS;
	}
    
    /**
	 * LogIn Check
	 */
	public String checkLogin() throws Exception
    {
		if(SessionUtil.getCookie(servletRequest,WebConstants.CURRENT_USER_SESSION) !=null){
			// add userName to the session
	    	String[] userValue=SessionUtil.getCookieValue(servletRequest, WebConstants.CURRENT_USER_SESSION);
	    	username=userValue[0];
	    	password=userValue[1];
	    	rememberMe=false;
	    	return SUCCESS; // forward to login Form
	 		
		}	
		// in other cases, return login page
        return ERROR;
		
		
    }
	
	
	/**
	 * Logout
	 */
	public String logout() throws Exception
    {
		// remove userName from the session
        if (session.containsKey(WebConstants.LOGGED_USER_ID)) {
            session.clear();
        }
		addActionMessage("Logout Successfully!!");
		//message.put("warning", "Logout Successfully");
		return SUCCESS;
	}

	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the rememberMe
	 */
	public boolean isRememberMe() {
		return rememberMe;
	}

	/**
	 * @param rememberMe the rememberMe to set
	 */
	public void setRememberMe(boolean rememberMe) {
		this.rememberMe = rememberMe;
	}

	@Override
	public void setCookiesMap(Map<String, String> arg0) {
		// TODO Auto-generated method stub
		
	}

	
    
}
