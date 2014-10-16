package com.gfs.erm.model.dao;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gfs.erm.exception.DataAccessException;
import com.gfs.erm.model.bo.Permission;

@Repository("permissionDao")
public class PermissionDaoImpl extends AbstractFacade<Permission> implements PermissionDao{

	protected PermissionDaoImpl() {
		super(Permission.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional(readOnly = true)
	public List<Permission> getList() throws DataAccessException{
		// TODO Auto-generated method stub
		try{
			return findAll(Order.asc("name"));
		}catch(Exception e){
			throw new DataAccessException(e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Permission get(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return find(id);
		
	}

	@Override
	public Boolean saveEntity(Permission t) throws DataAccessException {
		// TODO Auto-generated method stub
		try{
			save(t);
			return true;
		}catch(Exception e){
			throw new DataAccessException(e);
		}
	}

	@Override
	public Integer count() throws DataAccessException {
		// TODO Auto-generated method stub
		return countTotal();
	}

}
