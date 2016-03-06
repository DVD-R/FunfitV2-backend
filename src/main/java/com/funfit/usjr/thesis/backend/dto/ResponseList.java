package com.funfit.usjr.thesis.backend.dto;

import java.io.Serializable;

public class ResponseList implements Serializable{

		private String userId;
		private String firstname;
		private String lastname;
		private int age;
		private String gender;
		private String activitylevel;
		private double weight;
		private double height;
		private String email;
		private String faction_description;
		private String gcmKey;
		private int points;
		
		public ResponseList(){}

		public ResponseList(String userId ,String firstname, String lastname, int age, String gender, String activitylevel, double weight, double height, String email, String faction_description, String gcmKey,
				int points){
			this.userId = userId;
			this.firstname = firstname;
			this.lastname = lastname;
			this.age = age;
			this.gender = gender;
			this.activitylevel = activitylevel;
			this.weight = weight;
			this.height = height;
			this.email = email;
			this.faction_description = faction_description;
			this.gcmKey = gcmKey;
			this.points = points;
		}


		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getActivitylevel() {
			return activitylevel;
		}

		public void setActivitylevel(String activitylevel) {
			this.activitylevel = activitylevel;
		}

		public double getWeight() {
			return weight;
		}

		public void setWeight(double weight) {
			this.weight = weight;
		}

		public double getHeight() {
			return height;
		}

		public void setHeight(double height) {
			this.height = height;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getFaction_description() {
			return faction_description;
		}

		public void setFaction_description(String faction_description) {
			this.faction_description = faction_description;
		}

		public String getUserId() {
			return userId;
		}

		public void setUserId(String userId) {
			this.userId = userId;
		}

		public void setGcmKey(String gcmKey){
			this.gcmKey = gcmKey;
		}

		public String getGcmKey(){
			return gcmKey;
		}

		public int getPoints() {
			return points;
		}

		public void setPoints(int points) {
			this.points = points;
		}
		
		
	
}
