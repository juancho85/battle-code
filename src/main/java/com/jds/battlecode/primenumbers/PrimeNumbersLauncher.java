package com.jds.battlecode.primenumbers;

public class PrimeNumbersLauncher
{
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
