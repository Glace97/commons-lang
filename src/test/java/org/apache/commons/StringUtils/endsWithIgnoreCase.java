import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

class endsWithIgnoreCaseTest {

    private static StringUtils utils;

    @BeforeAll
    static void setUp() {
        utils = new StringUtils();
    }

    @Test
    void testEndsWithIgnoreCase_NullString_NullSuffix() {
        assertTrue(StringUtils.endsWithIgnoreCase(null, null));
    }

    @Test
    void testEndsWithIgnoreCase_NullString_NotNullSuffix() {
        assertFalse(StringUtils.endsWithIgnoreCase(null, "def"));
    }

    @Test
    void testEndsWithIgnoreCase_NotNullString_NullSuffix() {
        assertFalse(StringUtils.endsWithIgnoreCase("abcdef", null));
    }

    @Test
    void testEndsWithIgnoreCase_SameString_SameSuffix() {
        assertTrue(StringUtils.endsWithIgnoreCase("abcdef", "abcdef"));
    }

    @Test
    void testEndsWithIgnoreCase_SameString_DifferentCaseSuffix() {
        assertTrue(StringUtils.endsWithIgnoreCase("ABCDEF", "def"));
    }

    @Test
    void testEndsWithIgnoreCase_SameString_DifferentSuffix() {
        assertFalse(StringUtils.endsWithIgnoreCase("ABCDEF", "cde"));
    }

    @Test
    void testEndsWithIgnoreCase_EmptyString_EmptySuffix() {
        assertTrue(StringUtils.endsWithIgnoreCase("", ""));
    }

    @Test
    void testEndsWithIgnoreCase_EmptyString_NotEmptySuffix() {
        assertFalse(StringUtils.endsWithIgnoreCase("", "def"));
    }

    @Test
    void testEndsWithIgnoreCase_NotEmptyString_EmptySuffix() {
        assertTrue(StringUtils.endsWithIgnoreCase("abcdef", ""));
    }

    @Test
    void testEndsWithIgnoreCase_StringWithSpaces_SuffixWithSpaces() {
        assertTrue(StringUtils.endsWithIgnoreCase("hello world", "ld"));
    }

    @Test
    void testEndsWithIgnoreCase_StringWithSpaces_SuffixWithoutSpaces() {
        assertTrue(StringUtils.endsWithIgnoreCase("hello world", "WORLD"));
    }

    @Test
    void testEndsWithIgnoreCase_StringWithSpecialCharacters_SuffixWithSpecialCharacters() {
        assertTrue(StringUtils.endsWithIgnoreCase("hello@world", "@WORLD"));
    }

    @Test
    void testEndsWithIgnoreCase_StringWithSpecialCharacters_SuffixWithoutSpecialCharacters() {
        assertTrue(StringUtils.endsWithIgnoreCase("hello@world", "@world"));
    }

    @Test
    void testEndsWithIgnoreCase_StringWithAccentedCharacters_SuffixWithAccentedCharacters() {
        assertTrue(StringUtils.endsWithIgnoreCase("café", "fé"));
    }

    @Test
    void testEndsWithIgnoreCase_StringWithAccentedCharacters_SuffixWithoutAccentedCharacters() {
        assertTrue(StringUtils.endsWithIgnoreCase("café", "fe"));
    }

    @Test
    void testEndsWithIgnoreCase_StringWithUnicodeCharacters_SuffixWithUnicodeCharacters() {
        assertTrue(StringUtils.endsWithIgnoreCase("こんにちは", "ちは"));
    }

    @Test
    void testEndsWithIgnoreCase_StringWithUnicodeCharacters_SuffixWithoutUnicodeCharacters() {
        assertTrue(StringUtils.endsWithIgnoreCase("こんにちは", "ち"));
    }
}