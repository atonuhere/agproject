package com.gfs.erm.model.dao;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

/** * * this class wraps the org.springframework.jdbc.core.JdbcTemplate. */
public class GenericDao {
	private static GenericDao _instance = new GenericDao();
	private Map<String, DataSource> _jdbcTemplates;
	@Autowired
	private DataSource pooledDataSource;
	/**
	 * * empty c'tor
	 */
	private GenericDao() {
		_jdbcTemplates = new ConcurrentHashMap<String, DataSource>();
	}

	/** * @return the singleton instance */
	public static GenericDao getInstance() {
		return _instance;
	}

	/*************************************************************************** * UPDATE **************************************************************************/
	public int insert( String sql) {
		return update( sql);
	}

	public int modify( String sql) {
		return update( sql);
	}

	public int delete( String sql) {
		return update( sql);
	}

	public int insert( String sql, Object[] args) {
		return update( sql, args);
	}

	public int modify( String sql, Object[] args) {
		return update( sql, args);
	}

	public int delete( String sql, Object[] args) {
		return update( sql, args);
	}

	private int update( String sql) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		int numUpdates = jdbcTemplate.update(sql);
		return numUpdates;
	}

	private int update( String sql, Object[] args) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		int numUpdates = jdbcTemplate.update(sql, args);
		return numUpdates;
	}

	/*************************************************************************** * BATCH **************************************************************************/
	public int[] batchUpdate( List<String> sql) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		int[] numUpdates = jdbcTemplate.batchUpdate(sql.toArray(new String[0]));
		return numUpdates;
	}

	/***************************************************************************
	 * QUERY
	 **************************************************************************/
	public void query(String sql) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		jdbcTemplate.queryForInt(sql);
	}

	public <T> List<T> query( String sql,
			RowMapper<T> mapper) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		List<T> resutls = jdbcTemplate.query(sql, mapper);
		return resutls;
	}

	public <T> List<T> query(String sql,
			Object[] params, RowMapper<T> mapper, int maxRows) {
		List<T> resutls = null;
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		jdbcTemplate.setMaxRows(maxRows);
		resutls = jdbcTemplate.query(sql, params, mapper);
		return resutls;
	}

	public <T> T queryForObject( String sql,
			Object[] params, RowMapper<T> mapper) {
		T result = null;
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		result = jdbcTemplate.queryForObject(sql, params, mapper);
		return result;
	}

	public <T> T query( String sql,
			Class<T> requiredClazzType, Object[] args) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		T obj = jdbcTemplate.queryForObject(sql, args, requiredClazzType);
		return obj;
	}

	/*************************************************************************** * QUERY for long and int **************************************************************************/
	public int queryForInt( String sql) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		return jdbcTemplate.queryForInt(sql);
	}

	public int queryForInt(String sql, Object[] params) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		return jdbcTemplate.queryForInt(sql, params);
	}

	public long queryForLong( String sql) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		return jdbcTemplate.queryForLong(sql);
	}

	public long queryForLong(String sql,
			List<Object> params) {
		JdbcTemplate jdbcTemplate = getJdbcTemplate();
		return jdbcTemplate.queryForLong(sql, params);
	}

	/*************************************************************************** * UTILITIES **************************************************************************/
	/**
	 * * get the JdbcTemplate instance that's related to the data source * with
	 * the given name * * @param dataSourceName the name of the data source
	 */
	private JdbcTemplate getJdbcTemplate() {
		if (!_jdbcTemplates.containsKey("poolData")) {
			addDataSourceToCache();
		}
		JdbcTemplate jdbcTemplate = new JdbcTemplate(
				_jdbcTemplates.get("poolData"));
		return jdbcTemplate;
	}

	/**
	 * * add the given data source to the cache of JdbcTemplate's * * @param
	 * dataSourceName the name of the data source
	 */
	private void addDataSourceToCache() {
		
		_jdbcTemplates.put("poolData", pooledDataSource);
	}
}