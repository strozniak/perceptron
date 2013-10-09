package com.pwr.mio.perceptron;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		double[][] input = new double[][] {	{1,0,0},
											{0,1,0},
											{1,2,1}};
		int[] correctOutput = { 1, 0, 1};
		int perceptronInputSize = input[0].length;
		Perceptron perceptron = new Perceptron( perceptronInputSize, new SigmoidFunction() );
		
		RaportPrinter.printRaport(perceptron, input, correctOutput );
	}

}
