package com.challenge.fuegoquasar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.challenge.fuegoquasar.dto.QuasarRequestBody;
import com.challenge.fuegoquasar.dto.ResponseQuasar;
import com.challenge.fuegoquasar.dto.Satellite;
import com.challenge.fuegoquasar.exception.LocationException;
import com.challenge.fuegoquasar.exception.MessageException;
import com.challenge.fuegoquasar.service.QuasarService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="quasar")
@RestController
@RequestMapping("/api")
public class QuasarController {
	
	@Autowired
	private QuasarService quasarService;
	
	@ApiOperation(value = "/topsecret", notes = "Intercepta la posición y mensajes de naves imperiales")
	@PostMapping(value = "/topsecret", path = "/topsecret", name = "Top Secret", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> topSecret(@RequestBody QuasarRequestBody requestBody){
		try {
			ResponseQuasar response = quasarService.topSecret(requestBody.getSatellites());
			return new ResponseEntity<ResponseQuasar>(response, HttpStatus.OK);
		} catch (LocationException | MessageException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "/topsecret_split", notes = "Obtiene la posición de un satelite de acuerdo a su distancia y mensaje")
	@PostMapping(value = "/topsecret_split", path = "/topsecret_split", name = "Top Secret Split", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> topSecret(@RequestBody Satellite satellite){
		try {
			ResponseQuasar response = quasarService.topscretSplit(satellite.getDistance(), satellite.getMessage());
			return new ResponseEntity<ResponseQuasar>(response, HttpStatus.OK);
		} catch (LocationException | MessageException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@ApiOperation(value = "/topsecret_split/{satellite_name}", notes = "Obtiene la posición de un satelite de acuerdo a su nombre")
	@GetMapping(value = "/topsecret_split/{satellite_name}", path = "/topsecret_split/{satellite_name}", name = "Top Secret Split", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> topSecret(@PathVariable(value = "satellite_name") String satellite_name){
		try {
			ResponseQuasar response = quasarService.topscretSplit(satellite_name);
			return new ResponseEntity<ResponseQuasar>(response, HttpStatus.OK);
		} catch (LocationException | MessageException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	

}
