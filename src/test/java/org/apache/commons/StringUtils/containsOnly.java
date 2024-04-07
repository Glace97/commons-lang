import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ContainsOnlyTest {
    
    @Nested
    @DisplayName("Tests for containsOnly(CharSequence, char...)")
    class ContainsOnlyCharTest {
        
        @Test
        @DisplayName("Should return true if the CharSequence contains only valid characters")
        void shouldReturnTrueIfContainsOnlyValidChars() {
            assertTrue(StringUtils.containsOnly("abab", 'a', 'b'));
        }
        
        @Test
        @DisplayName("Should return false if the CharSequence contains invalid characters")
        void shouldReturnFalseIfContainsInvalidChars() {
            assertFalse(StringUtils.containsOnly("ab1", 'a', 'b'));
        }
        
        @Test
        @DisplayName("Should return true if the CharSequence is empty")
        void shouldReturnTrueIfCharSequenceIsEmpty() {
            assertTrue(StringUtils.containsOnly("", 'a', 'b'));
        }
        
        @Test
        @DisplayName("Should return false if the CharSequence is null")
        void shouldReturnFalseIfCharSequenceIsNull() {
            assertFalse(StringUtils.containsOnly(null, 'a', 'b'));
        }
        
        @Test
        @DisplayName("Should return false if the valid characters array is null")
        void shouldReturnFalseIfValidCharsIsNull() {
            assertFalse(StringUtils.containsOnly("abab", null));
        }
        
        @Test
        @DisplayName("Should return false if the valid characters array is empty")
        void shouldReturnFalseIfValidCharsIsEmpty() {
            assertFalse(StringUtils.containsOnly("abab", new char[0]));
        }
        
    }
    
    @Nested
    @DisplayName("Tests for containsOnly(CharSequence, String)")
    class ContainsOnlyStringTest {
        
        @Test
        @DisplayName("Should return true if the CharSequence contains only valid characters")
        void shouldReturnTrueIfContainsOnlyValidChars() {
            assertTrue(StringUtils.containsOnly("abab", "ab"));
        }
        
        @Test
        @DisplayName("Should return false if the CharSequence contains invalid characters")
        void shouldReturnFalseIfContainsInvalidChars() {
            assertFalse(StringUtils.containsOnly("ab1", "ab"));
        }
        
        @Test
        @DisplayName("Should return true if the CharSequence is empty")
        void shouldReturnTrueIfCharSequenceIsEmpty() {
            assertTrue(StringUtils.containsOnly("", "ab"));
        }
        
        @Test
        @DisplayName("Should return false if the CharSequence is null")
        void shouldReturnFalseIfCharSequenceIsNull() {
            assertFalse(StringUtils.containsOnly(null, "ab"));
        }
        
        @Test
        @DisplayName("Should return false if the valid characters string is null")
        void shouldReturnFalseIfValidCharsIsNull() {
            assertFalse(StringUtils.containsOnly("abab", null));
        }
        
        @Test
        @DisplayName("Should return false if the valid characters string is empty")
        void shouldReturnFalseIfValidCharsIsEmpty() {
            assertFalse(StringUtils.containsOnly("abab", ""));
        }
        
    }
    
}