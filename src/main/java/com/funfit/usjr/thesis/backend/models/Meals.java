package com.funfit.usjr.thesis.backend.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Meals")
public class Meals implements Serializable{

	@Id @GeneratedValue
	private int meal_id;
	
	@Column(name = "date")
	private String date;
	
	@ManyToOne
	@JoinColumn(name = "breakfastId", referencedColumnName = "breakfastId")
	private Breakfast breakfast;
	
	@ManyToOne
	@JoinColumn(name = "lunchId", referencedColumnName = "lunchId")
	private Lunch lunch;
	
	@ManyToOne
	@JoinColumn(name = "dinnerId", referencedColumnName = "dinnerId")
	private Dinner dinner;
	
	@ManyToOne
	@JoinColumn(name = "snackId", referencedColumnName = "snackId")
	private Snack snack;
	
	@Column(name = "userId")
	private int userId;
	
	public Meals() {}

	public Meals(int meal_id, String date, Breakfast breakfast, Lunch lunch, Dinner dinner, Snack snack ,int userId) {
		super();
		this.meal_id = meal_id;
		this.date = date;
		this.breakfast = breakfast;
		this.lunch = lunch;
		this.dinner = dinner;
		this.snack = snack;
		this.userId = userId;
	}

	public int getMeal_id() {
		return meal_id;
	}

	public void setMeal_id(int meal_id) {
		this.meal_id = meal_id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Breakfast getBreakfast() {
		return breakfast;
	}

	public void setBreakfast(Breakfast breakfast) {
		this.breakfast = breakfast;
	}

	public Lunch getLunch() {
		return lunch;
	}

	public void setLunch(Lunch lunch) {
		this.lunch = lunch;
	}

	public Dinner getDinner() {
		return dinner;
	}

	public void setDinner(Dinner dinner) {
		this.dinner = dinner;
	}

	
	
	public Snack getSnack() {
		return snack;
	}

	public void setSnack(Snack snack) {
		this.snack = snack;
	}

	public int getUserId() {
		return userId;
	}

	public void setUsers(int userId) {
		this.userId = userId;
	}
	
}
