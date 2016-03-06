package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.service.RunsDao;
import com.funfit.usjr.thesis.backend.data.dao.service.UserDao;
import com.funfit.usjr.thesis.backend.dto.RequestRun;
import com.funfit.usjr.thesis.backend.models.Meals;
import com.funfit.usjr.thesis.backend.models.Runs;
import com.funfit.usjr.thesis.backend.models.Users;

@Transactional
@Repository("runsDao")
public class RunsDaoImpl extends GenericDaoImpl<Runs> implements RunsDao{

	@Autowired
	private UserDao userDao;
	
	private Users user;
	
	public RunsDaoImpl(){
		super(Runs.class);
	}

	@Override
	public List<Runs> index() {
		// TODO Auto-generated method stub
		TypedQuery<Runs> query = entityManager.createQuery("Select r from Runs r", Runs.class);
		
		return query.getResultList();	
		}
	
	@Override
	public List<Runs> queryMeal(int userId) {
		// TODO Auto-generated method stub
		user = userDao.show(userId);
		Query query = entityManager.createQuery("select r from Runs r where r.userId=:userId");
		
		query.setParameter("userId", user.getId());
		List<Runs> territoryList = query.getResultList();
		return territoryList;
	}

	@Override
	public boolean checkRun(RequestRun requestRun) {
		// TODO Auto-generated method stub
		user = userDao.show(requestRun.getUserId());

		Runs runs = new Runs();
		
		Query query = entityManager.createQuery("select r from Runs r where r.userId=:userId and r.runId=:runId");
		
		query.setParameter("userId", user.getId());
		query.setParameter("runId", requestRun.getRunId());
		runs = (Runs) query.getSingleResult();
		if(!runs.getDate().equals(null)){
			return true;
		}else{
		return false;
		}
	}	
}