
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

class hexDigitMsb0ToIntTest {

    @Test
    void testHexDigitMsb0ToInt() {
        Assertions.assertEquals(0x0, Conversion.hexDigitMsb0ToInt('0'));
        Assertions.assertEquals(0x8, Conversion.hexDigitMsb0ToInt('1'));
        Assertions.assertEquals(0x4, Conversion.hexDigitMsb0ToInt('2'));
        Assertions.assertEquals(0xC, Conversion.hexDigitMsb0ToInt('3'));
        Assertions.assertEquals(0x2, Conversion.hexDigitMsb0ToInt('4'));
        Assertions.assertEquals(0xA, Conversion.hexDigitMsb0ToInt('5'));
        Assertions.assertEquals(0x6, Conversion.hexDigitMsb0ToInt('6'));
        Assertions.assertEquals(0xE, Conversion.hexDigitMsb0ToInt('7'));
        Assertions.assertEquals(0x1, Conversion.hexDigitMsb0ToInt('8'));
        Assertions.assertEquals(0x9, Conversion.hexDigitMsb0ToInt('9'));
        Assertions.assertEquals(0x5, Conversion.hexDigitMsb0ToInt('a'));
        Assertions.assertEquals(0x5, Conversion.hexDigitMsb0ToInt('A'));
        Assertions.assertEquals(0xD, Conversion.hexDigitMsb0ToInt('b'));
        Assertions.assertEquals(0xD, Conversion.hexDigitMsb0ToInt('B'));
        Assertions.assertEquals(0x3, Conversion.hexDigitMsb0ToInt('c'));
        Assertions.assertEquals(0x3, Conversion.hexDigitMsb0ToInt('C'));
        Assertions.assertEquals(0xB, Conversion.hexDigitMsb0ToInt('d'));
        Assertions.assertEquals(0xB, Conversion.hexDigitMsb0ToInt('D'));
        Assertions.assertEquals(0x7, Conversion.hexDigitMsb0ToInt('e'));
        Assertions.assertEquals(0x7, Conversion.hexDigitMsb0ToInt('E'));
        Assertions.assertEquals(0xF, Conversion.hexDigitMsb0ToInt('f'));
        Assertions.assertEquals(0xF, Conversion.hexDigitMsb0ToInt('F'));
    }

    @Test
    void testHexDigitMsb0ToIntInvalid() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            Conversion.hexDigitMsb0ToInt('G');
        });
    }
}
