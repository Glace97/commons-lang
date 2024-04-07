import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DecrementTest {

    private MutableFloat mutableFloat;

    @BeforeEach
    void setUp() {
        mutableFloat = new MutableFloat(5.0f);
    }

    @Test
    void testDecrement() {
        mutableFloat.decrement();
        assertEquals(4.0f, mutableFloat.getValue());
    }

    @Test
    void testDecrementMultipleTimes() {
        mutableFloat.decrement();
        mutableFloat.decrement();
        mutableFloat.decrement();
        assertEquals(2.0f, mutableFloat.getValue());
    }

    @Test
    void testDecrementToNegativeValue() {
        mutableFloat.decrement();
        mutableFloat.decrement();
        mutableFloat.decrement();
        mutableFloat.decrement();
        assertEquals(-1.0f, mutableFloat.getValue());
    }

    @Test
    void testDecrementZeroValue() {
        mutableFloat = new MutableFloat(0.0f);
        mutableFloat.decrement();
        assertEquals(-1.0f, mutableFloat.getValue());
    }
}