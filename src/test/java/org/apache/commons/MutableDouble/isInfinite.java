import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isInfiniteTest {

    @Test
    void testIsInfiniteWithPositiveInfiniteValue() {
        MutableDouble mutableDouble = new MutableDouble(Double.POSITIVE_INFINITY);
        assertTrue(mutableDouble.isInfinite());
    }
    
    @Test
    void testIsInfiniteWithNegativeInfiniteValue() {
        MutableDouble mutableDouble = new MutableDouble(Double.NEGATIVE_INFINITY);
        assertTrue(mutableDouble.isInfinite());
    }
    
    @Test
    void testIsInfiniteWithNonInfiniteValue() {
        MutableDouble mutableDouble = new MutableDouble(10.5);
        assertFalse(mutableDouble.isInfinite());
    }
    
    @Test
    void testIsInfiniteWithZero() {
        MutableDouble mutableDouble = new MutableDouble(0);
        assertFalse(mutableDouble.isInfinite());
    }
    
    @Test
    void testIsInfiniteWithNaN() {
        MutableDouble mutableDouble = new MutableDouble(Double.NaN);
        assertFalse(mutableDouble.isInfinite());
    }
    
    @Test
    void testIsInfiniteWithPositiveInfinityAsString() {
        MutableDouble mutableDouble = new MutableDouble("Infinity");
        assertTrue(mutableDouble.isInfinite());
    }
    
    @Test
    void testIsInfiniteWithNegativeInfinityAsString() {
        MutableDouble mutableDouble = new MutableDouble("-Infinity");
        assertTrue(mutableDouble.isInfinite());
    }
    
    @Test
    void testIsInfiniteWithNonInfiniteValueAsString() {
        MutableDouble mutableDouble = new MutableDouble("10.5");
        assertFalse(mutableDouble.isInfinite());
    }
    
    @Test
    void testIsInfiniteWithNaNAsString() {
        MutableDouble mutableDouble = new MutableDouble("NaN");
        assertFalse(mutableDouble.isInfinite());
    }
}