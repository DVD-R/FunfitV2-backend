package com.funfit.usjr.thesis.backend.dto;

import java.io.Serializable;

public class RequestCapture implements Serializable{

private String faction_description;
private int userId;
private int territoryId;

public RequestCapture(){}

public RequestCapture(String faction_description, int userId, int territoryId) {
	super();
	this.faction_description = faction_description;
	this.userId = userId;
	this.territoryId = territoryId;
}

public String getFaction_description() {
	return faction_description;
}

public void setFaction_description(String faction_description) {
	this.faction_description = faction_description;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}

public int getTerritoryId() {
	return territoryId;
}

public void setTerritoryId(int territoryId) {
	this.territoryId = territoryId;
}
}
