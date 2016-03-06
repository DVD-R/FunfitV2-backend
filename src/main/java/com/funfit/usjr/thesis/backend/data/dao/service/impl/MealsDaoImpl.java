package com.funfit.usjr.thesis.backend.data.dao.service.impl;


import java.util.List;

import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.service.MealsDao;
import com.funfit.usjr.thesis.backend.data.dao.service.UserDao;
import com.funfit.usjr.thesis.backend.models.Meals;
import com.funfit.usjr.thesis.backend.models.Users;

@Transactional
@Repository("mealsDao")
public class MealsDaoImpl extends GenericDaoImpl<Meals> implements MealsDao {

	@Autowired
	private UserDao userDao;
	
	private Users user;
	
	public MealsDaoImpl() {
		super(Meals.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Meals> queryMeal(int userId) {
		// TODO Auto-generated method stub
		user = userDao.show(userId);
		Query query = entityManager.createQuery("select m from Meals m where m.userId=:userId");
		
		query.setParameter("userId", user.getId());
		List<Meals> territoryList = query.getResultList();
		return territoryList;
	}
}