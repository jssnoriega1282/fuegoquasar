package com.challenge.fuegoquasar.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.challenge.fuegoquasar.dto.ResponseQuasar;
import com.challenge.fuegoquasar.dto.Satellite;
import com.challenge.fuegoquasar.exception.LocationException;
import com.challenge.fuegoquasar.exception.MessageException;

@Service
public interface QuasarService {
	
	ResponseQuasar topSecret(List<Satellite> satellites) throws LocationException, MessageException;
	
	ResponseQuasar topscretSplit(double distance, String[] messages) throws LocationException, MessageException;
	
	ResponseQuasar topscretSplit(String nameSatellite) throws LocationException, MessageException;

}
