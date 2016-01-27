package com.jds.battlecode.armstrongnumbers;

public class ArmstrongRunner implements Runnable {

	int start;
	int end;
	
	public ArmstrongRunner(int start, int end){
		this.start = start;
		this.end = end;
	}
	
	public void threadMessage(String message, long number) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s %d%n", threadName, message, number);
	}
	
	public void threadMessage(String message, int number) {
		String threadName = Thread.currentThread().getName();
		System.out.format("%s: %s %d%n", threadName, message, number);
	}
	
	public void run() {
		long startTime = System.nanoTime();
		for(int i= start; i < end; i++){
			if(i==sumPowerDigits(i)){
				threadMessage("armstrong number found: ", i);
        	}
		}
		long endTime = System.nanoTime();
		threadMessage("elapsed time: ", endTime - startTime);
	}
	
	public int sumPowerDigits(int number){
    	int sum = 0;
    	int len = (int) (Math.log10(number)+1);
    	while(number > 0){
    		sum += Math.pow(number % 10, len);
    		number /= 10; 
    	}
    	return sum;
    }

}
