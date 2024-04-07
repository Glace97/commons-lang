import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class intValueTest {

    @Test
    void testIntValueWithZero() {
        MutableDouble mutableDouble = new MutableDouble(0.0);
        assertEquals(0, mutableDouble.intValue());
    }

    @Test
    void testIntValueWithPositiveValue() {
        MutableDouble mutableDouble = new MutableDouble(10.5);
        assertEquals(10, mutableDouble.intValue());
    }

    @Test
    void testIntValueWithNegativeValue() {
        MutableDouble mutableDouble = new MutableDouble(-5.7);
        assertEquals(-5, mutableDouble.intValue());
    }

    @Test
    void testIntValueWithMaxValue() {
        MutableDouble mutableDouble = new MutableDouble(Double.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, mutableDouble.intValue());
    }

    @Test
    void testIntValueWithMinValue() {
        MutableDouble mutableDouble = new MutableDouble(Double.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE, mutableDouble.intValue());
    }

    @Test
    void testIntValueWithInfinity() {
        MutableDouble mutableDouble = new MutableDouble(Double.POSITIVE_INFINITY);
        assertEquals(Integer.MAX_VALUE, mutableDouble.intValue());
    }

    @Test
    void testIntValueWithNaN() {
        MutableDouble mutableDouble = new MutableDouble(Double.NaN);
        assertEquals(0, mutableDouble.intValue());
    }
}