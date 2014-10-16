package com.gfs.erm.model.service;

import java.util.List;

import com.gfs.erm.exception.DataAccessException;
import com.gfs.erm.model.bo.Branch;
import com.gfs.erm.model.bo.Permission;
import com.gfs.erm.model.bo.Role;

public interface MasterService {
   
    public List<Role> getRoleList() throws DataAccessException;
    
    public List<Branch> getBranchList() throws DataAccessException;
    
    public List<Permission> getPermissionList() throws DataAccessException;

       
    
}
