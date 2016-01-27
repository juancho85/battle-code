package com.jds.battlecode.primenumbers;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersLanucher 
{
	List<Long> primesCache = new ArrayList<Long>();
	
    public static void main( String[] args )
    {
    	long startTime = System.nanoTime();
    	int lowerBound = 123;
    	int upperBound = 234;
    	new PrimeNumbers(lowerBound, upperBound).executeLogic();;
    	long endTime = System.nanoTime();
    	System.out.printf("elapsed time: %d ns", endTime - startTime);
    }
    
    

}
