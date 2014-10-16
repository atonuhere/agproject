package com.gfs.erm.web.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.gfs.erm.util.Pager;
import com.gfs.erm.util.StringUtil;
import com.gfs.erm.web.common.WebConstants;
import com.gfs.erm.web.form.GeneralErrorForm;
import com.gfs.erm.web.form.GeneralSuccessForm;
import com.opensymphony.xwork2.ActionSupport;

public abstract class BaseAction extends ActionSupport implements RequestAware, SessionAware, ApplicationAware, ServletRequestAware,ServletResponseAware{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	protected List<?> dataList=new ArrayList<>();
	
	/* Current Paging Data List */
	protected Pager<?> dataPage=new Pager<>();;
	/* Current Data */
	protected Object dataObj=new Object();
	/* Current Data Array*/
	protected Map<String, Object> dataArr=new HashMap<String, Object>();
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
		ResourceBundle bundle = ResourceBundle.getBundle("messages_en", servletRequest.getLocale());
		servletRequest.getSession().setAttribute("bundle", bundle);
	}
    
	
	public abstract String execute(); 
	
	protected void setRequestAttribute(String key, Object obj) {
		servletRequest.setAttribute(key, obj);
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

	/**
	 * @return the rootpath
	 */
	public String getRootpath() {
		return rootpath;
	}

	/**
	 * @param rootpath the rootpath to set
	 */
	public void setRootpath(String rootpath) {
		this.rootpath = rootpath;
	}

	/**
	 * @return the permissions
	 */
	public HashMap<String, Boolean> getPermissions() {
		return permissions;
	}

	/**
	 * @param permissions the permissions to set
	 */
	public void setPermissions(HashMap<String, Boolean> permissions) {
		this.permissions = permissions;
	}

	/**
	 * @return the module
	 */
	public String getModule() {
		return module;
	}

	/**
	 * @param module the module to set
	 */
	public void setModule(String module) {
		this.module = module;
	}

	/**
	 * @return the actionName
	 */
	public String getActionName() {
		return actionName;
	}

	/**
	 * @param actionName the actionName to set
	 */
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	/**
	 * @return the roleId
	 */
	public Long getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
	}

	/**
	 * @return the curBranch
	 */
	public Long getCurBranch() {
		return curBranch;
	}

	/**
	 * @param curBranch the curBranch to set
	 */
	public void setCurBranch(Long curBranch) {
		this.curBranch = curBranch;
	}

	/**
	 * @return the control
	 */
	public String getControl() {
		return control;
	}

	/**
	 * @param control the control to set
	 */
	public void setControl(String control) {
		this.control = control;
	}

	/**
	 * @return the menu
	 */
	public String getMenu() {
		return menu;
	}

	/**
	 * @param menu the menu to set
	 */
	public void setMenu(String menu) {
		this.menu = menu;
	}

	/**
	 * @return the submenu
	 */
	public String getSubmenu() {
		return submenu;
	}

	/**
	 * @param submenu the submenu to set
	 */
	public void setSubmenu(String submenu) {
		this.submenu = submenu;
	}

	/**
	 * @return the step
	 */
	public Integer getStep() {
		return step;
	}

	/**
	 * @param step the step to set
	 */
	public void setStep(Integer step) {
		this.step = step;
	}

	/**
	 * @return the page
	 */
	public Integer getPage() {
		return page;
	}

	/**
	 * @param page the page to set
	 */
	public void setPage(Integer page) {
		this.page = page;
	}

	/**
	 * @return the pagingString
	 */
	public String getPagingString() {
		return pagingString;
	}

	/**
	 * @param pagingString the pagingString to set
	 */
	public void setPagingString(String pagingString) {
		this.pagingString = pagingString;
	}

	/**
	 * @return the ajaxPath
	 */
	public String getAjaxPath() {
		return ajaxPath;
	}

	/**
	 * @param ajaxPath the ajaxPath to set
	 */
	public void setAjaxPath(String ajaxPath) {
		this.ajaxPath = ajaxPath;
	}

	/**
	 * @return the elementId
	 */
	public String getElementId() {
		return elementId;
	}

	/**
	 * @param elementId the elementId to set
	 */
	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	/**
	 * @return the searchString
	 */
	public String getSearchString() {
		return searchString;
	}

	/**
	 * @param searchString the searchString to set
	 */
	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	/**
	 * @return the sort
	 */
	public String getSort() {
		return sort;
	}

	/**
	 * @param sort the sort to set
	 */
	public void setSort(String sort) {
		this.sort = sort;
	}

	/**
	 * @return the order
	 */
	public String getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(String order) {
		this.order = order;
	}

	/**
	 * @return the dorder
	 */
	public String getDorder() {
		return dorder;
	}

	/**
	 * @param dorder the dorder to set
	 */
	public void setDorder(String dorder) {
		this.dorder = dorder;
	}

	/**
	 * @return the records
	 */
	public Integer getRecords() {
		return records;
	}

	/**
	 * @param records the records to set
	 */
	public void setRecords(Integer records) {
		this.records = records;
	}

	/**
	 * @return the dataList
	 */
	public List<?> getDataList() {
		return dataList;
	}

	/**
	 * @param dataList the dataList to set
	 */
	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}

	/**
	 * @return the dataObj
	 */
	public Object getDataObj() {
		return dataObj;
	}

	/**
	 * @param dataObj the dataObj to set
	 */
	public void setDataObj(Object dataObj) {
		this.dataObj = dataObj;
	}

	/**
	 * @return the dataArr
	 */
	public Map<String, Object> getDataArr() {
		return dataArr;
	}

	/**
	 * @param dataArr the dataArr to set
	 */
	public void setDataArr(Map<String, Object> dataArr) {
		this.dataArr = dataArr;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the ajax
	 */
	public boolean isAjax() {
		return ajax;
	}

	/**
	 * @param ajax the ajax to set
	 */
	public void setAjax(boolean ajax) {
		this.ajax = ajax;
	}

	/**
	 * @return the checkNotification
	 */
	public Integer getCheckNotification() {
		return checkNotification;
	}

	/**
	 * @param checkNotification the checkNotification to set
	 */
	public void setCheckNotification(Integer checkNotification) {
		this.checkNotification = checkNotification;
	}

	/**
	 * @return the totalrows
	 */
	public Integer getTotalrows() {
		return totalrows;
	}

	/**
	 * @param totalrows the totalrows to set
	 */
	public void setTotalrows(Integer totalrows) {
		this.totalrows = totalrows;
	}

	/**
	 * @return the check
	 */
	public int getCheck() {
		return check;
	}

	/**
	 * @param check the check to set
	 */
	public void setCheck(int check) {
		this.check = check;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the dataPage
	 */
	public Pager<?> getDataPage() {
		return dataPage;
	}

	/**
	 * @param dataPage the dataPage to set
	 */
	public void setDataPage(Pager<?> dataPage) {
		this.dataPage = dataPage;
	}

	
	
	
}
