import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getValueTest {

    @Test
    void testGetValueWithDefaultConstructor() {
        MutableDouble mutableDouble = new MutableDouble();
        assertEquals(0.0, mutableDouble.getValue());
    }

    @Test
    void testGetValueWithConstructorWithValue() {
        MutableDouble mutableDouble = new MutableDouble(5.0);
        assertEquals(5.0, mutableDouble.getValue());
    }

    @Test
    void testGetValueWithConstructorWithNumberValue() {
        MutableDouble mutableDouble = new MutableDouble(10);
        assertEquals(10.0, mutableDouble.getValue());
    }

    @Test
    void testGetValueWithConstructorWithStringValue() {
        MutableDouble mutableDouble = new MutableDouble("15.5");
        assertEquals(15.5, mutableDouble.getValue());
    }

    @Test
    void testGetValueWithConstructorWithInvalidStringValue() {
        assertThrows(NumberFormatException.class, () -> {
            MutableDouble mutableDouble = new MutableDouble("abc");
            mutableDouble.getValue();
        });
    }
}