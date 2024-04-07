import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;

class countMatchesTest {

    @Nested
    @DisplayName("Tests for countMatches with char parameter")
    class CharTests {
        
        @Test
        @DisplayName("Counting char in null string should return 0")
        void testCountMatchesWithNullString() {
            assertEquals(0, StringUtils.countMatches(null, 'a'));
        }
        
        @Test
        @DisplayName("Counting char in empty string should return 0")
        void testCountMatchesWithEmptyString() {
            assertEquals(0, StringUtils.countMatches("", 'a'));
        }
        
        @Test
        @DisplayName("Counting char in string without char should return 0")
        void testCountMatchesWithNoChar() {
            assertEquals(0, StringUtils.countMatches("abba", 'x'));
        }
        
        @Test
        @DisplayName("Counting char 'a' in string 'abba' should return 2")
        void testCountMatchesWithCharA() {
            assertEquals(2, StringUtils.countMatches("abba", 'a'));
        }
        
        @Test
        @DisplayName("Counting char 'b' in string 'abba' should return 2")
        void testCountMatchesWithCharB() {
            assertEquals(2, StringUtils.countMatches("abba", 'b'));
        }
        
        @Test
        @DisplayName("Counting char 0 in string 'abba' should return 0")
        void testCountMatchesWithCharZero() {
            assertEquals(0, StringUtils.countMatches("abba", 0));
        }
    }
    
    @Nested
    @DisplayName("Tests for countMatches with substring parameter")
    class SubstringTests {
        
        @Test
        @DisplayName("Counting null substring in string should return 0")
        void testCountMatchesWithNullSubstring() {
            assertEquals(0, StringUtils.countMatches("abba", null));
        }
        
        @Test
        @DisplayName("Counting empty substring in string should return 0")
        void testCountMatchesWithEmptySubstring() {
            assertEquals(0, StringUtils.countMatches("abba", ""));
        }
        
        @Test
        @DisplayName("Counting substring 'a' in string 'abba' should return 2")
        void testCountMatchesWithSubstringA() {
            assertEquals(2, StringUtils.countMatches("abba", "a"));
        }
        
        @Test
        @DisplayName("Counting substring 'ab' in string 'abba' should return 1")
        void testCountMatchesWithSubstringAB() {
            assertEquals(1, StringUtils.countMatches("abba", "ab"));
        }
        
        @Test
        @DisplayName("Counting substring 'xxx' in string 'abba' should return 0")
        void testCountMatchesWithSubstringXXX() {
            assertEquals(0, StringUtils.countMatches("abba", "xxx"));
        }
        
        @Test
        @DisplayName("Counting substring 'aba' in string 'ababa' should return 1")
        void testCountMatchesWithSubstringABA() {
            assertEquals(1, StringUtils.countMatches("ababa", "aba"));
        }
    }
}