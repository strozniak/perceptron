package com.pwr.mio.neuralnetwork;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import com.pwr.mio.neuralnetwork.math.Function;
import com.pwr.mio.neuralnetwork.math.SigmoidFunction;
import com.pwr.mio.neuralnetwork.model.neuralnetwork.NeuralNetwork;
import com.pwr.mio.neuralnetwork.model.neuralnetwork.Neuron;
import com.pwr.mio.neuralnetwork.model.neuralnetwork.NeuronsLayer;
import com.pwr.mio.neuralnetwork.model.weather.WeatherData;
import com.pwr.mio.neuralnetwork.model.weather.WeatherDataTransformer;
import com.pwr.mio.neuralnetwork.utils.NeuralNetworkFeeder;

public class App {

	public static void main(String[] args) {
		
		// lista 2, zad1
		Function sigmoidFunction = new SigmoidFunction();
		List<Neuron> neurons = new LinkedList<Neuron>();
		
		Neuron isSunnyClassNeuron = new Neuron("sunny", 6, sigmoidFunction);
		Neuron isCloudyClassNeuron = new Neuron("cloudy",6, sigmoidFunction);
		Neuron isSnowingClassNeuron = new Neuron("snowing",6, sigmoidFunction);
		
		neurons.add(isSunnyClassNeuron);
		neurons.add(isCloudyClassNeuron);
		neurons.add(isSnowingClassNeuron);

		NeuronsLayer firstLayer = new NeuronsLayer(neurons);
		List<NeuronsLayer> layers = new LinkedList<NeuronsLayer>();
		layers.add(firstLayer);
		NeuralNetwork oneLayerNetwork = new NeuralNetwork(layers);

		List<WeatherData> dataFromCSVFile = WeatherDataTransformer
				.mapCSVToWeatherData("resources/input.csv");

		Random rnd = new Random();
		
		for (int i = 0 ; i < 300; i++) {
			int randomValue = rnd.nextInt(dataFromCSVFile.size());
			NeuralNetworkFeeder feeder = new NeuralNetworkFeeder(dataFromCSVFile.get(randomValue));
			oneLayerNetwork.learnLayer(feeder.getInput(), feeder.getCorrectOutput());
		}
	}
}
