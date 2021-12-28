package com.challenge.fuegoquasar.service.impl;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.challenge.fuegoquasar.dto.Position;
import com.challenge.fuegoquasar.dto.ResponseQuasar;
import com.challenge.fuegoquasar.dto.Satellite;
import com.challenge.fuegoquasar.exception.LocationException;
import com.challenge.fuegoquasar.exception.MessageException;
import com.challenge.fuegoquasar.service.LocationService;
import com.challenge.fuegoquasar.service.MessageService;
import com.challenge.fuegoquasar.service.QuasarService;
import com.challenge.fuegoquasar.util.UtilMapper;

@Component
public class QuasarServiceImpl implements QuasarService {
	
	@Autowired
	private LocationService locationService;
	
	@Autowired
	private MessageService messageService;

	@Override
	public ResponseQuasar topSecret(List<Satellite> satellites) throws LocationException, MessageException {
		ResponseQuasar response = new ResponseQuasar();		
		//OBTENER LA POSICIÓN DE LA NAVE IMPERIAL
		double[] positions = locationService.getLocation(UtilMapper.getAllPoints(satellites), 
				UtilMapper.getAllDistances(satellites));
		if(positions != null && positions.length > 0) {
			response.setPosition(new Position(positions[0], positions[1]));
		} else {
			throw new LocationException("No se pudo determinar la posición nave enemiga");
		}
		//OBTENER EL MENSAJE SECRETO
		response.setMessage(messageService.getMessage(satellites));
		return response;
	}
	
	@Override
	public ResponseQuasar topscretSplit(double distance, String[] messages) throws LocationException, MessageException {
		ResponseQuasar response = null;
		if(distance > 0) {
			Position position = UtilMapper.getPosition(distance, messages);
			if(position != null) {
				response = new ResponseQuasar();
				response.setPosition(position);
				response.setMessage("");
			} else {
				throw new LocationException("No hay suficiente información");
			}
		} else {
			throw new LocationException("No hay suficiente información");
		}	
		return response;
	}
	
	
	@Override
	public ResponseQuasar topscretSplit(String nameSatellite) throws LocationException, MessageException {
		ResponseQuasar response = null;
		if(nameSatellite != null) {
			Position position = UtilMapper.getPosition(nameSatellite);
			if(position != null) {
				response = new ResponseQuasar();
				response.setPosition(position);
				response.setMessage("");
			} else {
				throw new LocationException("No hay suficiente información");
			}
		} else {
			throw new LocationException("No hay suficiente información");
		}	
		return response;
	}

}
