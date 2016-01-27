package com.jds.battlecode.flavius;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Flavius {
	
	//position / TRUE:alive, FALSE:dead
	Map<Integer, Boolean> peoplePositions = new HashMap<Integer, Boolean>();
	
	public Flavius(){
		//initialize the people map
		IntStream.range(0, 40).forEach(i -> {
			peoplePositions.put(i, Boolean.TRUE);
		}); 
	}

	public void executeLogic() {
		int positionSuicide = 0;
		int nDeaths = 0;
		System.out.println(peoplePositions);
		while(nDeaths<39){
			peoplePositions.put(positionSuicide, Boolean.FALSE);
			nDeaths++;
			positionSuicide += 3;
			if(positionSuicide > 39){
				positionSuicide %= 40;
			}
		}
		System.out.println(peoplePositions);
	}

}
