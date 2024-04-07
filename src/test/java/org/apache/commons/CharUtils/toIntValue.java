
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class toIntValueTest {

    @Test
    void testToIntValue_ValidChar() {
        assertEquals(3, CharUtils.toIntValue('3'));
    }

    @Test
    void testToIntValue_InvalidChar() {
        assertThrows(IllegalArgumentException.class, () -> CharUtils.toIntValue('A'));
    }

    @Test
    void testToIntValue_ValidCharWithDefaultValue() {
        assertEquals(3, CharUtils.toIntValue('3', -1));
    }

    @Test
    void testToIntValue_InvalidCharWithDefaultValue() {
        assertEquals(-1, CharUtils.toIntValue('A', -1));
    }

    @Test
    void testToIntValue_NullCharacter() {
        assertThrows(NullPointerException.class, () -> CharUtils.toIntValue(null));
    }

    @Test
    void testToIntValue_NullCharacterWithDefaultValue() {
        assertEquals(-1, CharUtils.toIntValue(null, -1));
    }
}
