package com.funfit.usjr.thesis.backend.data.dao;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

/** 
 * @author victor
 * @param <T>
 */
public interface GenericDao<T> {
	
	public void create(T data);
	
	public T show1(int id);
	
	public T show(int id);
	
	public T showUser(String id);
	
	public T update(T data);
	
	public Boolean delete(T data);
}
