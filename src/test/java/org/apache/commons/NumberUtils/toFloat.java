import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class toFloatTest {

    @Test
    void testToFloat_NullString_ReturnsDefaultValue() {
        float result = NumberUtils.toFloat(null, 1.0f);
        assertEquals(1.0f, result);
    }

    @Test
    void testToFloat_EmptyString_ReturnsDefaultValue() {
        float result = NumberUtils.toFloat("", 1.0f);
        assertEquals(1.0f, result);
    }

    @Test
    void testToFloat_ValidString_ReturnsFloatValue() {
        float result = NumberUtils.toFloat("1.5");
        assertEquals(1.5f, result);
    }

    @Test
    void testToFloat_InvalidString_ReturnsDefaultValue() {
        float result = NumberUtils.toFloat("abc", 2.0f);
        assertEquals(2.0f, result);
    }
}