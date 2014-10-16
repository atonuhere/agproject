package com.gfs.erm.interceptor;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.StrutsStatics;
import org.apache.struts2.dispatcher.SessionMap;

import com.gfs.erm.web.common.WebConstants;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;



public class AccessRoleInterceptor extends AbstractInterceptor implements StrutsStatics {

	 /**
	 * 
	 */
	private static final long serialVersionUID = 3746631322913902648L;
	private String excludeMethod=""; 
	
	public void init() {
		//log.info("Intializing RolesInterceptor");
	}

	 public void destroy() {
	 
	 }

	 public String intercept(ActionInvocation invocation) throws Exception {

		final ActionContext context = invocation.getInvocationContext();
		HttpServletRequest request = (HttpServletRequest) context.get(HTTP_REQUEST);
		SessionMap<String,Object> session= (SessionMap<String,Object>) ActionContext.getContext().getSession();
		String namespace=invocation.getProxy().getNamespace();
		// Is there a "roleId" object stored in the user's HttpSession?
		if(session!=null){
			Long roleId = (Long) session.get(WebConstants.ROLE_HANDLE);
			System.out.println("role"+roleId);
			if (roleId != null) {
				
				if(roleId >=0){
					if(roleId ==0){
						return invocation.invoke(); ///Admin Role Permission
					}
					else{
						//if(checkRolePermissionInterceptor(roleId, namespace, session ))
							return invocation.invoke(); ///Admin Role Permission
						//else
						//	return "role-fail";	
					}
				}
				else
					return "role-fail";			
			 
			} else {
				// The user without any role.
				return "role-fail";
			}
		}else
			return "role-fail";
	 }

	public String getExcludeMethod() {
		return excludeMethod;
	}

	public void setExcludeMethod(String excludeMethod) {
		this.excludeMethod = excludeMethod;
	}

	
	/*@SuppressWarnings({ "unchecked", "rawtypes" })
	public Boolean checkRolePermissionInterceptor(Long roleId, String namespace, SessionMap<String,Object> session ) {
	    	Boolean check=false;
	    	if(session != null){
	    		//System.out.println("PERMISSION_HANDLE---------"+session.get(IMSConstants.PERMISSION_HANDLE));
	    		session= (SessionMap) ActionContext.getContext().getSession();
	    		List<AccessPermissions> apList= (List<AccessPermissions> ) session.get(IMSConstants.PERMISSION_HANDLE);
	    		if(apList !=null ){
	    			check=findPermissionMatch(apList, namespace);
	    		}
	    	}	
	    	
	    	return check;
	    }

	
	public Boolean findPermissionMatch(List<AccessPermissions> permissions, String searchTerm) {
    	Boolean result = false;
        for (AccessPermissions permission : permissions) {
            if ( permission.getModule().getClassUrl().contains(searchTerm) ) 
            	result=true;
        }
        return result;
    }*/
	
}