package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.service.ImpulseDao;
import com.funfit.usjr.thesis.backend.models.Impulse;

@Transactional
@Repository("impulseDao")
public class ImpulseDaoImpl extends GenericDaoImpl<Impulse> implements ImpulseDao{

	public ImpulseDaoImpl() {
		super(Impulse.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Impulse> index() {
		// TODO Auto-generated method stub
		TypedQuery<Impulse> query = entityManager.createQuery("select i from Impulse i", Impulse.class);

		return query.getResultList();
	}
}
