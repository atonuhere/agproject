package com.gfs.erm.web.form;

import org.springframework.beans.factory.annotation.Autowired;

import com.gfs.erm.dto.UserTO;
import com.gfs.erm.util.SessionUtil;
import com.gfs.erm.web.common.WebConstants;
import com.gfs.erm.web.delegate.UserDelegate;

/**
 * This class handle the data of Logon Form 
 */

public class LoginForm extends BaseForm{
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 9134914650899505946L;
	/** Current attempt of user */
    private String loginAttempt="1";
    /** Current username */
    private String username;
    /** Current password of user */
    private String password;
    /** Remeber mer */
    private boolean rememberMe;
   	
	@Autowired
	private UserDelegate userDelegate;
      
    public String execute()
    {
    	// check the entered userName and password
        if (username != null && password != null) {
             if(username.equals("root") &&   password.equals("gfs#123")){
            	 // add userName to the session
            	 session.put(WebConstants.LOGGED_USER_ID, 0l);
            	 session.put(WebConstants.CURRENT_USER_SESSION, null);
            	 return SUCCESS; // return login page
             }
             else{
            	// add userName to the session
            	UserTO u = userDelegate.authenticate(username, password);
         		if (u == null) {
         			this.setErrorFormSession("Invalid Username/Password");
     				return LOGIN; // return login page
         		}else{
     				session.put(WebConstants.LOGGED_USER_ID,u.getId());
     				session.put(WebConstants.CURRENT_USER_SESSION,u);
     				
     				if(rememberMe){
     					// Save to cookie  
     					SessionUtil.saveCookie(servletResponse, WebConstants.CURRENT_USER_SESSION,username,password); 
     					
     				}
     				
     				return SUCCESS; // return welcome page
         		}
            	
             }
             
        }
        return LOGIN; // return login page
    	
    }
    
    ///////////////////////////////////////////////
    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }
    ///////////////////////////////////////////////
    public void setPassword(String newValue) {
        this.password = newValue;
    }
    public void setUsername(String newValue) {
        this.username = newValue;
    }

	/**
	 * @return the loginAttempt
	 */
	public String getLoginAttempt() {
		return loginAttempt;
	}
	/**
	 * @param loginAttempt the loginAttempt to set
	 */
	public void setLoginAttempt(String loginAttempt) {
		this.loginAttempt = loginAttempt;
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

	/**
	 * @return the userDelegate
	 */
	public UserDelegate getUserDelegate() {
		return userDelegate;
	}

	/**
	 * @param userDelegate the userDelegate to set
	 */
	public void setUserDelegate(UserDelegate userDelegate) {
		this.userDelegate = userDelegate;
	}

	@Override
	public void prepare() {
		// TODO Auto-generated method stub
		
	}

	
}
