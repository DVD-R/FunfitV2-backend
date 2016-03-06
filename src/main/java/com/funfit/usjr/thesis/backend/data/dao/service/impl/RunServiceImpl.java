package com.funfit.usjr.thesis.backend.data.dao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.service.RunsDao;
import com.funfit.usjr.thesis.backend.data.dao.service.UserDao;
import com.funfit.usjr.thesis.backend.dto.RequestRun;
import com.funfit.usjr.thesis.backend.models.Runs;
import com.funfit.usjr.thesis.backend.models.Users;
import com.funfit.usjr.thesis.backend.service.RunService;

@Transactional
@Service("runService")
public class RunServiceImpl implements RunService{

	@Autowired
	private RunsDao runsDao;
	
	@Autowired
	private UserDao userDao;
	
	private Users user;
	private Runs runs;
	
	@Override
	public List<Runs> saveRun(RequestRun requestRun) {
		// TODO Auto-generated method stub
		user = new Users();
		runs = new Runs();
		user = userDao.show(requestRun.getUserId());
		runs.setRunId(requestRun.getRunId());
		runs.setDate(requestRun.getDate());
		runs.setDistance(requestRun.getDistance());
		runs.setTime(requestRun.getTime());
		runs.setUserId(user.getId());
		runsDao.create(runs);
		
		return runsDao.index();
	}

	@Override
	public List<Runs> queryRun(int userId) {
		// TODO Auto-generated method stub
		return runsDao.queryMeal(userId);
	}


}
