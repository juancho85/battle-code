package com.jds.battlecode.armstrongnumbers;

public class ArmstrongNumbers 
{
    public static void main( String[] args )
    {
    	long startTime = System.nanoTime();
    	executeLogic(100000);
    	long endTime = System.nanoTime();
    	System.out.printf("elapsed time: %d ns", endTime - startTime);
    }

	private static void executeLogic(int upperBound) {
		for(int i=0; i<upperBound; i++){
        	if(i==sumPowerDigits(i)){
        		System.out.println(i);
        	}
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
