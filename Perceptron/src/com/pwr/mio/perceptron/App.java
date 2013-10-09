package com.pwr.mio.perceptron;

public class App {

	public static void main(String[] args) {
		
		// correctOutput - czy jutro bedzie padac deszcz? = { 1-tak, 0-nie }
		// ponizsze dane sa pobrane z www.meteo.pl
		// x1 - temperatura [C]
		// x2 - temp punktu rosy [C]
		// x3 - temp gruntu [C]
		// x4 - wilgotnosc powietrza [%]
		// x5 - cisnienie [hPa]
		// x6 - czas trwania dnia [h]
		// x7 - deszcz [mm/h]
		// x8 = snieg [mm/h]
		// x9 - wiatr [m/s]
		// x10 - wys chmur [km]
	
		double[][] input = new double[][] {	{11,10,15,75,1019,11,0,0,7,3},
											{13,9,16,80,1011,11,0,0,9,0},
											{9,8,7,93,1016,11,1,0,5,3},
											{6,2,1,100,1025,10,3,0,3,2} };
		int[] correctOutput = { 0, 0, 1,1};
		int perceptronInputSize = input[0].length;
		Perceptron perceptron = new Perceptron( perceptronInputSize, new SigmoidFunction() );
		
		RaportPrinter.printRaport(perceptron, input, correctOutput );
	}

}
