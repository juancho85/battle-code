package com.jds.battlecode.coutdown;

import java.util.ArrayList;
import java.util.List;

public class Countdown {

	List<Integer> operands = new ArrayList<Integer>();
	
	int result;
	
	public enum Operations { SUM, SUBSTRACTION, PRODUCT, DIVISION };
	
	public List<Operations[]> operationPermutations = new ArrayList<Operations[]>();
	
	public Countdown(int result, int ... numbers) {
		for(int number : numbers){
			operands.add(number);
		}
		this.result = result;
		findAllOperationPermutations(operands.size()-1);
	}
	
	private void findAllOperationPermutations(int numberOfOperations) {
		//fix first element with first possible value
		
		//calculate the permutations for the remaining elements
			//pass subtotal
			//call method again with one element less
				//fix first element with first possible value
				
		for(int i = 0; i < numberOfOperations; i++){
			Operations[] ops = new Operations[numberOfOperations];
			for(Operations op: Operations.values()){
				//
			}
		}
	}
	
	private Operations[] findPermutations(Operations[] subtotal, int remainingOperations){
		if(remainingOperations == 0){
			return subtotal;
		}else{
			for(Operations op: Operations.values()){
				subtotal.
			}
		}
	}
	
	
	
	public void executeLogic() {
		for(int n : operands){
			System.out.println(n);
		}
	}

	
	public int performOperation(int op1, int op2, Operations operation){
		int result = 0;
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
