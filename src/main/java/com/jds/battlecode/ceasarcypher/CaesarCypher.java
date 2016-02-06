package com.jds.battlecode.ceasarcypher;

public class CaesarCypher {

    public static final int UPPERCASE_LOW_BOUND = 65;
    public static final int UPPERCASE_HIGH_BOUND = 90;
    public static final int NUMBER_OF_LETTERS_ALPHABET = 26;
    String cypheredMessage;

    int cypherKey;
    
    public CaesarCypher(String cypheredMessage, int cypherKey) {
        this.cypheredMessage = cypheredMessage;
        //if key > 26 then we only need to take the modulo
        this.cypherKey = cypherKey % NUMBER_OF_LETTERS_ALPHABET;
    }

    public String getDecypheredMessage() {
        int [] decodedCharCodes = new int[cypheredMessage.length()];
        for (int i=0; i<cypheredMessage.length();i++){
            int myCharAscii = (int) cypheredMessage.charAt(i);
            decodedCharCodes[i] = decodeCharAsciiCode((int) myCharAscii);
        }
        return convertAsciiArrayToString(decodedCharCodes);
    }

    private int decodeCharAsciiCode(int codedAscii){
        if(codedAscii < UPPERCASE_LOW_BOUND || codedAscii > UPPERCASE_HIGH_BOUND){
            //ignore not alphabetic uppercase characters
            return codedAscii;
        }
        //D_n(x) = (x - n) mod {26}.
        int modulusResult = ((codedAscii-UPPERCASE_LOW_BOUND-cypherKey)%NUMBER_OF_LETTERS_ALPHABET);
        if(modulusResult >= 0){
            return modulusResult+UPPERCASE_LOW_BOUND;
        }

        return UPPERCASE_HIGH_BOUND+modulusResult+1;
    }

    private String convertAsciiArrayToString(int[] asciiArray){
        StringBuffer buf = new StringBuffer();
        for(int myAscii : asciiArray){
            String s = Character.toString ((char) myAscii);
            buf.append(s);
        }
        return buf.toString();
    }

}
