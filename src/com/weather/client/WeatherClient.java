package com.weather.client;

import java.util.logging.Logger;

import com.weather.client.api.WeatherAPI;
import com.weather.client.commons.Utils;
import com.weather.model.Weather;

/**
 * @author krvsingh
 *
 */
public class WeatherClient {

	private static final Logger LOG = Logger.getLogger(WeatherClient.class.getName());
			
	/**
	 * @param args
	 *            City => delhi => ajmer,india Coord => lat,lon
	 */
	public static void main(String[] args) {

		Weather weather = null;

		if (args.length < 1) {
			LOG.severe("City name or coordinates required as argument. Coordinates must be comma seperated without spaces");
			System.exit(-1);
		}

		if (args.length == 1) {

			String weatherApiAccountId = Utils.getPropertyFromFile(
					WeatherClientConfig.clientPropertiesFile, "weather.api.account.id");

			// may be these are coordinates but we do not know yet
			if (args[0].indexOf(',') != -1) {

				String[] coord = args[0].split(",");
				if (coord.length == 2) {

					boolean isCoordinate = true;
					try {
						Float.parseFloat(coord[0]);
					} catch (NumberFormatException e) {
						try {
							Integer.parseInt(coord[0]);
						} catch (NumberFormatException e1) {
							// ignore ( seems to be a city with country name )
							isCoordinate = false;
						}
					}

					if (isCoordinate) {
						// Weather data from Weather API by coordinates
						weather = WeatherAPI.getWeatherByCoordinates(coord[0],
								coord[1], weatherApiAccountId);
					} else {
						// Weather data from Weather API by city name
						weather = WeatherAPI.getWeatherByCity(args[0],
								weatherApiAccountId);
					}
				} else {
					LOG.severe("unsupported input format");
					System.exit(-3);
				}
			} else {
				// Weather data from Weather API by city name
				weather = WeatherAPI.getWeatherByCity(args[0],
						weatherApiAccountId);
			}
		} else {
			LOG.severe("unsupported argument list");
			System.exit(-2);
		}

		// temperature data from temperature object
		if (weather != null) {
			System.out.println(weather.getTemperature().getValue());
		}
	}

}
