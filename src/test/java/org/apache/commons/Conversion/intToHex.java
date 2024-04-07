import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class intToHexTest {

    @Test
    void testIntToHex() {
        // Test case 1: nHexs = 0
        String result1 = Conversion.intToHex(255, 0, "0000", 0, 0);
        assertEquals("0000", result1);
        
        // Test case 2: nHexs = 1
        String result2 = Conversion.intToHex(255, 0, "0000", 0, 1);
        assertEquals("000F", result2);
        
        // Test case 3: nHexs = 2
        String result3 = Conversion.intToHex(255, 0, "0000", 0, 2);
        assertEquals("00FF", result3);
        
        // Test case 4: nHexs = 3
        String result4 = Conversion.intToHex(255, 0, "0000", 0, 3);
        assertEquals("0FFF", result4);
        
        // Test case 5: nHexs = 4
        String result5 = Conversion.intToHex(255, 0, "0000", 0, 4);
        assertEquals("FFFF", result5);
        
        // Test case 6: srcPos = 0
        String result6 = Conversion.intToHex(255, 0, "0000", 0, 2);
        assertEquals("00FF", result6);
        
        // Test case 7: srcPos = 4
        String result7 = Conversion.intToHex(255, 4, "0000", 0, 2);
        assertEquals("F000", result7);
        
        // Test case 8: srcPos = 8
        String result8 = Conversion.intToHex(255, 8, "0000", 0, 2);
        assertEquals("FF00", result8);
        
        // Test case 9: srcPos = 12
        String result9 = Conversion.intToHex(255, 12, "0000", 0, 2);
        assertEquals("FF00", result9);
        
        // Test case 10: dstPos = 0
        String result10 = Conversion.intToHex(255, 0, "0000", 0, 2);
        assertEquals("00FF", result10);
        
        // Test case 11: dstPos = 2
        String result11 = Conversion.intToHex(255, 0, "0000", 2, 2);
        assertEquals("0000FF", result11);
        
        // Test case 12: dstPos = 4
        String result12 = Conversion.intToHex(255, 0, "0000", 4, 2);
        assertEquals("0000FF", result12);
        
        // Test case 13: dstPos = 6
        String result13 = Conversion.intToHex(255, 0, "0000", 6, 2);
        assertEquals("000000FF", result13);
        
        // Test case 14: nHexs = 5 (throws IllegalArgumentException)
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.intToHex(255, 0, "0000", 0, 5);
        });
        
        // Test case 15: dstInit length < dstPos (throws StringIndexOutOfBoundsException)
        assertThrows(StringIndexOutOfBoundsException.class, () -> {
            Conversion.intToHex(255, 0, "0000", 5, 2);
        });
    }
}