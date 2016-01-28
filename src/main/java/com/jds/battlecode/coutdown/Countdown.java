package com.jds.battlecode.coutdown;

import java.util.ArrayList;
import java.util.List;

public class Countdown {

	List<Operations[]> operatorsPermutations;

	List<Integer[]> operandsPermutations;

	Integer result;

	List<Integer> resultsList = new ArrayList<Integer>();
	
	List<Operation> operationsList = new ArrayList<Operation>();

	public Countdown(List<Operations[]> operatorsPermutations, List<Integer[]> operandsPermutations, Integer result) {
		this.operatorsPermutations = operatorsPermutations;
		this.operandsPermutations = operandsPermutations;
		this.result = result;
	}

	public void executeLogic() {
		for (Integer[] operands : operandsPermutations) {
			for (Object[] op : operatorsPermutations) {
				Operation oper = new Operation((Operations []) op, operands);
				oper.calculateResult();
				operationsList.add(oper);
			}
		}
		findClosestResultWithOperations();
	}
	
	
	public void findClosestResultWithOperations(){
		Operation closestResult = null;
		int difference = 100000;
		for(Operation res : operationsList){
	        if(res.getResult() != null && Math.abs(res.getResult() - result) < difference){
				difference = Math.abs(res.getResult() - result);
				closestResult = res;
			}
		}
		System.out.print("Closest result: "+ closestResult );
	}

}
