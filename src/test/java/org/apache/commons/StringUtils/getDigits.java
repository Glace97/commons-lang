import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;

class getDigitsTest {
    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Nested
    @DisplayName("Testing getDigits method")
    class GetDigitsMethodTests {

        @Test
        @DisplayName("Test with null string")
        void testGetDigitsWithNullString() {
            String result = stringUtils.getDigits(null);
            Assertions.assertNull(result, "Expected null but got " + result);
        }

        @Test
        @DisplayName("Test with empty string")
        void testGetDigitsWithEmptyString() {
            String result = stringUtils.getDigits("");
            Assertions.assertEquals("", result, "Expected empty string but got " + result);
        }

        @Test
        @DisplayName("Test with string containing no digits")
        void testGetDigitsWithNoDigits() {
            String result = stringUtils.getDigits("abc");
            Assertions.assertEquals("", result, "Expected empty string but got " + result);
        }

        @Test
        @DisplayName("Test with string containing digits and special characters")
        void testGetDigitsWithDigitsAndSpecialCharacters() {
            String result = stringUtils.getDigits("1000$");
            Assertions.assertEquals("1000", result, "Expected '1000' but got " + result);
        }

        @Test
        @DisplayName("Test with string containing digits and alphabets")
        void testGetDigitsWithDigitsAndAlphabets() {
            String result = stringUtils.getDigits("1123~45");
            Assertions.assertEquals("112345", result, "Expected '112345' but got " + result);
        }

        @Test
        @DisplayName("Test with string containing digits and parentheses")
        void testGetDigitsWithDigitsAndParentheses() {
            String result = stringUtils.getDigits("(541) 754-3010");
            Assertions.assertEquals("5417543010", result, "Expected '5417543010' but got " + result);
        }

        @Test
        @DisplayName("Test with string containing unicode digits")
        void testGetDigitsWithUnicodeDigits() {
            String result = stringUtils.getDigits("\u0967\u0968\u0969");
            Assertions.assertEquals("\u0967\u0968\u0969", result, "Expected '\u0967\u0968\u0969' but got " + result);
        }
    }
}