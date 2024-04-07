import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class decrementAndGetTest {

    @Test
    void testDecrementAndGet() {
        MutableShort mutableShort = new MutableShort((short) 5);
        assertEquals(4, mutableShort.decrementAndGet());
    }

    @Test
    void testDecrementAndGetWithZero() {
        MutableShort mutableShort = new MutableShort((short) 0);
        assertEquals(-1, mutableShort.decrementAndGet());
    }

    @Test
    void testDecrementAndGetWithNegativeValue() {
        MutableShort mutableShort = new MutableShort((short) -5);
        assertEquals(-6, mutableShort.decrementAndGet());
    }

    @Test
    void testDecrementAndGetWithMaxValue() {
        MutableShort mutableShort = new MutableShort((short) Short.MAX_VALUE);
        assertEquals(Short.MAX_VALUE - 1, mutableShort.decrementAndGet());
    }

    @Test
    void testDecrementAndGetWithMinValue() {
        MutableShort mutableShort = new MutableShort((short) Short.MIN_VALUE);
        assertEquals(Short.MIN_VALUE - 1, mutableShort.decrementAndGet());
    }
}