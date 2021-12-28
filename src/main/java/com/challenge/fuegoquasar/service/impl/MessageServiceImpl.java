package com.challenge.fuegoquasar.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Component;

import com.challenge.fuegoquasar.dto.Satellite;
import com.challenge.fuegoquasar.exception.MessageException;
import com.challenge.fuegoquasar.service.MessageService;
import com.challenge.fuegoquasar.util.UtilMapper;

@Component
public class MessageServiceImpl implements MessageService {

	@Override
	public String getMessage(List<Satellite> satellites) throws MessageException {
		String menssage = "";
		if(satellites != null && satellites.size() > 0) {
			List<String[]> allMessages = UtilMapper.getAllMessages(satellites);
			if(allMessages != null && allMessages.size() > 0) {
				HashMap<Integer, String> valores = new HashMap<Integer, String>();
				for(String[] msg : allMessages) {
					for(int i=0;i<msg.length; i++) {						
						if(valores.containsKey(i)) {
							if(!msg[i].equals("")) {
								valores.put(i, msg[i]);
							}
						} else {
							valores.put(i, msg[i]);
						}
					}					
				}
				for(String val: valores.values()) {
					menssage = menssage.concat(val).concat(" ");
				}
			} else {
				throw new MessageException("No se pudo detemrinar el mensaje");
			}
		} 
		return menssage;
	}

}
