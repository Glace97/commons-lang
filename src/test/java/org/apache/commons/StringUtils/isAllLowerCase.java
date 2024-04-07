
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("isAllLowerCase method")
class isAllLowerCaseTest {

    @Nested
    @DisplayName("When input is null or empty")
    class NullOrEmptyInput {

        @Test
        @DisplayName("Should return false when input is null")
        void shouldReturnFalseWhenInputIsNull() {
            assertFalse(StringUtils.isAllLowerCase(null));
        }

        @Test
        @DisplayName("Should return false when input is empty")
        void shouldReturnFalseWhenInputIsEmpty() {
            assertFalse(StringUtils.isAllLowerCase(""));
        }

        @Test
        @DisplayName("Should return false when input contains only spaces")
        void shouldReturnFalseWhenInputContainsOnlySpaces() {
            assertFalse(StringUtils.isAllLowerCase("  "));
        }
    }

    @Nested
    @DisplayName("When input contains only lowercase characters")
    class LowercaseInput {

        @Test
        @DisplayName("Should return true when input is 'abc'")
        void shouldReturnTrueWhenInputIsAbc() {
            assertTrue(StringUtils.isAllLowerCase("abc"));
        }

        @Test
        @DisplayName("Should return true when input is 'abcdefghijklmnopqrstuvwxyz'")
        void shouldReturnTrueWhenInputIsAlphabet() {
            assertTrue(StringUtils.isAllLowerCase("abcdefghijklmnopqrstuvwxyz"));
        }
    }

    @Nested
    @DisplayName("When input contains uppercase characters or non-alphabetic characters")
    class UppercaseOrNonAlphabeticInput {

        @Test
        @DisplayName("Should return false when input is 'abC'")
        void shouldReturnFalseWhenInputContainsUppercase() {
            assertFalse(StringUtils.isAllLowerCase("abC"));
        }

        @Test
        @DisplayName("Should return false when input is 'ab c'")
        void shouldReturnFalseWhenInputContainsSpace() {
            assertFalse(StringUtils.isAllLowerCase("ab c"));
        }

        @Test
        @DisplayName("Should return false when input is 'ab1c'")
        void shouldReturnFalseWhenInputContainsNumber() {
            assertFalse(StringUtils.isAllLowerCase("ab1c"));
        }

        @Test
        @DisplayName("Should return false when input is 'ab/c'")
        void shouldReturnFalseWhenInputContainsSpecialCharacter() {
            assertFalse(StringUtils.isAllLowerCase("ab/c"));
        }
    }
}
