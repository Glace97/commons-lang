import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ReplaceOnceIgnoreCaseTest {

    @Nested
    @DisplayName("replaceOnceIgnoreCase method tests")
    class ReplaceOnceIgnoreCaseMethodTests {

        @Test
        @DisplayName("Replacing null text should return null")
        void replaceNullTextShouldReturnNull() {
            String result = StringUtils.replaceOnceIgnoreCase(null, "search", "replace");
            Assertions.assertNull(result);
        }

        @Test
        @DisplayName("Replacing empty text should return empty text")
        void replaceEmptyTextShouldReturnEmptyText() {
            String result = StringUtils.replaceOnceIgnoreCase("", "search", "replace");
            Assertions.assertEquals("", result);
        }

        @Test
        @DisplayName("Replacing null search string should return original text")
        void replaceNullSearchStringShouldReturnOriginalText() {
            String result = StringUtils.replaceOnceIgnoreCase("text", null, "replace");
            Assertions.assertEquals("text", result);
        }

        @Test
        @DisplayName("Replacing null replacement string should return original text")
        void replaceNullReplacementStringShouldReturnOriginalText() {
            String result = StringUtils.replaceOnceIgnoreCase("text", "search", null);
            Assertions.assertEquals("text", result);
        }

        @Test
        @DisplayName("Replacing empty search string should return original text")
        void replaceEmptySearchStringShouldReturnOriginalText() {
            String result = StringUtils.replaceOnceIgnoreCase("text", "", "replace");
            Assertions.assertEquals("text", result);
        }

        @Test
        @DisplayName("Replacing text with no occurrences of search string should return original text")
        void replaceTextWithNoOccurrencesShouldReturnOriginalText() {
            String result = StringUtils.replaceOnceIgnoreCase("text", "search", "replace");
            Assertions.assertEquals("text", result);
        }

        @Test
        @DisplayName("Replacing text with one occurrence of search string should return text with replacement")
        void replaceTextWithOneOccurrenceShouldReturnTextWithReplacement() {
            String result = StringUtils.replaceOnceIgnoreCase("text search text", "search", "replace");
            Assertions.assertEquals("text replace text", result);
        }

        @Test
        @DisplayName("Replacing text with multiple occurrences of search string should return text with first occurrence replaced")
        void replaceTextWithMultipleOccurrencesShouldReturnTextWithFirstOccurrenceReplaced() {
            String result = StringUtils.replaceOnceIgnoreCase("text search search", "search", "replace");
            Assertions.assertEquals("text replace search", result);
        }

        @Test
        @DisplayName("Replacing text with search string that is a substring of another word should not replace")
        void replaceTextWithSubstringSearchStringShouldNotReplace() {
            String result = StringUtils.replaceOnceIgnoreCase("text searching", "search", "replace");
            Assertions.assertEquals("text searching", result);
        }

        @Test
        @DisplayName("Replacing text with search string that appears multiple times as a substring should not replace")
        void replaceTextWithMultipleSubstringSearchStringShouldNotReplace() {
            String result = StringUtils.replaceOnceIgnoreCase("text searching searching", "search", "replace");
            Assertions.assertEquals("text searching searching", result);
        }

        @Test
        @DisplayName("Replacing text with search string that matches case insensitively should replace")
        void replaceTextWithCaseInsensitiveSearchStringShouldReplace() {
            String result = StringUtils.replaceOnceIgnoreCase("text SEARCH text", "search", "replace");
            Assertions.assertEquals("text replace text", result);
        }
    }
}