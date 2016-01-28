package com.jds.battlecode.coutdown;

import java.util.ArrayList;
import java.util.List;

public class Countdown {

	List<Object[]> operatorsPermutations;

	List<Integer[]> operandsPermutations;

	Integer result;

	List<Integer> resultsList = new ArrayList<Integer>();

	public Countdown(List<Object[]> operatorsPermutations, List<Integer[]> operandsPermutations, Integer result) {
		this.operatorsPermutations = operatorsPermutations;
		this.operandsPermutations = operandsPermutations;
		this.result = result;
	}

	public void executeLogic() {
		for (Integer[] operands : operandsPermutations) {
			for (Object[] op : operatorsPermutations) {
				for (int i = 1; i < operands.length; i++) {
					int subtotal = operands[i - 1];
					for (Object o : op) {
						if(i<operands.length){
							subtotal = performOperation(subtotal, operands[i],(Operations) o);
							i++;
						}
					}
					System.out.printf("*********result: %d%n", subtotal);
					resultsList.add(subtotal);
				}
			}
		}
		
		findClosestResult();
	}
	
	public void findClosestResult(){
		int closestResult = 0;
		int difference = 100000;
		for(Integer res : resultsList){
			if(Math.abs(res-result) < difference){
				difference = Math.abs(res-result);
				closestResult = res;
			}
		}
		System.out.printf("Closest result: %d.%n", closestResult);
	}

	public int performOperation(int op1, int op2, Operations operation) {
		int result = 0;
		System.out.printf("%d %s %d%n", op1, operation.toString(), op2);
		switch (operation) {
		case SUM:
			result = op1 + op2;
			break;
		case SUBSTRACTION:
			result = op1 - op2;
			break;
		case PRODUCT:
			result = op1 * op2;
			break;
		case DIVISION:
			result = op1 / op2;
			break;
		}
		return result;
	}

}
