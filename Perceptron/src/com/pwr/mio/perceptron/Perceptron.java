package com.pwr.mio.perceptron;

public class Perceptron {
	
	private enum WeightAction {INCREASE, DECREASE };
	
	private final static int DEFAULT_INPUT_SIZE = 10;
	private final int INPUT_SIZE;
	private final double ACTIVATION_TRESHOLD = 0.12;
	private final double WEIGHT_FACTOR = 0.1;

	private int iteration;
	private boolean isPerceptronWorkingProperly;
	private boolean isBiggerThanTreshold;
	private boolean givenOutput;
	private double activationFunctionResult;
	
	private double[] input;
	private double[] initialWeights;
	private double[] currentWeights;
	

	public Perceptron() {
		this(DEFAULT_INPUT_SIZE);
	}

	public Perceptron(int inputSize) {
		INPUT_SIZE = inputSize;
		iteration = 0;
		initDefaultWeights();
	}

	private void initDefaultWeights() {
		initialWeights = new double[INPUT_SIZE];
		currentWeights = new double[INPUT_SIZE];
		for (int i = 0; i < INPUT_SIZE ; i++) {
			initialWeights[i] = 1;
			currentWeights[i] = 1;
		}
		
	}

	public boolean learn(double[] input, boolean output) {
		this.input = input;
		this.givenOutput = output;
		iteration++;
		
		
		activationFunctionResult = count();
		isBiggerThanTreshold = activationFunctionResult >= ACTIVATION_TRESHOLD;
		isPerceptronWorkingProperly = (givenOutput == isBiggerThanTreshold);
		
		changeWeights(WEIGHT_FACTOR, isBiggerThanTreshold, isPerceptronWorkingProperly);
		
		return isPerceptronWorkingProperly;
	}

	private void changeWeights(double weightFactor,
			boolean isBiggerThanTreshold, boolean isPerceptronWorkingProperly) {

		if (!isPerceptronWorkingProperly) {
			if (isBiggerThanTreshold) {
				changeWeights(WeightAction.DECREASE);
			}
			else {
				changeWeights(WeightAction.INCREASE);
			}
		}
		
	}

	private void changeWeights(WeightAction currentWeightAction) {
		for (int i = 0 ; i < INPUT_SIZE; i++) {
			int intXi = (int) input[i]; // made because of double comparison
			if (intXi != 0) {
				if (currentWeightAction == WeightAction.DECREASE ) {
					currentWeights[i]  -=  currentWeights[i]*WEIGHT_FACTOR;
				} else if (currentWeightAction == WeightAction.INCREASE) {
					currentWeights[i]  +=  currentWeights[i]*WEIGHT_FACTOR;
				}
				
			}
		}
		
	}

	private double count() {
		double sigmaExpr = countSigma();
		
		return Math.exp((-1)*sigmaExpr);
	}

	private double countSigma() {
		double sigma = 0;
		
		for (int i = 0; i < INPUT_SIZE; i++) {
			sigma += currentWeights[i]*input[i];
		}
	
		return sigma;
	}

	public int getOutput() {
		return 0;
	}
	

	public double[] getCurrentWeights() {
		return currentWeights;
	}
	
	public String printCurrentState() {
		if (input != null )
 {
			String report = iteration + ") ";

			report += "Activation Treshold:"+"\t"+ACTIVATION_TRESHOLD+"\t";
			report += "Activation function result: "+Double.toString(activationFunctionResult)+"\t";
			report += "Given output: "+Boolean.toString(givenOutput)+"\t";
			report += "X = [\t";
			for (int i = 0; i < input.length; i++) {
				report += input[i] + "\t";
			}
			report += "]\tWEIGHTS = [\t";
			for (int i = 0; i < currentWeights.length; i++) {
				report += currentWeights[i] + "\t";
			}

			report += "]"+"\t"+"Recognized Correctly:" +"\t"+Boolean.toString(isPerceptronWorkingProperly);
			return report;
		} else 
			return "No input data";
		
	}
}
