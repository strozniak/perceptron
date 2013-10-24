package com.pwr.mio.neuralnetwork;

import com.pwr.mio.neuralnetwork.math.Function;

public class Neuron {
	private final String NAME;
	private final int INPUT_SIZE;
	private double activationTreshold = 0.9;
	private final Function function;
	
	// weights
	private double[] weights;
	private final double WEIGHT_FACTOR = 0.1;
	private double functionOutput = -1;
	private double[] input = {-1};
	private int perceptronOutputValue;
	private int correctOutput = -1;

	public Neuron(String neuronName, int inputSize, Function function) {
		NAME = neuronName;
		INPUT_SIZE = inputSize;
		this.function = function;
		initWeights();
	}
	
	public void learn(int correctOutput)
	{
		this.correctOutput = correctOutput;
		for (int i = 0 ; i < INPUT_SIZE; i++) {
			int intXi = (int) input[i]; // made because of double comparison
			if (intXi != 0) {
				weights[i]  +=  WEIGHT_FACTOR*(correctOutput-perceptronOutputValue)*input[i];
				
			}
		}
	}
	
	public int feed(double[] xVector) {
		input = xVector;
		functionOutput = function.count(input, weights);
		perceptronOutputValue = functionOutput >= activationTreshold ? 1 : 0;
		
		return perceptronOutputValue;
	}
	
	public double[] getWeights() {
		return weights;
	}

	private void initWeights() {
		weights = new double[INPUT_SIZE];
		for(int i = 0; i < INPUT_SIZE; i++ ) {
			weights[i] = 1;
		}
	}

	public void seActivationTreshold(double treshold) {
		activationTreshold = treshold;
	}

	public String getNAME() {
		return NAME;
	}

	public double[] getInput() {
		return input;
	}
	
	public int getInputSize() {
		return INPUT_SIZE;
	}
	
	public double getActivationTreshold() {
		return activationTreshold;
	}

	public double getFunctionOutput() {
		return functionOutput;
	}

	public int getCorrectOutput() {
		return correctOutput;
	}
	
}