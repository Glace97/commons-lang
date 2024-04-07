import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class SubtractTest {

    private MutableShort mutableShort;

    @BeforeEach
    void setUp() {
        mutableShort = new MutableShort(10);
    }

    @Test
    void testSubtractWithNumberOperand() {
        mutableShort.subtract(5);
        assertEquals(5, mutableShort.getValue());
    }

    @Test
    void testSubtractWithShortOperand() {
        mutableShort.subtract((short) 3);
        assertEquals(7, mutableShort.getValue());
    }

    @Test
    void testSubtractWithZeroOperand() {
        mutableShort.subtract(0);
        assertEquals(10, mutableShort.getValue());
    }

    @Test
    void testSubtractWithNegativeOperand() {
        mutableShort.subtract(-3);
        assertEquals(13, mutableShort.getValue());
    }
}