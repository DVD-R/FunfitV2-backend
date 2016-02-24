package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.service.VelocityDao;
import com.funfit.usjr.thesis.backend.models.Velocity;

@Transactional
@Repository("velocityDao")
public class VelocityDaoImpl extends GenericDaoImpl<Velocity> implements VelocityDao{

	public VelocityDaoImpl() {
		super(Velocity.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Velocity>  index() {
		// TODO Auto-generated method stub
		TypedQuery<Velocity> query = entityManager.createQuery("select v from Velocity v", Velocity.class);

		return query.getResultList();
	}
	
}
