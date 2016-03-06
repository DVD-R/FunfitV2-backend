package com.funfit.usjr.thesis.backend.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Runs")
public class Runs implements Serializable{

	@Id
	private int runId;

	@Column(name = "date")
	private String date;

	@Column(name = "distance")
	private int distance;

	@Column(name = "time")
	private int time;
	
	@Column(name = "userId")
	private int userId;
	
	public Runs(){}

	public Runs(int runId, String date, int distance, int time, int userId) {
		super();
		this.runId = runId;
		this.date = date;
		this.distance = distance;
		this.time = time;
		this.userId = userId;
	}

	public int getRunId() {
		return runId;
	}

	public void setRunId(int runId) {
		this.runId = runId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}