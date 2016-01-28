package com.jds.battlecode.coutdown;

import java.util.Arrays;

public class Operation {
	
	Operations [] operators;
	
	Integer[] operands;
	
	Integer result;
	
	public Operation(Operations [] operators, Integer[] operands){
		this.operators = operators;
		this.operands = operands;
	}

	@Override
	public String toString() {
		return "Operation [operators=" + Arrays.toString(operators) + ", operands=" + Arrays.toString(operands)
				+ ", result=" + result + "]";
	}
	
	public void calculateResult(){
		for (int i = 1; i < operands.length; i++) {
			int subtotal = operands[i - 1];
			for (Operations o : operators) {
				if(i<operands.length){
					subtotal = performOperation(subtotal, operands[i], o);
					i++;
				}
			}
			result = subtotal;
		}
		
	}
	
	public int performOperation(int op1, int op2, Operations operation) {
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

	public Integer getResult() {
		return result;
	}

	public void setResult(Integer result) {
		this.result = result;
	}
	
	

}
