package com.jds.battlecode.beer;

import java.text.ParseException;

public class BeerLauncher 
{
	
    public static void main( String[] args ) throws ParseException
    {
    	long startTime = System.nanoTime();
    	double litersOfBeer = 1000.23;
    	new Beer(litersOfBeer).executeLogic();
    	long endTime = System.nanoTime();
    	System.out.printf("elapsed time: %d ns", endTime - startTime);
    }

}
