
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class RepeatTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Nested
    @DisplayName("Tests for repeat(char ch, int repeat)")
    class RepeatCharTests {

        @Test
        @DisplayName("Repeat zero times should return an empty string")
        void repeatChar_ZeroTimes() {
            assertEquals("", stringUtils.repeat('e', 0));
        }

        @Test
        @DisplayName("Repeat positive times should return the repeated character")
        void repeatChar_PositiveTimes() {
            assertEquals("eee", stringUtils.repeat('e', 3));
        }

        @Test
        @DisplayName("Repeat negative times should return an empty string")
        void repeatChar_NegativeTimes() {
            assertEquals("", stringUtils.repeat('e', -2));
        }

    }

    @Nested
    @DisplayName("Tests for repeat(String str, int repeat)")
    class RepeatStringTests {

        @Test
        @DisplayName("Repeat null String should return null")
        void repeatString_NullString() {
            assertNull(stringUtils.repeat(null, 2));
        }

        @Test
        @DisplayName("Repeat zero times should return an empty string")
        void repeatString_ZeroTimes() {
            assertEquals("", stringUtils.repeat("", 0));
        }

        @Test
        @DisplayName("Repeat positive times should return the repeated string")
        void repeatString_PositiveTimes() {
            assertEquals("aaa", stringUtils.repeat("a", 3));
        }

        @Test
        @DisplayName("Repeat negative times should return an empty string")
        void repeatString_NegativeTimes() {
            assertEquals("", stringUtils.repeat("a", -2));
        }

        @Test
        @DisplayName("Repeat single character string should be optimized")
        void repeatString_SingleCharacterString() {
            assertEquals("ee", stringUtils.repeat("e", 2));
        }

        @Test
        @DisplayName("Repeat two character string should be optimized")
        void repeatString_TwoCharacterString() {
            assertEquals("abab", stringUtils.repeat("ab", 2));
        }

        @Test
        @DisplayName("Repeat long string should be optimized")
        void repeatString_LongString() {
            assertEquals("abcabcabc", stringUtils.repeat("abc", 3));
        }

    }

    @Nested
    @DisplayName("Tests for repeat(String str, String separator, int repeat)")
    class RepeatStringWithSeparatorTests {

        @Test
        @DisplayName("Repeat null String with null separator should return null")
        void repeatStringWithSeparator_NullStringAndSeparator() {
            assertNull(stringUtils.repeat(null, null, 2));
        }

        @Test
        @DisplayName("Repeat null String with non-null separator should return null")
        void repeatStringWithSeparator_NullString() {
            assertNull(stringUtils.repeat(null, "x", 2));
        }

        @Test
        @DisplayName("Repeat empty string with null separator should return an empty string")
        void repeatStringWithSeparator_EmptyString_NullSeparator() {
            assertEquals("", stringUtils.repeat("", null, 0));
        }

        @Test
        @DisplayName("Repeat empty string with empty separator should return an empty string")
        void repeatStringWithSeparator_EmptyString_EmptySeparator() {
            assertEquals("", stringUtils.repeat("", "", 2));
        }

        @Test
        @DisplayName("Repeat empty string with non-empty separator should return the separator")
        void repeatStringWithSeparator_EmptyString_NonEmptySeparator() {
            assertEquals("xx", stringUtils.repeat("", "x", 3));
        }

        @Test
        @DisplayName("Repeat string with separator should return the repeated string with separator")
        void repeatStringWithSeparator_StringWithSeparator() {
            assertEquals("?, ?, ?", stringUtils.repeat("?", ", ", 3));
        }

    }

}
