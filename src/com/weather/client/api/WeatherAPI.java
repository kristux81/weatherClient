package com.weather.client.api;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.weather.client.rest.HttpResponseException;
import com.weather.client.rest.Request;
import com.weather.client.rest.Response;
import com.weather.client.rest.RestClient;
import com.weather.model.Weather;

public class WeatherAPI {

	private static final Logger LOG = Logger.getLogger(WeatherAPI.class
			.getName());

	public static Weather getWeatherByCity(String city) {

		String url = Request.getRequestByName(city);

		Object response = null;
		try {
			response = RestClient.request(url);
		} catch (HttpResponseException e) {
			LOG.log(Level.WARNING, "", e);
		}

		// debug
		// System.out.println(Response.toString(response));

		// JAXB Parsing response to weather object
		return Response.parse(response);
	}

	public static Weather getWeatherByCoordinates(String latitude,
			String longitude) {

		String url = Request.getRequestByLocation(latitude, longitude);

		Object response = null;
		try {
			response = RestClient.request(url);
		} catch (HttpResponseException e) {
			LOG.log(Level.WARNING, "", e);
		}

		// debug
		// System.out.println(Response.toString(response));

		// JAXB Parsing response to weather object
		return Response.parse(response);
	}

}
