import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class floatValueTest {

    @Test
    void testFloatValue() {
        MutableLong mutableLong = new MutableLong(10L);
        assertEquals(10.0f, mutableLong.floatValue(), 0.001);
    }

    @Test
    void testFloatValueZero() {
        MutableLong mutableLong = new MutableLong(0L);
        assertEquals(0.0f, mutableLong.floatValue(), 0.001);
    }

    @Test
    void testFloatValueNegative() {
        MutableLong mutableLong = new MutableLong(-10L);
        assertEquals(-10.0f, mutableLong.floatValue(), 0.001);
    }

    @Test
    void testFloatValueMaxValue() {
        MutableLong mutableLong = new MutableLong(Long.MAX_VALUE);
        assertEquals((float) Long.MAX_VALUE, mutableLong.floatValue(), 0.001);
    }

    @Test
    void testFloatValueMinValue() {
        MutableLong mutableLong = new MutableLong(Long.MIN_VALUE);
        assertEquals((float) Long.MIN_VALUE, mutableLong.floatValue(), 0.001);
    }

    @Test
    void testFloatValueFromString() {
        MutableLong mutableLong = new MutableLong("10");
        assertEquals(10.0f, mutableLong.floatValue(), 0.001);
    }

    @Test
    void testFloatValueFromStringNegative() {
        MutableLong mutableLong = new MutableLong("-10");
        assertEquals(-10.0f, mutableLong.floatValue(), 0.001);
    }

    @Test
    void testFloatValueFromStringZero() {
        MutableLong mutableLong = new MutableLong("0");
        assertEquals(0.0f, mutableLong.floatValue(), 0.001);
    }

    @Test
    void testFloatValueFromStringMaxValue() {
        MutableLong mutableLong = new MutableLong(Long.toString(Long.MAX_VALUE));
        assertEquals((float) Long.MAX_VALUE, mutableLong.floatValue(), 0.001);
    }

    @Test
    void testFloatValueFromStringMinValue() {
        MutableLong mutableLong = new MutableLong(Long.toString(Long.MIN_VALUE));
        assertEquals((float) Long.MIN_VALUE, mutableLong.floatValue(), 0.001);
    }
}