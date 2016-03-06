package com.funfit.usjr.thesis.backend.dto;

import java.io.Serializable;

public class ResponseStatus implements Serializable{

	private boolean status;
	
	public ResponseStatus(){}

	public ResponseStatus(boolean status) {
		super();
		this.status = status;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
