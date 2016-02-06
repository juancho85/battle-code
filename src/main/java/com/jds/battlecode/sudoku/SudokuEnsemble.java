package com.jds.battlecode.sudoku;

import java.util.ArrayList;
import java.util.List;

public class SudokuEnsemble {

    List<SudokuElement> elements;

    SudokuEnsembleType type;

    int index;

    public SudokuEnsemble(List<SudokuElement> elements, int index, SudokuEnsembleType type) {
        this.elements = elements;
        this.index = index;
        this.type = type;
    }

    public boolean isComplete(){
        return elements.size()==9;
    }

    public void addElementToEnsemble(SudokuElement element){
        elements.add(element);
    }

    SudokuEnsembleType getSudokuEnsembleType(){
        return this.type;
    }

    List<SudokuElement> getElements(){
        return this.elements;
    }

    List<Integer> getElementValues(){
        List<Integer> result = new ArrayList<>();
        for(SudokuElement el : elements){
            if(!el.isEmpty()){
                result.add(el.element);
            }
        }
        return result;
    }

    List<Integer> getMissingElementValues(){
        List<Integer> result = new ArrayList<>();
        for(int i=1; i<10; i++){
            if(!this.getElementValues().contains(i)){
                result.add(i);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s%n",this.elements.toString());
    }
}
