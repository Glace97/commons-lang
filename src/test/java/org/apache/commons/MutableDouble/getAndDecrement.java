import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getAndDecrementTest {

    @Test
    void testGetAndDecrement() {
        MutableDouble mutableDouble = new MutableDouble(5.0);

        // Test initial value
        assertEquals(5.0, mutableDouble.getAndDecrement());

        // Test decrement by 1
        assertEquals(4.0, mutableDouble.getAndDecrement());

        // Test decrement multiple times
        assertEquals(3.0, mutableDouble.getAndDecrement());
        assertEquals(2.0, mutableDouble.getAndDecrement());
        assertEquals(1.0, mutableDouble.getAndDecrement());
        assertEquals(0.0, mutableDouble.getAndDecrement());

        // Test negative values
        mutableDouble = new MutableDouble(-5.0);
        assertEquals(-5.0, mutableDouble.getAndDecrement());
        assertEquals(-6.0, mutableDouble.getAndDecrement());
        assertEquals(-7.0, mutableDouble.getAndDecrement());

        // Test edge case of maximum double value
        mutableDouble = new MutableDouble(Double.MAX_VALUE);
        assertEquals(Double.MAX_VALUE, mutableDouble.getAndDecrement());

        // Test edge case of minimum double value
        mutableDouble = new MutableDouble(Double.MIN_VALUE);
        assertEquals(Double.MIN_VALUE, mutableDouble.getAndDecrement());
    }
}