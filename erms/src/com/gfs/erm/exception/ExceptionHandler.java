package com.gfs.erm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.gfs.erm.web.common.WebConstants;
import com.gfs.erm.util.Mailer;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.ExceptionHolder;
import com.opensymphony.xwork2.interceptor.ExceptionMappingInterceptor;
import org.apache.struts2.StrutsStatics;

public class ExceptionHandler extends ExceptionMappingInterceptor {

    /**
	 * 
	 */
	private static final long serialVersionUID = -3552948863906136672L;
	public HttpServletRequest request;
	public HttpSession session;
	
    @Override
	protected void publishException(ActionInvocation invocation, ExceptionHolder exceptionHolder) {
    	final ActionContext context = invocation.getInvocationContext();
    	try {
    		request = (HttpServletRequest) context.get(StrutsStatics.HTTP_REQUEST);
   			session = request.getSession(true);
   			String ipAddress = request.getHeader("X-FORWARDED-FOR");  
   			if (ipAddress == null) {  
    	       ipAddress = request.getRemoteAddr();  
   			}
   			String userMail=session.getAttribute(WebConstants.LOGGED_USER_EMAIL).toString();
   			
   			// Mail if Exception occurs
            Mailer mail= new Mailer();
    		mail.send(WebConstants.AdminMail,"Ims Exception Log","User Mail: "+userMail+" User IP: "+ipAddress+" <br/><br/>"+exceptionHolder.getExceptionStack().toString());
            //HibUtil.rollback();
       } catch (Exception e) {
            //
       }

        super.publishException(invocation, exceptionHolder);
    }
}
