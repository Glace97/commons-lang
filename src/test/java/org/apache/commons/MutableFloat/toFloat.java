import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toFloatTest {

    @Test
    void testToFloatWithZeroValue() {
        MutableFloat mutableFloat = new MutableFloat(0);
        assertEquals(0f, mutableFloat.toFloat());
    }

    @Test
    void testToFloatWithPositiveValue() {
        MutableFloat mutableFloat = new MutableFloat(10.5f);
        assertEquals(10.5f, mutableFloat.toFloat());
    }

    @Test
    void testToFloatWithNegativeValue() {
        MutableFloat mutableFloat = new MutableFloat(-5.75f);
        assertEquals(-5.75f, mutableFloat.toFloat());
    }

    @Test
    void testToFloatWithNullValue() {
        MutableFloat mutableFloat = new MutableFloat((Float) null);
        assertThrows(NullPointerException.class, mutableFloat::toFloat);
    }

    @Test
    void testToFloatWithStringValue() {
        MutableFloat mutableFloat = new MutableFloat("3.14");
        assertEquals(3.14f, mutableFloat.toFloat());
    }

    @Test
    void testToFloatWithInvalidStringValue() {
        MutableFloat mutableFloat = new MutableFloat("abc");
        assertThrows(NumberFormatException.class, mutableFloat::toFloat);
    }
}