package com.challenge.fuegoquasar.dto;

import java.io.Serializable;
import java.util.List;

public class QuasarRequestBody implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<Satellite> satellites;

	public List<Satellite> getSatellites() {
		return satellites;
	}

	public void setSatellites(List<Satellite> satellites) {
		this.satellites = satellites;
	}

}
