package com.gfs.erm.web.common;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;

public class WebConstants {

	private static HttpServletRequest request = (HttpServletRequest) ActionContext.getContext().get(ServletActionContext.HTTP_REQUEST);

	public static final String LOGGED_USER_ID = "loggedOnUserId";
	public static final String LOGGED_USER_EMAIL = "loggedOnUserEmail";
	public static final String LOGGED_USER_FULL_NAME = "loggedOnUserFullName";
	public static final String ROLE_HANDLE = "roleId";
	public static final String BRANCH_HANDLE = "branchCode";
	public static final String BRANCH_HANDLE_ID = "branchId";
	public static final String BRANCH_HANDLE_MAP = "branchMap";
	public static final String NOTIFICATIONCOUNT = "notifyCount";
	public static final String PERMISSION_HANDLE = "permissionMap";
	public static final String LOGGED_USER_TYPE = "loggedOnUserType";
	
	public static final String CURRENT_USER_SESSION = "ermUserSession";
	
	public static final String ACTION_AJAX = "ajaxSuccess";
	public static final int PERSONNEL_TYPE_DIRECTOR = 1;
	public static final int PERSONNEL_TYPE_EMPLOYEE = 2;
	public static final int PERSONNEL_TYPE_NONEMPLOYEE = 3;

	public static final String LOG_OFF = "logOff";
	public static final String LOGIN_ATTEMPT = "loginAttempt";
	public static final int MAX_LOGIN_ATTEMPT = 3;
	public static final String LOGON_MESSAGE = "logonMessage";
	public static final String LOGOUT_MESSAGE = "logoutMessage";
	public static final String LOCAL_CURRENCY = "Local_Currency";
	public static final String SERVLET_CONTEXT_PATH = "/RMS";

	public static final String STATUS_ACTIVE = "Active";
	public static final String STATUS_EXPIRED = "Expired";
	public static final String STATUS_INACTIVE = "Inactive";
	public static final String PENDING_STATUS = "Pending";

	public static final String TIMESTAMP_FORMAT = "dd/MM/yyyy HH:mm:ss";
	public static final String DATETIME_FORMAT = "dd/MM/yyyy HH:mm";
	public static final String DATE_FORMAT = "dd-MM-yyyy";
	public static final String DISPLAY_DATE_FORMAT = "dd MMM yyyy";
	public static final String DISPLAY_CAL_DATE_FORMAT = "dd/MM/yyyy";
	public static final String DISPLAY_CAL_CONVERT_DATE_FORMAT = "dd/MM/yyyy";
	public static final String DISPLAY_CAL_CONVERT_DATETIME_FORMAT = "dd/MM/yyyy hh:mm:ss";
	public static final String DISPLAY_GRID_DATE_FORMAT = "d/m/Y";
	public static final String DISPLAY_SX_DATE_FORMAT = "dd/MM/yyyy";
	public static final String CAL_DATE_RANGE = "-70:+10";
	public static final String CAL_DOB_RANGE = "-70:-17";
	public static final String CAL_DOJ_RANGE = "-70:+0";

	public static final int RECORDS_PER_PAGE = 15;
	public static final String DEFAULT_SORT = "asc";
	public static final String DEFAULT_DSORT = "desc";
	public static final String DEFAULT_COLUMN = "id";
	public static final String[] DEFAULT_ROWLIST = { "20", "30", "40" };

	public static final String ADD_PERMISSION = "addP";
	public static final String EDIT_PERMISSION = "editP";
	public static final String VIEW_PERMISSION = "viewP";
	public static final String DELETE_PERMISSION = "deleteP";
	public static final String APPROVE_PERMISSION = "approveP";
	public static final String INDEX_PERMISSION = "indexP";

	public static final String uploadPolicyPath = request.getSession().getServletContext().getRealPath(File.separator)+ "upload" + File.separator + "policy" + File.separator;
	public static final String uploadPath = request.getSession().getServletContext().getRealPath(File.separator)+ "upload" + File.separator;
	public static final String uploadEmpPath = request.getSession().getServletContext().getRealPath(File.separator)+ "upload" + File.separator + "employee" + File.separator;
	public static final String imagePath = request.getSession().getServletContext().getRealPath(File.separator)+ "images" + File.separator;
	public static final String dictionaryPath = request.getSession().getServletContext().getRealPath(File.separator)+ "dictionary" + File.separator;
	public static final String uploadClaimPath = request.getSession().getServletContext().getRealPath(File.separator)+ "upload" + File.separator + "claim" + File.separator;
	
	public static final String systemConfigPath = request.getSession().getServletContext().getRealPath(File.separator)+ "config" + File.separator;
	
	public static final String AdminMail = "merino_support@greenfieldsolutions.in";
	//public static final String AdminMail = "sambitd@merinoindia.com";

	// Common List of data
	public static final List<String> ASSETOWNER = new ArrayList<String>(
			Arrays.asList("Yes", "Owned", "Operating Lease"));
	public static final List<String> ASSETSTATUS = new ArrayList<String>(
			Arrays.asList("Yes", "Entered", "Acquired"));
	public static final String[] BRANCH_TYPE = { "HO", "Factory", "Warehouse",
			"Selling Branch", "Financial Branch" };
	
	public static final String[] POLICY_TYPE = {"Fire", "Marine", "MediClaim", "Others" };
	
	public static final String[] DISPLAY_INC_CATEGORY = { "Critical", "Major","Minor", "Ignorable" };
	
	public static final String[] DISPLAY_GENDER = { "Male", "Female"};
	
	public static final String[] DISPLAY_OBSOLETE_ASSET_STATUS = {
			"To be Disposed", "To be Retained", "Decision on Hold" };
	public static final String[] DISPLAY_OBSOLETE_ASSET_STATUS_PHASE = {
			"Not Taken Any Action", "Pending", "Completed" };
	
	public static final String[] NOTIFICATION_TYPE = { "Policy", "Incident", "Claim","Custom" };
	
	public static final Integer PageNavTrail=6;
	
	public static final String[] COVERAGE_TYPES = { "Raw Material", "Finished Goods","Misc. Items", "Co-Generation","Malicious Damage" };
	
	public static final String[] SHIPMENT_TYPES = { "Gr. No.", "BL. No.","BE. No.", "Air Consignment Note"};
	
	public static final String[] NOTIFICATION_TYPES = { "Asset", "Insurance","Incident", "Claim","System","Asset Obsolescence"};
	
	public static final String[] LAST_FIVE_FIN_YEARS={"2013-2014","2012-2013","2011-2012","2010-2011","2009-2010"};
	
	public static final String[] INCIDENT_STATUS = { "Incident Logged", "Investigation Assigned","Under Investigation","Report Submitted"};
}
