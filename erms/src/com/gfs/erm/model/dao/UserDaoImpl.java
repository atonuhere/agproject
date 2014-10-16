package com.gfs.erm.model.dao;

import java.util.List;

import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gfs.erm.exception.DataAccessException;
import com.gfs.erm.model.bo.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractFacade<User> implements UserDao {
	
	protected UserDaoImpl() {
		super(User.class);
		// TODO Auto-generated constructor stub
	}
    
	@Override
	@Transactional(readOnly = true)
	public List<User> getList() {
		 List<User> user= findAll(Order.desc("userName"));
		 
		 return user;
	}

	@Override
	public Boolean saveEntity(User t) throws DataAccessException {
		// TODO Auto-generated method stub
		save(t);
		return true;
	}

	@Override
	public User get(Long i) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public User get(String username) throws DataAccessException {
		// TODO Auto-generated method stub
		return find(Restrictions.eq("userName",username));
		
	}

	@Override
	public Integer count() throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	
  	
}
