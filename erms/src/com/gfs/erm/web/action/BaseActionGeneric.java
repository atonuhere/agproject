package com.gfs.erm.web.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.gfs.erm.exception.SystemsException;
import com.gfs.erm.util.Page;
import com.gfs.erm.util.StringUtil;
import com.gfs.erm.web.common.WebConstants;
import com.gfs.erm.web.form.GeneralErrorForm;
import com.gfs.erm.web.form.GeneralSuccessForm;

/**
 * @author Atonu Ganguly
 * 
 */
public abstract class BaseActionGeneric<T> extends ActionSupport implements RequestAware, SessionAware, ApplicationAware, ServletRequestAware,ServletResponseAware {

	private static final long serialVersionUID = -8209196735097293008L;

	/** Root path */
	protected String rootpath="/erms/";
	/** Current Permissions **/
	protected HashMap<String, Boolean> permissions;
	/* Current Module */
	protected String module="";
	/* Current Action */
	protected String actionName="";
	/* Current Role */
	protected Long roleId=0l;
	/* Current User Id */
	protected Long userId=0l;
	/* Current Branch */
	protected Long curBranch=1l;
	/** Current control */
	protected String control="";
	/** Current menu */
	protected String menu="";
	/** Current submenu */
	protected String submenu="";
	/** Current step */
	protected Integer step=1;
    //Get the requested page. By default grid sets this to 1.
	protected Integer page=1;
    /* Current Paging */
	protected String pagingString="";
	/* Current AjaxPath */
	protected String ajaxPath="";
	/* Current Element to update */
	protected String elementId="dispTable_List";
	/* Current search string when pagination call */
	protected String searchString="";
	// sorting order - asc or desc
	protected String  sort=WebConstants.DEFAULT_COLUMN;
    // get index row - i.e. user click to sort.
	protected String order=WebConstants.DEFAULT_SORT;
	// get index row - i.e. user click to sort.
	protected String dorder=WebConstants.DEFAULT_DSORT;
	// All Record
	protected Integer records=0;
	
	/* Current Data List */
	protected List<?> dataList=null;
	/* Current Data */
	protected Object dataObj=new Object();
	/* Current Data Array*/
	protected Map<String, Object> dataArr=null;
	/* Current Message */
	protected String message="";
	/* Check Request */
	protected boolean ajax=false;
	
	protected Integer checkNotification=1;
	
	// Extra variables
	protected Integer totalrows=0;
	//Check some value
	protected int check=0;
	//current Id
	protected Long id=0l;
	
	protected Map<String, Object> request;  
    protected Map<String, Object> session;  
    protected Map<String, Object> application;
    
    protected HttpServletRequest servletRequest;  
    protected HttpSession servletSession; 
    protected HttpServletResponse servletResponse; 
  
    public Map<String, Object> getRequest() {  
        return request;  
    }  
  
    public Map<String, Object> getSession() {  
        return session;  
    }  
  
    public Map<String, Object> getApplication() {  
        return application;  
    }  
  
    @Override
	public void setServletRequest(HttpServletRequest arg0) {
		// TODO Auto-generated method stub
		this.servletRequest=arg0;
		
	}

	@Override
	public void setServletResponse(HttpServletResponse arg0) {
		// TODO Auto-generated method stub
		this.servletResponse=arg0;
		
	}  
  
	@Override  
    public void setApplication(Map<String, Object> application) {  
        this.application = application; 
       
    }
	
	@Override  
    public void setSession(Map<String, Object> session) {  
        this.session = session; 
       
    }  
      
	@Override  
    public void setRequest(Map<String, Object> request) {  
        this.request = request;
        this.setBaseVariable();
       
    }
   
	
    // 	perform base variables to be stored in each request action
	public void setBaseVariable() {
		// perform secure action
		module = ServletActionContext.getActionMapping().getNamespace();
		actionName=ServletActionContext.getActionMapping().getName();
		
		if (session.containsKey(WebConstants.LOGGED_USER_ID)) {
			userId= (Long) session.get(WebConstants.LOGGED_USER_ID);
		}
		
		if (session.containsKey(WebConstants.BRANCH_HANDLE_ID)) {
			curBranch= (Long) session.get(WebConstants.BRANCH_HANDLE_ID);
		}
		
		if (session.containsKey(WebConstants.ROLE_HANDLE)) {
			roleId= (Long) session.get(WebConstants.ROLE_HANDLE);
		}
		//setting flag if request is ajax
		ajax = "XMLHttpRequest".equals(servletRequest.getHeader("X-Requested-With"));
		
	}
    
	
	public abstract String execute() throws SystemsException; 
	
	protected void setRequestAttribute(String key, Object obj) {
		servletRequest.setAttribute(key, obj);
	 }
	 
	 /**
	  * Returns generic Page instance.
	  * @param domain
	  * @param DTO
	  * @return
	  */
	 protected Page<T> getRequestedPage(Integer page){
	      Page<T> requestedPage = new Page<T>(); 
	      requestedPage.setPage(page);
	      requestedPage.setRows(WebConstants.RECORDS_PER_PAGE);
	      return requestedPage;
	 }
	
	/**
	  * into http session, the errorForm bean to be used on generic error form.  
	  * @param request The request
	  * @param errorMessage The key message in bundle to display
	  * @param exceptionMessage The exception message to display in source 
	  */
	public void setErrorSession(String errMsg, Exception e) {
		setBaseVariable();
		clearMessages();
		setErrorSession(servletRequest, errMsg, null, null, null, null, null, e);
	}

	public void setErrorSession(HttpServletRequest request, String errMsg, String arg0, String arg1, String arg2, String arg3, String arg4, Exception e) {
		try {
			GeneralErrorForm errFrm = new GeneralErrorForm();
			errFrm.setErrorMessage(errMsg, arg0, arg1, arg2, arg3, arg4);
			if (e!=null){
			    if (e.getMessage()==null) {
			        errFrm.setExceptionMessage(e.toString());    
			    } else {
			        errFrm.setExceptionMessage(e.getMessage());
			    }
			    errFrm.setStackTrace(StringUtil.getStackTraceToString(e));
			}
			request.getSession().setAttribute("errorAction", errFrm);
			request.getSession().removeAttribute("successAction");
		
		}catch(Exception ee) {
			ee.printStackTrace();
		}
	}
	
	/**
	  * Auxiliar Method. Set into http session, the successForm bean to be used on forms to show a successfully message.  
	  * @param request The request
	  * @param successMessage The key message in bundle to display
	  */
	public void setSuccessSession(String successMessage) {
		try {
			GeneralSuccessForm succFrm = new GeneralSuccessForm();
			succFrm.setSuccessMessage(successMessage);
			servletRequest.getSession().setAttribute("successAction", succFrm);
			servletRequest.getSession().removeAttribute("errorAction");
		}catch(Exception ee) {
			ee.printStackTrace();
		}			
	}

	/**
	 * Clear error and success objects from http session
	 * @param request
	 */
	protected void clearMessages(HttpServletRequest request){
		try {
			request.getSession().removeAttribute("errorAction");
			request.getSession().removeAttribute("successAction");
		}catch(Exception ee) {
			ee.printStackTrace();
		}
	}

	

}
