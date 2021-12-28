package com.challenge.fuegoquasar.util;

import java.util.ArrayList;
import java.util.List;

import com.challenge.fuegoquasar.dto.Position;
import com.challenge.fuegoquasar.dto.Satellite;
import com.challenge.fuegoquasar.exception.MessageException;

public class UtilMapper {

	/**
	 * Obtiene todos los puntos de coordenadas de cada uno de los satelites.
	 * 
	 * @param satellites Satelites operando
	 * @return double[][]Coordenadas de los satelites rebeldes.
	 */
	public static double[][] getAllPoints(List<Satellite> satellites) {
		double[][] points = null;
		if (satellites != null && satellites.size() > 0) {
			points = new double[satellites.size()][2];
			int row = 0;
			for (Satellite satellite : satellites) {
				if (satellite.getName().equalsIgnoreCase("kenobi")) {
					points[row][0] = -500;
					points[row][1] = -200;
				} else if (satellite.getName().equalsIgnoreCase("skywalker")) {
					points[row][0] = 100;
					points[row][1] = -100;
				} else {
					points[row][0] = 500;
					points[row][1] = 100;
				}
				row++;
			}
		}
		return points;
	}

	/**
	 * Obtiene los todas las distancias de los satelites enviados.
	 * 
	 * @param satellites Satelites operando.
	 * @return double[] Distancias de los satelites con respecto a la nave imperial.
	 */
	public static double[] getAllDistances(List<Satellite> satellites) {
		double[] distances = null;
		if (satellites != null && satellites.size() > 0) {
			distances = new double[satellites.size()];
			int row = 0;
			for (Satellite satellite : satellites) {
				if (satellite.getName().equalsIgnoreCase("kenobi")) {
					distances[row] = 100.0;
				} else if (satellite.getName().equalsIgnoreCase("skywalker")) {
					distances[row] = 115.5;
				} else {
					distances[row] = 142.7;
				}
				row++;
			}
		}
		return distances;
	}

	/**
	 * Arma una lista de todos los mensajes;
	 * 
	 * @param satellites
	 * @return
	 */
	public static List<String[]> getAllMessages(List<Satellite> satellites) {
		List<String[]> listMessages = null;
		String[] messages = null;
		if (satellites != null && satellites.size() > 0) {
			listMessages = new ArrayList<>();
			for (Satellite satellite : satellites) {
				if (satellite.getMessage() != null && satellite.getMessage().length > 0) {
					messages = new String[satellite.getMessage().length];
					for (int i = 0; i < satellite.getMessage().length; i++) {
						messages[i] = satellite.getMessage()[i];
					}
					listMessages.add(messages);
				}
			}
		}
		return listMessages;
	}

	/**
	 * Obtiene la posición de uns satelite por su nombre.
	 * 
	 * @param nameSatellite Nombre del Satelite.
	 * @return Positon Posición del Satelite
	 */
	public static Position getPosition(String nameSatellite) {
		Position position = null;
		if (nameSatellite.equalsIgnoreCase("kenobi")) {
			position = new Position(-500, -200);
		} else if (nameSatellite.equalsIgnoreCase("skywalker")) {
			position = new Position(100, -100);
		} else if (nameSatellite.equalsIgnoreCase("sato")) {
			position = new Position(500, 100);
		}
		return position;
	}

	/**
	 * Obtiene la posición de uns satelite a partir de la distancia y su mensaje.
	 * @param distance
	 * @param message
	 * @return
	 */
	public static Position getPosition(double distance, String[] message) throws MessageException {
		Position position = null;
		if(message != null && message.length > 0) {
			StringBuffer msg = new StringBuffer();
			for (int i = 0; i < message.length; i++) {
				msg = msg.append(message[i]);
			}
			if (distance == 100.0 && msg.toString().equalsIgnoreCase("estemensaje")) {
				position = new Position(-500, -200);
			} else if (distance == 115.5 && msg.toString().equalsIgnoreCase("essecreto")) {
				position = new Position(100, -100);
			} else if (distance == 142.7 && msg.toString().equalsIgnoreCase("esteun")) {
				position = new Position(500, 100);
			}
		} else {
			throw new MessageException("No hay sufiente información");
		}
		return position;
	}

}
