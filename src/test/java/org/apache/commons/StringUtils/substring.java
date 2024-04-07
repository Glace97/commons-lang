
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubstringTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Nested
    @DisplayName("Tests for substring(String str, int start)")
    class SubstringWithStartTest {
        
        @Test
        @DisplayName("Should return null when input String is null")
        void shouldReturnNullWhenStringIsNull() {
            String result = stringUtils.substring(null, 2);
            assertNull(result);
        }

        @Test
        @DisplayName("Should return empty String when input String is empty")
        void shouldReturnEmptyStringWhenStringIsEmpty() {
            String result = stringUtils.substring("", 2);
            assertEquals("", result);
        }

        @Test
        @DisplayName("Should return the whole String when start is 0")
        void shouldReturnWholeStringWhenStartIsZero() {
            String result = stringUtils.substring("abc", 0);
            assertEquals("abc", result);
        }

        @Test
        @DisplayName("Should return substring starting from start position when start is positive")
        void shouldReturnSubstringStartingFromStart() {
            String result = stringUtils.substring("abc", 1);
            assertEquals("bc", result);
        }

        @Test
        @DisplayName("Should return substring starting from the end of the String when start is negative")
        void shouldReturnSubstringStartingFromEndWhenStartIsNegative() {
            String result = stringUtils.substring("abc", -2);
            assertEquals("bc", result);
        }

        @Test
        @DisplayName("Should return empty String when start is greater than the length of the String")
        void shouldReturnEmptyStringWhenStartIsGreaterThanStringLength() {
            String result = stringUtils.substring("abc", 4);
            assertEquals("", result);
        }

        @Test
        @DisplayName("Should return the whole String when start is equal to the length of the String")
        void shouldReturnWholeStringWhenStartIsEqualToStringLength() {
            String result = stringUtils.substring("abc", 3);
            assertEquals("abc", result);
        }

        @Test
        @DisplayName("Should return the whole String when start is negative and absolute value is greater than the length of the String")
        void shouldReturnWholeStringWhenStartIsNegativeAndAbsoluteValueIsGreaterThanStringLength() {
            String result = stringUtils.substring("abc", -4);
            assertEquals("abc", result);
        }
    }

    @Nested
    @DisplayName("Tests for substring(String str, int start, int end)")
    class SubstringWithStartAndEndTest {
        
        @Test
        @DisplayName("Should return null when input String is null")
        void shouldReturnNullWhenStringIsNull() {
            String result = stringUtils.substring(null, 2, 4);
            assertNull(result);
        }

        @Test
        @DisplayName("Should return empty String when input String is empty")
        void shouldReturnEmptyStringWhenStringIsEmpty() {
            String result = stringUtils.substring("", 2, 4);
            assertEquals("", result);
        }

        @Test
        @DisplayName("Should return substring from start position to end position")
        void shouldReturnSubstringFromStartToEnd() {
            String result = stringUtils.substring("abc", 0, 2);
            assertEquals("ab", result);
        }

        @Test
        @DisplayName("Should return empty String when start position is greater than end position")
        void shouldReturnEmptyStringWhenStartIsGreaterThanEnd() {
            String result = stringUtils.substring("abc", 2, 0);
            assertEquals("", result);
        }

        @Test
        @DisplayName("Should return empty String when start and end positions are equal")
        void shouldReturnEmptyStringWhenStartAndEndAreEqual() {
            String result = stringUtils.substring("abc", 2, 2);
            assertEquals("", result);
        }

        @Test
        @DisplayName("Should return substring starting from start position and ending before end position")
        void shouldReturnSubstringFromStartToEndExclusive() {
            String result = stringUtils.substring("abc", 2, 4);
            assertEquals("c", result);
        }

        @Test
        @DisplayName("Should return empty String when start is greater than the length of the String")
        void shouldReturnEmptyStringWhenStartIsGreaterThanStringLength() {
            String result = stringUtils.substring("abc", 4, 6);
            assertEquals("", result);
        }

        @Test
        @DisplayName("Should return empty String when end is greater than the length of the String")
        void shouldReturnEmptyStringWhenEndIsGreaterThanStringLength() {
            String result = stringUtils.substring("abc", 2, 6);
            assertEquals("", result);
        }

        @Test
        @DisplayName("Should return substring from the end of the String when start is negative")
        void shouldReturnSubstringFromEndWhenStartIsNegative() {
            String result = stringUtils.substring("abc", -2, -1);
            assertEquals("b", result);
        }

        @Test
        @DisplayName("Should return substring from start position to end position when both start and end are negative")
        void shouldReturnSubstringFromStartToEndWhenBothStartAndEndAreNegative() {
            String result = stringUtils.substring("abc", -4, 2);
            assertEquals("ab", result);
        }

        @Test
        @DisplayName("Should return empty String when start is negative and absolute value is greater than the length of the String")
        void shouldReturnEmptyStringWhenStartIsNegativeAndAbsoluteValueIsGreaterThanStringLength() {
            String result = stringUtils.substring("abc", -6, -4);
            assertEquals("", result);
        }

        @Test
        @DisplayName("Should return empty String when end is negative and absolute value is greater than the length of the String")
        void shouldReturnEmptyStringWhenEndIsNegativeAndAbsoluteValueIsGreaterThanStringLength() {
            String result = stringUtils.substring("abc", 2, -4);
            assertEquals("", result);
        }
    }
}
