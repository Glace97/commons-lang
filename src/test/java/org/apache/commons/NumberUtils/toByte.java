
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toByteTest {

    @Test
    void testToByteWithValidString() {
        assertEquals(1, NumberUtils.toByte("1"));
    }

    @Test
    void testToByteWithEmptyString() {
        assertEquals(0, NumberUtils.toByte(""));
    }

    @Test
    void testToByteWithNullString() {
        assertEquals(0, NumberUtils.toByte(null));
    }

    @Test
    void testToByteWithInvalidString() {
        assertEquals(0, NumberUtils.toByte("abc"));
    }

    @Test
    void testToByteWithValidStringAndDefaultValue() {
        assertEquals(1, NumberUtils.toByte("1", (byte) 0));
    }

    @Test
    void testToByteWithEmptyStringAndDefaultValue() {
        assertEquals(0, NumberUtils.toByte("", (byte) 1));
    }

    @Test
    void testToByteWithNullStringAndDefaultValue() {
        assertEquals(1, NumberUtils.toByte(null, (byte) 1));
    }

    @Test
    void testToByteWithInvalidStringAndDefaultValue() {
        assertEquals(0, NumberUtils.toByte("abc", (byte) 1));
    }

}
