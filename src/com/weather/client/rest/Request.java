package com.weather.client.rest;

import com.weather.client.WeatherClientConfig;

public class Request {

	public static String getRequestByName(String city) {

		return WeatherClientConfig.weatherApi + RequestUrlParam.query + city
				+ RequestUrlParam.urlBind + RequestUrlParam.modeXml
				+ RequestUrlParam.urlBind + RequestUrlParam.unitMetric;
	}

	public static String getRequestByLocation(String latitude, String longitude) {

		return WeatherClientConfig.weatherApi + 
				RequestUrlParam.latitude + latitude
				+ RequestUrlParam.urlBind + RequestUrlParam.longitude + longitude
				+ RequestUrlParam.urlBind + RequestUrlParam.modeXml
				+ RequestUrlParam.urlBind + RequestUrlParam.unitMetric;
	}

}
