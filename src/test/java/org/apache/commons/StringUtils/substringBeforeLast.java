
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class SubstringBeforeLastTest {
    
    @Nested
    @DisplayName("Tests for substringBeforeLast method")
    class SubstringBeforeLastMethodTests {
        
        @Test
        @DisplayName("Test with null input string")
        void testSubstringBeforeLastWithNullString() {
            String str = null;
            String separator = "b";
            
            String result = StringUtils.substringBeforeLast(str, separator);
            
            Assertions.assertNull(result);
        }
        
        @Test
        @DisplayName("Test with empty input string")
        void testSubstringBeforeLastWithEmptyString() {
            String str = "";
            String separator = "b";
            
            String result = StringUtils.substringBeforeLast(str, separator);
            
            Assertions.assertEquals("", result);
        }
        
        @Test
        @DisplayName("Test with empty separator")
        void testSubstringBeforeLastWithEmptySeparator() {
            String str = "abcba";
            String separator = "";
            
            String result = StringUtils.substringBeforeLast(str, separator);
            
            Assertions.assertEquals("abcba", result);
        }
        
        @Test
        @DisplayName("Test with no occurrence of separator")
        void testSubstringBeforeLastWithNoSeparator() {
            String str = "abc";
            String separator = "c";
            
            String result = StringUtils.substringBeforeLast(str, separator);
            
            Assertions.assertEquals("ab", result);
        }
        
        @Test
        @DisplayName("Test with separator at the end")
        void testSubstringBeforeLastWithSeparatorAtEnd() {
            String str = "abcba";
            String separator = "a";
            
            String result = StringUtils.substringBeforeLast(str, separator);
            
            Assertions.assertEquals("abcb", result);
        }
        
        @Test
        @DisplayName("Test with separator at the start")
        void testSubstringBeforeLastWithSeparatorAtStart() {
            String str = "abcba";
            String separator = "b";
            
            String result = StringUtils.substringBeforeLast(str, separator);
            
            Assertions.assertEquals("abc", result);
        }
        
        @Test
        @DisplayName("Test with separator in the middle")
        void testSubstringBeforeLastWithSeparatorInMiddle() {
            String str = "abcdef";
            String separator = "d";
            
            String result = StringUtils.substringBeforeLast(str, separator);
            
            Assertions.assertEquals("abc", result);
        }
        
        @Test
        @DisplayName("Test with multiple occurrences of separator")
        void testSubstringBeforeLastWithMultipleSeparators() {
            String str = "abcdeabcde";
            String separator = "c";
            
            String result = StringUtils.substringBeforeLast(str, separator);
            
            Assertions.assertEquals("abcdeab", result);
        }
        
        @Test
        @DisplayName("Test with separator as the only character")
        void testSubstringBeforeLastWithSeparatorOnly() {
            String str = "abc";
            String separator = "abc";
            
            String result = StringUtils.substringBeforeLast(str, separator);
            
            Assertions.assertEquals("", result);
        }
    }
}
