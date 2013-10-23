package com.pwr.mio.perceptron;

public class Neuron {
	private enum WeightAction {INCREASE, DECREASE };
	
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

	public Neuron(int inputSize, Function function) {
		INPUT_SIZE = inputSize;
		this.function = function;
		initWeights();
	}

	public int learn(double[] xVector) {
		input = xVector;
		functionOutput = function.count(input, weights);
		int perceptronOutputValue =  functionOutput >= activationTreshold ? 1 : 0;
		
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
	
	public void inreaseWeights()
	{
		changeWeights(WeightAction.INCREASE);
	}

	
	public void decreaseWeights()
	{
		changeWeights(WeightAction.DECREASE);
	}
	

	private void changeWeights(WeightAction currentWeightAction ) {
		for (int i = 0 ; i < INPUT_SIZE; i++) {
			int intXi = (int) input[i]; // made because of double comparison
			if (intXi != 0) {
				if (currentWeightAction == WeightAction.DECREASE ) {
					weights[i]  -=  weights[i]*WEIGHT_FACTOR;
				} else if (currentWeightAction == WeightAction.INCREASE) {
					weights[i]  +=  weights[i]*WEIGHT_FACTOR;
				}
				
			}
		}
	}

	public int getInputSize() {
		return INPUT_SIZE;
	}
	
	public double getACTIVATION_TRESHOLD() {
		return activationTreshold;
	}

	public double getFunctionOutput() {
		return functionOutput;
	}
}