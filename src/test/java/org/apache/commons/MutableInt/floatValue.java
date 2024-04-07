import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class floatValueTest {

    @Test
    void testFloatValue() {
        MutableInt mutableInt = new MutableInt(10);
        assertEquals(10.0f, mutableInt.floatValue());
    }

    @Test
    void testFloatValueNegative() {
        MutableInt mutableInt = new MutableInt(-5);
        assertEquals(-5.0f, mutableInt.floatValue());
    }

    @Test
    void testFloatValueZero() {
        MutableInt mutableInt = new MutableInt(0);
        assertEquals(0.0f, mutableInt.floatValue());
    }

    @Test
    void testFloatValueMaxValue() {
        MutableInt mutableInt = new MutableInt(Integer.MAX_VALUE);
        assertEquals((float) Integer.MAX_VALUE, mutableInt.floatValue());
    }

    @Test
    void testFloatValueMinValue() {
        MutableInt mutableInt = new MutableInt(Integer.MIN_VALUE);
        assertEquals((float) Integer.MIN_VALUE, mutableInt.floatValue());
    }

    @Test
    void testFloatValueString() {
        MutableInt mutableInt = new MutableInt("15");
        assertEquals(15.0f, mutableInt.floatValue());
    }

    @Test
    void testFloatValueStringNegative() {
        MutableInt mutableInt = new MutableInt("-8");
        assertEquals(-8.0f, mutableInt.floatValue());
    }
}