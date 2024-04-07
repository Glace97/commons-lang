
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

class MatchesPatternTest {

    @Nested
    @DisplayName("matchesPattern(CharSequence input, String pattern)")
    class MatchesPatternWithoutMessage {

        @Test
        @DisplayName("should not throw exception when input matches the pattern")
        void shouldNotThrowExceptionWhenInputMatchesPattern() {
            Assertions.assertDoesNotThrow(() ->
                    Validate.matchesPattern("hi", "[a-z]*"));
        }

        @Test
        @DisplayName("should throw exception when input does not match the pattern")
        void shouldThrowExceptionWhenInputDoesNotMatchPattern() {
            Assertions.assertThrows(IllegalArgumentException.class, () ->
                    Validate.matchesPattern("123", "[a-z]*"));
        }

    }

    @Nested
    @DisplayName("matchesPattern(CharSequence input, String pattern, String message, Object... values)")
    class MatchesPatternWithMessage {

        @Test
        @DisplayName("should not throw exception when input matches the pattern")
        void shouldNotThrowExceptionWhenInputMatchesPattern() {
            Assertions.assertDoesNotThrow(() ->
                    Validate.matchesPattern("hi", "[a-z]*", "Input '%s' matches the pattern '%s'", "hi", "[a-z]*"));
        }

        @Test
        @DisplayName("should throw exception with formatted message when input does not match the pattern")
        void shouldThrowExceptionWithFormattedMessageWhenInputDoesNotMatchPattern() {
            IllegalArgumentException exception = Assertions.assertThrows(IllegalArgumentException.class, () ->
                    Validate.matchesPattern("123", "[a-z]*", "Input '%s' does not match the pattern '%s'", "123", "[a-z]*"));
            Assertions.assertEquals("Input '123' does not match the pattern '[a-z]*'", exception.getMessage());
        }

    }

}
