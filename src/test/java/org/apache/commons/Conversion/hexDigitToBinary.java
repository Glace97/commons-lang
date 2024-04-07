import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class hexDigitToBinaryTest {

    @Test
    void testHexDigitToBinary() {
        // Test case for '0'
        char hexDigit0 = '0';
        boolean[] expectedBinary0 = {false, false, false, false};
        assertArrayEquals(expectedBinary0, Conversion.hexDigitToBinary(hexDigit0));

        // Test case for '1'
        char hexDigit1 = '1';
        boolean[] expectedBinary1 = {true, false, false, false};
        assertArrayEquals(expectedBinary1, Conversion.hexDigitToBinary(hexDigit1));

        // Test case for '2'
        char hexDigit2 = '2';
        boolean[] expectedBinary2 = {false, true, false, false};
        assertArrayEquals(expectedBinary2, Conversion.hexDigitToBinary(hexDigit2));

        // Test case for '3'
        char hexDigit3 = '3';
        boolean[] expectedBinary3 = {true, true, false, false};
        assertArrayEquals(expectedBinary3, Conversion.hexDigitToBinary(hexDigit3));

        // Test case for '4'
        char hexDigit4 = '4';
        boolean[] expectedBinary4 = {false, false, true, false};
        assertArrayEquals(expectedBinary4, Conversion.hexDigitToBinary(hexDigit4));

        // Test case for '5'
        char hexDigit5 = '5';
        boolean[] expectedBinary5 = {true, false, true, false};
        assertArrayEquals(expectedBinary5, Conversion.hexDigitToBinary(hexDigit5));

        // Test case for '6'
        char hexDigit6 = '6';
        boolean[] expectedBinary6 = {false, true, true, false};
        assertArrayEquals(expectedBinary6, Conversion.hexDigitToBinary(hexDigit6));

        // Test case for '7'
        char hexDigit7 = '7';
        boolean[] expectedBinary7 = {true, true, true, false};
        assertArrayEquals(expectedBinary7, Conversion.hexDigitToBinary(hexDigit7));

        // Test case for '8'
        char hexDigit8 = '8';
        boolean[] expectedBinary8 = {false, false, false, true};
        assertArrayEquals(expectedBinary8, Conversion.hexDigitToBinary(hexDigit8));

        // Test case for '9'
        char hexDigit9 = '9';
        boolean[] expectedBinary9 = {true, false, false, true};
        assertArrayEquals(expectedBinary9, Conversion.hexDigitToBinary(hexDigit9));

        // Test case for 'a' or 'A'
        char hexDigitA = 'a';
        boolean[] expectedBinaryA = {false, true, false, true};
        assertArrayEquals(expectedBinaryA, Conversion.hexDigitToBinary(hexDigitA));

        // Test case for 'b' or 'B'
        char hexDigitB = 'b';
        boolean[] expectedBinaryB = {true, true, false, true};
        assertArrayEquals(expectedBinaryB, Conversion.hexDigitToBinary(hexDigitB));

        // Test case for 'c' or 'C'
        char hexDigitC = 'c';
        boolean[] expectedBinaryC = {false, false, true, true};
        assertArrayEquals(expectedBinaryC, Conversion.hexDigitToBinary(hexDigitC));

        // Test case for 'd' or 'D'
        char hexDigitD = 'd';
        boolean[] expectedBinaryD = {true, false, true, true};
        assertArrayEquals(expectedBinaryD, Conversion.hexDigitToBinary(hexDigitD));

        // Test case for 'e' or 'E'
        char hexDigitE = 'e';
        boolean[] expectedBinaryE = {false, true, true, true};
        assertArrayEquals(expectedBinaryE, Conversion.hexDigitToBinary(hexDigitE));

        // Test case for 'f' or 'F'
        char hexDigitF = 'f';
        boolean[] expectedBinaryF = {true, true, true, true};
        assertArrayEquals(expectedBinaryF, Conversion.hexDigitToBinary(hexDigitF));
    }

    @Test
    void testHexDigitToBinaryIllegalArgumentException() {
        // Test case for invalid hex digit
        char hexDigitInvalid = 'g';
        assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexDigitToBinary(hexDigitInvalid);
        });
    }
}