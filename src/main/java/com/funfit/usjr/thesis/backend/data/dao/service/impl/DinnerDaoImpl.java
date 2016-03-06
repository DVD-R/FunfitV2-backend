package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.service.DinnerDao;
import com.funfit.usjr.thesis.backend.models.Dinner;

@Transactional
@Repository("dinnerDao")
public class DinnerDaoImpl extends GenericDaoImpl<Dinner> implements DinnerDao{

	public DinnerDaoImpl(){
		super(Dinner.class);
	}
}
