package com.challenge.fuegoquasar.dto;

import java.io.Serializable;

public class Satellite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private Double distance;
	private String[] message;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Double getDistance() {
		return distance;
	}
	
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
	public String[] getMessage() {
		return message;
	}
	
	public void setMessage(String[] message) {
		this.message = message;
	}
	
	

	
}
