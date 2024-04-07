import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import java.util.Arrays;

class deleteWhitespaceTest {
    @Nested
    @DisplayName("Test deleteWhitespace method")

    class TestDeleteWhitespace {
        @Test
        @DisplayName("Test with null string")
        void testDeleteWhitespaceWithNull() {
            assertNull(StringUtils.deleteWhitespace(null));
        }

        @Test
        @DisplayName("Test with empty string")
        void testDeleteWhitespaceWithEmptyString() {
            assertEquals("", StringUtils.deleteWhitespace(""));
        }

        @Test
        @DisplayName("Test with string containing only whitespaces")
        void testDeleteWhitespaceWithWhitespaces() {
            assertEquals("", StringUtils.deleteWhitespace("   "));
        }

        @Test
        @DisplayName("Test with string containing no whitespaces")
        void testDeleteWhitespaceWithNoWhitespaces() {
            assertEquals("abc", StringUtils.deleteWhitespace("abc"));
        }

        @Test
        @DisplayName("Test with string containing whitespaces")
        void testDeleteWhitespaceWithWhitespacesInBetween() {
            assertEquals("abc", StringUtils.deleteWhitespace("   ab  c  "));
        }

        @Test
        @DisplayName("Test with string containing whitespaces at the beginning and end")
        void testDeleteWhitespaceWithWhitespacesAtBeginningAndEnd() {
            assertEquals("abc", StringUtils.deleteWhitespace("  abc  "));
        }
    }
}

The test suite covers the following cases:
1. Null input
2. Empty string input
3. String with only whitespaces
4. String with no whitespaces
5. String with whitespaces in between characters
6. String with whitespaces at the beginning and end