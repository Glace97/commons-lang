import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class toIntegerTest {
    private MutableInt mutableInt;

    @BeforeEach
    void setUp() {
        mutableInt = new MutableInt();
    }

    @Test
    @DisplayName("Test toInteger() with default value")
    void testToIntegerWithDefaultValue() {
        assertEquals(0, mutableInt.toInteger());
    }

    @Test
    @DisplayName("Test toInteger() with positive value")
    void testToIntegerWithPositiveValue() {
        mutableInt = new MutableInt(10);
        assertEquals(10, mutableInt.toInteger());
    }

    @Test
    @DisplayName("Test toInteger() with negative value")
    void testToIntegerWithNegativeValue() {
        mutableInt = new MutableInt(-10);
        assertEquals(-10, mutableInt.toInteger());
    }

    @Test
    @DisplayName("Test toInteger() with null value")
    void testToIntegerWithNullValue() {
        mutableInt = new MutableInt((Number) null);
        assertThrows(NullPointerException.class, () -> mutableInt.toInteger());
    }

    @Test
    @DisplayName("Test toInteger() with invalid string value")
    void testToIntegerWithInvalidStringValue() {
        mutableInt = new MutableInt("abc");
        assertThrows(NumberFormatException.class, () -> mutableInt.toInteger());
    }

    @Test
    @DisplayName("Test toInteger() with valid string value")
    void testToIntegerWithValidStringValue() {
        mutableInt = new MutableInt("20");
        assertEquals(20, mutableInt.toInteger());
    }
}