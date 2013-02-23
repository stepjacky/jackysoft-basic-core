package org.jackysoft.service;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Collection;

import javax.annotation.Resource;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.jackysoft.common.config.CommonConfiguration;
import org.jackysoft.util.StringUtils;
import org.springframework.dao.DataAccessException;


public abstract class AbstractDataProvider<B extends Serializable> implements CRUDDataProvider<String,B> {

	
	protected static final Log log = LogFactory.getLog(AbstractDataProvider.class);
	protected SessionFactory sessionFactory;	
	protected Class<B> type = null;
	protected CommonConfiguration config;

	

	public AbstractDataProvider() {}
	public AbstractDataProvider(Class<B> type) {
		super();
		this.type = type;
	}		

	
	
	public void updateSorts(Collection<B> beans) throws Exception {
		if (beans == null || beans.isEmpty())
			return;
		Object to = beans.iterator().next();
		Method[] fs = to.getClass().getMethods();
		String idpro = "id";
		for (Method f : fs) {
			if (f.isAnnotationPresent(javax.persistence.Id.class)) {
				idpro = StringUtils.lowerFirstChar(f.getName().substring(3));
				break;
			}
		}
		String hql = "update " + this.getEntityName()
				+ " set sortNum=:sortNum where " + idpro + "=:id";
				int count = 0;

		for (Object o : beans) {
			Object s = PropertyUtils.getProperty(o, "sort");
			Object id = PropertyUtils.getProperty(o, idpro);
			session().createQuery(hql)
					.setInteger("sort", Integer.parseInt(s.toString()))
					.setString("id", id.toString()).executeUpdate();
			if (++count % 10 == 0) {
				session().flush();
			}
		}

	}
		
	
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public Session session(){
		return this.sessionFactory.getCurrentSession();
	}
	
	@Override
	public B get(String id) throws DataAccessException {
		
		return (B) session().get(this.type, id);
	}
	@Override
	public B get(QueryCriteria qc) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Collection<B> gets(int start, int size) throws DataAccessException {
		
	    Collection<B> list  = session().createQuery("from "+table()).setFirstResult(start).setMaxResults(size).list();
		return list;
	}
	@Override
	public Collection<B> gets() throws DataAccessException {
		 Collection<B> list  = session().createQuery("from "+table()).list();
		 return list;
	}
	@Override
	public Collection<B> gets(QueryCriteria qc) throws DataAccessException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public void create(B b) throws DataAccessException {
		session().save(b);
		
	}
	@Override
	public void create(Collection<B> bs) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove(B t) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void remove(Collection<B> bs) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(B b) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void update(Collection<B> bs) throws DataAccessException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void saveOrUpdate(B b) throws DataAccessException {
		session().saveOrUpdate(b);
		
	}
	@Override
	public int count() throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int count(QueryCriteria qc) throws DataAccessException {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	public Class<B> getType() {
		return type;
	}

	public void setType(Class<B> type) {
		this.type = type;

	}
	/** 返回实体类名称 */
	public String getEntityName() {
		if (this.getType() != null)
			return getType().getName();
		else
			return null;
	}
	
	public String table(){
	   return getEntityName();	
	}	
	
	@Resource
	public void setConfig(CommonConfiguration config) {
		this.config = config;
	}

}
