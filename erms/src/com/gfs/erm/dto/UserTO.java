package com.gfs.erm.dto;

public class UserTO extends BaseTO{  
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -1942247880617135497L;
	private String userName;  
	 private String userPass;
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the userPass
	 */
	public String getUserPass() {
		return userPass;
	}
	/**
	 * @param userPass the userPass to set
	 */
	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}
	 
	 
	
	
} 