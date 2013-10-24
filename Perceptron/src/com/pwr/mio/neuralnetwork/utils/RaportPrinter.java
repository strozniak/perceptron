package com.pwr.mio.neuralnetwork.utils;

import com.pwr.mio.neuralnetwork.BadInputSizeException;
import com.pwr.mio.neuralnetwork.Neuron;

public class RaportPrinter {

	public static void printRaport(Neuron perceptron, double[][] input,
			int[] correctOutput) {

		if (input.length != correctOutput.length || perceptron.getInputSize() != input[0].length)
			throw new BadInputSizeException();
		
		printHeader(perceptron.getActivationTreshold());
		
		for (int i = 0; i < input.length; i++) {
			printInput(input[i]);
			printPerceptronWeights(perceptron);
			printCorrectOutput(correctOutput[i]);
			printPerceptronOutput(perceptron.feed(input[i]));
			printPerceptronInnerFunctionResult(perceptron.getFunctionOutput());
		}

	}
	
	private static void printPerceptronInnerFunctionResult(double functionOutput) {
		System.out.print("Perc. inner fn result = "+functionOutput+"\n");
	}

	private static void printPerceptronWeights(Neuron perceptron) {
		String inputText = "W = ";
		inputText += getFormattedVector(perceptron.getWeights());
		System.out.print(inputText);
	}

	private static void printHeader(double treshold) {
		System.out.println("Per. treshold = "+treshold);
		
	}

	private static void printInput(double[] input) {
		String inputText = "X = ";
		inputText += getFormattedVector(input);
		System.out.print(inputText);
	}

	private static void printPerceptronOutput(int i) {
		System.out.print("Perc. output = "+"\t"+i+"\t");
	}
	
	private static void printCorrectOutput(int i) {
		System.out.print("Correct output = "+i+"\t");
		
	}

	private static String getFormattedVector(double[] input) {
		String inputText = "[\t";
		for (int i = 0; i < input.length; i++) {
			inputText += input[i] + "\t";
		}
		inputText += "]"+"\t";
		return inputText;
	}

}
