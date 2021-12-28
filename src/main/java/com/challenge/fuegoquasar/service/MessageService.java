package com.challenge.fuegoquasar.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.challenge.fuegoquasar.dto.Satellite;
import com.challenge.fuegoquasar.exception.MessageException;

@Service
public interface MessageService {
	
	String getMessage(List<Satellite> satellites) throws MessageException;
	
}
