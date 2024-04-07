
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class ContainsTest {

    private CharSet charSet;

    @BeforeEach
    void setUp() {
        charSet = new CharSet("a-z");
    }

    @Nested
    @DisplayName("When the CharSet contains the character")
    class ContainsCharacter {

        @Test
        @DisplayName("Should return true")
        void containsCharacter_returnsTrue() {
            assertTrue(charSet.contains('a'));
        }
    }

    @Nested
    @DisplayName("When the CharSet does not contain the character")
    class DoesNotContainCharacter {

        @Test
        @DisplayName("Should return false")
        void doesNotContainCharacter_returnsFalse() {
            assertFalse(charSet.contains('1'));
        }
    }
    
    @Nested
    @DisplayName("When the CharSet is empty")
    class EmptyCharSet {

        @BeforeEach
        void setUp() {
            charSet = CharSet.EMPTY;
        }

        @Test
        @DisplayName("Should return false for any character")
        void containsCharacter_returnsFalse() {
            assertFalse(charSet.contains('a'));
            assertFalse(charSet.contains('1'));
            assertFalse(charSet.contains('_'));
        }
    }

    @Nested
    @DisplayName("When the CharSet contains special characters")
    class SpecialCharacters {

        @BeforeEach
        void setUp() {
            charSet = new CharSet("!@#$%");
        }

        @Test
        @DisplayName("Should return true for any character in the CharSet")
        void containsCharacter_returnsTrue() {
            assertTrue(charSet.contains('!'));
            assertTrue(charSet.contains('@'));
            assertTrue(charSet.contains('#'));
            assertTrue(charSet.contains('$'));
            assertTrue(charSet.contains('%'));
        }

        @Test
        @DisplayName("Should return false for any character not in the CharSet")
        void doesNotContainCharacter_returnsFalse() {
            assertFalse(charSet.contains('a'));
            assertFalse(charSet.contains('1'));
            assertFalse(charSet.contains('_'));
        }
    }

}
