package com.funfit.usjr.thesis.backend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.funfit.usjr.thesis.backend.data.dao.service.TerritoryDao;
import com.funfit.usjr.thesis.backend.dto.RequestCapture;
import com.funfit.usjr.thesis.backend.dto.ResponseTerritory;
import com.funfit.usjr.thesis.backend.models.Territory;
import com.funfit.usjr.thesis.backend.service.CaptureTerritoryService;

@RestController
public class TerritoryController {

	@Autowired
	private TerritoryDao territoryDao;
	
	@Autowired
	private CaptureTerritoryService captureTerritoryService;
	
	@RequestMapping(value = "/getTerritory",
					produces = MediaType.APPLICATION_JSON_VALUE,
					method = RequestMethod.GET)
	public List<ResponseTerritory> getTerritory(){
		List<Territory> listTerritory = territoryDao.index();
		ResponseTerritory responseTerritory = null;
		List<ResponseTerritory> listResponseTerritory = new ArrayList<>();
		for(Territory territory: listTerritory){
			responseTerritory = new ResponseTerritory();
			responseTerritory.setId(territory.getId());
			responseTerritory.setEncoded_polyline(territory.getEncoded_polyline());
			responseTerritory.setLevel(territory.getLevel());
			responseTerritory.setStatus(territory.getStatus());
			responseTerritory.setFaction_description(territory.getFaction_description());
			listResponseTerritory.add(responseTerritory);
		}
		
		return  listResponseTerritory;
	}
	
	@RequestMapping(value = "/captureTerritory",
					consumes = MediaType.APPLICATION_JSON_VALUE,
					method = RequestMethod.POST)
	public List<ResponseTerritory> captureTerritory(@RequestBody RequestCapture requestCapture){
		
	return captureTerritoryService.captureTerritory(requestCapture);	
	}
}