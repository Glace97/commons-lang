
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class isInTest {

    @Nested
    @DisplayName("Positive scenarios")
    class PositiveScenarios {

        private CharRange range;

        @BeforeEach
        void setUp() {
            range = CharRange.isIn('A', 'Z');
        }

        @Test
        @DisplayName("Test isIn() returns true for characters within the range")
        void testIsInReturnsTrueForCharactersWithinRange() {
            assertTrue(range.isIn('A'));
            assertTrue(range.isIn('M'));
            assertTrue(range.isIn('Z'));
        }

        @Test
        @DisplayName("Test isIn() returns false for characters outside the range")
        void testIsInReturnsFalseForCharactersOutsideRange() {
            assertFalse(range.isIn('a'));
            assertFalse(range.isIn('1'));
            assertFalse(range.isIn('!'));
        }
    }

    @Nested
    @DisplayName("Edge cases")
    class EdgeCases {

        private CharRange range;

        @BeforeEach
        void setUp() {
            range = CharRange.isIn(Character.MIN_VALUE, Character.MAX_VALUE);
        }

        @Test
        @DisplayName("Test isIn() returns true for minimum character value")
        void testIsInReturnsTrueForMinimumCharacterValue() {
            assertTrue(range.isIn(Character.MIN_VALUE));
        }

        @Test
        @DisplayName("Test isIn() returns true for maximum character value")
        void testIsInReturnsTrueForMaximumCharacterValue() {
            assertTrue(range.isIn(Character.MAX_VALUE));
        }
    }

    @Nested
    @DisplayName("Parameterized test")
    class ParameterizedTest {

        private CharRange range;

        @BeforeEach
        void setUp() {
            range = CharRange.isIn('A', 'Z');
        }

        @ParameterizedTest
        @ValueSource(chars = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'})
        @DisplayName("Test isIn() returns true for all characters within the range")
        void testIsInReturnsTrueForAllCharactersWithinRange(char character) {
            assertTrue(range.isIn(character));
        }
    }
}
