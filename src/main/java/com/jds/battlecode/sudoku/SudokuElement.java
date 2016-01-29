package com.jds.battlecode.sudoku;

public class SudokuElement {
	
	int x;
	
	int y;
	
	int element;

	public SudokuElement(int x_coordinate, int y_coordinate, int element) {
		super();
		this.x = x_coordinate;
		this.y = y_coordinate;
		this.element = element;
	}

	@Override
	public String toString() {
		return String.format("SudokuElement [x=%d, y=%d, element=%d]%n", x, y, element);
	}
	
}
