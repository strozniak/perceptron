package com.pwr.mio.perceptron;

public class SigmoidFunction implements Function {

	@Override
	public double count(double[] xVector, double[] weightsVector) {
		if (xVector.length != weightsVector.length) {
			throw new BadInputSizeException();
		}
		return (1/(1+eExpression(xVector, weightsVector)));
	}

	private double eExpression(double[] xVector, double[] weightsVector) {
		return Math.exp((-1)*sigma(xVector, weightsVector));
	}

	private double sigma(double[] xVector, double[] weightsVector) {
		int inputSize = xVector.length;
		double output = 0;
		
		for (int i = 0; i < inputSize; i++ ) {
			output += xVector[i]*weightsVector[i];
		}
		return output;
	}
}
