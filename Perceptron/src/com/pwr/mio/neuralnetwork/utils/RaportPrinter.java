package com.pwr.mio.neuralnetwork.utils;

import com.pwr.mio.neuralnetwork.Neuron;

public class RaportPrinter {

	public static void printRaport(Neuron neuron) {
		String line = printNeuronName(neuron) + "\t";
		line += printWeights(neuron) + "\t";
		line += printInput(neuron) + "\t";
		line += printOutput(neuron) + "\t";
		line += printCorrectOutput(neuron) + "\t";
		System.out.println(line);

	}
	
	private static String printWeights(Neuron neuron) {
		String formattedWeights = "W = "; 
		double[] weights = neuron.getWeights();
		formattedWeights += printVector(weights);
		
		return formattedWeights;
	}
	

	private static String printNeuronName(Neuron neuron) {
		return neuron.getNAME();
		
	}

	private static String printInput(Neuron neuron) {
		return "X = " + printVector(neuron.getInput());
		
	}

	private static String printOutput(Neuron neuron) {
		return "Y = "+neuron.getFunctionOutput();
	}

	private static String printCorrectOutput(Neuron neuron) {
		return "Y\' = " + neuron.getCorrectOutput();
		
	}

	private static String printVector(double[] vector) {
		String formattedVector = "[\t";
		for(int i = 0; i < vector.length; i++) {
			formattedVector += vector[i] +"\t";
		}
		formattedVector += "]";
		return formattedVector;
	}
}
