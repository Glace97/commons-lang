import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class isNotBlankTest {

    private StringUtils stringUtils;

    @BeforeAll
    public void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    void testIsNotBlank_Null_ReturnsFalse() {
        CharSequence input = null;
        boolean result = stringUtils.isNotBlank(input);
        Assertions.assertFalse(result);
    }

    @Test
    void testIsNotBlank_EmptyString_ReturnsFalse() {
        CharSequence input = "";
        boolean result = stringUtils.isNotBlank(input);
        Assertions.assertFalse(result);
    }

    @Test
    void testIsNotBlank_Whitespace_ReturnsFalse() {
        CharSequence input = " ";
        boolean result = stringUtils.isNotBlank(input);
        Assertions.assertFalse(result);
    }

    @Test
    void testIsNotBlank_NonEmptyString_ReturnsTrue() {
        CharSequence input = "bob";
        boolean result = stringUtils.isNotBlank(input);
        Assertions.assertTrue(result);
    }

    @Test
    void testIsNotBlank_LeadingAndTrailingWhitespace_ReturnsTrue() {
        CharSequence input = "  bob  ";
        boolean result = stringUtils.isNotBlank(input);
        Assertions.assertTrue(result);
    }
}