
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class isNaNTest {

    @Test
    void testNaN() {
        MutableDouble mutableDouble = new MutableDouble(Double.NaN);
        assertTrue(mutableDouble.isNaN());
    }

    @Test
    void testNotNaN() {
        MutableDouble mutableDouble = new MutableDouble(10.5);
        assertFalse(mutableDouble.isNaN());
    }

    @ParameterizedTest
    @ValueSource(strings = {"NaN", "nan", "NAN"})
    void testFromStringNaN(String value) {
        MutableDouble mutableDouble = new MutableDouble(value);
        assertTrue(mutableDouble.isNaN());
    }

    @ParameterizedTest
    @ValueSource(strings = {"123", "1.23", "-10.5"})
    void testFromStringNotNaN(String value) {
        MutableDouble mutableDouble = new MutableDouble(value);
        assertFalse(mutableDouble.isNaN());
    }

    @Test
    void testFromNullNumber() {
        assertThrows(NullPointerException.class, () -> new MutableDouble((Number) null));
    }

    @Test
    void testFromNullString() {
        assertThrows(NullPointerException.class, () -> new MutableDouble((String) null));
    }

    @Test
    void testInvalidString() {
        assertThrows(NumberFormatException.class, () -> new MutableDouble("abc"));
    }

}
