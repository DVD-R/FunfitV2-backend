package com.funfit.usjr.thesis.backend.data.dao.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.GenericDao;
import com.funfit.usjr.thesis.backend.models.Velocity;

@Transactional
public interface VelocityDao extends GenericDao<Velocity>{
	public List<Velocity> index();
}
