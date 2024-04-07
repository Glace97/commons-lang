
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class stripEndTest {

    @Nested
    @DisplayName("When stripChars is null")
    class WhenStripCharsIsNull {

        @Test
        @DisplayName("Should strip whitespace from the end of the string")
        void shouldStripWhitespaceFromEndOfString() {
            String str = "  abc  ";
            String expected = "  abc";

            String result = StringUtils.stripEnd(str, null);

            Assertions.assertEquals(expected, result);
        }

        @Test
        @DisplayName("Should return the same string if it doesn't end with whitespace")
        void shouldReturnSameStringIfNoWhitespaceAtEnd() {
            String str = "abc";
            String expected = "abc";

            String result = StringUtils.stripEnd(str, null);

            Assertions.assertEquals(expected, result);
        }

        @Test
        @DisplayName("Should return null if the input string is null")
        void shouldReturnNullForNullInputString() {
            String str = null;

            String result = StringUtils.stripEnd(str, null);

            Assertions.assertNull(result);
        }

    }

    @Nested
    @DisplayName("When stripChars is empty")
    class WhenStripCharsIsEmpty {

        @Test
        @DisplayName("Should return the same string")
        void shouldReturnSameString() {
            String str = "abc";
            String expected = "abc";

            String result = StringUtils.stripEnd(str, "");

            Assertions.assertEquals(expected, result);
        }

    }

    @Nested
    @DisplayName("When stripChars is not empty or null")
    class WhenStripCharsIsNotEmpty {

        @Test
        @DisplayName("Should strip characters from the end of the string")
        void shouldStripCharactersFromEndOfString() {
            String str = "  abcyx  ";
            String stripChars = "xyz";
            String expected = "  abc";

            String result = StringUtils.stripEnd(str, stripChars);

            Assertions.assertEquals(expected, result);
        }

        @Test
        @DisplayName("Should return the same string if it doesn't end with the characters to strip")
        void shouldReturnSameStringIfNoCharactersToStripAtEnd() {
            String str = "abc";
            String stripChars = "xyz";
            String expected = "abc";

            String result = StringUtils.stripEnd(str, stripChars);

            Assertions.assertEquals(expected, result);
        }

    }

    @Nested
    @DisplayName("When input string is empty")
    class WhenInputStringIsEmpty {

        @Test
        @DisplayName("Should return an empty string")
        void shouldReturnEmptyString() {
            String str = "";
            String expected = "";

            String result = StringUtils.stripEnd(str, null);

            Assertions.assertEquals(expected, result);
        }

    }

    @Nested
    @DisplayName("When input string is whitespace")
    class WhenInputStringIsWhitespace {

        @Test
        @DisplayName("Should return an empty string")
        void shouldReturnEmptyString() {
            String str = "   ";
            String expected = "";

            String result = StringUtils.stripEnd(str, null);

            Assertions.assertEquals(expected, result);
        }

    }

    @Nested
    @DisplayName("When stripChars contains special characters")
    class WhenStripCharsContainsSpecialCharacters {

        @Test
        @DisplayName("Should strip special characters from the end of the string")
        void shouldStripSpecialCharactersFromEndOfString() {
            String str = "abc!@#$";
            String stripChars = "!@#$";
            String expected = "abc";

            String result = StringUtils.stripEnd(str, stripChars);

            Assertions.assertEquals(expected, result);
        }

    }

}
