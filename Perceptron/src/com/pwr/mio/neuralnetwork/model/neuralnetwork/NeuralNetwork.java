package com.pwr.mio.neuralnetwork.model.neuralnetwork;

import java.util.List;

public class NeuralNetwork {
	
	private final List<NeuronsLayer> layers;

	
	public NeuralNetwork(List<NeuronsLayer> layers) {
		this.layers = layers;
	}
	
	public void learnLayer(double[] input, int[] correctOutput) {
		int layerSize = layers.size();
		int[] output;
		for (int i = 0; i < layerSize; i++) {
			NeuronsLayer layer = layers.get(i);
			output = layer.learnPerceptrons(input, correctOutput);
		}
	}
}
