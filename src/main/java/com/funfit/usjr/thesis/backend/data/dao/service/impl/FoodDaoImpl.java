package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.service.FoodDao;
import com.funfit.usjr.thesis.backend.models.Food;

@Transactional
@Repository("foodDao")
public class FoodDaoImpl extends GenericDaoImpl<Food> implements FoodDao{

	public FoodDaoImpl(){
		super(Food.class);
	}
}
