package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.service.TerritoryDao;
import com.funfit.usjr.thesis.backend.models.Territory;

@Repository("territoryDao")
@Transactional
public class TerritoryDaoImpl extends GenericDaoImpl<Territory> implements TerritoryDao{

	public TerritoryDaoImpl() {
		super(Territory.class);
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Territory> index() {
		// TODO Auto-generated method stub
		TypedQuery query = entityManager.createQuery("select t from Territory t", Territory.class);
		return query.getResultList();
	}

}
