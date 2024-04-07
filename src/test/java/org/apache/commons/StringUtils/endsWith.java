import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class endsWithTest {
    StringUtils stringUtils;

    @BeforeAll
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    void testEndsWithNull() {
        assertFalse(StringUtils.endsWith(null, null));
        assertFalse(StringUtils.endsWith(null, "def"));
        assertFalse(StringUtils.endsWith("abcdef", null));
    }

    @Test
    void testEndsWithCaseSensitive() {
        assertTrue(StringUtils.endsWith("abcdef", "def"));
        assertFalse(StringUtils.endsWith("ABCDEF", "def"));
        assertFalse(StringUtils.endsWith("ABCDEF", "cde"));
        assertTrue(StringUtils.endsWith("ABCDEF", ""));
    }
}