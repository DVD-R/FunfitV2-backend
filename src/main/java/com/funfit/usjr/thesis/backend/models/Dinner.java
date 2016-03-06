package com.funfit.usjr.thesis.backend.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Dinner")
public class Dinner implements Serializable{

	@Id @GeneratedValue
	private int dinnerId;
	
	@ManyToOne
	@JoinColumn(name = "foodId", referencedColumnName = "foodId")
	private Food food;
	
	public Dinner(){}

	public Dinner(int dinnerId, Food food) {
		super();
		this.dinnerId = dinnerId;
		this.food = food;
	}

	public int getDinnerId() {
		return dinnerId;
	}

	public void setDinnerId(int dinnerId) {
		this.dinnerId = dinnerId;
	}

	public Food getFood() {
		return food;
	}
	
	public void setFood(Food food) {
		this.food = food;
	}
	
	
}
