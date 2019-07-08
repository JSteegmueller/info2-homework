package main;

import java.util.HashMap;
import java.util.Map;

public class ComputationalNodeHelper {

	public static Map<String, Double> parseUnknowns(String unknowns) {
		unknowns = unknowns.replaceAll("\\s+", ""); // remove all whitespace
		String[] array = unknowns.split(","); // separate to array at ','
		Map<String, Double> result = new HashMap<String, Double>();
		for (int i = 0; i < array.length; i++) {
			if (array[i].length() == 0) {
				continue;
			}
			String[] unknown = array[i].split("="); // seperate left and right part
			if (unknown.length != 2) {
				throw new IllegalArgumentException("Could not parse '" + array[i] +
						"'. Unknowns should be given like this: \"x = 2, y = 4\"");
			}
			String key = unknown[0];
			Double value = Double.parseDouble(unknown[1]);
			result.put(key, value); // put key value pair into map
		}
		return result;
	}

}
