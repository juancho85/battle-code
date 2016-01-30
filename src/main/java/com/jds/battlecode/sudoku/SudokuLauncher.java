package com.jds.battlecode.sudoku;

import java.text.ParseException;

public class SudokuLauncher
{

    public static void main( String[] args ) throws ParseException
    {
        long startTime = System.nanoTime();
        //complete sudoku
        //String message = " 23456789;456789123;789123456;234567891;678912345;891234567;345678912;567891234;912345678";
        //String message = " 23456789;456789123;789123456;234567891;678912345;891234567;345678912;567891234;912345678";
        //one from the internet
        //String message = "    567  ;8  91  36; 7 8 315 ;796      ;  1   9  ;      281; 126 5 9 ;35  98  4;  834    ";
        //String message= "85 936 4 ; 9 47 53 ;  4  8  9;9        ;5 78 32 1;        3;4  2  3  ; 68 49 7 ; 7 165 24";
        String message= " 27 98   ;  4    92;53  4617 ;3  1   5 ; 45   76 ; 7   5  9; 5892  16;49    2  ;   85 93 ";
        Sudoku sudoku = new Sudoku(message);
        sudoku.executeLogic();
        long endTime = System.nanoTime();
        System.out.printf("elapsed time: %d ns", endTime - startTime);
    }

}
