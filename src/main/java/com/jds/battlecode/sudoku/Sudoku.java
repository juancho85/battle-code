package com.jds.battlecode.sudoku;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {

	String message;
	
	List<SudokuElement> listElements = new ArrayList<SudokuElement>();

	public Sudoku(String message) {
		String[] lines = message.split(";");
		for(int i = 0; i < lines.length; i++){
			for(int j = 0; j < lines[i].length(); j++){
				String digit =  lines[i].substring(j, j+1);
				SudokuElement element = new SudokuElement(i, j, Integer.valueOf(digit));
				listElements.add(element);
			}
		}
		System.out.println(listElements);
	}

	public void executeLogic() {
		//
	}

}
