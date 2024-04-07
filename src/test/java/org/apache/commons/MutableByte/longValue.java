import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class longValueTest {

    @Test
    void testLongValueWithPositiveValue() {
        MutableByte mutableByte = new MutableByte((byte) 10);
        assertEquals(10L, mutableByte.longValue());
    }

    @Test
    void testLongValueWithNegativeValue() {
        MutableByte mutableByte = new MutableByte((byte) -5);
        assertEquals(-5L, mutableByte.longValue());
    }

    @Test
    void testLongValueWithZero() {
        MutableByte mutableByte = new MutableByte((byte) 0);
        assertEquals(0L, mutableByte.longValue());
    }

    @Test
    void testLongValueWithMaxValue() {
        MutableByte mutableByte = new MutableByte(Byte.MAX_VALUE);
        assertEquals((long) Byte.MAX_VALUE, mutableByte.longValue());
    }

    @Test
    void testLongValueWithMinValue() {
        MutableByte mutableByte = new MutableByte(Byte.MIN_VALUE);
        assertEquals((long) Byte.MIN_VALUE, mutableByte.longValue());
    }

    @Test
    void testLongValueFromString() {
        MutableByte mutableByte = new MutableByte("20");
        assertEquals(20L, mutableByte.longValue());
    }

    @Test
    void testLongValueFromStringWithNegativeValue() {
        MutableByte mutableByte = new MutableByte("-15");
        assertEquals(-15L, mutableByte.longValue());
    }

    @Test
    void testLongValueFromStringWithZero() {
        MutableByte mutableByte = new MutableByte("0");
        assertEquals(0L, mutableByte.longValue());
    }

    @Test
    void testLongValueFromStringWithMaxValue() {
        MutableByte mutableByte = new MutableByte(String.valueOf(Byte.MAX_VALUE));
        assertEquals((long) Byte.MAX_VALUE, mutableByte.longValue());
    }

    @Test
    void testLongValueFromStringWithMinValue() {
        MutableByte mutableByte = new MutableByte(String.valueOf(Byte.MIN_VALUE));
        assertEquals((long) Byte.MIN_VALUE, mutableByte.longValue());
    }
}