import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class setShortValueTest {

    @Test
    void testSetShortValue() {
        BitField bitField = new BitField(0b1111); // Create a BitField instance with a mask of 0b1111
        
        // Test with positive values
        short holder1 = 0b0000000000000000; // holder with all 0 bits
        short value1 = 0b1010; // value with bits to be replaced
        short expected1 = 0b0000000000001010; // expected result
        assertEquals(expected1, bitField.setShortValue(holder1, value1));
        
        short holder2 = 0b0000000000001111; // holder with all 1 bits
        short value2 = 0b0101; // value with bits to be replaced
        short expected2 = 0b0000000000000101; // expected result
        assertEquals(expected2, bitField.setShortValue(holder2, value2));
        
        // Test with negative values
        short holder3 = (short) 0b1111111111111111; // holder with all 1 bits
        short value3 = (short) 0b1010; // value with bits to be replaced
        short expected3 = (short) 0b1111111111111010; // expected result
        assertEquals(expected3, bitField.setShortValue(holder3, value3));
        
        short holder4 = (short) 0b1111111111110000; // holder with all 0 bits
        short value4 = (short) 0b0101; // value with bits to be replaced
        short expected4 = (short) 0b1111111111110101; // expected result
        assertEquals(expected4, bitField.setShortValue(holder4, value4));
        
        // Test with edge cases
        short holder5 = 0b0000000000000000; // holder with all 0 bits
        short value5 = 0b0000; // value with bits to be replaced
        short expected5 = 0b0000000000000000; // expected result
        assertEquals(expected5, bitField.setShortValue(holder5, value5));
        
        short holder6 = (short) 0b1111111111111111; // holder with all 1 bits
        short value6 = (short) 0b1111; // value with bits to be replaced
        short expected6 = (short) 0b1111111111111111; // expected result
        assertEquals(expected6, bitField.setShortValue(holder6, value6));
    }
}