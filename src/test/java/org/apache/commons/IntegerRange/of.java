import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ofTest {

    @Test
    void testOfInt() {
        IntegerRange range = IntegerRange.of(1, 10);
        assertEquals(1, range.getMinimum());
        assertEquals(10, range.getMaximum());
    }

    @Test
    void testOfInteger() {
        IntegerRange range = IntegerRange.of(Integer.valueOf(1), Integer.valueOf(10));
        assertEquals(Integer.valueOf(1), range.getMinimum());
        assertEquals(Integer.valueOf(10), range.getMaximum());
    }

    @Test
    void testOfIntReversed() {
        IntegerRange range = IntegerRange.of(10, 1);
        assertEquals(1, range.getMinimum());
        assertEquals(10, range.getMaximum());
    }

    @Test
    void testOfIntegerReversed() {
        IntegerRange range = IntegerRange.of(Integer.valueOf(10), Integer.valueOf(1));
        assertEquals(Integer.valueOf(1), range.getMinimum());
        assertEquals(Integer.valueOf(10), range.getMaximum());
    }

    @Test
    void testOfIntEqual() {
        IntegerRange range = IntegerRange.of(1, 1);
        assertEquals(1, range.getMinimum());
        assertEquals(1, range.getMaximum());
    }

    @Test
    void testOfIntegerEqual() {
        IntegerRange range = IntegerRange.of(Integer.valueOf(1), Integer.valueOf(1));
        assertEquals(Integer.valueOf(1), range.getMinimum());
        assertEquals(Integer.valueOf(1), range.getMaximum());
    }

    @Test
    void testOfIntNegative() {
        IntegerRange range = IntegerRange.of(-10, -1);
        assertEquals(-10, range.getMinimum());
        assertEquals(-1, range.getMaximum());
    }

    @Test
    void testOfIntegerNegative() {
        IntegerRange range = IntegerRange.of(Integer.valueOf(-10), Integer.valueOf(-1));
        assertEquals(Integer.valueOf(-10), range.getMinimum());
        assertEquals(Integer.valueOf(-1), range.getMaximum());
    }

    @Test
    void testOfIntZero() {
        IntegerRange range = IntegerRange.of(0, 0);
        assertEquals(0, range.getMinimum());
        assertEquals(0, range.getMaximum());
    }

    @Test
    void testOfIntegerZero() {
        IntegerRange range = IntegerRange.of(Integer.valueOf(0), Integer.valueOf(0));
        assertEquals(Integer.valueOf(0), range.getMinimum());
        assertEquals(Integer.valueOf(0), range.getMaximum());
    }

    @Test
    void testOfIntMaxValue() {
        IntegerRange range = IntegerRange.of(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, range.getMinimum());
        assertEquals(Integer.MAX_VALUE, range.getMaximum());
    }

    @Test
    void testOfIntegerMaxValue() {
        IntegerRange range = IntegerRange.of(Integer.valueOf(Integer.MAX_VALUE), Integer.valueOf(Integer.MAX_VALUE));
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), range.getMinimum());
        assertEquals(Integer.valueOf(Integer.MAX_VALUE), range.getMaximum());
    }

    @Test
    void testOfIntMinValue() {
        IntegerRange range = IntegerRange.of(Integer.MIN_VALUE, Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE, range.getMinimum());
        assertEquals(Integer.MIN_VALUE, range.getMaximum());
    }

    @Test
    void testOfIntegerMinValue() {
        IntegerRange range = IntegerRange.of(Integer.valueOf(Integer.MIN_VALUE), Integer.valueOf(Integer.MIN_VALUE));
        assertEquals(Integer.valueOf(Integer.MIN_VALUE), range.getMinimum());
        assertEquals(Integer.valueOf(Integer.MIN_VALUE), range.getMaximum());
    }
}