package com.weather.client;

/**
 * @author krvsingh
 *
 */
public interface WeatherClientConfig {

	/**
	 * External properties file : must be provided in CLASSPATH
	 */
	String clientPropertiesFile = "client.properties";
	
	/**
	 * Our weather API
	 */
	String weatherApi = "http://api.openweathermap.org/data/2.5/weather?";
	
	/**
	 * response read time out : value in mills.
	 * increase it for slow networks 
	 */
	int readTimeOut = 5000 ;
	
	/**
	 * connection time out : value in mills.
	 */
	int connectTimeOut = 3000 ;
}
