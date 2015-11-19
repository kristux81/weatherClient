package com.weather.client.rest;

import com.weather.client.WeatherClientConfig;

public class Request {

	public static String getRequestByName(String city, String accID) {

		return WeatherClientConfig.weatherApi + RequestUrlParam.query + city
				+ RequestUrlParam.urlBind + RequestUrlParam.modeXml
				+ RequestUrlParam.urlBind + RequestUrlParam.unitMetric
				+ RequestUrlParam.urlBind + RequestUrlParam.appid + accID;
	}

	public static String getRequestByLocation(String latitude,
			String longitude, String accID) {

		return WeatherClientConfig.weatherApi + RequestUrlParam.latitude
				+ latitude + RequestUrlParam.urlBind
				+ RequestUrlParam.longitude + longitude
				+ RequestUrlParam.urlBind + RequestUrlParam.modeXml
				+ RequestUrlParam.urlBind + RequestUrlParam.unitMetric
				+ RequestUrlParam.urlBind + RequestUrlParam.appid + accID;
	}

}
