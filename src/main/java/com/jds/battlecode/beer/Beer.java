package com.jds.battlecode.beer;

public class Beer {

	double litersOfBeer;
	
	double BEER_3 = 3;
	double BEER_0_5 = 0.5;
	double BEER_0_25 = 0.25;
	double BEER_0_125 = 0.125;

	public Beer(double litersOfBeer) {
		this.litersOfBeer = litersOfBeer;
	}

	public void executeLogic() {
		double remainingBeer = litersOfBeer;
		int mugsCount = (int) Math.floor(remainingBeer / BEER_3) ;
		remainingBeer %= BEER_3;
		int pintsCount = (int) Math.floor(remainingBeer / BEER_0_5);
		remainingBeer %= BEER_0_5;
		int halfPintsCount = (int) Math.floor(remainingBeer / BEER_0_25);
		remainingBeer %= BEER_0_25;
		int gillsCount = (int) Math.floor(remainingBeer / BEER_0_125);
		remainingBeer %= BEER_0_125;
		if(remainingBeer>0){
			gillsCount++;
		}
		System.out.printf("mugs: %d, pints: %d, halfs: %d, gills: %d%n", mugsCount, pintsCount, halfPintsCount, gillsCount);
		//double verif = mugsCount*BEER_3 + pintsCount*BEER_0_5 + halfPintsCount*BEER_0_25 + gillsCount*BEER_0_125;
		//System.out.printf("verif: %f%n", verif);
	}

}
