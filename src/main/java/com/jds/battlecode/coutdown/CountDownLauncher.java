package com.jds.battlecode.coutdown;

import java.text.ParseException;

public class CountDownLauncher 
{
	
    public static void main( String[] args ) throws ParseException
    {
    	long startTime = System.nanoTime();
    	int [] operands = {100, 10, 5};
    	int result = 124;
    	new Countdown(result, operands).executeLogic();
    	long endTime = System.nanoTime();
    	System.out.printf("elapsed time: %d ns", endTime - startTime);
    }

}
