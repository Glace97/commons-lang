import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class toStringTest {

    @Test
    @DisplayName("Test toString() with default value")
    void testToStringWithDefaultValue() {
        MutableByte mutableByte = new MutableByte();
        Assertions.assertEquals("0", mutableByte.toString());
    }

    @Test
    @DisplayName("Test toString() with positive value")
    void testToStringWithPositiveValue() {
        MutableByte mutableByte = new MutableByte((byte) 10);
        Assertions.assertEquals("10", mutableByte.toString());
    }

    @Test
    @DisplayName("Test toString() with negative value")
    void testToStringWithNegativeValue() {
        MutableByte mutableByte = new MutableByte((byte) -5);
        Assertions.assertEquals("-5", mutableByte.toString());
    }

    @Test
    @DisplayName("Test toString() with null value")
    void testToStringWithNullValue() {
        MutableByte mutableByte = new MutableByte((Number) null);
        Assertions.assertThrows(NullPointerException.class, mutableByte::toString);
    }

    @Test
    @DisplayName("Test toString() with valid string value")
    void testToStringWithValidStringValue() {
        MutableByte mutableByte = new MutableByte("15");
        Assertions.assertEquals("15", mutableByte.toString());
    }

    @Test
    @DisplayName("Test toString() with invalid string value")
    void testToStringWithInvalidStringValue() {
        Assertions.assertThrows(NumberFormatException.class, () -> new MutableByte("abc").toString());
    }
}