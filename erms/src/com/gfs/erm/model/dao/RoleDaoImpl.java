package com.gfs.erm.model.dao;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gfs.erm.exception.DataAccessException;
import com.gfs.erm.model.bo.Role;

@Repository("roleDao")
public class RoleDaoImpl extends AbstractFacade<Role> implements RoleDao{

	protected RoleDaoImpl() {
		super(Role.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional(readOnly = true)
	public List<Role> getList() throws DataAccessException{
		// TODO Auto-generated method stub
		try{
			return findAll(Order.asc("role"));
		}catch(Exception e){
			throw new DataAccessException(e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Role get(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return find(id);
		
	}

	@Override
	public Boolean saveEntity(Role t) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer count() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
