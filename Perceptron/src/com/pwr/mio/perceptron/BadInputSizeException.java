package com.pwr.mio.perceptron;

public class BadInputSizeException extends RuntimeException {
	public BadInputSizeException() {
		super("X and weights vectors have different sizes");
	}

}
