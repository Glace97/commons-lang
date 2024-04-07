import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class decrementAndGetTest {

    @Test
    void testDecrementAndGet() {
        MutableDouble mutableDouble = new MutableDouble(5.0);
        double result = mutableDouble.decrementAndGet();
        Assertions.assertEquals(4.0, result);
    }

    @Test
    void testDecrementAndGetWithZero() {
        MutableDouble mutableDouble = new MutableDouble(0.0);
        double result = mutableDouble.decrementAndGet();
        Assertions.assertEquals(-1.0, result);
    }

    @Test
    void testDecrementAndGetWithNegativeValue() {
        MutableDouble mutableDouble = new MutableDouble(-5.0);
        double result = mutableDouble.decrementAndGet();
        Assertions.assertEquals(-6.0, result);
    }
    
    @Test
    void testDecrementAndGetWithMaxValue() {
        MutableDouble mutableDouble = new MutableDouble(Double.MAX_VALUE);
        double result = mutableDouble.decrementAndGet();
        Assertions.assertEquals(Double.MAX_VALUE - 1.0, result);
    }

    @Test
    void testDecrementAndGetWithMinValue() {
        MutableDouble mutableDouble = new MutableDouble(Double.MIN_VALUE);
        double result = mutableDouble.decrementAndGet();
        Assertions.assertEquals(Double.MIN_VALUE - 1.0, result);
    }

    @Test
    void testDecrementAndGetWithNaN() {
        MutableDouble mutableDouble = new MutableDouble(Double.NaN);
        double result = mutableDouble.decrementAndGet();
        Assertions.assertEquals(Double.NaN, result);
    }
}