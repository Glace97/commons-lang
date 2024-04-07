import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class prependIfMissingIgnoreCaseTest {

    @Test
    void testPrependIfMissingIgnoreCase_NullString_ReturnsNull() {
        String result = StringUtils.prependIfMissingIgnoreCase(null, "prefix");
        assertEquals(null, result);
    }

    @Test
    void testPrependIfMissingIgnoreCase_NullPrefix_ReturnsSameString() {
        String result = StringUtils.prependIfMissingIgnoreCase("string", null);
        assertEquals("string", result);
    }

    @Test
    void testPrependIfMissingIgnoreCase_EmptyString_ReturnsPrefix() {
        String result = StringUtils.prependIfMissingIgnoreCase("", "prefix");
        assertEquals("prefix", result);
    }

    @Test
    void testPrependIfMissingIgnoreCase_StringWithNoMatchingPrefix_ReturnsStringWithPrefix() {
        String result = StringUtils.prependIfMissingIgnoreCase("string", "prefix");
        assertEquals("prefixstring", result);
    }

    @Test
    void testPrependIfMissingIgnoreCase_StringWithMatchingPrefix_ReturnsSameString() {
        String result = StringUtils.prependIfMissingIgnoreCase("prefixstring", "prefix");
        assertEquals("prefixstring", result);
    }

    @Test
    void testPrependIfMissingIgnoreCase_StringWithMatchingPrefixDifferentCase_ReturnsSameString() {
        String result = StringUtils.prependIfMissingIgnoreCase("PREFIXstring", "prefix");
        assertEquals("PREFIXstring", result);
    }

    @Test
    void testPrependIfMissingIgnoreCase_AdditionalPrefixes_StringWithNoMatchingPrefix_ReturnsStringWithPrefix() {
        String result = StringUtils.prependIfMissingIgnoreCase("string", "prefix", "other");
        assertEquals("prefixstring", result);
    }

    @Test
    void testPrependIfMissingIgnoreCase_AdditionalPrefixes_StringWithMatchingPrefix_ReturnsSameString() {
        String result = StringUtils.prependIfMissingIgnoreCase("prefixstring", "prefix", "other");
        assertEquals("prefixstring", result);
    }

    @Test
    void testPrependIfMissingIgnoreCase_AdditionalPrefixes_StringWithMatchingPrefixDifferentCase_ReturnsSameString() {
        String result = StringUtils.prependIfMissingIgnoreCase("PREFIXstring", "prefix", "other");
        assertEquals("PREFIXstring", result);
    }

    @Test
    void testPrependIfMissingIgnoreCase_AdditionalPrefixes_StringWithMatchingAdditionalPrefix_ReturnsSameString() {
        String result = StringUtils.prependIfMissingIgnoreCase("otherstring", "prefix", "other");
        assertEquals("otherstring", result);
    }

    @Test
    void testPrependIfMissingIgnoreCase_AdditionalPrefixes_StringWithMatchingAdditionalPrefixDifferentCase_ReturnsSameString() {
        String result = StringUtils.prependIfMissingIgnoreCase("OTHERstring", "prefix", "other");
        assertEquals("OTHERstring", result);
    }
}