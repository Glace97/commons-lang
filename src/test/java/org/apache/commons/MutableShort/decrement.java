import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class decrementTest {

    @Test
    void testDecrement() {
        MutableShort mutableShort = new MutableShort((short) 5);
        mutableShort.decrement();
        assertEquals(4, mutableShort.getValue());
    }

    @Test
    void testDecrementZero() {
        MutableShort mutableShort = new MutableShort((short) 0);
        mutableShort.decrement();
        assertEquals(-1, mutableShort.getValue());
    }

    @Test
    void testDecrementNegativeValue() {
        MutableShort mutableShort = new MutableShort((short) -5);
        mutableShort.decrement();
        assertEquals(-6, mutableShort.getValue());
    }

    @Test
    void testDecrementMaxValue() {
        MutableShort mutableShort = new MutableShort(Short.MAX_VALUE);
        mutableShort.decrement();
        assertEquals(Short.MAX_VALUE - 1, mutableShort.getValue());
    }

    @Test
    void testDecrementMinValue() {
        MutableShort mutableShort = new MutableShort(Short.MIN_VALUE);
        mutableShort.decrement();
        assertEquals(Short.MIN_VALUE + 1, mutableShort.getValue());
    }
}

Note: The test class assumes that there is a getter method "getValue()" in the MutableShort class to retrieve the current value.