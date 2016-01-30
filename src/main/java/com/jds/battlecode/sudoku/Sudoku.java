package com.jds.battlecode.sudoku;

import java.util.*;

public class Sudoku {

    String message;

    int NUMBER_OF_TILES = 81;

    //1+2+3+4+5+6+7+8+9
    int SUM_COMPLETE_ENSEMBLE = 45;

    int MAX_ITERATIONS = 5000;

    SudokuEnsemble row0 = new SudokuEnsemble(new ArrayList<SudokuElement>(),0,SudokuEnsembleType.ROW);
    SudokuEnsemble row1 = new SudokuEnsemble(new ArrayList<SudokuElement>(),1,SudokuEnsembleType.ROW);
    SudokuEnsemble row2 = new SudokuEnsemble(new ArrayList<SudokuElement>(),2,SudokuEnsembleType.ROW);
    SudokuEnsemble row3 = new SudokuEnsemble(new ArrayList<SudokuElement>(),3,SudokuEnsembleType.ROW);
    SudokuEnsemble row4 = new SudokuEnsemble(new ArrayList<SudokuElement>(),4,SudokuEnsembleType.ROW);
    SudokuEnsemble row5 = new SudokuEnsemble(new ArrayList<SudokuElement>(),5,SudokuEnsembleType.ROW);
    SudokuEnsemble row6 = new SudokuEnsemble(new ArrayList<SudokuElement>(),6,SudokuEnsembleType.ROW);
    SudokuEnsemble row7 = new SudokuEnsemble(new ArrayList<SudokuElement>(),7,SudokuEnsembleType.ROW);
    SudokuEnsemble row8 = new SudokuEnsemble(new ArrayList<SudokuElement>(),8,SudokuEnsembleType.ROW);

    SudokuEnsemble col0 = new SudokuEnsemble(new ArrayList<SudokuElement>(),0,SudokuEnsembleType.COLUMN);
    SudokuEnsemble col1 = new SudokuEnsemble(new ArrayList<SudokuElement>(),1,SudokuEnsembleType.COLUMN);
    SudokuEnsemble col2 = new SudokuEnsemble(new ArrayList<SudokuElement>(),2,SudokuEnsembleType.COLUMN);
    SudokuEnsemble col3 = new SudokuEnsemble(new ArrayList<SudokuElement>(),3,SudokuEnsembleType.COLUMN);
    SudokuEnsemble col4 = new SudokuEnsemble(new ArrayList<SudokuElement>(),4,SudokuEnsembleType.COLUMN);
    SudokuEnsemble col5 = new SudokuEnsemble(new ArrayList<SudokuElement>(),5,SudokuEnsembleType.COLUMN);
    SudokuEnsemble col6 = new SudokuEnsemble(new ArrayList<SudokuElement>(),6,SudokuEnsembleType.COLUMN);
    SudokuEnsemble col7 = new SudokuEnsemble(new ArrayList<SudokuElement>(),7,SudokuEnsembleType.COLUMN);
    SudokuEnsemble col8 = new SudokuEnsemble(new ArrayList<SudokuElement>(),8,SudokuEnsembleType.COLUMN);

    SudokuEnsemble cuadrant0 = new SudokuEnsemble(new ArrayList<SudokuElement>(),0,SudokuEnsembleType.CUADRANT);
    SudokuEnsemble cuadrant1 = new SudokuEnsemble(new ArrayList<SudokuElement>(),1,SudokuEnsembleType.CUADRANT);
    SudokuEnsemble cuadrant2 = new SudokuEnsemble(new ArrayList<SudokuElement>(),2,SudokuEnsembleType.CUADRANT);
    SudokuEnsemble cuadrant3 = new SudokuEnsemble(new ArrayList<SudokuElement>(),3,SudokuEnsembleType.CUADRANT);
    SudokuEnsemble cuadrant4 = new SudokuEnsemble(new ArrayList<SudokuElement>(),4,SudokuEnsembleType.CUADRANT);
    SudokuEnsemble cuadrant5 = new SudokuEnsemble(new ArrayList<SudokuElement>(),5,SudokuEnsembleType.CUADRANT);
    SudokuEnsemble cuadrant6 = new SudokuEnsemble(new ArrayList<SudokuElement>(),6,SudokuEnsembleType.CUADRANT);
    SudokuEnsemble cuadrant7 = new SudokuEnsemble(new ArrayList<SudokuElement>(),7,SudokuEnsembleType.CUADRANT);
    SudokuEnsemble cuadrant8 = new SudokuEnsemble(new ArrayList<SudokuElement>(),8,SudokuEnsembleType.CUADRANT);

    List<SudokuElement> elementList = new ArrayList<SudokuElement>();

    int numberOfsolvedTiles = 0;

    public Sudoku(String message) {
        String[] lines = message.split(";");
        for(int i = 0; i < lines.length; i++){
            for(int j = 0; j < lines[i].length(); j++){
                String stringDigit =  lines[i].substring(j, j+1);
                Integer digit = null;
                if(!stringDigit.equals(" ")){
                    numberOfsolvedTiles++;
                    digit = Integer.valueOf(stringDigit);
                }
                SudokuElement element = new SudokuElement(j, i, digit);
                elementList.add(element);
                addElementToEnsemble(element);
            }
        }
        System.out.println(elementList);
    }

