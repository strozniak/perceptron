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

public class Zad1 {

	public static void main(String[] args) {
		
		// lista 2, zad1
		Function sigmoidFunction = new SigmoidFunction();
		List<Neuron> neurons = new LinkedList<Neuron>();
		
		// sa trzy wykluczajace sie klasy: czy dane sa z 1. sierpnia 2. pazdziernika 3. stycznia
		Neuron isSunnyClassNeuron = new Neuron("isAugust", 6, sigmoidFunction);
		Neuron isCloudyClassNeuron = new Neuron("isOctober",6, sigmoidFunction);
		Neuron isSnowingClassNeuron = new Neuron("isJanuary",6, sigmoidFunction);
		
		neurons.add(isSunnyClassNeuron);
		neurons.add(isCloudyClassNeuron);
		neurons.add(isSnowingClassNeuron);

		NeuronsLayer firstLayer = new NeuronsLayer(neurons);
		List<NeuronsLayer> layers = new LinkedList<NeuronsLayer>();
		layers.add(firstLayer);
		NeuralNetwork oneLayerNetwork = new NeuralNetwork(layers);

		List<WeatherData> dataFromCSVFile = WeatherDataTransformer
				.mapCSVToWeatherData("resources/small.csv");

		Random rnd = new Random();
		
		for (int i = 0 ; i < 100; i++) {
			int randomValue = rnd.nextInt(dataFromCSVFile.size());
			NeuralNetworkFeeder feeder = new NeuralNetworkFeeder(dataFromCSVFile.get(randomValue));
			oneLayerNetwork.learnLayer(feeder.getInput(), feeder.getCorrectOutput());
		}
	
		System.out.println("#############################################################################");
		System.out.println("szukam zle sklasyfikowanych par");
		System.out.println("#############################################################################");

		for (int i = 0 ; i < 10; i++) {
			int randomValue = rnd.nextInt(dataFromCSVFile.size());
			NeuralNetworkFeeder feeder = new NeuralNetworkFeeder(dataFromCSVFile.get(i));
			oneLayerNetwork.learnLayer(feeder.getInput(), feeder.getCorrectOutput());
		}
		
	}
}
