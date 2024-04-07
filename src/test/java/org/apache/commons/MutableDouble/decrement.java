import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class decrementTest {

    @Test
    void testDecrement() {
        MutableDouble mutableDouble = new MutableDouble(5.0);
        mutableDouble.decrement();
        assertEquals(4.0, mutableDouble.getValue());
    }

    @Test
    void testDecrementZero() {
        MutableDouble mutableDouble = new MutableDouble(0.0);
        mutableDouble.decrement();
        assertEquals(-1.0, mutableDouble.getValue());
    }

    @Test
    void testDecrementNegative() {
        MutableDouble mutableDouble = new MutableDouble(-5.0);
        mutableDouble.decrement();
        assertEquals(-6.0, mutableDouble.getValue());
    }

    @Test
    void testDecrementLargeValue() {
        MutableDouble mutableDouble = new MutableDouble(Double.MAX_VALUE);
        mutableDouble.decrement();
        assertEquals(Double.MAX_VALUE - 1, mutableDouble.getValue());
    }

    @Test
    void testDecrementSmallValue() {
        MutableDouble mutableDouble = new MutableDouble(Double.MIN_VALUE);
        mutableDouble.decrement();
        assertEquals(Double.MIN_VALUE - 1, mutableDouble.getValue());
    }
}