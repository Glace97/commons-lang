import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class incrementTest {
    private MutableInt mutableInt;

    @BeforeEach
    void setUp() {
        mutableInt = new MutableInt();
    }

    @Test
    void testIncrement() {
        mutableInt.increment();
        assertEquals(1, mutableInt.getValue());
    }
    
    @Test
    void testIncrementMultipleTimes() {
        mutableInt.increment();
        mutableInt.increment();
        mutableInt.increment();
        assertEquals(3, mutableInt.getValue());
    }
    
    @Test
    void testIncrementWithNegativeValue() {
        mutableInt = new MutableInt(-5);
        mutableInt.increment();
        assertEquals(-4, mutableInt.getValue());
    }
    
    @Test
    void testIncrementWithMaxIntValue() {
        mutableInt = new MutableInt(Integer.MAX_VALUE);
        mutableInt.increment();
        assertEquals(Integer.MIN_VALUE, mutableInt.getValue());
    }
    
    @Test
    void testIncrementWithMinIntValue() {
        mutableInt = new MutableInt(Integer.MIN_VALUE);
        mutableInt.increment();
        assertEquals(Integer.MIN_VALUE + 1, mutableInt.getValue());
    }
    
    @Test
    void testIncrementWithStringValue() {
        mutableInt = new MutableInt("10");
        mutableInt.increment();
        assertEquals(11, mutableInt.getValue());
    }
    
    @Test
    void testIncrementWithInvalidStringValue() {
        assertThrows(NumberFormatException.class, () -> {
            mutableInt = new MutableInt("abc");
            mutableInt.increment();
        });
    }
}