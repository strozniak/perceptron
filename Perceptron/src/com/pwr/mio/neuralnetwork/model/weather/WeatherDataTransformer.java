package com.pwr.mio.neuralnetwork.model.weather;

import java.util.LinkedList;
import java.util.List;

import com.pwr.mio.neuralnetwork.utils.CSVParser;

public class WeatherDataTransformer {
	
	public static List<WeatherData> mapCSVToWeatherData(String fileName) {
		List<String[]> rawData = CSVParser.parse(fileName);
		List<WeatherData> transformedData = new LinkedList<WeatherData>();
		
		for(int i = 1; i < rawData.size(); i++) 
		{
			String[] line = rawData.get(i);
			WeatherData weatherData = new WeatherData();
			
			weatherData.setTime(line[0]);
			weatherData.setAtmosphericPresure(Integer.parseInt(line[1]));
			weatherData.setRainFall(Double.parseDouble(line[2]));
			weatherData.setWindSpeed(Double.parseDouble(line[3]));
			weatherData.setWindDirection(Double.parseDouble(line[4]));
			weatherData.setTemperature(Double.parseDouble(line[5]));
			weatherData.setHumidity(Double.parseDouble(line[6]));
			weatherData.setSunny(Integer.parseInt(line[7]));
			weatherData.setCloudy(Integer.parseInt(line[8]));
			weatherData.setSnowing(Integer.parseInt(line[9]));
			
			
			transformedData.add(weatherData);
		}
		
		return transformedData;
	}

}
