package com.jds.battlecode.sudoku;

import java.text.ParseException;

public class SudokuLauncher 
{
	
    public static void main( String[] args ) throws ParseException
    {
    	long startTime = System.nanoTime();
    	String message = "123456789;456789123;789123456;234567891;678912345;891234567;345678912;567891234;912345678";
    	new Sudoku(message).executeLogic();
    	long endTime = System.nanoTime();
    	System.out.printf("elapsed time: %d ns", endTime - startTime);
    }

}
