package com.funfit.usjr.thesis.backend.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "breakfast")
public class Breakfast implements Serializable{

	
	@Id @GeneratedValue
	private int breakfastId;
	
	@ManyToOne
	@JoinColumn(name = "foodId", referencedColumnName = "foodId")
	private Food food;

	public Breakfast(){}

	public Breakfast(int breakfastId, Food food) {
		super();
		this.breakfastId = breakfastId;
		this.food = food;
	}

	public int getBreakfastId() {
		return breakfastId;
	}

	public void setBreakfastId(int breakfastId) {
		this.breakfastId = breakfastId;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}
	
}
