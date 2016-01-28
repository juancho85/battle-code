package com.jds.battlecode.coutdown;

import java.util.ArrayList;
import java.util.List;

public class Multicombination {

	public static List<Object[]> getCombinations(Object[] possibleValues, int desiredLength) {
		List<Object[]> resultList = new ArrayList<Object[]>();
		List<String> listIndexes = new ArrayList<String>();
		for (int i = 0; i < Math.pow(possibleValues.length, desiredLength); i++) {
			String zeroPadding = "%0"+desiredLength+"d";
			String index = String.format(zeroPadding, Integer.valueOf(Integer.toString(i, possibleValues.length)));
			listIndexes.add(index);
		}

		for (String index : listIndexes) {
			Object[] acumulator = new Object[desiredLength];
			for (int i = 0; i < index.length(); i++) {
				acumulator[i] = possibleValues[Integer.parseInt(index.substring(i, i + 1))];
			}
			resultList.add(acumulator);
		}
		return resultList;
	}

}
