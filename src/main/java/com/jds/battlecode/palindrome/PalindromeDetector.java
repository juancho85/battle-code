package com.jds.battlecode.palindrome;

public class PalindromeDetector {

	String word;

	public PalindromeDetector(String word) {
		this.word = word;
	}

	public void executeLogic() {
		if(isPalindrome(word)){
			System.out.printf("The word %s is palindrome %n", word);
		}else{
			System.out.printf("The word %s is NOT palindrome %n", word);
		}
	}

	private boolean isPalindrome(String word) {
		return areBoundsEqual(word);
	}

	private boolean areBoundsEqual(String word) {
		// base case: the word is either 1 letter long => palindrome
		// or there are no more letters => palidrome
		if(word.length()<2){
			return true;
		}
		// compare the bounds and call recursivelly with the remaining letters in the word
		return word.substring(0,1).equals(word.substring(word.length()-1, word.length())) && areBoundsEqual(word.substring(1,word.length()-1));
	}

}
