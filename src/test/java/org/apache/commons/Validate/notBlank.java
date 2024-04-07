import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class notBlankTest {

    private Validate validate;

    @Test
    void notBlank_ValidInput_ReturnsInput() {
        String input = "valid string";
        String result = validate.notBlank(input);
        assertEquals(input, result);
    }

    @ParameterizedTest
    @NullSource
    void notBlank_NullInput_ThrowsNullPointerException(String input) {
        assertThrows(NullPointerException.class, () -> validate.notBlank(input));
    }

    @ParameterizedTest
    @EmptySource
    void notBlank_EmptyInput_ThrowsIllegalArgumentException(String input) {
        assertThrows(IllegalArgumentException.class, () -> validate.notBlank(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\t", "\n", "\r", "\f"})
    void notBlank_WhitespaceInput_ThrowsIllegalArgumentException(String input) {
        assertThrows(IllegalArgumentException.class, () -> validate.notBlank(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"valid string", "another valid string"})
    void notBlank_ValidInputWithMessage_ReturnsInput(String input) {
        String message = "Custom error message";
        String result = validate.notBlank(input, message);
        assertEquals(input, result);
    }

    @ParameterizedTest
    @NullSource
    void notBlank_NullInputWithMessage_ThrowsNullPointerException(String input) {
        String message = "Custom error message";
        assertThrows(NullPointerException.class, () -> validate.notBlank(input, message));
    }

    @ParameterizedTest
    @EmptySource
    void notBlank_EmptyInputWithMessage_ThrowsIllegalArgumentException(String input) {
        String message = "Custom error message";
        assertThrows(IllegalArgumentException.class, () -> validate.notBlank(input, message));
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\t", "\n", "\r", "\f"})
    void notBlank_WhitespaceInputWithMessage_ThrowsIllegalArgumentException(String input) {
        String message = "Custom error message";
        assertThrows(IllegalArgumentException.class, () -> validate.notBlank(input, message));
    }
}