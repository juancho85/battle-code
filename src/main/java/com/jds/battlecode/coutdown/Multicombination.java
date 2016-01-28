package com.jds.battlecode.coutdown;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class Multicombination<T> {
	
	final Class<T> typeParameterClass;
	
	public Multicombination(Class<T> typeParameterClass){
		this.typeParameterClass = typeParameterClass;
	}

	public List<T[]> getCombinations(T[] possibleValues, int desiredLength) {
		List<T[]> resultList = new ArrayList<T[]>();
		if(desiredLength==0){
			resultList.add(possibleValues);
			return resultList;
		}
		
		List<String> listIndexes = new ArrayList<String>();
		for (int i = 0; i < Math.pow(possibleValues.length, desiredLength); i++) {
			String zeroPadding = "%0"+desiredLength+"d";
			String index = String.format(zeroPadding, Integer.valueOf(Integer.toString(i, possibleValues.length)));
			listIndexes.add(index);
		}

		for (String index : listIndexes) {
			T[] acumulator = (T[]) Array.newInstance(typeParameterClass, desiredLength);
			for (int i = 0; i < index.length(); i++) {
				acumulator[i] = possibleValues[Integer.parseInt(index.substring(i, i + 1))];
			}
			resultList.add(acumulator);
		}
		return resultList;
	}

}
