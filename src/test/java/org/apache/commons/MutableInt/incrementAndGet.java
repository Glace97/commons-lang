import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class incrementAndGetTest {

    @Test
    void testIncrementAndGet() {
        MutableInt mutableInt = new MutableInt(0);
        assertEquals(1, mutableInt.incrementAndGet());
    }

    @Test
    void testIncrementAndGetWithNegativeValue() {
        MutableInt mutableInt = new MutableInt(-10);
        assertEquals(-9, mutableInt.incrementAndGet());
    }

    @Test
    void testIncrementAndGetWithMaxValue() {
        MutableInt mutableInt = new MutableInt(Integer.MAX_VALUE);
        assertEquals(Integer.MIN_VALUE, mutableInt.incrementAndGet());
    }

    @Test
    void testIncrementAndGetWithMinValue() {
        MutableInt mutableInt = new MutableInt(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE + 1, mutableInt.incrementAndGet());
    }

    @Test
    void testIncrementAndGetWithZeroValue() {
        MutableInt mutableInt = new MutableInt(0);
        assertEquals(1, mutableInt.incrementAndGet());
    }
}