package com.funfit.usjr.thesis.backend;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.funfit.usjr.thesis.backend.dto.RequestRun;
import com.funfit.usjr.thesis.backend.models.Runs;
import com.funfit.usjr.thesis.backend.service.RunService;

@RestController
public class RunsController {

	@Autowired
	private RunService runService;
	
	@RequestMapping(value = "/saveRun",
					consumes = MediaType.APPLICATION_JSON_VALUE,
					produces = MediaType.APPLICATION_JSON_VALUE,
					method = RequestMethod.POST)
	public List<Runs> saveRun(@RequestBody RequestRun requestRun){
		return runService.saveRun(requestRun);
	}

	@RequestMapping(value = "/queryRun",
					produces = MediaType.APPLICATION_JSON_VALUE,
					method = RequestMethod.GET)
	public List<Runs> queryRun(@RequestParam(value = "userId") int userId){
		return runService.queryRun(userId);
	}

}
