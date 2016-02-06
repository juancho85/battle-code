package com.jds.battlecode.ceasarcypher;

import java.text.ParseException;

public class CaesarCypherLauncher
{
	
    public static void main( String[] args ) throws ParseException
    {
    	long startTime = System.nanoTime();
        //DEFEND THE EAST WALL OF THE CASTLE
//        String cypheredMessage = "NOPOXN DRO OKCD GKVV YP DRO MKCDVO";
//        int cypherKey = 400;
//        String cypheredMessage = "QRSRAQ GUR RNFG JNYY BS GUR PNFGYR";
//        int cypherKey = -13;
        String cypheredMessage = "STUTCS IWT TPHI LPAA DU IWT RPHIAT";
        int cypherKey = 15;


        CaesarCypher caesarCypher = new CaesarCypher(cypheredMessage, cypherKey);
        System.out.println(caesarCypher.getDecypheredMessage());
    	long endTime = System.nanoTime();
    	System.out.printf("elapsed time: %d ns", endTime - startTime);
    }

}
