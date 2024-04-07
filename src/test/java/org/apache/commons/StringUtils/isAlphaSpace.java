
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class isAlphaSpaceTest {

    @Nested
    @DisplayName("Testing isAlphaSpace method")
    class IsAlphaSpaceMethod {

        @Test
        @DisplayName("Returns true when input is null")
        void testIsAlphaSpace_NullInput_ReturnsFalse() {
            Assertions.assertFalse(StringUtils.isAlphaSpace(null));
        }

        @Test
        @DisplayName("Returns true when input is an empty string")
        void testIsAlphaSpace_EmptyString_ReturnsTrue() {
            Assertions.assertTrue(StringUtils.isAlphaSpace(""));
        }

        @Test
        @DisplayName("Returns true when input contains only letters and spaces")
        void testIsAlphaSpace_OnlyLettersAndSpaces_ReturnsTrue() {
            Assertions.assertTrue(StringUtils.isAlphaSpace("abc"));
            Assertions.assertTrue(StringUtils.isAlphaSpace("ab c"));
        }

        @Test
        @DisplayName("Returns false when input contains digits")
        void testIsAlphaSpace_ContainsDigits_ReturnsFalse() {
            Assertions.assertFalse(StringUtils.isAlphaSpace("ab2c"));
        }

        @Test
        @DisplayName("Returns false when input contains special characters")
        void testIsAlphaSpace_ContainsSpecialCharacters_ReturnsFalse() {
            Assertions.assertFalse(StringUtils.isAlphaSpace("ab-c"));
        }

        @Test
        @DisplayName("Returns true when input contains only spaces")
        void testIsAlphaSpace_OnlySpaces_ReturnsTrue() {
            Assertions.assertTrue(StringUtils.isAlphaSpace("  "));
        }
    }
}
