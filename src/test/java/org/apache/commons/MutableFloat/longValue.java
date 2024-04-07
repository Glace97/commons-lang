import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class longValueTest {

    @Test
    void testLongValueWithZero() {
        MutableFloat mutableFloat = new MutableFloat(0);
        assertEquals(0, mutableFloat.longValue());
    }

    @Test
    void testLongValueWithPositiveValue() {
        MutableFloat mutableFloat = new MutableFloat(3.14f);
        assertEquals(3, mutableFloat.longValue());
    }

    @Test
    void testLongValueWithNegativeValue() {
        MutableFloat mutableFloat = new MutableFloat(-3.14f);
        assertEquals(-3, mutableFloat.longValue());
    }

    @Test
    void testLongValueWithMaxValue() {
        MutableFloat mutableFloat = new MutableFloat(Float.MAX_VALUE);
        assertEquals(Long.MAX_VALUE, mutableFloat.longValue());
    }

    @Test
    void testLongValueWithMinValue() {
        MutableFloat mutableFloat = new MutableFloat(Float.MIN_VALUE);
        assertEquals(0, mutableFloat.longValue());
    }

    @Test
    void testLongValueWithNullValue() {
        MutableFloat mutableFloat = new MutableFloat((Float) null);
        assertThrows(NullPointerException.class, mutableFloat::longValue);
    }

    @Test
    void testLongValueWithStringValue() {
        MutableFloat mutableFloat = new MutableFloat("3.14");
        assertEquals(3, mutableFloat.longValue());
    }

    @Test
    void testLongValueWithInvalidStringValue() {
        MutableFloat mutableFloat = new MutableFloat("abc");
        assertThrows(NumberFormatException.class, mutableFloat::longValue);
    }
}