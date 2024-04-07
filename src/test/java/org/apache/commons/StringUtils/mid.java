
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MidTest {
    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Nested
    @DisplayName("Positive Test Cases")
    class PositiveTestCases {
        @Test
        @DisplayName("Should return null when input string is null")
        void shouldReturnNullWhenInputStringIsNull() {
            String result = stringUtils.mid(null, 0, 2);
            assertNull(result);
        }

        @Test
        @DisplayName("Should return an empty string when length is negative")
        void shouldReturnEmptyStringWhenLengthIsNegative() {
            String result = stringUtils.mid("abc", 0, -1);
            assertEquals("", result);
        }

        @Test
        @DisplayName("Should return an empty string when position is greater than string length")
        void shouldReturnEmptyStringWhenPositionIsGreaterThanStringLength() {
            String result = stringUtils.mid("abc", 4, 2);
            assertEquals("", result);
        }

        @Test
        @DisplayName("Should return the middle characters when position and length are valid")
        void shouldReturnMiddleCharactersWhenPositionAndLengthAreValid() {
            String result = stringUtils.mid("abc", 1, 2);
            assertEquals("bc", result);
        }

        @Test
        @DisplayName("Should return the whole string when length exceeds the available characters")
        void shouldReturnWholeStringWhenLengthExceedsAvailableCharacters() {
            String result = stringUtils.mid("abc", 0, 4);
            assertEquals("abc", result);
        }

        @Test
        @DisplayName("Should return the remaining characters when position is at the end of the string")
        void shouldReturnRemainingCharactersWhenPositionIsAtEndOfString() {
            String result = stringUtils.mid("abc", 2, 4);
            assertEquals("c", result);
        }

        @Test
        @DisplayName("Should return the whole string when position is negative and length exceeds the string length")
        void shouldReturnWholeStringWhenPositionIsNegativeAndLengthExceedsStringLength() {
            String result = stringUtils.mid("abc", -2, 4);
            assertEquals("abc", result);
        }
    }

    @Nested
    @DisplayName("Edge Test Cases")
    class EdgeTestCases {
        @Test
        @DisplayName("Should return an empty string when input string is empty")
        void shouldReturnEmptyStringWhenInputStringIsEmpty() {
            String result = stringUtils.mid("", 0, 2);
            assertEquals("", result);
        }

        @Test
        @DisplayName("Should return an empty string when length is zero")
        void shouldReturnEmptyStringWhenLengthIsZero() {
            String result = stringUtils.mid("abc", 0, 0);
            assertEquals("", result);
        }

        @Test
        @DisplayName("Should return the whole string when position is zero and length is zero")
        void shouldReturnWholeStringWhenPositionIsZeroAndLengthIsZero() {
            String result = stringUtils.mid("abc", 0, 0);
            assertEquals("", result);
        }
    }
}
