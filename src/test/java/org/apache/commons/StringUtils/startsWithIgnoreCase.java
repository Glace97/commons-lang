import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class startsWithIgnoreCaseTest {

    private StringUtils utils;

    @BeforeEach
    void setUp() {
        utils = new StringUtils();
    }

    @Test
    void testStartsWithIgnoreCaseNullStrings() {
        assertTrue(utils.startsWithIgnoreCase(null, null));
        assertFalse(utils.startsWithIgnoreCase(null, "abc"));
        assertFalse(utils.startsWithIgnoreCase("abcdef", null));
    }

    @Test
    void testStartsWithIgnoreCaseCaseInsensitive() {
        assertTrue(utils.startsWithIgnoreCase("abcdef", "abc"));
        assertTrue(utils.startsWithIgnoreCase("ABCDEF", "abc"));
        assertFalse(utils.startsWithIgnoreCase("ABCDEF", "def"));
    }

    @Test
    void testStartsWithIgnoreCaseEmptyStrings() {
        assertTrue(utils.startsWithIgnoreCase("", ""));
        assertFalse(utils.startsWithIgnoreCase("", "abc"));
        assertFalse(utils.startsWithIgnoreCase("abcdef", ""));
    }

    @Test
    void testStartsWithIgnoreCaseWhitespaceStrings() {
        assertTrue(utils.startsWithIgnoreCase("   abcdef", "   abc"));
        assertTrue(utils.startsWithIgnoreCase("   ABCDEF", "   abc"));
        assertFalse(utils.startsWithIgnoreCase("   ABCDEF", "   def"));
    }
    
    @Test
    void testStartsWithIgnoreCaseUnicodeStrings() {
        assertTrue(utils.startsWithIgnoreCase("Ábcd", "á"));
        assertTrue(utils.startsWithIgnoreCase("àbcd", "Á"));
        assertFalse(utils.startsWithIgnoreCase("Äbcd", "á"));
    }
}