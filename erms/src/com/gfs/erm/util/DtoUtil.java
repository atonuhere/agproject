package com.gfs.erm.util;

import java.util.ArrayList;
import java.util.List;

import com.gfs.erm.dto.IncidentLogTO;
import com.gfs.erm.exception.BusinessException;
import com.gfs.erm.util.DateUtil;
import com.gfs.erm.util.Page;
import com.gfs.erm.util.Pager;
import com.gfs.erm.model.bo.IncidentLog;
import com.gfs.erm.web.common.WebConstants;

public class DtoUtil {
	
	
	public static List<IncidentLogTO> getIncidentLogList(List<IncidentLog> incList) throws BusinessException{
		List<IncidentLogTO> incLog=new ArrayList<IncidentLogTO>();
		try {
						
			for(int i=0; i < incList.size(); i++){
				IncidentLogTO incto= new IncidentLogTO();
				incto.setId(incList.get(i).getId());
				incto.setIncNumber(incList.get(i).getIncNumber());
				incto.setBranchName(incList.get(i).getBranch().getName());
				incto.setIncidentStatus(WebConstants.INCIDENT_STATUS[incList.get(i).getIncstatus()]);
				incto.setIncidentType(incList.get(i).getIncType().getName());
				incto.setIncLocation(incList.get(i).getIncLocation());
				incto.setIncidentDate(DateUtil.formatDate(incList.get(i).getIncDate()));
				
				incLog.add(incto);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return incLog;
		
	}
	
	public static Page<?> setdList(Pager<?> dList) throws BusinessException{
		Page<?> data=null;
		try {
			data.setOrder(dList.getOrder());
			data.setSort(dList.getSort());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return data;
		
	}
}
