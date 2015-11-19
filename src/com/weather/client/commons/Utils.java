package com.weather.client.commons;

/**
 * @author krvsingh
 *
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Utils {

	private static final Logger LOG = Logger.getLogger(Utils.class.getName());

	public static String getPropertyFromFile(String file, String key) {
		
		LOG.info("Reading Key : " + key + " From file : " + file);

		try {
			return getPropertyObject(file).getProperty(key);
		} catch (Exception e) {
			LOG.log(Level.WARNING, "", e);
		}

		return null;
	}

	public static String getPropertyFromFile(String file, String key, String def) {
		
		LOG.info("Reading Key : " + key + " From file : " + file);
		
		try {
			return getPropertyObject(file).getProperty(key, def);
		} catch (Exception e) {
			LOG.log(Level.WARNING, "", e);
		}

		return null;
	}

	public static Properties getPropertyObject(String file) {

		if (file != null) {

			Properties properties = new Properties();
			try {
				FileInputStream inputStream = new FileInputStream(
						new File(file));
				properties.load(inputStream);
				inputStream.close();

			} catch (IOException e) {
				LOG.severe(String.format(
						"Connection Properties File \"%s\" NOT FOUND", file));
			}
			return properties;
		}
		return null;
	}
}
