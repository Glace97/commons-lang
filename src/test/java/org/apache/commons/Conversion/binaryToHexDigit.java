import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("binaryToHexDigitTest")
class binaryToHexDigitTest {

    @Nested
    @DisplayName("binaryToHexDigit")
    class BinaryToHexDigit {

        private Conversion conversion;

        @BeforeEach
        void setUp() {
            conversion = new Conversion();
        }

        @Test
        @DisplayName("Should convert binary to hexadecimal digit '1'")
        void shouldConvertBinaryToHexDigit1() {
            boolean[] binary = {true, false, false, false};
            char expected = '1';
            char actual = Conversion.binaryToHexDigit(binary);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Should convert binary to hexadecimal digit '0'")
        void shouldConvertBinaryToHexDigit0() {
            boolean[] binary = {false, false, false, false};
            char expected = '0';
            char actual = Conversion.binaryToHexDigit(binary);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Should convert binary to hexadecimal digit 'f'")
        void shouldConvertBinaryToHexDigitF() {
            boolean[] binary = {true, true, true, true};
            char expected = 'f';
            char actual = Conversion.binaryToHexDigit(binary);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Should convert binary to hexadecimal digit '8'")
        void shouldConvertBinaryToHexDigit8() {
            boolean[] binary = {false, false, false, true};
            char expected = '8';
            char actual = Conversion.binaryToHexDigit(binary);
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("Should throw IllegalArgumentException when converting an empty array")
        void shouldThrowIllegalArgumentExceptionWhenConvertingEmptyArray() {
            boolean[] binary = {};
            assertThrows(IllegalArgumentException.class, () -> Conversion.binaryToHexDigit(binary));
        }

        @Test
        @DisplayName("Should throw NullPointerException when converting a null array")
        void shouldThrowNullPointerExceptionWhenConvertingNullArray() {
            assertThrows(NullPointerException.class, () -> Conversion.binaryToHexDigit(null));
        }

        @Test
        @DisplayName("Should convert binary to hexadecimal digit 'a' when srcPos is 1")
        void shouldConvertBinaryToHexDigitAWhenSrcPosIs1() {
            boolean[] binary = {true, false, false, false};
            int srcPos = 1;
            char expected = 'a';
            char actual = Conversion.binaryToHexDigit(binary, srcPos);
            assertEquals(expected, actual);
        }

        // Add more test cases to cover all edge cases

    }
}