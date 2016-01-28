package com.jds.battlecode.coutdown;

import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

public class CountDownLauncher 
{
	
    public static void main( String[] args ) throws ParseException
    {
    	long startTime = System.nanoTime();
    	System.out.println("start !!!!");
    	Integer[] operands = {101, 10, 5, 4};
    	Integer targetResult = Integer.valueOf(115);
    	Permutation<Integer> operandsCombinations = new Permutation<Integer>();
    	List<Integer[]> operandsPermutations = operandsCombinations.getAllPosiblePermutations(Arrays.asList(operands));
    	List<Object[]> operatorsPermutations = Multicombination.getCombinations(Operations.values(), operands.length - 1);
    	Countdown countdown = new Countdown(operatorsPermutations, operandsPermutations, targetResult);
    	//TODO: store the operations used to get the result
    	countdown.executeLogic();
    	long endTime = System.nanoTime();
    	System.out.printf("elapsed time: %d ns", endTime - startTime);
    }

}
