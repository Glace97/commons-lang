import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getAndDecrementTest {

    @Test
    void testGetAndDecrement() {
        MutableShort mutableShort = new MutableShort(10);

        short result = mutableShort.getAndDecrement();

        assertEquals(10, result);
        assertEquals(9, mutableShort.getValue());
    }

    @Test
    void testGetAndDecrementNegativeValue() {
        MutableShort mutableShort = new MutableShort(-5);

        short result = mutableShort.getAndDecrement();

        assertEquals(-5, result);
        assertEquals(-6, mutableShort.getValue());
    }

    @Test
    void testGetAndDecrementZeroValue() {
        MutableShort mutableShort = new MutableShort(0);

        short result = mutableShort.getAndDecrement();

        assertEquals(0, result);
        assertEquals(-1, mutableShort.getValue());
    }

    @Test
    void testGetAndDecrementMaxValue() {
        MutableShort mutableShort = new MutableShort(Short.MAX_VALUE);

        short result = mutableShort.getAndDecrement();

        assertEquals(Short.MAX_VALUE, result);
        assertEquals(Short.MAX_VALUE - 1, mutableShort.getValue());
    }

    @Test
    void testGetAndDecrementMinValue() {
        MutableShort mutableShort = new MutableShort(Short.MIN_VALUE);

        short result = mutableShort.getAndDecrement();

        assertEquals(Short.MIN_VALUE, result);
        assertEquals(Short.MIN_VALUE - 1, mutableShort.getValue());
    }

    @Test
    void testGetAndDecrementString() {
        MutableShort mutableShort = new MutableShort("15");

        short result = mutableShort.getAndDecrement();

        assertEquals(15, result);
        assertEquals(14, mutableShort.getValue());
    }

    @Test
    void testGetAndDecrementInvalidString() {
        assertThrows(NumberFormatException.class, () -> {
            MutableShort mutableShort = new MutableShort("abc");
            mutableShort.getAndDecrement();
        });
    }
}