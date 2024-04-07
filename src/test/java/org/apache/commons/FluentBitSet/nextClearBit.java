import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class nextClearBitTest {

    FluentBitSet bitSet;

    @BeforeEach
    void setUp() {
        bitSet = new FluentBitSet();
    }

    @Test
    void testNextClearBit() {
        assertEquals(0, bitSet.nextClearBit(0));
        
        // Test when all bits are set to true
        bitSet.bitSet.set(0, 10);
        assertEquals(10, bitSet.nextClearBit(0));
        
        // Test when fromIndex is negative
        assertThrows(IndexOutOfBoundsException.class, () -> bitSet.nextClearBit(-1));
        
        // Test when fromIndex is greater than the length of the bit set
        assertEquals(0, bitSet.nextClearBit(20));
        
        // Test when the bit set is empty
        assertEquals(0, bitSet.nextClearBit(0));
        
        // Test when there is only one clear bit
        bitSet.bitSet.set(0, 5);
        assertEquals(5, bitSet.nextClearBit(0));
        
        // Test when there are multiple clear bits
        bitSet.bitSet.clear(2);
        assertEquals(2, bitSet.nextClearBit(0));
        
        // Test when fromIndex is in the middle of the bit set
        bitSet.bitSet.clear(3);
        assertEquals(2, bitSet.nextClearBit(1));
    }

}