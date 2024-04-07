
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class firstNonBlankTest {

    @Test
    void testFirstNonBlank() {
        // Test when all values are null or empty
        Assertions.assertNull(StringUtils.firstNonBlank());
        Assertions.assertNull(StringUtils.firstNonBlank(null));
        Assertions.assertNull(StringUtils.firstNonBlank(null, ""));
        Assertions.assertNull(StringUtils.firstNonBlank("", "", ""));

        // Test when there is only one non-blank value
        Assertions.assertEquals("abc", StringUtils.firstNonBlank(null, "abc"));
        Assertions.assertEquals("xyz", StringUtils.firstNonBlank("xyz", null));
        Assertions.assertEquals("xyz", StringUtils.firstNonBlank(null, "", " ", "xyz"));

        // Test when there are multiple non-blank values
        Assertions.assertEquals("abc", StringUtils.firstNonBlank(null, "abc", "def"));
        Assertions.assertEquals("xyz", StringUtils.firstNonBlank(null, "xyz", "abc"));
    }

    @Test
    void testFirstNonBlankWithWhitespace() {
        // Test when values contain whitespace characters only
        Assertions.assertNull(StringUtils.firstNonBlank(" ", " ", " "));
        Assertions.assertNull(StringUtils.firstNonBlank(" ", "", " "));
        Assertions.assertNull(StringUtils.firstNonBlank(" ", " ", "", " "));

        // Test when values contain a mixture of blank and non-blank values
        Assertions.assertEquals("abc", StringUtils.firstNonBlank(" ", "abc"));
        Assertions.assertEquals("xyz", StringUtils.firstNonBlank("xyz", " "));
        Assertions.assertEquals("xyz", StringUtils.firstNonBlank(" ", "", " ", "xyz"));
        Assertions.assertEquals("xyz", StringUtils.firstNonBlank(" ", "xyz", "abc"));
    }

}
