package com.gfs.erm.util;

public interface PageNavigator {
	   
	public String buildPageNav(String path, int resultSize, int page, int pageSize, String element);
        
    public int getStart(); 
    public int getEnd(); 
}
