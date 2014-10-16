package com.gfs.erm.util;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Locale;
import java.util.Vector;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gfs.erm.dto.EventTO;
import com.gfs.erm.dto.UserTO;
import com.gfs.erm.web.common.SystemSingleton;
import com.gfs.erm.web.common.WebConstants;

/**
 * This class contain util methods to handler http session.
 */
public final class SessionUtil {

	private static HashMap<String,EventTO> lastEventList;
	
	private static Vector<EventTO> events;
	
	
	/**
	 * The constructor was set to private to avoid instancing creation  
	 */
	private SessionUtil(){}
	
	/**
	 * Get current UserTO from http session (connected on system)
	 */
	public static UserTO getCurrentUser(HttpServletRequest request){
	    return (UserTO)request.getSession().getAttribute(WebConstants.CURRENT_USER_SESSION);
	}

	/**
	 * Get current locale based on current user connected
	 */
	public static Locale getCurrentLocale(HttpServletRequest request){
	    return (request.getLocale());
	}

	
	public static void addEvent(UserTO uto, String event){
		if (uto!=null && uto.getId()!=null) {
			if (lastEventList==null) {
				lastEventList = new HashMap<String,EventTO>();
				events = new Vector<EventTO>();
			}
			try {
				lastEventList.remove(uto.getId());
			} catch (Exception e) {
				//it is not necessary...
			}

			//keep event max log = 200 records...
			if (events.size()>200) {
				for (int i=0; i<events.size()-200; i++) {
					events.remove(0);
				}
			}
			
			EventTO eto = new EventTO();
			eto.setCreationDate(DateUtil.getNow());
			eto.setDescription(event);
			eto.setUsername(uto.getUserName());
			eto.setSummary(LogUtil.SUMMARY_USER_ACTION);
			
			lastEventList.put(uto.getId().toString(), eto);
			events.addElement(eto);
		}
	}

	public static HashMap<String,EventTO> getLastEvents(){
		return lastEventList;
	}

	public static Vector<EventTO> getEvents(){
		return events;
	}
	
	
	public static String getUri(HttpServletRequest request){
	    String hst = request.getServerName();
	    String prt = request.getServerPort()+"";
		String protoc = SystemSingleton.getInstance().getSystemProtocol();
	    
	    if (!prt.equals("0")) {
	        prt = ":" + prt; 
	    } else {
	        prt = "";
	    }
	    return protoc + "://" + hst + prt;
	}
	
	
    public static String getUID(String sessionId) {
        String strRetVal = "";
        String strTemp = "";
        try {
        	
            //Get IdentityHash() segment
            strTemp = Long.toHexString(System.identityHashCode(sessionId));
            while (strTemp.length() < 8) {
                strTemp = '0' + strTemp;
            }
            strRetVal = strTemp + ":";

            //Get CurrentTimeMillis() segment
            strTemp = Long.toHexString(System.currentTimeMillis());
            while (strTemp.length() < 12) {
                strTemp = '0' + strTemp;
            }
            strRetVal += strTemp + ':';

            //Get Random Segment
            SecureRandom prng = SecureRandom.getInstance("SHA1PRNG");
            strTemp = Integer.toHexString(prng.nextInt());
            while (strTemp.length() < 8) {
                strTemp = '0' + strTemp;
            }
            strRetVal += strTemp.substring(4);

	    } catch (java.security.NoSuchAlgorithmException ex) {
	    	ex.printStackTrace();
	    }

        return strRetVal.toUpperCase();
	}
    

	public static Cookie getCookie(HttpServletRequest servletRequest,  String cookieName){  
		 Cookie cookies [] = servletRequest.getCookies();
		 Cookie myCookie = null;  
		 if (cookies != null)  
		 {  
			 for (int i = 0; i < cookies.length; i++)  
			 {  
				 if (cookies [i].getName().equals (cookieName))  
				 {  
					 myCookie = cookies[i];  
					 break;  
				 }  
			 }  
		 }  
		 return myCookie;  
	}
	
	public static String[] getCookieValue(HttpServletRequest servletRequest, String cookieName){  
		 Cookie cookies [] = servletRequest.getCookies();
		 Cookie myCookie = null;
		 String[] usercookie=null;
		 if (cookies != null)  
		 {  
			 for (int i = 0; i < cookies.length; i++)  
			 {  
				 if (cookies [i].getName().equals (cookieName))  
				 {  
					 myCookie = cookies[i];  
					 break;  
				 }  
			 }  
		 }  
		 String cookieValue= myCookie.getValue();
		 usercookie=cookieValue.split(",");
		 
		 return usercookie;
	}
	
	public static void saveCookie(HttpServletResponse servletResponse, String cookieName,String userName,String pass){
		// Save to cookie
		String cookieValue=" "+userName+" ,"+pass;
	    Cookie user = new Cookie(cookieName, cookieValue);
	    user.setMaxAge(60*60*24*365); // Make the cookie last a year
	    servletResponse.addCookie(user);
	}
    
}
