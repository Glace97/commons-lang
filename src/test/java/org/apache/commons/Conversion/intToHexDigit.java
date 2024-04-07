import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.UUID;

class intToHexDigitTest {

    @Nested
    @DisplayName("Positive Test Cases")
    class PositiveTests {

        @Test
        @DisplayName("Test intToHexDigit with 0")
        void testIntToHexDigitWithZero() {
            char result = Conversion.intToHexDigit(0);
            Assertions.assertEquals('0', result);
        }

        @Test
        @DisplayName("Test intToHexDigit with 1")
        void testIntToHexDigitWithOne() {
            char result = Conversion.intToHexDigit(1);
            Assertions.assertEquals('1', result);
        }

        @Test
        @DisplayName("Test intToHexDigit with 10")
        void testIntToHexDigitWithTen() {
            char result = Conversion.intToHexDigit(10);
            Assertions.assertEquals('A', result);
        }

        // Add more positive test cases for other values

    }

    @Nested
    @DisplayName("Negative Test Cases")
    class NegativeTests {

        @Test
        @DisplayName("Test intToHexDigit with -1")
        void testIntToHexDigitWithNegativeValue() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                Conversion.intToHexDigit(-1);
            });
        }

        @Test
        @DisplayName("Test intToHexDigit with 16")
        void testIntToHexDigitWithOutOfRangeValue() {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                Conversion.intToHexDigit(16);
            });
        }

        // Add more negative test cases for other values

    }
}