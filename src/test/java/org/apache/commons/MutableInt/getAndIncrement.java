import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class getAndIncrementTest {

    @Test
    void testGetAndIncrement() {
        MutableInt mutableInt = new MutableInt(5);
        int result = mutableInt.getAndIncrement();
        
        assertEquals(5, result);
        assertEquals(6, mutableInt.getValue());
    }
    
    @Test
    void testGetAndIncrementZero() {
        MutableInt mutableInt = new MutableInt(0);
        int result = mutableInt.getAndIncrement();
        
        assertEquals(0, result);
        assertEquals(1, mutableInt.getValue());
    }

    @Test
    void testGetAndIncrementNegative() {
        MutableInt mutableInt = new MutableInt(-5);
        int result = mutableInt.getAndIncrement();
        
        assertEquals(-5, result);
        assertEquals(-4, mutableInt.getValue());
    }
    
    @Test
    void testGetAndIncrementMaxValue() {
        MutableInt mutableInt = new MutableInt(Integer.MAX_VALUE);
        int result = mutableInt.getAndIncrement();
        
        assertEquals(Integer.MAX_VALUE, result);
        assertEquals(Integer.MIN_VALUE, mutableInt.getValue());
    }
    
    @Test
    void testGetAndIncrementMinValue() {
        MutableInt mutableInt = new MutableInt(Integer.MIN_VALUE);
        int result = mutableInt.getAndIncrement();
        
        assertEquals(Integer.MIN_VALUE, result);
        assertEquals(Integer.MIN_VALUE + 1, mutableInt.getValue());
    }
}