package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.service.SnackDao;
import com.funfit.usjr.thesis.backend.models.Snack;

@Transactional
@Repository("SnackDao")
public class SnackDaoImpl extends GenericDaoImpl<Snack> implements SnackDao{

	public SnackDaoImpl(){
		super(Snack.class);
	}
}