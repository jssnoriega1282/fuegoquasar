package com.challenge.fuegoquasar.service.impl;

import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.springframework.stereotype.Component;

import com.challenge.fuegoquasar.service.LocationService;
import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;

@Component
public class LocationServiceImpl implements LocationService {

	@Override
	public double[] getLocation(double[][] positions, double[] distances) {		
		TrilaterationFunction puntosATrigangular = new TrilaterationFunction(positions, distances);
		NonLinearLeastSquaresSolver solucionPuntos = new NonLinearLeastSquaresSolver(puntosATrigangular, new LevenbergMarquardtOptimizer());
		return solucionPuntos.solve().getPoint().toArray();		
	}

}
