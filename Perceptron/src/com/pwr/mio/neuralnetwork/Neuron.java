package com.pwr.mio.neuralnetwork;

public class Neuron {
	private final int INPUT_SIZE;
	private double activationTreshold = 0.9;
	
	public void seActivationTreshold(double treshold) {
		activationTreshold = treshold;
	}

	private final Function function;
	
	// weights
	private double[] weights;
	private final double WEIGHT_FACTOR = 0.1;
	private double functionOutput = -1;
	private double[] input;
	private int perceptronOutputValue;

	public Neuron(int inputSize, Function function) {
		INPUT_SIZE = inputSize;
		this.function = function;
		initWeights();
	}
	
	public void learn(int correctOutput)
	{
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

	public int getInputSize() {
		return INPUT_SIZE;
	}
	
	public double getActivationTreshold() {
		return activationTreshold;
	}

	public double getFunctionOutput() {
		return functionOutput;
	}
	
}