import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class longValueTest {

    @Test
    void testLongValuePositive() {
        MutableDouble mutableDouble = new MutableDouble(10.5);
        assertEquals(10, mutableDouble.longValue());
    }
    
    @Test
    void testLongValueNegative() {
        MutableDouble mutableDouble = new MutableDouble(-5.7);
        assertEquals(-5, mutableDouble.longValue());
    }
    
    @Test
    void testLongValueZero() {
        MutableDouble mutableDouble = new MutableDouble(0);
        assertEquals(0, mutableDouble.longValue());
    }
    
    @Test
    void testLongValueMaxValue() {
        MutableDouble mutableDouble = new MutableDouble(Double.MAX_VALUE);
        assertEquals(Long.MAX_VALUE, mutableDouble.longValue());
    }
    
    @Test
    void testLongValueMinValue() {
        MutableDouble mutableDouble = new MutableDouble(Double.MIN_VALUE);
        assertEquals(0, mutableDouble.longValue());
    }
    
    @Test
    void testLongValueNaN() {
        MutableDouble mutableDouble = new MutableDouble(Double.NaN);
        assertEquals(0, mutableDouble.longValue());
    }
    
    @Test
    void testLongValueInfinity() {
        MutableDouble mutableDouble = new MutableDouble(Double.POSITIVE_INFINITY);
        assertEquals(Long.MAX_VALUE, mutableDouble.longValue());
    }
    
    @Test
    void testLongValueNegativeInfinity() {
        MutableDouble mutableDouble = new MutableDouble(Double.NEGATIVE_INFINITY);
        assertEquals(Long.MIN_VALUE, mutableDouble.longValue());
    }
    
    @Test
    void testLongValueString() {
        MutableDouble mutableDouble = new MutableDouble("15.3");
        assertEquals(15, mutableDouble.longValue());
    }
    
    @Test
    void testLongValueInvalidString() {
        assertThrows(NumberFormatException.class, () -> new MutableDouble("abc"));
    }
}