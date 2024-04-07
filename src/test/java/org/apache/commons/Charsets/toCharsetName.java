import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("toCharsetName Test")
class toCharsetNameTest {

    @Nested
    @DisplayName("Null and Empty Inputs")
    class NullAndEmptyInputs {

        @Test
        @DisplayName("Should return default charset name when input is null")
        void shouldReturnDefaultCharsetNameWhenInputIsNull() {
            // Arrange
            String charsetName = null;
            String expected = Charset.defaultCharset().name();

            // Act
            String result = Charsets.toCharsetName(charsetName);

            // Assert
            assertEquals(expected, result);
        }

        @ParameterizedTest
        @NullAndEmptySource
        @DisplayName("Should return input charset name when input is empty")
        void shouldReturnInputCharsetNameWhenInputIsEmpty(String charsetName) {
            // Arrange
            String expected = charsetName;

            // Act
            String result = Charsets.toCharsetName(charsetName);

            // Assert
            assertEquals(expected, result);
        }

    }

    @Nested
    @DisplayName("Valid Input")
    class ValidInput {

        @ParameterizedTest
        @ValueSource(strings = { "UTF-8", "ISO-8859-1", "US-ASCII" })
        @DisplayName("Should return input charset name when input is valid")
        void shouldReturnInputCharsetNameWhenInputIsValid(String charsetName) {
            // Arrange
            String expected = charsetName;

            // Act
            String result = Charsets.toCharsetName(charsetName);

            // Assert
            assertEquals(expected, result);
        }

    }

}