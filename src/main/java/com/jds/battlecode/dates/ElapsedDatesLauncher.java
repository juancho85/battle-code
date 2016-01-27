package com.jds.battlecode.dates;

import java.text.ParseException;

import org.joda.time.DateTime;

public class ElapsedDatesLauncher 
{
	
    public static void main( String[] args ) throws ParseException
    {
    	long startTime = System.nanoTime();
    	DateTime now = new DateTime();
    	DateTime endDate = new DateTime(2016, 1, 29, 12, 0, 0, 0);
    	new ElapsedDates(now, endDate).executeLogic();
    	long endTime = System.nanoTime();
    	System.out.printf("elapsed time: %d ns", endTime - startTime);
    }

}
