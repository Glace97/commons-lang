import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class hexToIntTest {
    
    @Test
    void testHexToInt() {
        // Test case 1: Empty string, should return dstInit
        int result1 = Conversion.hexToInt("", 0, 10, 0, 0);
        assertEquals(10, result1);
        
        // Test case 2: nHex = 0, should return dstInit
        int result2 = Conversion.hexToInt("123", 0, 20, 0, 0);
        assertEquals(20, result2);
        
        // Test case 3: (nHex - 1) * 4 + dstPos < 32, should not throw IllegalArgumentException
        assertDoesNotThrow(() -> Conversion.hexToInt("ABC", 0, 0, 0, 3));
        
        // Test case 4: (nHex - 1) * 4 + dstPos >= 32, should throw IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexToInt("ABC", 0, 0, 16, 3));
        
        // Test case 5: Positive test case with valid input
        int result5 = Conversion.hexToInt("ABCDEF", 0, 0, 0, 6);
        assertEquals(11259375, result5);
        
        // Test case 6: Positive test case with srcPos > 0
        int result6 = Conversion.hexToInt("ABCDEF", 1, 0, 0, 5);
        assertEquals(1125937, result6);
        
        // Test case 7: Positive test case with dstPos > 0
        int result7 = Conversion.hexToInt("ABCDEF", 0, 0, 2, 5);
        assertEquals(450369, result7);
        
        // Test case 8: Positive test case with nHex = 1
        int result8 = Conversion.hexToInt("A", 0, 0, 0, 1);
        assertEquals(10, result8);
        
        // Test case 9: Positive test case with nHex = 1 and dstPos > 0
        int result9 = Conversion.hexToInt("A", 0, 0, 2, 1);
        assertEquals(40, result9);
    }
}