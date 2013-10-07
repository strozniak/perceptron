package com.pwr.mio.perceptron;

public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int inputSize = 10;
		Perceptron perceptron = new Perceptron(inputSize);
		
		
		double[][] input = new double[][] {	{1,0,0},
											{0,1,0},
											{1,2,1}};
		
		boolean[] correctOutput = { true, false, true, false, true, true, true };
		
		for (int i = 0 ; i < 10; i++) {
			perceptron.learn(input[i], correctOutput[i]);
			System.out.println(perceptron.printCurrentState());
		}
	}

}
