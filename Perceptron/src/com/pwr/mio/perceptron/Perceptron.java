package com.pwr.mio.perceptron;

public class Perceptron {
	private enum WeightAction {INCREASE, DECREASE };
	
	private final int INPUT_SIZE;
	private final static int DEFAULT_INPUT_SIZE = 10;
	private final double ACTIVATION_TRESHOLD = 0.8;
	private final Function function;
	
	// weights
	private double[] weights;
	private final double WEIGHT_FACTOR = 0.1;
	private double functionOutput = -1;

	public Perceptron() {
		this(DEFAULT_INPUT_SIZE, new SigmoidFunction());
	}

	public Perceptron(int inputSize, Function function) {
		INPUT_SIZE = inputSize;
		this.function = function;
		initWeights();
	}

	public int learn(double[] xVector, int correctOutput) {
		functionOutput = function.count(xVector, weights);
		int perceptronOutputValue =  functionOutput >= ACTIVATION_TRESHOLD ? 1 : 0;
		boolean isPerceptronWorkingProperly = (correctOutput == perceptronOutputValue);
		changeWeights( xVector, perceptronOutputValue, isPerceptronWorkingProperly );
		
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

	private void changeWeights(	double[] input, int perceptronOutputValue, boolean isPerceptronWorkingProperly) {

		if (!isPerceptronWorkingProperly) {
			if ( perceptronOutputValue == 1 ) {
				changeWeights(WeightAction.DECREASE,input);
			}
			else {
				changeWeights(WeightAction.INCREASE, input);
			}
		}
		
	}

	private void changeWeights(WeightAction currentWeightAction, double[] xVector ) {
		for (int i = 0 ; i < INPUT_SIZE; i++) {
			int intXi = (int) xVector[i]; // made because of double comparison
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
		return ACTIVATION_TRESHOLD;
	}

	public double getFunctionOutput() {
		return functionOutput;
	}
}