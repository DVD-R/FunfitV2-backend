package com.funfit.usjr.thesis.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "food")
public class Food {

	@Id @GeneratedValue
	private int foodId;
	
	@Column(name = "calories")
	private double calories;
	
	@Column(name = "carbohydrate")
	private double carbohydrate;
	
	@Column(name = "cholesterol")
	private double cholesterol;
	
	@Column(name = "course")
	private String course;
	
	@Column(name = "fat")
	private double fat;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "protein")
	private double protein;
	
	@Column(name = "sodium")
	private double sodium;
	
	public Food(){}

	public Food(int foodId, double calories, double carbohydrate, double cholesterol, String course, double fat,
			String name, double protein, double sodium) {
		super();
		this.foodId = foodId;
		this.calories = calories;
		this.carbohydrate = carbohydrate;
		this.cholesterol = cholesterol;
		this.course = course;
		this.fat = fat;
		this.name = name;
		this.protein = protein;
		this.sodium = sodium;
	}

	public int getFoodId() {
		return foodId;
	}

	public void setFoodId(int foodId) {
		this.foodId = foodId;
	}

	public double getCalories() {
		return calories;
	}

	public void setCalories(double calories) {
		this.calories = calories;
	}

	public double getCarbohydrate() {
		return carbohydrate;
	}

	public void setCarbohydrate(double carbohydrate) {
		this.carbohydrate = carbohydrate;
	}

	public double getCholesterol() {
		return cholesterol;
	}

	public void setCholesterol(double cholesterol) {
		this.cholesterol = cholesterol;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public double getFat() {
		return fat;
	}

	public void setFat(double fat) {
		this.fat = fat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public double getSodium() {
		return sodium;
	}

	public void setSodium(double sodium) {
		this.sodium = sodium;
	}
}
