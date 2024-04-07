
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ReplaceFirstTest {

    @Nested
    @DisplayName("When text is null")
    class WhenTextIsNull {

        @Test
        @DisplayName("Should return null")
        void shouldReturnNull() {
            String text = null;
            String regex = "abc";
            String replacement = "xyz";

            String result = StringUtils.replaceFirst(text, regex, replacement);

            Assertions.assertNull(result);
        }
    }

    @Nested
    @DisplayName("When regex is null")
    class WhenRegexIsNull {

        @Test
        @DisplayName("Should return the original text")
        void shouldReturnOriginalText() {
            String text = "abc";
            String regex = null;
            String replacement = "xyz";

            String result = StringUtils.replaceFirst(text, regex, replacement);

            Assertions.assertEquals(text, result);
        }
    }

    @Nested
    @DisplayName("When replacement is null")
    class WhenReplacementIsNull {

        @Test
        @DisplayName("Should return the original text")
        void shouldReturnOriginalText() {
            String text = "abc";
            String regex = "abc";
            String replacement = null;

            String result = StringUtils.replaceFirst(text, regex, replacement);

            Assertions.assertEquals(text, result);
        }
    }

    @Nested
    @DisplayName("When text is empty")
    class WhenTextIsEmpty {

        @Test
        @DisplayName("Should return the original text")
        void shouldReturnOriginalText() {
            String text = "";
            String regex = "abc";
            String replacement = "xyz";

            String result = StringUtils.replaceFirst(text, regex, replacement);

            Assertions.assertEquals(text, result);
        }
    }

    @Nested
    @DisplayName("When regex is empty")
    class WhenRegexIsEmpty {

        @Test
        @DisplayName("Should return the original text")
        void shouldReturnOriginalText() {
            String text = "abc";
            String regex = "";
            String replacement = "xyz";

            String result = StringUtils.replaceFirst(text, regex, replacement);

            Assertions.assertEquals(text, result);
        }
    }

    @Nested
    @DisplayName("When text contains multiple occurrences of regex")
    class WhenTextContainsMultipleOccurrencesOfRegex {

        @Test
        @DisplayName("Should replace only the first occurrence")
        void shouldReplaceOnlyFirstOccurrence() {
            String text = "abc abc abc";
            String regex = "abc";
            String replacement = "xyz";

            String result = StringUtils.replaceFirst(text, regex, replacement);

            Assertions.assertEquals("xyz abc abc", result);
        }
    }

    @Nested
    @DisplayName("When regex is not found in the text")
    class WhenRegexIsNotFound {

        @Test
        @DisplayName("Should return the original text")
        void shouldReturnOriginalText() {
            String text = "abc";
            String regex = "xyz";
            String replacement = "123";

            String result = StringUtils.replaceFirst(text, regex, replacement);

            Assertions.assertEquals(text, result);
        }
    }

    @Nested
    @DisplayName("When regex contains special characters")
    class WhenRegexContainsSpecialCharacters {

        @Test
        @DisplayName("Should escape the special characters in the regex")
        void shouldEscapeSpecialCharactersInRegex() {
            String text = "Hello (World)";
            String regex = "\\(World\\)";
            String replacement = "Universe";

            String result = StringUtils.replaceFirst(text, regex, replacement);

            Assertions.assertEquals("Hello Universe", result);
        }
    }
}
