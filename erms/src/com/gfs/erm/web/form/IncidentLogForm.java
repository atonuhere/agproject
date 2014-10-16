package com.gfs.erm.web.form;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.gfs.erm.dto.IncidentLogTO;
import com.gfs.erm.util.DateUtil;
import com.gfs.erm.model.bo.Branch;
import com.gfs.erm.model.bo.IncidentType;
import com.gfs.erm.web.common.WebConstants;
import com.gfs.erm.web.delegate.IncidentDelegate;
import com.gfs.erm.web.delegate.MasterDelegate;


public class IncidentLogForm extends BaseForm {

	private static final long serialVersionUID = 2766220301564926504L;
	private IncidentLogTO incident;
	private String dateConv1="";
	private String dateConv2="";
	
	@Autowired
	private IncidentDelegate incidentDelegate;
	
	@Autowired
	private MasterDelegate masterDelegate;
	
	public String execute()
    {
    	Boolean flag=false;
    	try{
			if(incident.getId()== null){
			
				incident.setLoggedBy(userId);
	
				// AUTO GENERATED INCIDENT NUMBER START		
				Date dt = new Date();
				SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
				String slno ="INC"+ft.format(dt);
				//String inc_num = inclogDao.getIncidentNumber(slno);
				String inc_num = "0001";
				String INC_SL = "";
				if(inc_num != "null"){
					int get_num = Integer.parseInt(inc_num.substring(inc_num.length() - 2, inc_num.length()));
					int  NUM = get_num + 1;	
					String padded_num = String.format("%02d" , NUM);
				    INC_SL = slno+padded_num;	
				    		    
				}else{
					
					INC_SL = slno+"01";	 
				}
				System.out.println("INC_NUM>>"+ INC_SL);
				incident.setIncNumber(INC_SL);
			// AUTO GENERATED NUMBER END		

			}

			if(servletRequest.getParameter("reported_on")!=null){
				
				dateConv1=servletRequest.getParameter("reported_on").toString();
				incident.setReportedOn(DateUtil.convertDate(dateConv1,WebConstants.DISPLAY_CAL_CONVERT_DATE_FORMAT));
			}
			if(servletRequest.getParameter("inc_date")!=null){
				
				dateConv2=servletRequest.getParameter("inc_date").toString();
				incident.setIncDate(DateUtil.convertDate(dateConv2,WebConstants.DISPLAY_CAL_CONVERT_DATE_FORMAT));
			}
			
			
			flag=incidentDelegate.saveIncidentLog(incident);
			
			
			
		
		}catch (Exception e){
			this.setErrorFormSession("Incident Add Error",e);
		}
		if(flag){
			this.setSuccessFormSession("Incident Added Successfully");
			return SUCCESS;
		}else{
			this.setErrorFormSession("Incident Add Error",null);
			return INPUT;
		}	
       	
    }
	
	@Override
    public void prepare()
    {
		try{
			List<IncidentType> incTypeList=incidentDelegate.getIncidentTypeList();
			dataArr.put("incidentTypeList",incTypeList);
			List<Branch> branchList=masterDelegate.branchList();
			dataArr.put("branchList",branchList);
		}catch (Exception e){
			this.setErrorFormSession("Incident Add Error",e);
		}
    	
    }

	public IncidentLogTO getIncident() {
		return incident;
	}

	public void setIncident(IncidentLogTO incident) {
		this.incident = incident;
	}

	public String getDateConv1() {
		return dateConv1;
	}

	public void setDateConv1(String dateConv1) {
		this.dateConv1 = dateConv1;
	}

	public String getDateConv2() {
		return dateConv2;
	}

	public void setDateConv2(String dateConv2) {
		this.dateConv2 = dateConv2;
	}

	public IncidentDelegate getIncidentDelegate() {
		return incidentDelegate;
	}

	public void setIncidentDelegate(IncidentDelegate incidentDelegate) {
		this.incidentDelegate = incidentDelegate;
	}

	public MasterDelegate getMasterDelegate() {
		return masterDelegate;
	}

	public void setMasterDelegate(MasterDelegate masterDelegate) {
		this.masterDelegate = masterDelegate;
	}

	
}
