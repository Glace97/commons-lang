import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

class toStringTest {

    @Test
    @DisplayName("Test toString with non-negated range")
    void testToStringNonNegatedRange() {
        CharRange range = new CharRange('a', 'z', false);
        assertEquals("a-z", range.toString());
    }

    @Test
    @DisplayName("Test toString with negated range")
    void testToStringNegatedRange() {
        CharRange range = new CharRange('a', 'z', true);
        assertEquals("^a-z", range.toString());
    }

    @Test
    @DisplayName("Test toString with single character range")
    void testToStringSingleCharacterRange() {
        CharRange range = new CharRange('a', 'a', false);
        assertEquals("a", range.toString());
    }

    @Test
    @DisplayName("Test toString with empty range")
    void testToStringEmptyRange() {
        CharRange range = new CharRange('z', 'a', false);
        assertEquals("", range.toString());
    }

    @Test
    @DisplayName("Test toString with reversed range")
    void testToStringReversedRange() {
        CharRange range = new CharRange('z', 'a', true);
        assertEquals("^a-z", range.toString());
    }
}