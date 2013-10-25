package com.pwr.mio.neuralnetwork.utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class CSVParser {

	public static List<String[]> parse(String fileName) {
		List<String[]> data = new LinkedList<String[]>();
		BufferedReader br = null;

		try {
			br = new BufferedReader(new FileReader(fileName));
			String line = null;
			String delimiter = "[,]";
			while ((line = br.readLine()) != null) {
				data.add(line.split(delimiter));
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return data;
	}
}
