package com.jds.battlecode.primenumbers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PrimeNumbers {

	int lowerBound;
	int upperBound;

	List<Integer> primes = new ArrayList<Integer>();

	public PrimeNumbers(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		primes.add(2);
	}

	public void executeLogic() {
		for (int i = lowerBound; i < upperBound; i++) {
			if(isPrime(i)){
				primes.add(i);
				System.out.println(i);
			}
		}
	}

	public boolean isPrime(int number) {
		
		if (primes.contains(number)) {
			// already in the list
			return true;
		}
		
		int maxPrimeFound = primes.stream().max(Comparator.naturalOrder()).orElse(0);
		if(number < maxPrimeFound){
			return false;
		}
		
		if(number % 2 == 0){
			return false;
		}
		
		int limit = (int) Math.round(Math.sqrt(number));
		for (int i = 3; i <= limit; i++) {
			if(number % i == 0){
				return false;
			}
		}
		return true;
	}

}
