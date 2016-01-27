package com.jds.battlecode.armstrongnumbers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ArmstrongNumbers2 
{
    public static void main( String[] args ) throws InterruptedException
    {
    	long startTime = System.nanoTime();
    	executeLogic(100001);
    	long endTime = System.nanoTime();
    	System.out.printf("elapsed time: %d ns.%n", endTime - startTime);
    }

	private static void executeLogic(int upperBound) throws InterruptedException {
		ExecutorService es = Executors.newCachedThreadPool();
		int chunckSize = upperBound / 4;
		es.execute(new ArmstrongRunner(chunckSize*3+1,upperBound));
		es.execute(new ArmstrongRunner(chunckSize*2+1,chunckSize*3));
		es.execute(new ArmstrongRunner(chunckSize+1,chunckSize*2));
		es.execute(new ArmstrongRunner(0,chunckSize));
		es.shutdown();
		while(!es.awaitTermination(1, TimeUnit.MINUTES)){
			System.out.println("waiting");
			Thread.sleep(1000);
		}
	}
    
    public static int sumPowerDigits(int number){
    	int sum = 0;
    	int len = (int) (Math.log10(number)+1);
    	while(number > 0){
    		sum += Math.pow(number % 10, len);
    		number /= 10; 
    	}
    	return sum;
    }
}
