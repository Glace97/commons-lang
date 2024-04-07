import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ordinalIndexOfTest {
    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Nested
    @DisplayName("Tests for ordinalIndexOf method")
    class OrdinalIndexOfTests {
        @Test
        @DisplayName("Should return -1 if str is null")
        void testOrdinalIndexOfWithNullStr() {
            CharSequence str = null;
            CharSequence searchStr = "a";
            int ordinal = 1;

            int result = stringUtils.ordinalIndexOf(str, searchStr, ordinal);

            assertEquals(-1, result);
        }

        @Test
        @DisplayName("Should return -1 if searchStr is null")
        void testOrdinalIndexOfWithNullSearchStr() {
            CharSequence str = "aabaabaa";
            CharSequence searchStr = null;
            int ordinal = 1;

            int result = stringUtils.ordinalIndexOf(str, searchStr, ordinal);

            assertEquals(-1, result);
        }

        @Test
        @DisplayName("Should return 0 if both str and searchStr are empty")
        void testOrdinalIndexOfWithEmptyStrAndSearchStr() {
            CharSequence str = "";
            CharSequence searchStr = "";
            int ordinal = 1;

            int result = stringUtils.ordinalIndexOf(str, searchStr, ordinal);

            assertEquals(0, result);
        }

        @Test
        @DisplayName("Should return 0 if searchStr is empty")
        void testOrdinalIndexOfWithEmptySearchStr() {
            CharSequence str = "aabaabaa";
            CharSequence searchStr = "";
            int ordinal = 1;

            int result = stringUtils.ordinalIndexOf(str, searchStr, ordinal);

            assertEquals(0, result);
        }

        @Test
        @DisplayName("Should return 0 if ordinal is 0")
        void testOrdinalIndexOfWithZeroOrdinal() {
            CharSequence str = "aabaabaa";
            CharSequence searchStr = "a";
            int ordinal = 0;

            int result = stringUtils.ordinalIndexOf(str, searchStr, ordinal);

            assertEquals(0, result);
        }

        @Test
        @DisplayName("Should return -1 if ordinal is negative")
        void testOrdinalIndexOfWithNegativeOrdinal() {
            CharSequence str = "aabaabaa";
            CharSequence searchStr = "a";
            int ordinal = -1;

            int result = stringUtils.ordinalIndexOf(str, searchStr, ordinal);

            assertEquals(-1, result);
        }

        @Test
        @DisplayName("Should return -1 if searchStr does not exist in str")
        void testOrdinalIndexOfWithNoMatch() {
            CharSequence str = "aabaabaa";
            CharSequence searchStr = "c";
            int ordinal = 1;

            int result = stringUtils.ordinalIndexOf(str, searchStr, ordinal);

            assertEquals(-1, result);
        }

        @Test
        @DisplayName("Should return 0 if ordinal is 1 and searchStr is at the start of str")
        void testOrdinalIndexOfWithOrdinalOneAndSearchStrAtStart() {
            CharSequence str = "aabaabaa";
            CharSequence searchStr = "a";
            int ordinal = 1;

            int result = stringUtils.ordinalIndexOf(str, searchStr, ordinal);

            assertEquals(0, result);
        }

        @Test
        @DisplayName("Should return 1 if ordinal is 2 and searchStr is at the second position in str")
        void testOrdinalIndexOfWithOrdinalTwoAndSearchStrAtSecondPosition() {
            CharSequence str = "aabaabaa";
            CharSequence searchStr = "a";
            int ordinal = 2;

            int result = stringUtils.ordinalIndexOf(str, searchStr, ordinal);

            assertEquals(1, result);
        }

        @Test
        @DisplayName("Should return 2 if ordinal is 1 and searchStr is at the third position in str")
        void testOrdinalIndexOfWithOrdinalOneAndSearchStrAtThirdPosition() {
            CharSequence str = "aabaabaa";
            CharSequence searchStr = "b";
            int ordinal = 1;

            int result = stringUtils.ordinalIndexOf(str, searchStr, ordinal);

            assertEquals(2, result);
        }

        @Test
        @DisplayName("Should return 5 if ordinal is 2 and searchStr is at the sixth position in str")
        void testOrdinalIndexOfWithOrdinalTwoAndSearchStrAtSixthPosition() {
            CharSequence str = "aabaabaa";
            CharSequence searchStr = "b";
            int ordinal = 2;

            int result = stringUtils.ordinalIndexOf(str, searchStr, ordinal);

            assertEquals(5, result);
        }

        @Test
        @DisplayName("Should return 1 if ordinal is 1 and searchStr is at the second position in str")
        void testOrdinalIndexOfWithOrdinalOneAndSearchStrOverlap() {
            CharSequence str = "aabaabaa";
            CharSequence searchStr = "ab";
            int ordinal = 1;

            int result = stringUtils.ordinalIndexOf(str, searchStr, ordinal);

            assertEquals(1, result);
        }

        @Test
        @DisplayName("Should return 4 if ordinal is 2 and searchStr is at the fifth position in str")
        void testOrdinalIndexOfWithOrdinalTwoAndSearchStrOverlap() {
            CharSequence str = "aabaabaa";
            CharSequence searchStr = "ab";
            int ordinal = 2;

            int result = stringUtils.ordinalIndexOf(str, searchStr, ordinal);

            assertEquals(4, result);
        }

        @Test
        @DisplayName("Should return 0 if ordinal is 1 and searchStr is empty")
        void testOrdinalIndexOfWithOrdinalOneAndEmptySearchStr() {
            CharSequence str = "aabaabaa";
            CharSequence searchStr = "";
            int ordinal = 1;

            int result = stringUtils.ordinalIndexOf(str, searchStr, ordinal);

            assertEquals(0, result);
        }

        @Test
        @DisplayName("Should return 0 if ordinal is 2 and searchStr is empty")
        void testOrdinalIndexOfWithOrdinalTwoAndEmptySearchStr() {
            CharSequence str = "aabaabaa";
            CharSequence searchStr = "";
            int ordinal = 2;

            int result = stringUtils.ordinalIndexOf(str, searchStr, ordinal);

            assertEquals(0, result);
        }
    }
}