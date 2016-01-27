package com.jds.battlecode.telegram;

import java.text.ParseException;

public class TelegramLauncher 
{
	
    public static void main( String[] args ) throws ParseException
    {
    	long startTime = System.nanoTime();
    	String message = "it compilesss it works stop";
    	new Telegram(message).executeLogic();
    	long endTime = System.nanoTime();
    	System.out.printf("elapsed time: %d ns", endTime - startTime);
    }

}
