package com.gfs.erm.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Service;  

import com.gfs.erm.exception.DataAccessException;
import com.gfs.erm.model.bo.Branch;
import com.gfs.erm.model.bo.Permission;
import com.gfs.erm.model.bo.Role;
import com.gfs.erm.model.dao.BranchDao;
import com.gfs.erm.model.dao.PermissionDao;
import com.gfs.erm.model.dao.RoleDao;

@Service("masterService")   
public class MasterServiceImpl implements MasterService {  
    
	@Autowired
	private RoleDao roleDao;
	
	@Autowired
	private PermissionDao permissionDao;
	
	@Autowired
	private BranchDao branchDao;

	@Override
	public List<Role> getRoleList() throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			  return roleDao.getList();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e);
		}
	}

	

	@Override
	public List<Permission> getPermissionList() throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			  return permissionDao.getList();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e);
		}
	}

	
	
	@Override
	public List<Branch> getBranchList() throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			  return branchDao.getList();
		}catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DataAccessException(e);
		}
	}
	
	/**
	 * @return the roleDao
	 */
	public RoleDao getRoleDao() {
		return roleDao;
	}

	/**
	 * @param roleDao the roleDao to set
	 */
	public void setRoleDao(RoleDao roleDao) {
		this.roleDao = roleDao;
	}

	/**
	 * @return the permissionDao
	 */
	public PermissionDao getPermissionDao() {
		return permissionDao;
	}

	/**
	 * @param permissionDao the permissionDao to set
	 */
	public void setPermissionDao(PermissionDao permissionDao) {
		this.permissionDao = permissionDao;
	}

	/**
	 * @return the branchDao
	 */
	public BranchDao getBranchDao() {
		return branchDao;
	}

	/**
	 * @param branchDao the branchDao to set
	 */
	public void setBranchDao(BranchDao branchDao) {
		this.branchDao = branchDao;
	}

	
}
