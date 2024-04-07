
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class IndexOfIgnoreCaseTest {

    @Nested
    @DisplayName("indexOfIgnoreCase tests")
    class IndexOfIgnoreCaseTests {

        @Test
        @DisplayName("Should return -1 when input strings are null")
        void testIndexOfIgnoreCaseWithNullInputs() {
            int result = StringUtils.indexOfIgnoreCase(null, null);
            Assertions.assertEquals(-1, result);
        }

        @Test
        @DisplayName("Should return -1 when search string is null")
        void testIndexOfIgnoreCaseWithNullSearchString() {
            int result = StringUtils.indexOfIgnoreCase("abc", null);
            Assertions.assertEquals(-1, result);
        }

        @Test
        @DisplayName("Should return -1 when input string is null")
        void testIndexOfIgnoreCaseWithNullInputString() {
            int result = StringUtils.indexOfIgnoreCase(null, "abc");
            Assertions.assertEquals(-1, result);
        }

        @Test
        @DisplayName("Should return 0 when both input and search strings are empty")
        void testIndexOfIgnoreCaseWithEmptyStrings() {
            int result = StringUtils.indexOfIgnoreCase("", "");
            Assertions.assertEquals(0, result);
        }

        @Test
        @DisplayName("Should return 0 when input string is empty and search string is not empty")
        void testIndexOfIgnoreCaseWithEmptyInputString() {
            int result = StringUtils.indexOfIgnoreCase("", "abc");
            Assertions.assertEquals(0, result);
        }

        @Test
        @DisplayName("Should return -1 when input string is not empty and search string is empty")
        void testIndexOfIgnoreCaseWithEmptySearchString() {
            int result = StringUtils.indexOfIgnoreCase("abc", "");
            Assertions.assertEquals(-1, result);
        }

        @Test
        @DisplayName("Should return 0 when search string is found at the beginning of the input string")
        void testIndexOfIgnoreCaseWithMatchAtBeginning() {
            int result = StringUtils.indexOfIgnoreCase("aabaabaa", "a");
            Assertions.assertEquals(0, result);
        }

        @Test
        @DisplayName("Should return 2 when search string is found in the middle of the input string")
        void testIndexOfIgnoreCaseWithMatchInMiddle() {
            int result = StringUtils.indexOfIgnoreCase("aabaabaa", "b");
            Assertions.assertEquals(2, result);
        }

        @Test
        @DisplayName("Should return 1 when search string is found partially in the input string")
        void testIndexOfIgnoreCaseWithPartialMatch() {
            int result = StringUtils.indexOfIgnoreCase("aabaabaa", "ab");
            Assertions.assertEquals(1, result);
        }

        @Test
        @DisplayName("Should return 5 when search string is found in the input string after a given start position")
        void testIndexOfIgnoreCaseWithStartPos() {
            int result = StringUtils.indexOfIgnoreCase("aabaabaa", "b", 3);
            Assertions.assertEquals(5, result);
        }

        @Test
        @DisplayName("Should return -1 when search string is not found in the input string")
        void testIndexOfIgnoreCaseWithNoMatch() {
            int result = StringUtils.indexOfIgnoreCase("aabaabaa", "c");
            Assertions.assertEquals(-1, result);
        }

        @Test
        @DisplayName("Should return -1 when start position is greater than the length of the input string")
        void testIndexOfIgnoreCaseWithInvalidStartPos() {
            int result = StringUtils.indexOfIgnoreCase("aabaabaa", "b", 9);
            Assertions.assertEquals(-1, result);
        }

        @Test
        @DisplayName("Should return -1 when start position is negative")
        void testIndexOfIgnoreCaseWithNegativeStartPos() {
            int result = StringUtils.indexOfIgnoreCase("aabaabaa", "b", -1);
            Assertions.assertEquals(-1, result);
        }
    }
}
