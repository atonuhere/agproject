package com.gfs.erm.model.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.gfs.erm.web.common.WebConstants;

@SuppressWarnings("unchecked")
@Transactional
public abstract class AbstractFacade<T> {

	@Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public AbstractFacade() {
    }

    
    public void save(T entity) {
    	getSession().persist(entity);
    }

    public void update(T entity) {
    	getSession().merge(entity);
    }

    public void remove(T entity) {
    	getSession().delete(getSession().merge(entity));
    }

    public T find(Long primaryKey) {
        return (T) getSession().get(entityClass, primaryKey);
    }

    public List<T> findAll(Order order) {
        Criteria cq = getSession().createCriteria(entityClass);
        cq.addOrder(order);
        return (List<T>) cq.list();
    }
    
    public T find(Criterion criterion) {
    	 Criteria cq = getSession().createCriteria(entityClass);
         cq.add(criterion);
         return (T) cq.uniqueResult();
    }
    
    public List<T> findAll(Criterion criterion) {
   	 Criteria cq = getSession().createCriteria(entityClass);
     cq.add(criterion);
     
     return (List<T>) cq.list();
   }
    
    public List<T> findByPage(final int start, final int end,final String orderBy,final String sort){
    	Criteria criteria = getSession().createCriteria(entityClass);
    	Order order;
		String sortcol="";
    	if(sort.equalsIgnoreCase("")){
			sortcol= WebConstants.DEFAULT_COLUMN;
		}else {
			sortcol= sort;
		}
		if(orderBy.equalsIgnoreCase("asc")){
			order= Order.asc(sortcol);
		}else {
			order= Order.desc(sortcol);
		}
		criteria.setFirstResult(start);
		criteria.setMaxResults(end);
		criteria.addOrder(order);
        
        return (List<T>) criteria.list();
    }
    
    public Integer countTotal() {
      	Criteria criteria = getSession().createCriteria(entityClass);
      	criteria.setProjection(Projections.count("id"));
      	Long count= (Long) criteria.uniqueResult();
        return count.intValue();
    }
    
	
	


}
