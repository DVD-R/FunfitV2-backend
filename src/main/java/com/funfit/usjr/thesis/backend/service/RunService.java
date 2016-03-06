package com.funfit.usjr.thesis.backend.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.funfit.usjr.thesis.backend.dto.RequestRun;
import com.funfit.usjr.thesis.backend.models.Runs;

public interface RunService {
	public List<Runs> saveRun(RequestRun requestRun);
	public List<Runs> queryRun(int userId);
}
