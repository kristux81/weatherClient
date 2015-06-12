package com.weather.client.rest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.weather.client.WeatherClientConfig;

/**
 * @author krvsingh
 *
 */
public class RestClient {

	public static Object request(String resourceUrl)
			throws HttpResponseException {

		try {
			HttpURLConnection connection = (HttpURLConnection) new URL(
					resourceUrl).openConnection();

			connection.setRequestMethod("GET");

			// As real time as it may get !! : we do not want to cache responses
			connection.setRequestProperty("pragma", "no-cache");

			connection.setConnectTimeout(WeatherClientConfig.connectTimeOut);

			// parameter disabled since we do not know server response time yet.
			// CAUTION : ideally it must be set
			// may lead to application hang for some time
			//connection.setReadTimeout(WeatherClientConfig.readTimeOut);

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
