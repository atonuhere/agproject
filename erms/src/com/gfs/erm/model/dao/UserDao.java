package com.gfs.erm.model.dao;

import com.gfs.erm.exception.DataAccessException;
import com.gfs.erm.model.bo.User;
public interface UserDao extends GeneralDao<User,Long>{

	public User get(String username) throws DataAccessException;
}
