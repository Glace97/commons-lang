
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class isInstanceOfTest {
    @Nested
    @DisplayName("isInstanceOf(Class, Object)")
    class IsInstanceOfWithoutMessage {
        private Validate validate;

        @BeforeEach
        void setUp() {
            validate = new Validate();
        }

        @Test
        @DisplayName("should not throw an exception when object is an instance of the specified class")
        void shouldNotThrowExceptionWhenObjectIsInstanceOfClass() {
            assertDoesNotThrow(() -> validate.isInstanceOf(String.class, "test"));
        }

        @Test
        @DisplayName("should throw an exception with the default message when object is not an instance of the specified class")
        void shouldThrowExceptionWithDefaultMessageWhenObjectIsNotInstanceOfClass() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> validate.isInstanceOf(Integer.class, "test"));

            assertEquals("Expected type: java.lang.Integer, actual: java.lang.String", exception.getMessage());
        }
    }

    @Nested
    @DisplayName("isInstanceOf(Class, Object, String, Object...)")
    class IsInstanceOfWithMessage {
        private Validate validate;

        @BeforeEach
        void setUp() {
            validate = new Validate();
        }

        @Test
        @DisplayName("should not throw an exception when object is an instance of the specified class")
        void shouldNotThrowExceptionWhenObjectIsInstanceOfClass() {
            assertDoesNotThrow(() -> validate.isInstanceOf(String.class, "test", "Custom message"));
        }

        @Test
        @DisplayName("should throw an exception with the custom message when object is not an instance of the specified class")
        void shouldThrowExceptionWithCustomMessageWhenObjectIsNotInstanceOfClass() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> validate.isInstanceOf(Integer.class, "test", "Custom message"));

            assertEquals("Custom message", exception.getMessage());
        }

        @Test
        @DisplayName("should format the message with the provided values")
        void shouldFormatMessageWithProvidedValues() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                    () -> validate.isInstanceOf(Integer.class, "test", "Value: %s", 123));

            assertEquals("Value: 123", exception.getMessage());
        }
    }
}
