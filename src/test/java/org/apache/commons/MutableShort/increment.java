import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class incrementTest {

    @Test
    void testIncrement() {
        MutableShort mutableShort = new MutableShort((short) 0);
        mutableShort.increment();
        assertEquals(1, mutableShort.getValue());
    }

    @Test
    void testIncrementWithPositiveValue() {
        MutableShort mutableShort = new MutableShort((short) 100);
        mutableShort.increment();
        assertEquals(101, mutableShort.getValue());
    }

    @Test
    void testIncrementWithNegativeValue() {
        MutableShort mutableShort = new MutableShort((short) -100);
        mutableShort.increment();
        assertEquals(-99, mutableShort.getValue());
    }

    @Test
    void testIncrementWithMaxValue() {
        MutableShort mutableShort = new MutableShort(Short.MAX_VALUE);
        mutableShort.increment();
        assertEquals(Short.MIN_VALUE, mutableShort.getValue());
    }

    @Test
    void testIncrementWithMinValue() {
        MutableShort mutableShort = new MutableShort(Short.MIN_VALUE);
        mutableShort.increment();
        assertEquals((short) (Short.MIN_VALUE + 1), mutableShort.getValue());
    }

    @Test
    void testIncrementWithStringValue() {
        MutableShort mutableShort = new MutableShort("10");
        mutableShort.increment();
        assertEquals(11, mutableShort.getValue());
    }

    @Test
    void testIncrementWithInvalidStringValue() {
        assertThrows(NumberFormatException.class, () -> {
            MutableShort mutableShort = new MutableShort("abc");
            mutableShort.increment();
        });
    }
}