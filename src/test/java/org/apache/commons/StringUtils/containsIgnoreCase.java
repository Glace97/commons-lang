
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainsIgnoreCaseTest {
    
    private StringUtils stringUtils;
    
    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }
    
    @Nested
    @DisplayName("Positive Cases")
    class PositiveCases {
        
        @Test
        @DisplayName("When both strings are null, should return false")
        void testContainsIgnoreCase_BothNull() {
            assertFalse(StringUtils.containsIgnoreCase(null, null));
        }
        
        @Test
        @DisplayName("When search string is null, should return false")
        void testContainsIgnoreCase_SearchNull() {
            assertFalse(StringUtils.containsIgnoreCase("abc", null));
        }
        
        @Test
        @DisplayName("When input string is null, should return false")
        void testContainsIgnoreCase_InputNull() {
            assertFalse(StringUtils.containsIgnoreCase(null, "abc"));
        }
        
        @Test
        @DisplayName("When input string and search string are empty, should return true")
        void testContainsIgnoreCase_BothEmpty() {
            assertTrue(StringUtils.containsIgnoreCase("", ""));
        }
        
        @Test
        @DisplayName("When input string is empty and search string is not empty, should return true")
        void testContainsIgnoreCase_InputEmpty() {
            assertTrue(StringUtils.containsIgnoreCase("", "abc"));
        }
        
        @Test
        @DisplayName("When input string contains the search string (case-insensitive), should return true")
        void testContainsIgnoreCase_InputContainsSearch() {
            assertTrue(StringUtils.containsIgnoreCase("abc", "A"));
        }
        
        @Test
        @DisplayName("When input string does not contain the search string (case-insensitive), should return false")
        void testContainsIgnoreCase_InputDoesNotContainSearch() {
            assertFalse(StringUtils.containsIgnoreCase("abc", "z"));
        }
    }
    
    @Nested
    @DisplayName("Negative Cases")
    class NegativeCases {
        
        @Test
        @DisplayName("When input string and search string are different, should return false")
        void testContainsIgnoreCase_InputDifferentFromSearch() {
            assertFalse(StringUtils.containsIgnoreCase("abc", "xyz"));
        }
    }
}

