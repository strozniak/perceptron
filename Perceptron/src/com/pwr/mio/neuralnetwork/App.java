package com.pwr.mio.neuralnetwork;

import java.util.LinkedList;
import java.util.List;

import com.pwr.mio.neuralnetwork.math.Function;
import com.pwr.mio.neuralnetwork.math.SigmoidFunction;
import com.pwr.mio.neuralnetwork.model.WeatherData;
import com.pwr.mio.neuralnetwork.model.WeatherDataTransformer;

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

		for (int i = 0 ; i < 10; i++) {
			NeuralNetworkFeeder feeder = new NeuralNetworkFeeder(dataFromCSVFile.get(i));
			oneLayerNetwork.learnLayer(feeder.getInput(), feeder.getCorrectOutput());
		}

	}

}
