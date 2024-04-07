import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class longValueTest {

    @Test
    void testLongValue() {
        MutableShort mutableShort = new MutableShort((short) 10);
        Assertions.assertEquals(10L, mutableShort.longValue());
    }

    @Test
    void testLongValueWithNegativeValue() {
        MutableShort mutableShort = new MutableShort((short) -5);
        Assertions.assertEquals(-5L, mutableShort.longValue());
    }

    @Test
    void testLongValueWithZeroValue() {
        MutableShort mutableShort = new MutableShort((short) 0);
        Assertions.assertEquals(0L, mutableShort.longValue());
    }

    @Test
    void testLongValueWithMaxValue() {
        MutableShort mutableShort = new MutableShort(Short.MAX_VALUE);
        Assertions.assertEquals((long) Short.MAX_VALUE, mutableShort.longValue());
    }

    @Test
    void testLongValueWithMinValue() {
        MutableShort mutableShort = new MutableShort(Short.MIN_VALUE);
        Assertions.assertEquals((long) Short.MIN_VALUE, mutableShort.longValue());
    }

    @Test
    void testLongValueWithPositiveStringValue() {
        MutableShort mutableShort = new MutableShort("100");
        Assertions.assertEquals(100L, mutableShort.longValue());
    }

    @Test
    void testLongValueWithNegativeStringValue() {
        MutableShort mutableShort = new MutableShort("-50");
        Assertions.assertEquals(-50L, mutableShort.longValue());
    }

    @Test
    void testLongValueWithZeroStringValue() {
        MutableShort mutableShort = new MutableShort("0");
        Assertions.assertEquals(0L, mutableShort.longValue());
    }

    @Test
    void testLongValueWithInvalidStringValue() {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            MutableShort mutableShort = new MutableShort("abc");
            mutableShort.longValue();
        });
    }
}