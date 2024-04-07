
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class StringUtilsTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Nested
    @DisplayName("chop method tests")
    class ChopTests {

        @Test
        @DisplayName("chop should return null for null input")
        void testChopWithNullInput() {
            assertNull(stringUtils.chop(null));
        }

        @Test
        @DisplayName("chop should return empty string for empty input")
        void testChopWithEmptyInput() {
            assertEquals("", stringUtils.chop(""));
        }

        @Test
        @DisplayName("chop should remove the last character from a string")
        void testChopWithValidInput() {
            assertEquals("abc", stringUtils.chop("abcd"));
            assertEquals("abc", stringUtils.chop("abc\r\n"));
            assertEquals("abc", stringUtils.chop("abc\n"));
            assertEquals("abc", stringUtils.chop("abc \r"));
        }

        @Test
        @DisplayName("chop should remove both \\r and \\n characters if present at the end")
        void testChopWithCrLfInput() {
            assertEquals("abc", stringUtils.chop("abc\r\n"));
        }

        @Test
        @DisplayName("chop should return empty string if input has only one character")
        void testChopWithSingleCharacterInput() {
            assertEquals("", stringUtils.chop("a"));
        }

        @Test
        @DisplayName("chop should return empty string if input has only \\r character")
        void testChopWithCrInput() {
            assertEquals("", stringUtils.chop("\r"));
        }

        @Test
        @DisplayName("chop should return empty string if input has only \\n character")
        void testChopWithLfInput() {
            assertEquals("", stringUtils.chop("\n"));
        }

        @Test
        @DisplayName("chop should return empty string if input has only \\r\\n characters")
        void testChopWithCrLfInputOnly() {
            assertEquals("", stringUtils.chop("\r\n"));
        }
    }
}
