package com.gfs.erm.web.action;

import org.springframework.beans.factory.annotation.Autowired;

import com.gfs.erm.model.bo.User;
import com.gfs.erm.model.service.UserService;
import com.gfs.erm.dto.UserTO;
import com.gfs.erm.exception.UserAlreadyExistsException;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class UserAction extends ActionSupport implements ModelDriven<UserTO>{
    private static final long serialVersionUID = 7021982816578678150L;

    @Autowired
    private UserTO userTO;
    
    @Autowired
    private UserService userService;

    public String execute() throws Exception {
        
        try {
            if(userTO!=null){
	        	User user=new User();
	        	
	            user.setUserName(userTO.getUserName());
	            user.setPassword(userTO.getUserPass());
	            //user.setUserAge(userTO.getUserAge());
	            //user.setUserGender(userTO.getUserGender());
	            //user.setUserHobbies(userBean.getUserHobbies().);
	            //user.setUserJobType(userTO.getUserJob());
	        	
	            userService.addUser(user);
            }else{
            	return INPUT;
            }
             
        } catch (UserAlreadyExistsException e) {
            return INPUT;
        }
        return SUCCESS;
    }

	/**
	 * @return the userService
	 */
	public UserService getUserService() {
		return userService;
	}

	/**
	 * @param userService the userService to set
	 */
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@Override
	public UserTO getModel() {
		// TODO Auto-generated method stub
		return null;
	}

	public UserTO getUserTO() {
		return userTO;
	}

	public void setUserTO(UserTO userTO) {
		this.userTO = userTO;
	}

  
}
