package com.funfit.usjr.thesis.backend.service;

import java.util.List;

import com.funfit.usjr.thesis.backend.dto.RequestRun;
import com.funfit.usjr.thesis.backend.models.Runs;

public interface RunService {
	public List<Runs> saveRun(RequestRun requestRun);
	public List<RequestRun> queryRun(int userId);
}