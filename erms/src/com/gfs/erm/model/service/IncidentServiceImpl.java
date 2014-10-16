package com.gfs.erm.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gfs.erm.dto.IncidentLogTO;
import com.gfs.erm.exception.BusinessException;
import com.gfs.erm.exception.DataAccessException;
import com.gfs.erm.util.DefaultPageNavigator;
import com.gfs.erm.util.Page;
import com.gfs.erm.util.PageNavigator;
import com.gfs.erm.util.Pager;
import com.gfs.erm.model.bo.Branch;
import com.gfs.erm.model.bo.IncidentLog;
import com.gfs.erm.model.bo.IncidentType;
import com.gfs.erm.model.dao.BranchDao;
import com.gfs.erm.model.dao.IncidentLogDao;
import com.gfs.erm.model.dao.IncidentTypeDao;
import com.gfs.erm.util.DtoUtil;

@Service("incidentService") 
public class IncidentServiceImpl implements IncidentService{

	@Autowired
	private IncidentLogDao incidentLogDao;
	
	@Autowired
	private IncidentTypeDao incidentTypeDao;
	
	@Autowired
	private BranchDao branchDao;
	
	@Override
	public List<IncidentLog> getIncidentLogList() throws BusinessException  {
		// TODO Auto-generated method stub
		List<IncidentLog> incList=new ArrayList<IncidentLog>();
		try {
			incList= incidentLogDao.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e);
		}
		return incList;
	}
	
	/**
	  * {@inheritDoc} 
	  */
	 @Override
	 public Pager<IncidentLogTO> findByCriteria(IncidentLogTO searchCriteria, Pager<IncidentLogTO> page) throws BusinessException {
		 Page<IncidentLog> incidents= new Page<IncidentLog>();
		 try {
			 incidents.setOrder(page.getOrder());
			 incidents.setSort(page.getSort());
			 incidents.setPage(page.getPage());
			 incidents.setRows(page.getRows());
			 
			 Page<IncidentLog> incidentList = incidentLogDao.findByCriteria(searchCriteria, incidents);
			 List<IncidentLogTO> incidentdtos=DtoUtil.getIncidentLogList(incidentList.getResultList());
			 
			 PageNavigator pageNav = new DefaultPageNavigator();
			 String pageString=pageNav.buildPageNav(page.getAjaxPath(),incidentList.getRecords(), page.getPage(),page.getRows(), page.getElementId());
			 
			 page.setResultList(incidentdtos);
			 page.setPagingString(pageString);
			 
			 
			 return page;
		 } catch (Exception e) {
				// TODO Auto-generated catch block
				throw new BusinessException(e);
		 }	 
	 }
	
	@Override
	public List<IncidentLog> getIncidentLogList(int start, int end,String order, String sort) throws BusinessException  {
		// TODO Auto-generated method stub
		List<IncidentLog> incList=new ArrayList<IncidentLog>();
		try {
			incList= incidentLogDao.getList(start, end, order, sort);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return incList;
	}
	
	@Override
	public Integer incidentLogCount() throws BusinessException  {
		// TODO Auto-generated method stub
		Integer count=0;
		try {
			count= incidentLogDao.count();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}
	
	@Override
	public List<IncidentLog> getIncidentLogList(Integer incStatus) throws BusinessException  {
		// TODO Auto-generated method stub
		List<IncidentLog> incList=new ArrayList<IncidentLog>();
		try {
			incList= incidentLogDao.getList(incStatus);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e);
		}
		return incList;
	}
	
	
	
	@Override
	public IncidentLog getIncidentLog(Long id) throws BusinessException  {
		// TODO Auto-generated method stub
		IncidentLog incL=new IncidentLog();
		try {
			incL= incidentLogDao.get(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e);
		}
		return incL;
	}
	
	@Override
	public List<IncidentType> getIncidentTypeList() throws BusinessException {
		// TODO Auto-generated method stub		
		List<IncidentType> incTypeList=new ArrayList<IncidentType>();
		try {
			incTypeList= incidentTypeDao.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e);
		}
		return incTypeList;
		
	}
	
	@Override
	public List<Branch> getBranchList() throws BusinessException {
		// TODO Auto-generated method stub
		List<Branch> branches=new ArrayList<Branch>();
		try {
			branches= branchDao.getList();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e);
		}
		return branches;
	}
	
	
	@Override
	public Boolean saveIncidentLog(IncidentLog incLog) throws BusinessException {
		// TODO Auto-generated method stub
		try {	
			return incidentLogDao.saveEntity(incLog);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new BusinessException(e);
		}
	}
	
	@Override
	public Branch getBranch(Long branchId) throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return branchDao.get(branchId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	@Override
	public IncidentType getIncidentType(Long incTypeId)
			throws BusinessException {
		// TODO Auto-generated method stub
		try {
			return incidentTypeDao.get(incTypeId);
		} catch (DataAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}


	
	
		
	
	
	

	public IncidentLogDao getIncidentLogDao() {
		return incidentLogDao;
	}

	public void setIncidentLogDao(IncidentLogDao incidentLogDao) {
		this.incidentLogDao = incidentLogDao;
	}


	public IncidentTypeDao getIncidentTypeDao() {
		return incidentTypeDao;
	}


	public void setIncidentTypeDao(IncidentTypeDao incidentTypeDao) {
		this.incidentTypeDao = incidentTypeDao;
	}


	public BranchDao getBranchDao() {
		return branchDao;
	}


	public void setBranchDao(BranchDao branchDao) {
		this.branchDao = branchDao;
	}

		
}
