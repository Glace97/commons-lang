import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class containsTest {
    private StringUtils stringUtils = new StringUtils();

    @Test
    void testContainsWithNullString() {
        assertFalse(stringUtils.contains(null, "abc"));
    }

    @Test
    void testContainsWithNullSearchSeq() {
        assertFalse(stringUtils.contains("abc", null));
    }

    @Test
    void testContainsWithEmptyStringAndEmptySearchSeq() {
        assertTrue(stringUtils.contains("", ""));
    }

    @Test
    void testContainsWithEmptyString() {
        assertTrue(stringUtils.contains("abc", ""));
    }

    @Test
    void testContainsWithValidSearchSeq() {
        assertTrue(stringUtils.contains("abc", "a"));
    }

    @Test
    void testContainsWithInvalidSearchSeq() {
        assertFalse(stringUtils.contains("abc", "z"));
    }

    @Test
    void testContainsWithEmptyCharSequence() {
        assertFalse(stringUtils.contains("", 'a'));
    }

    @Test
    void testContainsWithValidSearchChar() {
        assertTrue(stringUtils.contains("abc", 'a'));
    }

    @Test
    void testContainsWithInvalidSearchChar() {
        assertFalse(stringUtils.contains("abc", 'z'));
    }
}