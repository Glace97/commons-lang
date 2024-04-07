
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ReplaceCharsTest {

    @Nested
    @DisplayName("replaceChars(String, char, char) method")
    class ReplaceCharsSingleCharTests {

        @Test
        @DisplayName("Replace single character in a string")
        void testReplaceSingleChar() {
            String result = StringUtils.replaceChars("abcba", 'b', 'y');
            Assertions.assertEquals("aycya", result);
        }

        @Test
        @DisplayName("Replace single character in an empty string")
        void testReplaceSingleCharInEmptyString() {
            String result = StringUtils.replaceChars("", 'b', 'y');
            Assertions.assertEquals("", result);
        }

        @Test
        @DisplayName("Replace single character in a null string")
        void testReplaceSingleCharInNullString() {
            String result = StringUtils.replaceChars(null, 'b', 'y');
            Assertions.assertNull(result);
        }

    }

    @Nested
    @DisplayName("replaceChars(String, String, String) method")
    class ReplaceCharsMultipleCharsTests {

        @Test
        @DisplayName("Replace multiple characters in a string")
        void testReplaceMultipleChars() {
            String result = StringUtils.replaceChars("abcba", "bc", "yz");
            Assertions.assertEquals("ayzya", result);
        }

        @Test
        @DisplayName("Replace multiple characters with longer replaceChars")
        void testReplaceMultipleCharsWithLongerReplaceChars() {
            String result = StringUtils.replaceChars("abcba", "bc", "yzx");
            Assertions.assertEquals("ayzya", result);
        }

        @Test
        @DisplayName("Replace multiple characters with shorter replaceChars")
        void testReplaceMultipleCharsWithShorterReplaceChars() {
            String result = StringUtils.replaceChars("abcba", "bc", "y");
            Assertions.assertEquals("ayya", result);
        }

        @Test
        @DisplayName("Replace multiple characters in an empty string")
        void testReplaceMultipleCharsInEmptyString() {
            String result = StringUtils.replaceChars("", "bc", "yz");
            Assertions.assertEquals("", result);
        }

        @Test
        @DisplayName("Replace multiple characters in a null string")
        void testReplaceMultipleCharsInNullString() {
            String result = StringUtils.replaceChars(null, "bc", "yz");
            Assertions.assertNull(result);
        }

        @Test
        @DisplayName("Replace multiple characters with null replaceChars")
        void testReplaceMultipleCharsWithNullReplaceChars() {
            String result = StringUtils.replaceChars("abcba", "bc", null);
            Assertions.assertEquals("aba", result);
        }

        @Test
        @DisplayName("Replace multiple characters with empty replaceChars")
        void testReplaceMultipleCharsWithEmptyReplaceChars() {
            String result = StringUtils.replaceChars("abcba", "bc", "");
            Assertions.assertEquals("aba", result);
        }

    }
}
