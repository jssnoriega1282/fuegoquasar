package com.challenge.fuegoquasar.service;

import org.springframework.stereotype.Service;

@Service
public interface LocationService {
	
	double[] getLocation(double[][] positions, double[] distances);
}
