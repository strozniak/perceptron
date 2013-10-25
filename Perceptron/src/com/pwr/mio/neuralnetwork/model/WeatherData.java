package com.pwr.mio.neuralnetwork.model;

public class WeatherData {
	private String time;
	private int atmosphericPresure;
	private double rainFall;
	private double windSpeed;
	private double windDirection;
	private double temperature;
	private double humidity;
	private int isSunny;
	private int isCloudy;
	private int isSnowing;
	
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getPresure() {
		return atmosphericPresure;
	}
	public void setAtmosphericPresure(int atmosphericPresure) {
		this.atmosphericPresure = atmosphericPresure;
	}
	public double getRainFall() {
		return rainFall;
	}
	public void setRainFall(double rainFall) {
		this.rainFall = rainFall;
	}
	public double getWindSpeed() {
		return windSpeed;
	}
	public void setWindSpeed(double windSpeed) {
		this.windSpeed = windSpeed;
	}
	public double getWindDirection() {
		return windDirection;
	}
	public void setWindDirection(double windDirection) {
		this.windDirection = windDirection;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public double getHumidity() {
		return humidity;
	}
	public void setHumidity(double humidity) {
		this.humidity = humidity;
	}
	public int isSunny() {
		return isSunny;
	}
	public void setSunny(int isSunny) {
		this.isSunny = isSunny;
	}
	public int isCloudy() {
		return isCloudy;
	}
	public void setCloudy(int isCloudy) {
		this.isCloudy = isCloudy;
	}
	public int isSnowing() {
		return isSnowing;
	}
	public void setSnowing(int isSnowing) {
		this.isSnowing = isSnowing;
	}
}
