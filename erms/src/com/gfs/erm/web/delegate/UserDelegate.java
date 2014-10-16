package com.gfs.erm.web.delegate;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.gfs.erm.dto.UserTO;
import com.gfs.erm.model.bo.User;
import com.gfs.erm.model.service.UserService;
import com.gfs.erm.web.delegate.GeneralDelegate;
import com.gfs.erm.exception.BusinessException;

@Repository("userDelegate")
@Scope("singleton")
public class UserDelegate extends GeneralDelegate {
	
	/** The Business object related with current delegate */
	@Autowired
	private UserService userService;
	
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

	public Vector<UserTO> getUserList(){
		Vector<UserTO> users=new Vector<UserTO>();
		List<User> userList=new ArrayList<User>();
		try {
			userList = userService.getUserList();
			for(int i=0; i< userList.size(); i++){
				UserTO userto= new UserTO();
				userto.setId(userList.get(i).getId());
				
				users.add(userto);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			new BusinessException(e);
		}
		
		return users;
		
	}
	
	public UserTO getUser(String username){
		UserTO userTo=new UserTO();
		try {
			User user = userService.getUser(username);
			if(user!=null){
				userTo.setId(user.getId());
				userTo.setUserName(user.getUserName());
				//userTo.setUserAge(user.getUserAge());
				userTo.setUserPass(user.getPassword());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			new BusinessException(e);
		}
		
		return userTo;
		
	}
	public UserTO authenticate(String username,String password){
		UserTO userTo=null;
		try {
			User user = userService.authenticate(username, password);
			if(user!=null){
				userTo= new UserTO();
				userTo.setId(user.getId());
				userTo.setUserName(user.getUserName());
				//userTo.setUserAge(user.getUserAge());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			new BusinessException(e);
		}
		
		return userTo;
		
	}
	
	public List<User> userList(){
		List<User> userList=null;
		try {
			userList=userService.getUserList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			new BusinessException(e);
		}
		
		return userList;
		
	}
	
	

}
