package caesarcypher;

import com.jds.battlecode.ceasarcypher.CaesarCypher;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CaesarCypherTest {

    private static final String EXPECTED_CHAIN = "DEFEND THE EAST WALL OF THE CASTLE";

    @Test
    public void testPositiveKeyDecypher(){
        String cypheredMessage = "STUTCS IWT TPHI LPAA DU IWT RPHIAT";
        int cypherKey = 15;
        CaesarCypher cut =  new CaesarCypher(cypheredMessage, cypherKey);
        assertEquals(EXPECTED_CHAIN, cut.getDecypheredMessage());
    }

    @Test
    public void testBigPositiveKeyDecypher(){
        String cypheredMessage = "NOPOXN DRO OKCD GKVV YP DRO MKCDVO";
        int cypherKey = 400;
        CaesarCypher cut =  new CaesarCypher(cypheredMessage, cypherKey);
        assertEquals(EXPECTED_CHAIN, cut.getDecypheredMessage());
    }

    @Test
    public void testNegativeKeyDecypher(){
        String cypheredMessage = "QRSRAQ GUR RNFG JNYY BS GUR PNFGYR";
        int cypherKey = 13;
        CaesarCypher cut =  new CaesarCypher(cypheredMessage, cypherKey);
        assertEquals(EXPECTED_CHAIN, cut.getDecypheredMessage());
    }


}
