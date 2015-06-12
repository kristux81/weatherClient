package com.weather.client.rest;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.weather.model.Weather;

/**
 * @author krvsingh
 *
 */
public final class Response {

	private static final Logger LOG = Logger
			.getLogger(Response.class.getName());

	public static Weather parse(Object response) {

		Weather weather = null;
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Weather.class);
			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			weather = (Weather) unmarshaller.unmarshal((InputStream) response);
		} catch (JAXBException e) {
			LOG.log(Level.SEVERE, Response.toString(response), e);
		}

		return weather;
	}

	public static String toString(Object stream) {

		StringBuilder sb = null;
		try {
			sb = new StringBuilder();
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					(InputStream) stream));
			int i;
			while ((i = reader.read()) != -1) {
				sb.append((char) i);
			}
			reader.close();

		} catch (Exception ex) {
			LOG.log(Level.SEVERE, "", ex);
		}

		return sb.toString();
	}
}
