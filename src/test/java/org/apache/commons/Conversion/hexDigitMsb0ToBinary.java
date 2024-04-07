import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

class hexDigitMsb0ToBinaryTest {

    @Test
    @DisplayName("Test hexadecimal digit '0'")
    void testHexDigit0() {
        char hexDigit = '0';
        boolean[] expected = {false, false, false, false};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary(hexDigit));
    }

    @Test
    @DisplayName("Test hexadecimal digit '1'")
    void testHexDigit1() {
        char hexDigit = '1';
        boolean[] expected = {false, false, false, true};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary(hexDigit));
    }

    @Test
    @DisplayName("Test hexadecimal digit '2'")
    void testHexDigit2() {
        char hexDigit = '2';
        boolean[] expected = {false, false, true, false};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary(hexDigit));
    }

    @Test
    @DisplayName("Test hexadecimal digit '3'")
    void testHexDigit3() {
        char hexDigit = '3';
        boolean[] expected = {false, false, true, true};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary(hexDigit));
    }

    @Test
    @DisplayName("Test hexadecimal digit '4'")
    void testHexDigit4() {
        char hexDigit = '4';
        boolean[] expected = {false, true, false, false};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary(hexDigit));
    }

    @Test
    @DisplayName("Test hexadecimal digit '5'")
    void testHexDigit5() {
        char hexDigit = '5';
        boolean[] expected = {false, true, false, true};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary(hexDigit));
    }

    @Test
    @DisplayName("Test hexadecimal digit '6'")
    void testHexDigit6() {
        char hexDigit = '6';
        boolean[] expected = {false, true, true, false};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary(hexDigit));
    }

    @Test
    @DisplayName("Test hexadecimal digit '7'")
    void testHexDigit7() {
        char hexDigit = '7';
        boolean[] expected = {false, true, true, true};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary(hexDigit));
    }

    @Test
    @DisplayName("Test hexadecimal digit '8'")
    void testHexDigit8() {
        char hexDigit = '8';
        boolean[] expected = {true, false, false, false};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary(hexDigit));
    }

    @Test
    @DisplayName("Test hexadecimal digit '9'")
    void testHexDigit9() {
        char hexDigit = '9';
        boolean[] expected = {true, false, false, true};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary(hexDigit));
    }

    @Test
    @DisplayName("Test hexadecimal digit 'a' or 'A'")
    void testHexDigitA() {
        char hexDigit = 'a';
        boolean[] expected = {true, false, true, false};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary(hexDigit));

        hexDigit = 'A';
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary(hexDigit));
    }

    @Test
    @DisplayName("Test hexadecimal digit 'b' or 'B'")
    void testHexDigitB() {
        char hexDigit = 'b';
        boolean[] expected = {true, false, true, true};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary(hexDigit));

        hexDigit = 'B';
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary(hexDigit));
    }

    @Test
    @DisplayName("Test hexadecimal digit 'c' or 'C'")
    void testHexDigitC() {
        char hexDigit = 'c';
        boolean[] expected = {true, true, false, false};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary(hexDigit));

        hexDigit = 'C';
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary(hexDigit));
    }

    @Test
    @DisplayName("Test hexadecimal digit 'd' or 'D'")
    void testHexDigitD() {
        char hexDigit = 'd';
        boolean[] expected = {true, true, false, true};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary(hexDigit));

        hexDigit = 'D';
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary(hexDigit));
    }

    @Test
    @DisplayName("Test hexadecimal digit 'e' or 'E'")
    void testHexDigitE() {
        char hexDigit = 'e';
        boolean[] expected = {true, true, true, false};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary(hexDigit));

        hexDigit = 'E';
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary(hexDigit));
    }

    @Test
    @DisplayName("Test hexadecimal digit 'f' or 'F'")
    void testHexDigitF() {
        char hexDigit = 'f';
        boolean[] expected = {true, true, true, true};
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary(hexDigit));

        hexDigit = 'F';
        assertArrayEquals(expected, Conversion.hexDigitMsb0ToBinary(hexDigit));
    }

    @Test
    @DisplayName("Test invalid hexadecimal digit")
    void testInvalidHexDigit() {
        char hexDigit = 'g';
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexDigitMsb0ToBinary(hexDigit);
        });
    }
}