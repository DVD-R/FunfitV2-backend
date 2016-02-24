package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.GenericDao;

/**
 * 
 * @author victor
 *
 * @param <T>
 */
@Transactional
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class GenericDaoImpl<T> implements GenericDao<T>{
	private Class<T> thisClass;

	protected EntityManager entityManager;

	public GenericDaoImpl(){
		
	}
	
	public GenericDaoImpl(Class<T> thisClass){
		this.thisClass = thisClass;
	}
	
	
	public EntityManager getEntityManager(){
		return entityManager;
	}
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager){
		this.entityManager = entityManager;
	}

	@Override
	public void create(T data) {
		// TODO Auto-generated method stub
		entityManager.persist(data);
		entityManager.flush();
	}

	@Override
	public T show1(int id) {
		// TODO Auto-generated method stub
		return (T) entityManager.find(thisClass, id);
	}

	@Override
	public T show(int id) {
		// TODO Auto-generated method stub
		return (T) entityManager.find(thisClass, id);
	}

	@Override
	public T showUser(String id) {
		// TODO Auto-generated method stub
		return (T) entityManager.find(thisClass, id);
	}

	@Override
	public T update(T data) {
		// TODO Auto-generated method stub
		try{
			   return entityManager.merge(data);
			} catch(Exception ex) {
				return null;
			}	
		}

	@Override
	public Boolean delete(T data) {
		//  Auto-generated method stub
		try {
		     entityManager.remove(data);
		} catch (Exception ex) {
			return false;
		}
		return true;
	}

	
}