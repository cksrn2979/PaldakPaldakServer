package com.example.changoo.model;

import com.google.gson.Gson;

public class Fish {
	String id;
	String user_id;
	String name;
	String species;
	String imgLocation;
	double maxFower;
	double agvFower;
	double weight;
	String date;
	double time;
	String GPS;

	public Fish() {
		super();
	}

	public Fish(String id, String user_id, String name, String species, String imgLocation, double maxFower,
			double agvFower, double weight, String date, double time, String GPS) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.name = name;
		this.species = species;
		this.imgLocation = imgLocation;
		this.maxFower = maxFower;
		this.agvFower = agvFower;
		this.weight = weight;
		this.date = date;
		this.time = time;
		this.GPS = GPS;
	}
	
	public String toString(){
		Gson gson=new Gson();
		return gson.toJson(this);
	}
	 
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getImgLocation() {
		return imgLocation;
	}

	public void setImgLocation(String imgLocation) {
		this.imgLocation = imgLocation;
	}

	public double getMaxFower() {
		return maxFower;
	}

	public void setMaxFower(double maxFower) {
		this.maxFower = maxFower;
	}

	public double getAgvFower() {
		return agvFower;
	}

	public void setAgvFower(double agvFower) {
		this.agvFower = agvFower;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}

	public String getGPS() {
		return GPS;
	}

	public void setGPS(String GPS) {
		this.GPS = GPS;
	}

}
