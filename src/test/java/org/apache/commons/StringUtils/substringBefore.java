
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SubstringBeforeTest {

    @Nested
    @DisplayName("Tests for substringBefore with char separator")
    class CharSeparatorTests {
        
        @Test
        @DisplayName("Test with null string input")
        void testSubstringBeforeWithNullString() {
            String result = StringUtils.substringBefore(null, 'a');
            Assertions.assertNull(result);
        }

        @Test
        @DisplayName("Test with empty string input")
        void testSubstringBeforeWithEmptyString() {
            String result = StringUtils.substringBefore("", 'a');
            Assertions.assertEquals("", result);
        }

        @Test
        @DisplayName("Test with no occurrence of separator")
        void testSubstringBeforeWithNoSeparator() {
            String result = StringUtils.substringBefore("abc", 'd');
            Assertions.assertEquals("abc", result);
        }

        @Test
        @DisplayName("Test with separator at the beginning")
        void testSubstringBeforeWithSeparatorAtBeginning() {
            String result = StringUtils.substringBefore("abcba", 'a');
            Assertions.assertEquals("", result);
        }

        @Test
        @DisplayName("Test with separator in the middle")
        void testSubstringBeforeWithSeparatorInMiddle() {
            String result = StringUtils.substringBefore("abcba", 'b');
            Assertions.assertEquals("a", result);
        }

        @Test
        @DisplayName("Test with separator at the end")
        void testSubstringBeforeWithSeparatorAtEnd() {
            String result = StringUtils.substringBefore("abc", 'c');
            Assertions.assertEquals("ab", result);
        }

    }

    @Nested
    @DisplayName("Tests for substringBefore with String separator")
    class StringSeparatorTests {

        @Test
        @DisplayName("Test with null string input")
        void testSubstringBeforeWithNullString() {
            String result = StringUtils.substringBefore(null, "a");
            Assertions.assertNull(result);
        }

        @Test
        @DisplayName("Test with empty string input")
        void testSubstringBeforeWithEmptyString() {
            String result = StringUtils.substringBefore("", "a");
            Assertions.assertEquals("", result);
        }

        @Test
        @DisplayName("Test with null separator")
        void testSubstringBeforeWithNullSeparator() {
            String result = StringUtils.substringBefore("abc", null);
            Assertions.assertEquals("abc", result);
        }

        @Test
        @DisplayName("Test with empty separator")
        void testSubstringBeforeWithEmptySeparator() {
            String result = StringUtils.substringBefore("abc", "");
            Assertions.assertEquals("", result);
        }

        @Test
        @DisplayName("Test with no occurrence of separator")
        void testSubstringBeforeWithNoSeparator() {
            String result = StringUtils.substringBefore("abc", "d");
            Assertions.assertEquals("abc", result);
        }

        @Test
        @DisplayName("Test with separator at the beginning")
        void testSubstringBeforeWithSeparatorAtBeginning() {
            String result = StringUtils.substringBefore("abcba", "a");
            Assertions.assertEquals("", result);
        }

        @Test
        @DisplayName("Test with separator in the middle")
        void testSubstringBeforeWithSeparatorInMiddle() {
            String result = StringUtils.substringBefore("abcba", "b");
            Assertions.assertEquals("a", result);
        }

        @Test
        @DisplayName("Test with separator at the end")
        void testSubstringBeforeWithSeparatorAtEnd() {
            String result = StringUtils.substringBefore("abc", "c");
            Assertions.assertEquals("ab", result);
        }

    }

}
