
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class appendIfMissingIgnoreCaseTest {

    @Test
    void testAppendIfMissingIgnoreCase() {
        // Null string and null suffix
        Assertions.assertNull(StringUtils.appendIfMissingIgnoreCase(null, null));

        // Null string and non-null suffix
        Assertions.assertEquals("xyz", StringUtils.appendIfMissingIgnoreCase(null, "xyz"));

        // Empty string and null suffix
        Assertions.assertEquals("", StringUtils.appendIfMissingIgnoreCase("", null));

        // Empty string and empty suffix
        Assertions.assertEquals("", StringUtils.appendIfMissingIgnoreCase("", ""));

        // Empty string and non-empty suffix
        Assertions.assertEquals("xyz", StringUtils.appendIfMissingIgnoreCase("", "xyz"));

        // Non-empty string and null suffix
        Assertions.assertEquals("abc", StringUtils.appendIfMissingIgnoreCase("abc", null));

        // Non-empty string and empty suffix
        Assertions.assertEquals("abc", StringUtils.appendIfMissingIgnoreCase("abc", ""));

        // Non-empty string and suffix already present (case-insensitive)
        Assertions.assertEquals("abc", StringUtils.appendIfMissingIgnoreCase("abc", "Bc"));

        // Non-empty string and suffix not present (case-insensitive)
        Assertions.assertEquals("abcxyz", StringUtils.appendIfMissingIgnoreCase("abc", "xyz"));

        // Non-empty string and multiple suffixes
        Assertions.assertEquals("abcxyz", StringUtils.appendIfMissingIgnoreCase("abc", "xyz", "mno"));

        // Non-empty string and multiple suffixes with null
        Assertions.assertEquals("abcxyz", StringUtils.appendIfMissingIgnoreCase("abc", "xyz", null));

        // Non-empty string and multiple suffixes with empty string
        Assertions.assertEquals("abc", StringUtils.appendIfMissingIgnoreCase("abc", "xyz", ""));

        // Non-empty string and multiple suffixes with suffix already present
        Assertions.assertEquals("abcxyz", StringUtils.appendIfMissingIgnoreCase("abcxyz", "xyz", "mno"));

        // Non-empty string and multiple suffixes with suffix already present (case-insensitive)
        Assertions.assertEquals("abcXYZ", StringUtils.appendIfMissingIgnoreCase("abcXYZ", "xyz", "mno"));
    }
}
