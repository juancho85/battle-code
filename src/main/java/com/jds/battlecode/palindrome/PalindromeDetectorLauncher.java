package com.jds.battlecode.palindrome;

import java.text.ParseException;

public class PalindromeDetectorLauncher 
{
	
    public static void main( String[] args ) throws ParseException
    {
    	long startTime = System.nanoTime();
    	String word = "osotoso";
    	new PalindromeDetector(word).executeLogic();
    	long endTime = System.nanoTime();
    	System.out.printf("elapsed time: %d ns", endTime - startTime);
    }

}
