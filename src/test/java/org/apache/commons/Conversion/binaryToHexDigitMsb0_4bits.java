
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class binaryToHexDigitMsb0_4bitsTest {

    @Test
    void testBinaryToHexDigitMsb0_4bits_Positive() {
        // Test cases for positive conversions
        assertEquals('8', Conversion.binaryToHexDigitMsb0_4bits(Conversion.TTTT));
        assertEquals('7', Conversion.binaryToHexDigitMsb0_4bits(Conversion.FTTT));
        assertEquals('b', Conversion.binaryToHexDigitMsb0_4bits(Conversion.TFTT));
        assertEquals('3', Conversion.binaryToHexDigitMsb0_4bits(Conversion.FFTT));
        assertEquals('f', Conversion.binaryToHexDigitMsb0_4bits(Conversion.TTFT));
        assertEquals('7', Conversion.binaryToHexDigitMsb0_4bits(Conversion.FTFT));
        assertEquals('5', Conversion.binaryToHexDigitMsb0_4bits(Conversion.TFFT));
        assertEquals('1', Conversion.binaryToHexDigitMsb0_4bits(Conversion.FFFT));
        assertEquals('d', Conversion.binaryToHexDigitMsb0_4bits(Conversion.TTTF));
        assertEquals('3', Conversion.binaryToHexDigitMsb0_4bits(Conversion.FTTF));
        assertEquals('a', Conversion.binaryToHexDigitMsb0_4bits(Conversion.TFTF));
        assertEquals('2', Conversion.binaryToHexDigitMsb0_4bits(Conversion.FFTF));
        assertEquals('e', Conversion.binaryToHexDigitMsb0_4bits(Conversion.TTFF));
        assertEquals('6', Conversion.binaryToHexDigitMsb0_4bits(Conversion.FTFF));
        assertEquals('c', Conversion.binaryToHexDigitMsb0_4bits(Conversion.TFFF));
        assertEquals('4', Conversion.binaryToHexDigitMsb0_4bits(Conversion.FFFF));
    }

    @Test
    void testBinaryToHexDigitMsb0_4bits_Exceptions() {
        // Test cases for exceptions
        assertThrows(IllegalArgumentException.class, () -> Conversion.binaryToHexDigitMsb0_4bits(Conversion.TTTT, 1));
        assertThrows(IllegalArgumentException.class, () -> Conversion.binaryToHexDigitMsb0_4bits(Conversion.TTTT, 5));
        assertThrows(IllegalArgumentException.class, () -> Conversion.binaryToHexDigitMsb0_4bits(Conversion.TTTT, 8));
        assertThrows(NullPointerException.class, () -> Conversion.binaryToHexDigitMsb0_4bits(null));
    }

}
