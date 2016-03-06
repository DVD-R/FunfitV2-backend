package com.funfit.usjr.thesis.backend.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Lunch")
public class Lunch implements Serializable{

	@Id @GeneratedValue
	private int lunchId;
	
	@ManyToOne
	@JoinColumn(name = "foodId", referencedColumnName = "foodId")
	private Food food;

	public Lunch(){}
	
	public Lunch(int lunchId, Food food) {
		super();
		this.lunchId = lunchId;
		this.food = food;
	}

	public int getLunchId() {
		return lunchId;
	}

	public void setLunchId(int lunchId) {
		this.lunchId = lunchId;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}
	
	
}
