
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptyStringSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class uncapitalizeTest {

    @Nested
    @DisplayName("Tests for uncapitalize method")
    class UncapitalizeTests {

        @Test
        @DisplayName("Should return null when input is null")
        void shouldReturnNullWhenInputIsNull() {
            // Arrange
            String input = null;

            // Act
            String result = StringUtils.uncapitalize(input);

            // Assert
            Assertions.assertNull(result);
        }

        @ParameterizedTest
        @EmptyStringSource
        @DisplayName("Should return empty string when input is empty")
        void shouldReturnEmptyStringWhenInputIsEmpty(String input) {
            // Act
            String result = StringUtils.uncapitalize(input);

            // Assert
            Assertions.assertEquals("", result);
        }

        @ParameterizedTest
        @ValueSource(strings = {"cat", "Cat"})
        @DisplayName("Should uncapitalize the first character when input is a word")
        void shouldUncapitalizeFirstCharacterWhenInputIsWord(String input) {
            // Act
            String result = StringUtils.uncapitalize(input);

            // Assert
            Assertions.assertEquals("cat", result);
        }

        @ParameterizedTest
        @ValueSource(strings = {"CAT", "cAT"})
        @DisplayName("Should not change the case of characters other than the first character")
        void shouldNotChangeCaseOfOtherCharacters(String input) {
            // Act
            String result = StringUtils.uncapitalize(input);

            // Assert
            Assertions.assertNotEquals(input, result);
        }

        @ParameterizedTest
        @ValueSource(strings = {"  cat", "Cat  ", "  CAT  "})
        @DisplayName("Should preserve leading and trailing spaces")
        void shouldPreserveLeadingAndTrailingSpaces(String input) {
            // Act
            String result = StringUtils.uncapitalize(input);

            // Assert
            Assertions.assertEquals(input, result);
        }

        @ParameterizedTest
        @ValueSource(strings = {"\n", "\r", "\r\n"})
        @DisplayName("Should preserve linefeed and carriage return characters")
        void shouldPreserveLinefeedAndCarriageReturnCharacters(String input) {
            // Act
            String result = StringUtils.uncapitalize(input);

            // Assert
            Assertions.assertEquals(input, result);
        }

        @ParameterizedTest
        @ValueSource(strings = {"\u0000", "\uFFFF"})
        @DisplayName("Should preserve non-printable characters")
        void shouldPreserveNonPrintableCharacters(String input) {
            // Act
            String result = StringUtils.uncapitalize(input);

            // Assert
            Assertions.assertEquals(input, result);
        }

    }

}
