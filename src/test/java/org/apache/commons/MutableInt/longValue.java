import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class longValueTest {

    private MutableInt mutableInt;

    @BeforeEach
    void setUp() {
        mutableInt = new MutableInt();
    }

    @Test
    void testLongValueWithZero() {
        assertEquals(0, mutableInt.longValue());
    }

    @Test
    void testLongValueWithPositiveValue() {
        mutableInt = new MutableInt(10);
        assertEquals(10, mutableInt.longValue());
    }

    @Test
    void testLongValueWithNegativeValue() {
        mutableInt = new MutableInt(-10);
        assertEquals(-10, mutableInt.longValue());
    }

    @Test
    void testLongValueWithMaxIntValue() {
        mutableInt = new MutableInt(Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE, mutableInt.longValue());
    }

    @Test
    void testLongValueWithMinIntValue() {
        mutableInt = new MutableInt(Integer.MIN_VALUE);
        assertEquals(Integer.MIN_VALUE, mutableInt.longValue());
    }

    @Test
    void testLongValueWithMaxLongValue() {
        mutableInt = new MutableInt(Long.MAX_VALUE);
        assertEquals(Long.MAX_VALUE, mutableInt.longValue());
    }

    @Test
    void testLongValueWithMinLongValue() {
        mutableInt = new MutableInt(Long.MIN_VALUE);
        assertEquals(Long.MIN_VALUE, mutableInt.longValue());
    }
}