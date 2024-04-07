import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class unwrapTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    void testUnwrap_NullStringAndNullChar_ReturnsNull() {
        String result = stringUtils.unwrap(null, '\0');
        assertNull(result);
    }

    @Test
    void testUnwrap_NullStringAndNonNullChar_ReturnsNull() {
        String result = stringUtils.unwrap(null, '1');
        assertNull(result);
    }

    @Test
    void testUnwrap_NonNullStringAndNullChar_ReturnsString() {
        String result = stringUtils.unwrap("a", '\0');
        assertEquals("a", result);
    }

    @Test
    void testUnwrap_NonNullStringAndNonNullChar_ReturnsUnwrappedString() {
        String result = stringUtils.unwrap("aa", 'a');
        assertEquals("", result);
    }

    @Test
    void testUnwrap_QuotedStringAndWrapChar_ReturnsUnwrappedString() {
        String result = stringUtils.unwrap("\'abc\'", '\'');
        assertEquals("abc", result);
    }

    @Test
    void testUnwrap_NonQuotedStringAndWrapChar_ReturnsString() {
        String result = stringUtils.unwrap("AABabcBAA", 'A');
        assertEquals("ABabcBA", result);
    }

    @Test
    void testUnwrap_StringWithNoWrapChar_ReturnsString() {
        String result = stringUtils.unwrap("A", '#');
        assertEquals("A", result);
    }

    @Test
    void testUnwrap_StringWithWrapCharAtStart_ReturnsString() {
        String result = stringUtils.unwrap("#A", '#');
        assertEquals("#A", result);
    }

    @Test
    void testUnwrap_StringWithWrapCharAtEnd_ReturnsString() {
        String result = stringUtils.unwrap("A#", '#');
        assertEquals("A#", result);
    }

    @Test
    void testUnwrap_NullStringAndNullToken_ReturnsNull() {
        String result = stringUtils.unwrap(null, null);
        assertNull(result);
    }

    @Test
    void testUnwrap_NullStringAndEmptyToken_ReturnsNull() {
        String result = stringUtils.unwrap(null, "");
        assertNull(result);
    }

    @Test
    void testUnwrap_NullStringAndNonNullToken_ReturnsNull() {
        String result = stringUtils.unwrap(null, "1");
        assertNull(result);
    }

    @Test
    void testUnwrap_NonNullStringAndNullToken_ReturnsString() {
        String result = stringUtils.unwrap("a", null);
        assertEquals("a", result);
    }

    @Test
    void testUnwrap_NonNullStringAndEmptyToken_ReturnsString() {
        String result = stringUtils.unwrap("a", "");
        assertEquals("a", result);
    }

    @Test
    void testUnwrap_NonNullStringAndShortToken_ReturnsString() {
        String result = stringUtils.unwrap("a", "aa");
        assertEquals("a", result);
    }

    @Test
    void testUnwrap_NonNullStringAndToken_ReturnsUnwrappedString() {
        String result = stringUtils.unwrap("aa", "a");
        assertEquals("", result);
    }

    @Test
    void testUnwrap_QuotedStringAndWrapToken_ReturnsUnwrappedString() {
        String result = stringUtils.unwrap("\'abc\'", "\'");
        assertEquals("abc", result);
    }

    @Test
    void testUnwrap_QuotedStringAndDoubleWrapToken_ReturnsUnwrappedString() {
        String result = stringUtils.unwrap("\"abc\"", "\"");
        assertEquals("abc", result);
    }

    @Test
    void testUnwrap_NonQuotedStringAndWrapToken_ReturnsString() {
        String result = stringUtils.unwrap("AABabcBAA", "AA");
        assertEquals("BabcB", result);
    }

    @Test
    void testUnwrap_StringWithNoWrapToken_ReturnsString() {
        String result = stringUtils.unwrap("A", "#");
        assertEquals("A", result);
    }

    @Test
    void testUnwrap_StringWithWrapTokenAtStart_ReturnsString() {
        String result = stringUtils.unwrap("#A", "#");
        assertEquals("#A", result);
    }

    @Test
    void testUnwrap_StringWithWrapTokenAtEnd_ReturnsString() {
        String result = stringUtils.unwrap("A#", "#");
        assertEquals("A#", result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"\n", "\r", "\n\r", " \n ", " \r ", " \n\r "})
    void testUnwrap_StringWithWhitespaceToken_ReturnsUnwrappedString(String input) {
        String result = stringUtils.unwrap(input, " ");
        assertEquals(input.trim(), result);
    }
}