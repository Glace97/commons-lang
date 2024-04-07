import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class isAlphanumericSpaceTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Nested
    @DisplayName("Positive Cases")
    class PositiveCases {

        @Test
        @DisplayName("Test isAlphanumericSpace with null input")
        void testIsAlphanumericSpaceWithNull() {
            assertFalse(stringUtils.isAlphanumericSpace(null));
        }

        @Test
        @DisplayName("Test isAlphanumericSpace with empty input")
        void testIsAlphanumericSpaceWithEmpty() {
            assertTrue(stringUtils.isAlphanumericSpace(""));
        }

        @Test
        @DisplayName("Test isAlphanumericSpace with only spaces")
        void testIsAlphanumericSpaceWithSpaces() {
            assertTrue(stringUtils.isAlphanumericSpace("  "));
        }

        @Test
        @DisplayName("Test isAlphanumericSpace with only letters and digits")
        void testIsAlphanumericSpaceWithLettersAndDigits() {
            assertTrue(stringUtils.isAlphanumericSpace("abc"));
            assertTrue(stringUtils.isAlphanumericSpace("ab2c"));
        }

        @Test
        @DisplayName("Test isAlphanumericSpace with letters, digits, and spaces")
        void testIsAlphanumericSpaceWithLettersDigitsAndSpaces() {
            assertTrue(stringUtils.isAlphanumericSpace("ab c"));
        }
    }

    @Nested
    @DisplayName("Negative Cases")
    class NegativeCases {

        @ParameterizedTest
        @ValueSource(strings = {"ab-c", "ab*c", "ab_c"})
        @DisplayName("Test isAlphanumericSpace with special characters")
        void testIsAlphanumericSpaceWithSpecialCharacters(String input) {
            assertFalse(stringUtils.isAlphanumericSpace(input));
        }
    }
}