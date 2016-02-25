package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import java.util.List;

import javax.persistence.Query;
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

	@Override
	public Territory fetchSpecificTerritory(int id) {
		// TODO Auto-generated method stub
		Query query = entityManager.createQuery("select t from Territory t where t.id=:id");
		query.setParameter("id", id);
		List<Territory> territoryList = query.getResultList();
		Territory territory = null;
		for(Territory t: territoryList){
			territory = new Territory();
			territory.setId(t.getId());
			territory.setEncoded_polyline(t.getEncoded_polyline());
			territory.setFaction_description(t.getFaction_description());
			territory.setLevel(t.getLevel());
			territory.setStatus(t.getStatus());
			territory.setTime_stamp(t.getTime_stamp());
			territory.setFaction(t.getFaction());
		}
		return territory;
	}
	
	
}