package com.gfs.erm.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.gfs.erm.dto.IncidentLogTO;
import com.gfs.erm.exception.DataAccessException;
import com.gfs.erm.util.Page;
import com.gfs.erm.model.bo.IncidentLog;
import com.gfs.erm.web.common.WebConstants;

@Repository("incidentLogDao")
public class IncidentLogDaoImpl extends AbstractFacade<IncidentLog> implements IncidentLogDao{

	protected IncidentLogDaoImpl() {
		super(IncidentLog.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional(readOnly = true)
	public List<IncidentLog> getList() throws DataAccessException{
		// TODO Auto-generated method stub
		try{
			return findAll(Order.asc("incNumber"));
		}catch(Exception e){
			throw new DataAccessException(e);
		}
	}
	
	@Override
	@Transactional(readOnly = true)
	public List<IncidentLog> getList(int start, int end,String order, String sort) throws DataAccessException{
		// TODO Auto-generated method stub
		try{
			return findByPage(start, end, order, sort);
		}catch(Exception e){
			throw new DataAccessException(e);
		}
	}
	

	@Override
	@Transactional(readOnly = true)
	public Integer count() throws DataAccessException{
		// TODO Auto-generated method stub
		try{
			return countTotal();
		}catch(Exception e){
			throw new DataAccessException(e);
		}
	}
	
	
	
	@Override
	@Transactional(readOnly = false)
	public Boolean saveEntity(IncidentLog incLog) throws DataAccessException{
		// TODO Auto-generated method stub
		Boolean flag=false;
		try{
			if(incLog.getId()==null)
				save(incLog);
			else
				update(incLog);
			flag=true;
		}catch(Exception e){
			throw new DataAccessException(e);
			
		}
		return flag;
	}

	@Override
	public IncidentLog get(Long id) throws DataAccessException{
		// TODO Auto-generated method stub
		try{
			return find(id);
		}catch(Exception e){
			throw new DataAccessException(e);
			
		}
	}

	@Override
	public List<IncidentLog> getList(Integer incStatusId)
			throws DataAccessException {
		// TODO Auto-generated method stub
		try{
			return findAll(Restrictions.eq("incstatus", incStatusId));
		}catch(Exception e){
			throw new DataAccessException(e);
		}
		
	}

	/**
	  * {@inheritDoc} 
	  */
	 @SuppressWarnings("unchecked")
	 @Override
	public Page<IncidentLog> findByCriteria(IncidentLogTO searchCriteria,	Page<IncidentLog> page) throws DataAccessException {
		// TODO Auto-generated method stub
		Order order;
		String sortcol="";
		
		try{
			 Criteria criteria = getSession().createCriteria(IncidentLog.class);
		  
			 if (searchCriteria.getIncNumber() != null && searchCriteria.getIncNumber().trim().length() != 0) {
				 criteria.add(Restrictions.ilike("incNumber", searchCriteria.getIncNumber(), MatchMode.ANYWHERE)); 
	   
			 }
			 if (searchCriteria.getIncidentStatusId() != null && searchCriteria.getIncidentStatusId() != 0) {
				 criteria.add(Restrictions.eq("incstatus", searchCriteria.getIncidentStatusId())); 
	   
			 }
	  
			 //get total number of records first
			 criteria.setProjection(Projections.rowCount());
			 Integer rowCount = ((Long) criteria.list().get(0)).intValue();
			 //reset projection to null
			 criteria.setProjection(null);
			 Integer to = page.getPage() * page.getRows();
		     Integer from = to - page.getRows();
		     //calculate the total pages for the query
			 Integer totNumOfPages =(int) Math.ceil((double) rowCount / (double)page.getRows());
			 if(page.getSort().equalsIgnoreCase("")){
				sortcol= WebConstants.DEFAULT_COLUMN;
			 }else {
				 sortcol= page.getSort();
			 }
			 if(page.getOrder().equalsIgnoreCase("asc")){
				order= Order.asc(sortcol);
			 }else {
				 order= Order.desc(sortcol);
			 }
			 criteria.setFirstResult(from);
			 criteria.setMaxResults(to);
			 criteria.addOrder(order);
		    	  
		      List<IncidentLog> incidents = (List<IncidentLog>) criteria.list(); 
		      //Update 'page' instance.
		      page.setRecords(rowCount); //Total number of records
		      page.setResultList(incidents);
		      page.setTotal(totNumOfPages);
		  
		      return page; 
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	

	

}
