import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class intToHexDigitMsb0Test {

    @Test
    void testIntToHexDigitMsb0() {
        Assertions.assertEquals('0', Conversion.intToHexDigitMsb0(0));
        Assertions.assertEquals('8', Conversion.intToHexDigitMsb0(1));
        Assertions.assertEquals('4', Conversion.intToHexDigitMsb0(2));
        Assertions.assertEquals('C', Conversion.intToHexDigitMsb0(3));
        Assertions.assertEquals('2', Conversion.intToHexDigitMsb0(4));
        Assertions.assertEquals('A', Conversion.intToHexDigitMsb0(5));
        Assertions.assertEquals('6', Conversion.intToHexDigitMsb0(6));
        Assertions.assertEquals('E', Conversion.intToHexDigitMsb0(7));
        Assertions.assertEquals('1', Conversion.intToHexDigitMsb0(8));
        Assertions.assertEquals('9', Conversion.intToHexDigitMsb0(9));
        Assertions.assertEquals('5', Conversion.intToHexDigitMsb0(10));
        Assertions.assertEquals('D', Conversion.intToHexDigitMsb0(11));
        Assertions.assertEquals('3', Conversion.intToHexDigitMsb0(12));
        Assertions.assertEquals('B', Conversion.intToHexDigitMsb0(13));
        Assertions.assertEquals('7', Conversion.intToHexDigitMsb0(14));
        Assertions.assertEquals('F', Conversion.intToHexDigitMsb0(15));
    }

    @Test
    void testInvalidInput() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> Conversion.intToHexDigitMsb0(-1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Conversion.intToHexDigitMsb0(16));
    }
}