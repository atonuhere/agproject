package com.gfs.erm.web.form;

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
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;

public abstract class BaseForm extends ActionSupport implements Preparable,RequestAware, SessionAware, ApplicationAware, ServletRequestAware,ServletResponseAware{

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
	protected List<?> dataList=new ArrayList<>();;
	
	/* Current Paging Data List */
	protected Pager<?> dataPage=new Pager<>();
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
    
	protected void setRequestAttribute(String key, Object obj) {
		servletRequest.setAttribute(key, obj);
	}
	
	public abstract String execute(); 
		
	public abstract void prepare();
		
	
	/**
	  * into http session, the errorForm bean to be used on generic error form.  
	  * @param request The request
	  * @param errorMessage The key message in bundle to display
	  * @param exceptionMessage The exception message to display in source 
	  */
	public void setErrorFormSession(String errMsg, Exception e) {
		setErrorFormSession(servletRequest, errMsg, null, null, null, null, null, e);
	}
	
	/**
	  * into http session, the errorForm bean to be used on generic error form.  
	  * @param request The request
	  * @param errorMessage The key message in bundle to display
	  * @param exceptionMessage The exception message to display in source 
	  */
	public void setErrorFormSession(String errMsg) {
		setErrorFormSession(servletRequest, errMsg, null, null, null, null, null, null);
	}

	public void setErrorFormSession(HttpServletRequest request, String errMsg, String arg0, String arg1, String arg2, String arg3, String arg4, Exception e) {
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
			}else{
				errFrm.setExceptionMessage(errMsg); 
			}
			request.getSession().setAttribute("errorForm", errFrm);
			request.getSession().removeAttribute("successForm");
		
		}catch(Exception ee) {
			ee.printStackTrace();
		}
	}
	
	/**
	  * Auxiliar Method. Set into http session, the successForm bean to be used on forms to show a successfully message.  
	  * @param request The request
	  * @param successMessage The key message in bundle to display
	  */
	public void setSuccessFormSession(String successMessage) {
		try {
			GeneralSuccessForm succFrm = new GeneralSuccessForm();
			succFrm.setSuccessMessage(successMessage);
			servletRequest.getSession().setAttribute("successForm", succFrm);
			servletRequest.getSession().removeAttribute("errorForm");
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
			request.getSession().removeAttribute("errorForm");
			request.getSession().removeAttribute("successForm");
		}catch(Exception ee) {
			ee.printStackTrace();
		}
	}

	public String getRootpath() {
		return rootpath;
	}

	public void setRootpath(String rootpath) {
		this.rootpath = rootpath;
	}

	public HashMap<String, Boolean> getPermissions() {
		return permissions;
	}

	public void setPermissions(HashMap<String, Boolean> permissions) {
		this.permissions = permissions;
	}

	public String getModule() {
		return module;
	}

	public void setModule(String module) {
		this.module = module;
	}

	public String getActionName() {
		return actionName;
	}

	public void setActionName(String actionName) {
		this.actionName = actionName;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getCurBranch() {
		return curBranch;
	}

	public void setCurBranch(Long curBranch) {
		this.curBranch = curBranch;
	}

	public String getControl() {
		return control;
	}

	public void setControl(String control) {
		this.control = control;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getSubmenu() {
		return submenu;
	}

	public void setSubmenu(String submenu) {
		this.submenu = submenu;
	}

	public Integer getStep() {
		return step;
	}

	public void setStep(Integer step) {
		this.step = step;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public String getPagingString() {
		return pagingString;
	}

	public void setPagingString(String pagingString) {
		this.pagingString = pagingString;
	}

	public String getAjaxPath() {
		return ajaxPath;
	}

	public void setAjaxPath(String ajaxPath) {
		this.ajaxPath = ajaxPath;
	}

	public String getElementId() {
		return elementId;
	}

	public void setElementId(String elementId) {
		this.elementId = elementId;
	}

	public String getSearchString() {
		return searchString;
	}

	public void setSearchString(String searchString) {
		this.searchString = searchString;
	}

	public String getSort() {
		return sort;
	}

	public void setSort(String sort) {
		this.sort = sort;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getDorder() {
		return dorder;
	}

	public void setDorder(String dorder) {
		this.dorder = dorder;
	}

	public Integer getRecords() {
		return records;
	}

	public void setRecords(Integer records) {
		this.records = records;
	}

	public List<?> getDataList() {
		return dataList;
	}

	public void setDataList(List<?> dataList) {
		this.dataList = dataList;
	}

	public Pager<?> getDataPage() {
		return dataPage;
	}

	public void setDataPage(Pager<?> dataPage) {
		this.dataPage = dataPage;
	}

	public Object getDataObj() {
		return dataObj;
	}

	public void setDataObj(Object dataObj) {
		this.dataObj = dataObj;
	}

	public Map<String, Object> getDataArr() {
		return dataArr;
	}

	public void setDataArr(Map<String, Object> dataArr) {
		this.dataArr = dataArr;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isAjax() {
		return ajax;
	}

	public void setAjax(boolean ajax) {
		this.ajax = ajax;
	}

	public Integer getCheckNotification() {
		return checkNotification;
	}

	public void setCheckNotification(Integer checkNotification) {
		this.checkNotification = checkNotification;
	}

	public Integer getTotalrows() {
		return totalrows;
	}

	public void setTotalrows(Integer totalrows) {
		this.totalrows = totalrows;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	

	
	
	
}
