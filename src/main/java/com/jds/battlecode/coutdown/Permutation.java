package com.jds.battlecode.coutdown;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Permutation<T extends Object> {
	List<T[]> posiblePermutations = new ArrayList<T[]>();
	
	public void permute(List<T> arr, int k){
        for(int i = k; i < arr.size(); i++){
            Collections.swap(arr, i, k);
            permute(arr, k+1);
            Collections.swap(arr, k, i);
        }
        if (k == arr.size() -1){
        	posiblePermutations.add((T[]) arr.toArray());
            System.out.println(Arrays.toString(arr.toArray()));
        }
    }
	
	public List<T[]> getAllPosiblePermutations(List<T> arr){
		List<T[]> permutations = new ArrayList<T[]>();
		if(posiblePermutations.isEmpty()){
			permute(arr, 0);
		}
		permutations.addAll(0, posiblePermutations);
		//clear for next calls to the class
		posiblePermutations.clear();
		return permutations;
	}
}
