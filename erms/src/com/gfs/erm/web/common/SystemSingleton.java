package com.gfs.erm.web.common;

public class SystemSingleton {

    private static SystemSingleton myInstance;

    private static String timerStatus;
    
    private static String publicDownload;
    
    private static String systemProtocol;
    
    private static String defaultEncoding;
    
    private SystemSingleton() {
    }
    
    
    public static SystemSingleton getInstance(){
          if(myInstance == null) {
               myInstance = new SystemSingleton();
          }
          return myInstance;
    }

    
	
    ////////////////////////////////////////
	public String getTimerStatus() {
		return timerStatus;
	}
	public void setTimerStatus(String newValue) {
		SystemSingleton.timerStatus = newValue;
	}
	
	
    ////////////////////////////////////////
	public String getPublicDownload() {
		return publicDownload;
	}
	public void setPublicDownload(String newValue) {
		SystemSingleton.publicDownload = newValue;
	}

	
	////////////////////////////////////////
	public String getSystemProtocol() {
		return systemProtocol;
	}
	public void setSystemProtocol(String newValue) {
		SystemSingleton.systemProtocol = newValue;
	}
	
	////////////////////////////////////////
	public String getDefaultEncoding() {
		return defaultEncoding;
	}
	public void setDefaultEncoding(String newValue) {
		SystemSingleton.defaultEncoding = newValue;
	}
	
	
		
}
