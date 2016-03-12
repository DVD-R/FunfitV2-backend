package com.funfit.usjr.thesis.backend.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Snacks")
public class Snack implements Serializable{
	
	@Id @GeneratedValue
	private int snackId;
	
	@ManyToOne
	@JoinColumn(name = "foodId", referencedColumnName = "foodId")
	private Food food;

	public Snack(){}

	public Snack(int snackId, Food food) {
		super();
		this.snackId = snackId;
		this.food = food;
	}

	public int getSnackId() {
		return snackId;
	}

	public void setSnackId(int snackId) {
		this.snackId = snackId;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}
}
