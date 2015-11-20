package com.weather.client.rest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.weather.client.WeatherClientConfig;
import com.weather.client.commons.Utils;

/**
 * @author krvsingh
 *
 */
public class RestClient {

	public static boolean config = false;
	public static int readTimeOut;
	public static int connectTimeOut;

	public static void init() {

		if (!config) {

			readTimeOut = Integer.parseInt(Utils.getPropertyFromFile(
					WeatherClientConfig.clientPropertiesFile,
					"client.read.timeout",
					String.valueOf(WeatherClientConfig.readTimeOut)));

			connectTimeOut = Integer.parseInt(Utils.getPropertyFromFile(
					WeatherClientConfig.clientPropertiesFile,
					"client.connect.timeout",
					String.valueOf(WeatherClientConfig.connectTimeOut)));
			
		   config = true ;
		}

	}

	public static Object request(String resourceUrl)
			throws HttpResponseException {

		init();

		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(
					resourceUrl).openConnection();

			connection.setRequestMethod("GET");

			// As real time as it may get !! : we do not want to cache responses
			connection.setRequestProperty("pragma", "no-cache");

			connection.setConnectTimeout(connectTimeOut);

			// parameter disabled since we do not know server response time yet.
			// CAUTION : ideally it must be set
			// may lead to application hang for some time
			// connection.setReadTimeout(readTimeOut);

			// Ok, send the request
			connection.connect();

			int response = connection.getResponseCode();
			if (response == HttpURLConnection.HTTP_OK) {

				return connection.getInputStream();
			} else {

				throw new HttpResponseException(resourceUrl,
						Response.toString(connection.getErrorStream()),
						connection.getResponseCode(),
						connection.getResponseMessage());
			}
		} catch (HttpResponseException ex) {
			throw ex;
		} catch (Exception ex) {
			Logger.getLogger(RestClient.class.getName()).log(Level.SEVERE, "",
					ex);
			return null;
		}
	}

}
