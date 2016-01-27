package com.jds.battlecode.telegram;

public class Telegram {

	String message;

	public Telegram(String message) {
		this.message = message;
	}

	public void executeLogic() {
		if(message.endsWith("stop")){
			String [] words =  message.substring(0, message.length() - 4).split(" ");
			int totalCost = 0;
			for(String word : words){
				//should punctuation marks be ignored in the count?
				int cost = (word.length() / 10) + 1;
				System.out.printf("word: %s, cost: %d.%n",word, cost);
				totalCost += cost;
			}
			System.out.printf("Total cost: %d.%n", totalCost);
		}else{
			System.out.println("The message is not ending by stop");
		}
	}

}
