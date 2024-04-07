import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

@DisplayName("capitalize Test Suite")
class capitalizeTest {

    @Nested
    @DisplayName("Tests for capitalize method")
    class CapitalizeTests {

        @Test
        @DisplayName("Test empty string")
        void testEmptyString() {
            String input = "";
            String expected = "";
            String actual = WordUtils.capitalize(input);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Test null string")
        void testNullString() {
            String input = null;
            String expected = null;
            String actual = WordUtils.capitalize(input);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Test whitespace separated words")
        void testWhitespaceSeparatedWords() {
            String input = "i am FINE";
            String expected = "I Am FINE";
            String actual = WordUtils.capitalize(input);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Test delimiter separated words with null delimiters")
        void testDelimiterSeparatedWordsWithNullDelimiters() {
            String input = "i am fine";
            String expected = "I Am Fine";
            String actual = WordUtils.capitalize(input, null);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Test delimiter separated words with empty delimiters")
        void testDelimiterSeparatedWordsWithEmptyDelimiters() {
            String input = "i am fine";
            String expected = "I Am Fine";
            String actual = WordUtils.capitalize(input, new char[0]);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Test delimiter separated words with specified delimiters")
        void testDelimiterSeparatedWordsWithSpecifiedDelimiters() {
            String input = "i aM.fine";
            String expected = "I aM.Fine";
            String actual = WordUtils.capitalize(input, '.');
            assertEquals(expected, actual);
        }
    }
}