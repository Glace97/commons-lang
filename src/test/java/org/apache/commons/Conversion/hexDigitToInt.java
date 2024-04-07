import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class hexDigitToIntTest {

    @Test
    void testHexDigitToInt() {
        // Test for valid hexadecimal digits
        assertEquals(0, Conversion.hexDigitToInt('0'));
        assertEquals(1, Conversion.hexDigitToInt('1'));
        assertEquals(2, Conversion.hexDigitToInt('2'));
        assertEquals(3, Conversion.hexDigitToInt('3'));
        assertEquals(4, Conversion.hexDigitToInt('4'));
        assertEquals(5, Conversion.hexDigitToInt('5'));
        assertEquals(6, Conversion.hexDigitToInt('6'));
        assertEquals(7, Conversion.hexDigitToInt('7'));
        assertEquals(8, Conversion.hexDigitToInt('8'));
        assertEquals(9, Conversion.hexDigitToInt('9'));
        assertEquals(10, Conversion.hexDigitToInt('a'));
        assertEquals(11, Conversion.hexDigitToInt('b'));
        assertEquals(12, Conversion.hexDigitToInt('c'));
        assertEquals(13, Conversion.hexDigitToInt('d'));
        assertEquals(14, Conversion.hexDigitToInt('e'));
        assertEquals(15, Conversion.hexDigitToInt('f'));
        assertEquals(10, Conversion.hexDigitToInt('A'));
        assertEquals(11, Conversion.hexDigitToInt('B'));
        assertEquals(12, Conversion.hexDigitToInt('C'));
        assertEquals(13, Conversion.hexDigitToInt('D'));
        assertEquals(14, Conversion.hexDigitToInt('E'));
        assertEquals(15, Conversion.hexDigitToInt('F'));

        // Test for invalid hexadecimal digits
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('g'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('G'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt(' '));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('@'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('!'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('?'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('\''));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('"'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('\\'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('/'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt(':'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt(';'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('<'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('>'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('['));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt(']'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('{'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('}'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('('));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt(')'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('-'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('_'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('='));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('+'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('*'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('~'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('`'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('%'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('$'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('^'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('&'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('|'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt('.'));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt(','));
        assertThrows(IllegalArgumentException.class, () -> Conversion.hexDigitToInt(' '));
    }
}