package org.jackysoft.service;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.jackysoft.util.CollectionUtils;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.dao.DataAccessException;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class AbstractServiceImpl<ID,B extends java.io.Serializable> extends AbstractDataProvider<B> implements ResourceLoaderAware{

	
	protected ResourceLoader resourceLoader;
    public AbstractServiceImpl() {super();}
	public AbstractServiceImpl(Class<B> type) {
		super(type);
	}

	protected Collection<B> getsByHql(String hql) throws DataAccessException {
		Session session = session();

		Collection<B> crat = null;
		try {
			if (hql == null)
				return Collections.emptyList();
			crat = session.createQuery(hql).list();

		} catch (DataAccessException e) {
			e.printStackTrace();
			log.error(e.toString());
		}
		return crat;
	}

	protected Collection<B> getsByExample(B t) {
		Example example = Example.create(t);
		return session().createCriteria(this.type).add(example).list();

	}
	
		
	@SuppressWarnings("unchecked")
	@Override
	public Collection<B> gets() throws DataAccessException {
		Session session = session();
		Query q = session.createQuery("from "+table());
		Collection<B> list = q.list();
		//CollectionUtils.notNullable(list);
		return list;
	}
	@Override
	public Collection<B> gets(QueryCriteria qc) throws DataAccessException {
		return null;
	}
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void create(B b) throws DataAccessException {
		Session session = session();
		session.save(b);
		
	}
	
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void create(Collection<B> bs) throws DataAccessException {
		CollectionUtils.notNullable(bs);
		Session sess = session();
		int count = 0;
		Iterator<B> itr = bs.iterator();
		while (itr.hasNext()) {
			B b = itr.next();
			sess.saveOrUpdate(b);
			if (++count % 20 == 0) {
				sess.flush();
				sess.clear();
			}

		}

		
	}
	
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void remove(B t) throws DataAccessException {

		Session session = session();
		session.delete(t);
		
		
	}	
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRES_NEW)
	public void remove(Collection<B> bs) throws DataAccessException {
		Session sess = session();
		int count = 0;
		Iterator<B> itr = bs.iterator();
		while (itr.hasNext()) {
			B b = itr.next();
			sess.delete(b);
			if (++count % 20 == 0) {
				sess.flush();
				sess.clear();
			}

		}

		
	}
	@Override
	public void update(B b) throws DataAccessException {
		session().evict(b);
		session().update(b);
		session().flush();
		
	}
	@Override
	public void update(Collection<B> bs) throws DataAccessException {
		Session sess = session();
		int count = 0;
		Iterator<B> itr = bs.iterator();
		while (itr.hasNext()) {
			B b = itr.next();
			sess.update(b);
			if (++count % 20 == 0) {
				sess.flush();
				sess.clear();
			}

		}
		
	}
	@Override
	public void saveOrUpdate(B b) throws DataAccessException {
		Session session = session();
		session.saveOrUpdate(b);
		
	}
	@Override
	public int count() throws DataAccessException {
		Session session = session();
		Object obj = session.createQuery(
				"select count(*) from " + type.getName()).uniqueResult();
		Long icount = obj==null?0L:Long.parseLong(obj.toString());
		return icount.intValue();
	}
	@Override
	public int count(QueryCriteria qc) throws DataAccessException {
		
		return 0;
	}
	
	protected Query query(String hql) throws DataAccessException {
		return session().createQuery(hql);
	}
	@Override
	public Collection<B> gets(int start, int size) throws DataAccessException {
		Session session = session();
		List list = session.createCriteria(type).setFirstResult(start).setMaxResults(size).list();
		return list;
	}
	@Override
	public void setResourceLoader(ResourceLoader arg0) {
		this.resourceLoader = arg0;
		
	}	
		
}
