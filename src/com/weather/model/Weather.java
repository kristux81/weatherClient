package com.weather.model;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElements;

@XmlRootElement(name="current")
@XmlAccessorType(XmlAccessType.FIELD)
public class Weather
{
	@XmlElements( {@XmlElement(name="temperature", type=Temperature.class)} )
    private Temperature  temperature;

	public Temperature getTemperature() {
		return temperature;
	}

	public void setTemperature(Temperature temperature) {
		this.temperature = temperature;
	}
   
}
