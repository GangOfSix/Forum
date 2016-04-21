package com.forum.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BaseDao<T> {
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public Long count(String hql) {
		return (Long) this.getCurrentSession().createQuery(hql).uniqueResult();
	}

	public Long count(String hql, Object[] param) {
		Query q = this.getCurrentSession().createQuery(hql);
		if (param != null && param.length > 0) {
			for (int i = 0; i < param.length; i++) {
				q.setParameter(i, param[i]);
			}
		}
		return (Long) q.uniqueResult();
	}
	
	public Serializable save(T t) {
		return this.getCurrentSession().save(t);
	}
	
	public void delete(T t) {
		this.getCurrentSession().delete(t);
	}
	
	public void update(T t) {
		this.getCurrentSession().update(t);
	}
	
	@SuppressWarnings("unchecked")
	public T load(Class<T> clazz, Serializable id) {
		return (T)this.getCurrentSession().load(clazz, id);
	}
	
	@SuppressWarnings("unchecked")
	public T get(Class<T> clazz, Serializable id) {
		return (T)this.getCurrentSession().get(clazz, id);
	}
	
	public T get(String hql, Object[] param) {
		List<T> list = this.find(hql, param);
		if (list != null && list.size() > 0) {
			return list.get(0);
		} else {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<T> find(String hql) {
		return this.getCurrentSession().createQuery(hql).list();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Object[] params) {
		Query query = this.getCurrentSession().createQuery(hql);
		if(params!=null && params.length>0) {
			for(int i=0; i<params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		return (List<T>)query.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<T> find(String hql, Object[] params, int beginIndex, int everyPage) {
		Query query = this.getCurrentSession().createQuery(hql);
		if(params!=null && params.length>0) {
			for(int i=0; i<params.length; i++) {
				query.setParameter(i, params[i]);
			}
		}
		query.setFirstResult(beginIndex);
		query.setMaxResults(everyPage);
		return (List<T>)query.list();
	}
}