    public void executeLogic() {
        int i = 0;
        System.out.println("solved tiles: " + numberOfsolvedTiles);
        System.out.println("unsolved tiles: " + (NUMBER_OF_TILES -numberOfsolvedTiles));
        while(numberOfsolvedTiles <NUMBER_OF_TILES && i < MAX_ITERATIONS){
            for(SudokuElement el: elementList){
                if(el.isEmpty()){
                    SudokuEnsemble row = getRowEnsembleByIndex(el.y);
                    SudokuEnsemble column = getColEnsembleByIndex(el.x);
                    SudokuEnsemble cuadrant = getCuadrantEnsembleByIndex(getCuadrantforElement(el));

                    List<Integer> rowMissingValues = row.getMissingElementValues();
                    List<Integer> columnMissingValues = column.getMissingElementValues();
                    List<Integer> cuadrantMissingValues = cuadrant.getMissingElementValues();

                    List<Integer> joinMissingValues = calculateJoinValues(rowMissingValues, columnMissingValues, cuadrantMissingValues);

                    if(joinMissingValues.size()==1){
                        int missingElement = joinMissingValues.get(0);
                        el.element = missingElement;
                        numberOfsolvedTiles++;
                        System.out.println("missing element [PATH JOIN]: " + el);
                        break;
                    }

                    List<Integer> rowValues = row.getElementValues();
                    List<Integer> columnValues = column.getElementValues();
                    List<Integer> cuadrantValues = cuadrant.getElementValues();

                    if(rowValues.size()==8){
                        int missingElement = SUM_COMPLETE_ENSEMBLE - getSumElementValues(rowValues);
                        el.element = missingElement;
                        numberOfsolvedTiles++;
                        System.out.println("missing element [PATH ROW 8]: " + el);
                        break;
                    }

                    if(columnValues.size()==8){
                        int missingElement = SUM_COMPLETE_ENSEMBLE - getSumElementValues(columnValues);
                        el.element = missingElement;
                        numberOfsolvedTiles++;
                        System.out.println("missing element [PATH COL 8]: " + el);
                        break;
                    }

                    if(cuadrantValues.size()==8){
                        int missingElement = SUM_COMPLETE_ENSEMBLE - getSumElementValues(cuadrantValues);
                        el.element = missingElement;
                        numberOfsolvedTiles++;
                        System.out.println("missing element [PATH CUAD 8]: " + el);
                        break;
                    }
                }
            }
            i++;
        }

        System.out.println("solved tiles: " + numberOfsolvedTiles);
        System.out.println("unsolved tiles: " + (NUMBER_OF_TILES -numberOfsolvedTiles));
        printSudoku();
    }

    private List<Integer> calculateJoinValues(List<Integer> rowMissingValues, List<Integer> columnMissingValues, List<Integer> cuadrantMissingValues) {
        List<Integer> joinValues = new ArrayList<Integer>();
        for(Integer value: rowMissingValues){
            if (columnMissingValues.contains(value) && cuadrantMissingValues.contains(value) ){
                joinValues.add(value);
            }
        }
        return joinValues;
    }



    private void printSudoku() {
        System.out.println("SOLUTION:");
        System.out.print(elementList);
    }

    int getSumElementValues(Collection<Integer> uniqueValues){
        int sum = 0;
        for(Integer val : uniqueValues){
            sum += val;
        }
        return sum;
    }

    private void addElementToEnsemble(SudokuElement element) {
        getColEnsembleByIndex(element.x).addElementToEnsemble(element);
        getRowEnsembleByIndex(element.y).addElementToEnsemble(element);
        getCuadrantEnsembleByIndex(getCuadrantforElement(element)).addElementToEnsemble(element);
    }

    int getCuadrantforElement(SudokuElement element){
        int x = element.x;
        int y = element.y;
        int cuadrant = 0;
        if(x<3){
            if(y<3){
                cuadrant =0;
            } else if (y>=3 && y<6){
                cuadrant=3;
            } else{
                cuadrant=6;
            }
        }else if(x>=3 && x<6){
            if(y<3){
                cuadrant =1;
            } else if (y >=3 && y<6){
                cuadrant=4;
            } else{
                cuadrant=7;
            }
        }else {
            if(y<3){
                cuadrant = 2;
            } else if (y >= 3 && y < 6){
                cuadrant = 5;
            } else{
                cuadrant = 8;
            }
        }
        System.out.println("cuadrant "+cuadrant+" :" + "for element: " + element);
        return cuadrant;
    }

    SudokuEnsemble getColEnsembleByIndex(int index){
        switch(index){
            case 0:
                return col0;
            case 1:
                return col1;
            case 2:
                return col2;
            case 3:
                return col3;
            case 4:
                return col4;
            case 5:
                return col5;
            case 6:
                return col6;
            case 7:
                return col7;
            case 8:
                return col8;
        }
        //should never happen
        return null;
    }

    SudokuEnsemble getRowEnsembleByIndex(int index){
        switch(index){
            case 0:
                return row0;
            case 1:
                return row1;
            case 2:
                return row2;
            case 3:
                return row3;
            case 4:
                return row4;
            case 5:
                return row5;
            case 6:
                return row6;
            case 7:
                return row7;
            case 8:
                return row8;
        }
        //should never happen
        return null;
    }

    SudokuEnsemble getCuadrantEnsembleByIndex(int index){
        switch(index){
            case 0:
                return cuadrant0;
            case 1:
                return cuadrant1;
            case 2:
                return cuadrant2;
            case 3:
                return cuadrant3;
            case 4:
                return cuadrant4;
            case 5:
                return cuadrant5;
            case 6:
                return cuadrant6;
            case 7:
                return cuadrant7;
            case 8:
                return cuadrant8;
        }
        //should never happen
        return null;
    }

}
