package com.pwr.mio.neuralnetwork;

import com.pwr.mio.neuralnetwork.model.WeatherData;

public class NeuralNetworkFeeder {
	
	private double[] input;
	private int[] correctOutput;
	
	public NeuralNetworkFeeder(WeatherData data) {
		input = new double[6];
		correctOutput = new int[3];
		populateInputData(data);
		populateCorrectOutputData(data);
	}

	private void populateInputData(WeatherData data) {
		input[0] = data.getPresure();
		input[1] = data.getRainFall();
		input[2] = data.getWindSpeed();
		input[3] = data.getWindDirection();
		input[4] = data.getTemperature();
		input[5] = data.getHumidity();
	}

	private void populateCorrectOutputData(WeatherData data) {
		correctOutput[0] = data.isSunny();
		correctOutput[1] = data.isCloudy();
		correctOutput[2] = data.isSnowing();
	}

	public double[] getInput() {
		return input;
	}

	public int[] getCorrectOutput() {
		return correctOutput;
	}
}
