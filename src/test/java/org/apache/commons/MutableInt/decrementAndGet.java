import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class decrementAndGetTest {

    @Test
    void testDecrementAndGet() {
        MutableInt mutableInt = new MutableInt(5);
        assertEquals(4, mutableInt.decrementAndGet());
    }

    @Test
    void testDecrementAndGetZero() {
        MutableInt mutableInt = new MutableInt(0);
        assertEquals(-1, mutableInt.decrementAndGet());
    }

    @Test
    void testDecrementAndGetNegative() {
        MutableInt mutableInt = new MutableInt(-5);
        assertEquals(-6, mutableInt.decrementAndGet());
    }

    @Test
    void testDecrementAndGetMinValue() {
        MutableInt mutableInt = new MutableInt(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE - 1, mutableInt.decrementAndGet());
    }

    @Test
    void testDecrementAndGetMaxValue() {
        MutableInt mutableInt = new MutableInt(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE - 1, mutableInt.decrementAndGet());
    }
}