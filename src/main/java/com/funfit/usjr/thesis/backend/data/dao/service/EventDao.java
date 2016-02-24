package com.funfit.usjr.thesis.backend.data.dao.service;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.GenericDao;
import com.funfit.usjr.thesis.backend.models.Event;
import com.funfit.usjr.thesis.backend.models.Impulse;

@Transactional
public interface EventDao extends GenericDao<Event>{
	public List<Event> index();
}
