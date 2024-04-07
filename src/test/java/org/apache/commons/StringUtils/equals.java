
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EqualsTest {

    StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Nested
    @DisplayName("When comparing two equal CharSequences")
    class WhenComparingEqualCharSequences {

        @Test
        @DisplayName("Should return true")
        void shouldReturnTrue() {
            assertTrue(StringUtils.equals("abc", "abc"));
        }
    }

    @Nested
    @DisplayName("When comparing two different CharSequences")
    class WhenComparingDifferentCharSequences {

        @Test
        @DisplayName("Should return false")
        void shouldReturnFalse() {
            assertFalse(StringUtils.equals("abc", "def"));
        }
    }

    @Nested
    @DisplayName("When comparing a CharSequence with null")
    class WhenComparingCharSequenceWithNull {

        @Test
        @DisplayName("Should return false")
        void shouldReturnFalse() {
            assertFalse(StringUtils.equals("abc", null));
        }
    }

    @Nested
    @DisplayName("When comparing null with a CharSequence")
    class WhenComparingNullWithCharSequence {

        @Test
        @DisplayName("Should return false")
        void shouldReturnFalse() {
            assertFalse(StringUtils.equals(null, "abc"));
        }
    }

    @Nested
    @DisplayName("When comparing two null CharSequences")
    class WhenComparingNullCharSequences {

        @Test
        @DisplayName("Should return true")
        void shouldReturnTrue() {
            assertTrue(StringUtils.equals(null, null));
        }
    }

    @Nested
    @DisplayName("When comparing a CharSequence with a String object")
    class WhenComparingCharSequenceWithString {

        @Test
        @DisplayName("Should return true")
        void shouldReturnTrue() {
            assertTrue(StringUtils.equals("abc", new StringBuilder("abc")));
        }
    }

    @Nested
    @DisplayName("When comparing a CharSequence with a different CharSequence")
    class WhenComparingCharSequenceWithDifferentCharSequence {

        @Test
        @DisplayName("Should return false")
        void shouldReturnFalse() {
            assertFalse(StringUtils.equals("abc", new StringBuilder("def")));
        }
    }

    @Nested
    @DisplayName("When comparing two empty CharSequences")
    class WhenComparingEmptyCharSequences {

        @Test
        @DisplayName("Should return true")
        void shouldReturnTrue() {
            assertTrue(StringUtils.equals("", ""));
        }
    }

    @Nested
    @DisplayName("When comparing two CharSequences with different lengths")
    class WhenComparingCharSequencesWithDifferentLengths {

        @Test
        @DisplayName("Should return false")
        void shouldReturnFalse() {
            assertFalse(StringUtils.equals("abc", "abcd"));
        }
    }
}
