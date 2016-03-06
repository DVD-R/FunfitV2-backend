package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.service.BreakfastDao;
import com.funfit.usjr.thesis.backend.models.Breakfast;

@Transactional
@Repository("breakfastDao")
public class BreakfastDaoImpl extends GenericDaoImpl<Breakfast> implements BreakfastDao{

	public BreakfastDaoImpl(){
		super(Breakfast.class);
	}
}
