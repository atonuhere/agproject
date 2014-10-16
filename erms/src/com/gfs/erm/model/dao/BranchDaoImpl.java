package com.gfs.erm.model.dao;

import java.util.List;

import org.hibernate.criterion.Order;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gfs.erm.exception.DataAccessException;
import com.gfs.erm.model.bo.Branch;

@Repository("branchDao")
public class BranchDaoImpl extends AbstractFacade<Branch> implements BranchDao{

	protected BranchDaoImpl() {
		super(Branch.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional(readOnly = true)
	public List<Branch> getList() throws DataAccessException{
		// TODO Auto-generated method stub
		try{
			return findAll(Order.asc("name"));
		}catch(Exception e){
			throw new DataAccessException(e);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public Branch get(Long id) throws DataAccessException {
		// TODO Auto-generated method stub
		return find(id);
		
	}

	@Override
	public Boolean saveEntity(Branch t) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer count() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

}
