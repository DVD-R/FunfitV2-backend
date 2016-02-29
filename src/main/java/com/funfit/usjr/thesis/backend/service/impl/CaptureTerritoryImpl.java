package com.funfit.usjr.thesis.backend.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.funfit.usjr.thesis.backend.data.dao.service.FactionDao;
import com.funfit.usjr.thesis.backend.data.dao.service.TerritoryDao;
import com.funfit.usjr.thesis.backend.data.dao.service.UserDao;
import com.funfit.usjr.thesis.backend.dto.RequestCapture;
import com.funfit.usjr.thesis.backend.dto.ResponseTerritory;
import com.funfit.usjr.thesis.backend.models.Faction;
import com.funfit.usjr.thesis.backend.models.Territory;
import com.funfit.usjr.thesis.backend.models.Users;
import com.funfit.usjr.thesis.backend.service.CaptureTerritoryService;
import com.funfit.usjr.thesis.backend.service.NotificationService;

@Transactional
@Service("captureTerritoryService")
public class CaptureTerritoryImpl implements CaptureTerritoryService{

	
	@Autowired
	FactionDao factionDao;
	
	@Autowired
	NotificationService notificationService;
	
	@Autowired
	TerritoryDao territoryDao;
	
	@Autowired
	UserDao userDao;
	
	@Override
	public List<ResponseTerritory> captureTerritory(RequestCapture requestCapture) {
		// TODO Auto-generated method stub
		Faction faction = new Faction();
		Territory territory = new Territory();
		faction = factionDao.query(requestCapture.getUserId());
		territory = territoryDao.fetchSpecificTerritory(requestCapture.getTerritoryId());
		Date dateobj = new Date();

		try{
		switch(territory.getFaction_description()){
		
		case "impulse":
			
			if(requestCapture.getFaction_description().equals("impulse")){
				territory.setLevel(territory.getLevel()+1);
				territory.setStatus("captured");
				territory.setTime_stamp(dateobj);
				territory.setUser_id(requestCapture.getUserId());
				territoryDao.update(territory);
			}else if(requestCapture.getFaction_description().equals("velocity")){
				if(territory.getLevel() >= 1){
				territory.setLevel(territory.getLevel()-1);
				territory.setStatus("captured");
				territory.setTime_stamp(dateobj);
				territory.setUser_id(requestCapture.getUserId());
				territoryDao.update(territory);
				}else if(territory.getLevel() == 0){
					territory.setFaction_description(requestCapture.getFaction_description());
					territory.setLevel(1);
					territory.setStatus("captured");
					territory.setTime_stamp(dateobj);
					territory.setFaction(faction);
					List<String> items = new ArrayList<>();
					
					Users userInvader = new Users();
					userInvader = userDao.show(requestCapture.getUserId());
					
					Territory t = new Territory();
					t = territoryDao.show(requestCapture.getTerritoryId());
					Users userDefender = new Users();
					userDefender = userDao.show(t.getId());
					
					items.add(userInvader.getGcmKey());
					items.add(userDefender.getGcmKey());
					
					notificationService.broadcast(items);
					
					territory.setUser_id(requestCapture.getUserId());
					territoryDao.update(territory);
				}
			}
			
			break;
		
		case "velocity": 
			
			if(requestCapture.getFaction_description().equals("velocity")){
				territory.setLevel(territory.getLevel()+1);
				territory.setStatus("captured");
				territory.setTime_stamp(dateobj);
				territory.setUser_id(requestCapture.getUserId());
				territoryDao.update(territory);
				
			}else if(requestCapture.getFaction_description().equals("impulse")){
				if(territory.getLevel() >= 1){
					territory.setLevel(territory.getLevel()-1);
					territory.setStatus("captured");
					territory.setTime_stamp(dateobj);
					territory.setUser_id(requestCapture.getUserId());
					territoryDao.update(territory);
					}else if(territory.getLevel() == 0){
						territory.setFaction_description(requestCapture.getFaction_description());
						territory.setLevel(1);
						territory.setStatus("captured");
						territory.setTime_stamp(dateobj);
						territory.setFaction(faction);
					
						List<String> items = new ArrayList<>();
						
						Users userInvader = new Users();
						userInvader = userDao.show(requestCapture.getUserId());
						
						Territory t = new Territory();
						t = territoryDao.show(requestCapture.getTerritoryId());
						Users userDefender = new Users();
						userDefender = userDao.show(t.getId());
						
						items.add(userInvader.getGcmKey());
						items.add(userDefender.getGcmKey());
						
						notificationService.broadcast(items);
						
						territory.setUser_id(requestCapture.getUserId());
						territoryDao.update(territory);
					}	
			}
			
			break;
		}
		}catch(Exception e){
			territory.setFaction_description(requestCapture.getFaction_description());
			territory.setLevel(1);
			territory.setStatus("captured");
			territory.setTime_stamp(dateobj);
			territory.setFaction(faction);
			territory.setUser_id(requestCapture.getUserId());
			territoryDao.update(territory);
		}
				
		ResponseTerritory responseTerritory = null;
		List<ResponseTerritory> listTerritory = new ArrayList<>();
		
		for(Territory t: territoryDao.index()){
			responseTerritory = new ResponseTerritory();
			responseTerritory.setId(t.getId());
			responseTerritory.setEncoded_polyline(t.getEncoded_polyline());
			responseTerritory.setFaction_description(t.getFaction_description());
			responseTerritory.setLevel(t.getLevel());
			responseTerritory.setStatus(t.getStatus());
			listTerritory.add(responseTerritory);
		}
		
		return listTerritory;
	}


	
}
