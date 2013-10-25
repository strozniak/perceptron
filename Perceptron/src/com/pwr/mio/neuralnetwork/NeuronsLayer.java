package com.pwr.mio.neuralnetwork;

import java.util.List;

import com.pwr.mio.neuralnetwork.utils.RaportPrinter;

public class NeuronsLayer {
	private List<Neuron> neurons;
	private final int LAYER_SIZE;
	
	public NeuronsLayer(List<Neuron> perceptrons) {
		this.neurons = perceptrons;
		LAYER_SIZE = perceptrons.size();
	}
	
	public int[] learnPerceptrons(double[] input, int[] correctOutput) {
		int[] output = new int[LAYER_SIZE];
		for (int i = 0; i < LAYER_SIZE; i++) {
			Neuron neuron = neurons.get(i);
			output[i] = neuron.feed(input);
			neuron.learn(correctOutput[i]);
			RaportPrinter.printRaport(neuron);
		}
		return output;
	}
}
