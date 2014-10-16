package com.gfs.erm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.StrutsStatics;
import com.gfs.erm.web.common.WebConstants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class LoginInterceptor extends AbstractInterceptor implements StrutsStatics {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 3746631322913902648L;
	private static final Log log = LogFactory.getLog(LoginInterceptor.class);
	HttpSession session;
	@Override
	 public void init() {
	  log.info("Intializing LoginInterceptor");
	 }

	 public void destroy() {
	 }
	 
	 @Override
	 public String intercept(ActionInvocation invocation) throws Exception {

		  final ActionContext context = invocation.getInvocationContext();
		  HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
		  session = request.getSession(true);
		 	  
		  // Is there a "user" object stored in the user's HttpSession?
		  if(session!=null){	
			  
			  Long userId = (Long) session.getAttribute(WebConstants.LOGGED_USER_ID);
			  if ( userId != null) {
				 
				  if(userId >= 0){
					  return invocation.invoke();
				  } else
					  return "login-fail";
				  
			  } else {
				
				 // Is the user attempting to log in right now?
				 String loginAttempt = request.getParameter(WebConstants.LOGIN_ATTEMPT);
				 /* The user is attempting to log in. */
				 if (!StringUtils.isBlank(loginAttempt)) {
					 return invocation.invoke();
				 }
				
				 return "login-fail";
			  }
		  }else{
			  return "login-fail";
		  }
	 }

	public HttpSession getSession() {
		return session;
	}

	public void setSession(HttpSession session) {
		this.session = session;
	}

	

}