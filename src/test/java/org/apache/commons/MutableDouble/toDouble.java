import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toDoubleTest {

    @Test
    void testToDoubleWithPositiveValue() {
        MutableDouble mutableDouble = new MutableDouble(3.14);
        Double result = mutableDouble.toDouble();
        assertEquals(3.14, result);
    }

    @Test
    void testToDoubleWithNegativeValue() {
        MutableDouble mutableDouble = new MutableDouble(-5.67);
        Double result = mutableDouble.toDouble();
        assertEquals(-5.67, result);
    }

    @Test
    void testToDoubleWithZeroValue() {
        MutableDouble mutableDouble = new MutableDouble(0);
        Double result = mutableDouble.toDouble();
        assertEquals(0, result);
    }

    @Test
    void testToDoubleWithNullValue() {
        MutableDouble mutableDouble = new MutableDouble((Number) null);
        assertThrows(NullPointerException.class, () -> mutableDouble.toDouble());
    }

    @Test
    void testToDoubleWithStringValue() {
        MutableDouble mutableDouble = new MutableDouble("10.5");
        Double result = mutableDouble.toDouble();
        assertEquals(10.5, result);
    }

    @Test
    void testToDoubleWithInvalidStringValue() {
        MutableDouble mutableDouble = new MutableDouble("abc");
        assertThrows(NumberFormatException.class, () -> mutableDouble.toDouble());
    }
}