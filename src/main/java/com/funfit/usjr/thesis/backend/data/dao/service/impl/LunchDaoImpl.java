package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.service.LunchDao;
import com.funfit.usjr.thesis.backend.models.Lunch;

@Transactional
@Repository("lunchDao")
public class LunchDaoImpl extends GenericDaoImpl<Lunch> implements LunchDao{

	public LunchDaoImpl(){
		super(Lunch.class);
	}
}
