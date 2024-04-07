
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MatchesTest {

    @Nested
    @DisplayName("Positive Test Cases")
    class PositiveTests {

        @Test
        @DisplayName("Test matching strings with no differences")
        void testMatchesNoDifferences() {
            CharSequence first = "abcdefg";
            CharSequence second = "abcdefg";
            int[] expected = {7, 0, 7, 7};

            int[] result = StringUtils.matches(first, second);

            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test matching strings with transpositions")
        void testMatchesWithTranspositions() {
            CharSequence first = "abc";
            CharSequence second = "bca";
            int[] expected = {3, 1, 0, 3};

            int[] result = StringUtils.matches(first, second);

            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test matching strings with a common prefix")
        void testMatchesWithCommonPrefix() {
            CharSequence first = "abcxyz";
            CharSequence second = "abc123";
            int[] expected = {3, 0, 3, 6};

            int[] result = StringUtils.matches(first, second);

            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test matching empty strings")
        void testMatchesEmptyStrings() {
            CharSequence first = "";
            CharSequence second = "";
            int[] expected = {0, 0, 0, 0};

            int[] result = StringUtils.matches(first, second);

            assertArrayEquals(expected, result);
        }

        @Test
        @DisplayName("Test matching strings with different lengths")
        void testMatchesDifferentLengths() {
            CharSequence first = "abc";
            CharSequence second = "abcdefg";
            int[] expected = {3, 0, 3, 7};

            int[] result = StringUtils.matches(first, second);

            assertArrayEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("Negative Test Cases")
    class NegativeTests {

        @Test
        @DisplayName("Test matching null strings")
        void testMatchesNullStrings() {
            CharSequence first = null;
            CharSequence second = null;

            Assertions.assertThrows(NullPointerException.class, () -> StringUtils.matches(first, second));
        }

        @Test
        @DisplayName("Test matching null and non-null strings")
        void testMatchesNullAndNonNullStrings() {
            CharSequence first = null;
            CharSequence second = "abc";

            Assertions.assertThrows(NullPointerException.class, () -> StringUtils.matches(first, second));
        }
    }
}
