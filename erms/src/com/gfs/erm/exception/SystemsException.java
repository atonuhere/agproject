package com.gfs.erm.exception;

/**
 * This class represent a parent exception of system. 
 */
public class SystemsException extends Exception {
    
	private static final long serialVersionUID = 1L;
	
	/** Message from exception */
	private String errorMessage;
	
	
	/**
	 * Constructor
	 */
	public SystemsException(Exception e){
	    super(e.toString(), e.getCause());
	    
		//remove unecessary information of error message...
		String errorContent = e.toString();
		//errorContent = errorContent.replaceAll("com.pandora.exception.BusinessException: ", "");
		//errorContent = errorContent.replaceAll("com.pandora.exception.DataAccessException: ", "");
		
		this.errorMessage = errorContent;
		
	}

	/**
	 * Constructor
	 */
	public SystemsException(String msg){
		super(msg);
		this.errorMessage = msg;
	}
	
	
    //////////////////////////////////////////	
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String newValue) {
		errorMessage = newValue;
	}

}