import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getAndIncrementTest {

    @Test
    void testGetAndIncrement() {
        MutableDouble mutableDouble = new MutableDouble(5.0);

        // Test initial value
        assertEquals(5.0, mutableDouble.getAndIncrement());

        // Test incremented value
        assertEquals(6.0, mutableDouble.getAndIncrement());

        // Test negative value
        mutableDouble = new MutableDouble(-2.5);
        assertEquals(-2.5, mutableDouble.getAndIncrement());

        // Test zero value
        mutableDouble = new MutableDouble(0.0);
        assertEquals(0.0, mutableDouble.getAndIncrement());

        // Test large value
        mutableDouble = new MutableDouble(Double.MAX_VALUE);
        assertEquals(Double.MAX_VALUE, mutableDouble.getAndIncrement());

        // Test edge case where value is NaN
        mutableDouble = new MutableDouble(Double.NaN);
        assertEquals(Double.NaN, mutableDouble.getAndIncrement());

        // Test edge case where value is positive infinity
        mutableDouble = new MutableDouble(Double.POSITIVE_INFINITY);
        assertEquals(Double.POSITIVE_INFINITY, mutableDouble.getAndIncrement());

        // Test edge case where value is negative infinity
        mutableDouble = new MutableDouble(Double.NEGATIVE_INFINITY);
        assertEquals(Double.NEGATIVE_INFINITY, mutableDouble.getAndIncrement());
    }
}