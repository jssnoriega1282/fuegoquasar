package com.challenge.fuegoquasar.dto;

import java.io.Serializable;

public class ResponseQuasar implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Position position;	
	private String message;
	
	public Position getPosition() {
		return position;
	}
	
	public void setPosition(Position position) {
		this.position = position;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}	
	

}
