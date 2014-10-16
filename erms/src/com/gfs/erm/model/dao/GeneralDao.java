package com.gfs.erm.model.dao;

import java.util.List;

import com.gfs.erm.exception.DataAccessException;

public interface GeneralDao<T, I> {
	
	public List<T> getList() throws DataAccessException;
	
	public Boolean saveEntity(T t) throws DataAccessException;
	
	public T get(Long i) throws DataAccessException;
	
	public Integer count() throws DataAccessException;
	
	//public List<T> getList(int start, int end,String order, String sort) throws DataAccessException;
	
}
