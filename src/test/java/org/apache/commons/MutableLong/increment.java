import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class IncrementTest {

    private MutableLong mutableLong;

    @BeforeEach
    void setUp() {
        mutableLong = new MutableLong();
    }

    @Test
    void testIncrement() {
        mutableLong.increment();
        assertEquals(1, mutableLong.getValue());
    }

    @Test
    void testIncrementMultipleTimes() {
        mutableLong.increment();
        mutableLong.increment();
        mutableLong.increment();
        assertEquals(3, mutableLong.getValue());
    }

    @Test
    void testIncrementWithInitialValue() {
        mutableLong = new MutableLong(5);
        mutableLong.increment();
        assertEquals(6, mutableLong.getValue());
    }

    @Test
    void testIncrementWithNegativeValue() {
        mutableLong = new MutableLong(-3);
        mutableLong.increment();
        assertEquals(-2, mutableLong.getValue());
    }

    @Test
    void testIncrementWithDecimalValue() {
        mutableLong = new MutableLong(3.5);
        assertThrows(ClassCastException.class, () -> {
            mutableLong.increment();
        });
    }

    @Test
    void testIncrementWithStringValue() {
        mutableLong = new MutableLong("10");
        mutableLong.increment();
        assertEquals(11, mutableLong.getValue());
    }

    @Test
    void testIncrementWithInvalidStringValue() {
        assertThrows(NumberFormatException.class, () -> {
            mutableLong = new MutableLong("abc");
            mutableLong.increment();
        });
    }
}