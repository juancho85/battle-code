package com.jds.battlecode.sudoku;

public class SudokuElement {

    int x;

    int y;

    Integer element;

    public SudokuElement(int x_coordinate, int y_coordinate, Integer element) {
        super();
        this.x = x_coordinate;
        this.y = y_coordinate;
        this.element = element;
    }

    boolean isEmpty(){
        return element==null;
    }

    @Override
    public String toString() {
        return String.format("[x=%d, y=%d, val=%d]", x, y, element);
    }

}
