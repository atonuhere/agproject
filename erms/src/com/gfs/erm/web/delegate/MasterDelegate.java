package com.gfs.erm.web.delegate;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import com.gfs.erm.model.bo.Branch;
import com.gfs.erm.model.bo.Role;
import com.gfs.erm.model.service.MasterService;
import com.gfs.erm.web.delegate.GeneralDelegate;
import com.gfs.erm.exception.BusinessException;

@Repository("masterDelegate")
@Scope("singleton")
public class MasterDelegate extends GeneralDelegate {
	
	/** The Business object related with current delegate */
	@Autowired
	private MasterService masterService;
	
		
	public List<Role> roleList(){
		List<Role> roleList=null;
		try {
			roleList=masterService.getRoleList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			new BusinessException(e);
		}
		
		return roleList;
		
	}
	
	public List<Branch> branchList(){
		List<Branch> branchList=null;
		try {
			branchList=masterService.getBranchList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			new BusinessException(e);
		}
		
		return branchList;
		
	}

}
