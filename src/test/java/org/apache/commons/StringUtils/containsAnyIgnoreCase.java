import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class containsAnyIgnoreCaseTest {
    
    private StringUtils stringUtils;
    
    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    @DisplayName("Test containsAnyIgnoreCase with null cs and null searchCharSequences")
    void testContainsAnyIgnoreCaseNullCsAndNullSearchCharSequences() {
        CharSequence cs = null;
        CharSequence[] searchCharSequences = null;
        assertFalse(stringUtils.containsAnyIgnoreCase(cs, searchCharSequences));
    }
    
    @Test
    @DisplayName("Test containsAnyIgnoreCase with null cs and empty searchCharSequences")
    void testContainsAnyIgnoreCaseNullCsAndEmptySearchCharSequences() {
        CharSequence cs = null;
        CharSequence[] searchCharSequences = new CharSequence[0];
        assertFalse(stringUtils.containsAnyIgnoreCase(cs, searchCharSequences));
    }
    
    @Test
    @DisplayName("Test containsAnyIgnoreCase with null cs and non-empty searchCharSequences")
    void testContainsAnyIgnoreCaseNullCsAndNonEmptySearchCharSequences() {
        CharSequence cs = null;
        CharSequence[] searchCharSequences = new CharSequence[] {"abc", "def"};
        assertFalse(stringUtils.containsAnyIgnoreCase(cs, searchCharSequences));
    }
    
    @Test
    @DisplayName("Test containsAnyIgnoreCase with empty cs and null searchCharSequences")
    void testContainsAnyIgnoreCaseEmptyCsAndNullSearchCharSequences() {
        CharSequence cs = "";
        CharSequence[] searchCharSequences = null;
        assertFalse(stringUtils.containsAnyIgnoreCase(cs, searchCharSequences));
    }
    
    @Test
    @DisplayName("Test containsAnyIgnoreCase with empty cs and empty searchCharSequences")
    void testContainsAnyIgnoreCaseEmptyCsAndEmptySearchCharSequences() {
        CharSequence cs = "";
        CharSequence[] searchCharSequences = new CharSequence[0];
        assertFalse(stringUtils.containsAnyIgnoreCase(cs, searchCharSequences));
    }
    
    @Test
    @DisplayName("Test containsAnyIgnoreCase with empty cs and non-empty searchCharSequences")
    void testContainsAnyIgnoreCaseEmptyCsAndNonEmptySearchCharSequences() {
        CharSequence cs = "";
        CharSequence[] searchCharSequences = new CharSequence[] {"abc", "def"};
        assertFalse(stringUtils.containsAnyIgnoreCase(cs, searchCharSequences));
    }
    
    @Test
    @DisplayName("Test containsAnyIgnoreCase with non-empty cs and null searchCharSequences")
    void testContainsAnyIgnoreCaseNonEmptyCsAndNullSearchCharSequences() {
        CharSequence cs = "abcd";
        CharSequence[] searchCharSequences = null;
        assertFalse(stringUtils.containsAnyIgnoreCase(cs, searchCharSequences));
    }
    
    @Test
    @DisplayName("Test containsAnyIgnoreCase with non-empty cs and empty searchCharSequences")
    void testContainsAnyIgnoreCaseNonEmptyCsAndEmptySearchCharSequences() {
        CharSequence cs = "abcd";
        CharSequence[] searchCharSequences = new CharSequence[0];
        assertFalse(stringUtils.containsAnyIgnoreCase(cs, searchCharSequences));
    }
    
    @Test
    @DisplayName("Test containsAnyIgnoreCase with non-empty cs and searchCharSequences containing null")
    void testContainsAnyIgnoreCaseNonEmptyCsAndSearchCharSequencesContainingNull() {
        CharSequence cs = "abcd";
        CharSequence[] searchCharSequences = new CharSequence[] {"abc", null, "def"};
        assertTrue(stringUtils.containsAnyIgnoreCase(cs, searchCharSequences));
    }
    
    @Test
    @DisplayName("Test containsAnyIgnoreCase with non-empty cs and searchCharSequences containing empty string")
    void testContainsAnyIgnoreCaseNonEmptyCsAndSearchCharSequencesContainingEmptyString() {
        CharSequence cs = "abcd";
        CharSequence[] searchCharSequences = new CharSequence[] {"abc", "", "def"};
        assertTrue(stringUtils.containsAnyIgnoreCase(cs, searchCharSequences));
    }
    
    @Test
    @DisplayName("Test containsAnyIgnoreCase with cs and searchCharSequences containing matching strings")
    void testContainsAnyIgnoreCaseCsAndSearchCharSequencesContainingMatchingStrings() {
        CharSequence cs = "abcd";
        CharSequence[] searchCharSequences = new CharSequence[] {"abc", "def"};
        assertTrue(stringUtils.containsAnyIgnoreCase(cs, searchCharSequences));
    }
    
    @Test
    @DisplayName("Test containsAnyIgnoreCase with cs and searchCharSequences containing non-matching strings")
    void testContainsAnyIgnoreCaseCsAndSearchCharSequencesContainingNonMatchingStrings() {
        CharSequence cs = "abcd";
        CharSequence[] searchCharSequences = new CharSequence[] {"xyz", "pqr"};
        assertFalse(stringUtils.containsAnyIgnoreCase(cs, searchCharSequences));
    }
    
    @Test
    @DisplayName("Test containsAnyIgnoreCase with cs and searchCharSequences containing matching and non-matching strings")
    void testContainsAnyIgnoreCaseCsAndSearchCharSequencesContainingMatchingAndNonMatchingStrings() {
        CharSequence cs = "abcd";
        CharSequence[] searchCharSequences = new CharSequence[] {"xyz", "abc"};
        assertTrue(stringUtils.containsAnyIgnoreCase(cs, searchCharSequences));
    }
    
    @Test
    @DisplayName("Test containsAnyIgnoreCase with cs and searchCharSequences containing empty string")
    void testContainsAnyIgnoreCaseCsAndSearchCharSequencesContainingEmptyString() {
        CharSequence cs = "abcd";
        CharSequence[] searchCharSequences = new CharSequence[] {""};
        assertTrue(stringUtils.containsAnyIgnoreCase(cs, searchCharSequences));
    }
    
    @Test
    @DisplayName("Test containsAnyIgnoreCase with cs and searchCharSequences containing whitespace characters")
    void testContainsAnyIgnoreCaseCsAndSearchCharSequencesContainingWhitespaceCharacters() {
        CharSequence cs = "abcd";
        CharSequence[] searchCharSequences = new CharSequence[] {" ", "\n", "\r"};
        assertFalse(stringUtils.containsAnyIgnoreCase(cs, searchCharSequences));
    }
}