package com.funfit.usjr.thesis.backend.data.dao.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.GenericDao;
import com.funfit.usjr.thesis.backend.models.Meals;

@Transactional
public interface MealsDao extends GenericDao<Meals>{
	public List<Meals> queryMeal(int userId);
}
