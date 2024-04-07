
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class normalizeSpaceTest {

    @Test
    void testNormalizeSpaceWithNullString() {
        String result = StringUtils.normalizeSpace(null);
        assertNull(result);
    }

    @Test
    void testNormalizeSpaceWithEmptyString() {
        String result = StringUtils.normalizeSpace("");
        assertEquals("", result);
    }

    @Test
    void testNormalizeSpaceWithOnlyWhitespace() {
        String result = StringUtils.normalizeSpace("   ");
        assertEquals("", result);
    }

    @Test
    void testNormalizeSpaceWithLeadingWhitespace() {
        String result = StringUtils.normalizeSpace("   hello");
        assertEquals("hello", result);
    }

    @Test
    void testNormalizeSpaceWithTrailingWhitespace() {
        String result = StringUtils.normalizeSpace("hello   ");
        assertEquals("hello", result);
    }

    @Test
    void testNormalizeSpaceWithMultipleWhitespaces() {
        String result = StringUtils.normalizeSpace("hello   world");
        assertEquals("hello world", result);
    }

    @Test
    void testNormalizeSpaceWithUnicodeWhitespace() {
        String result = StringUtils.normalizeSpace("hello\u200Bworld");
        assertEquals("hello world", result);
    }

    @Test
    void testNormalizeSpaceWithControlCharacters() {
        String result = StringUtils.normalizeSpace("hello\tworld");
        assertEquals("hello world", result);
    }

    @Test
    void testNormalizeSpaceWithLeadingAndTrailingWhitespace() {
        String result = StringUtils.normalizeSpace("   hello   ");
        assertEquals("hello", result);
    }
}
