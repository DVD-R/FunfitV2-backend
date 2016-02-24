package com.funfit.usjr.thesis.backend.data.dao.service;

import java.util.List;

import com.funfit.usjr.thesis.backend.data.dao.GenericDao;
import com.funfit.usjr.thesis.backend.models.Territory;

public interface TerritoryDao extends GenericDao<Territory>{
	public List<Territory> index();
}
