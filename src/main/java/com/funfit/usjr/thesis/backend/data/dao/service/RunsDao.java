package com.funfit.usjr.thesis.backend.data.dao.service;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.GenericDao;
import com.funfit.usjr.thesis.backend.dto.RequestRun;
import com.funfit.usjr.thesis.backend.models.Meals;
import com.funfit.usjr.thesis.backend.models.Runs;
import com.funfit.usjr.thesis.backend.models.Users;

@Transactional
public interface RunsDao extends GenericDao<Runs>{
	public List<Runs> index();
	public List<Runs> queryMeal(int userId);
	public boolean checkRun(RequestRun requestRun);
}
