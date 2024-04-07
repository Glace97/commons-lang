import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isFormatLetterTest {

    @Test
    void testValidFormatLetters() {
        FastDateParser parser = new FastDateParser("", TimeZone.getDefault(), Locale.getDefault());
        assertTrue(parser.isFormatLetter('G'));
        assertTrue(parser.isFormatLetter('y'));
        assertTrue(parser.isFormatLetter('M'));
        assertTrue(parser.isFormatLetter('d'));
        assertTrue(parser.isFormatLetter('H'));
        assertTrue(parser.isFormatLetter('m'));
        assertTrue(parser.isFormatLetter('s'));
        assertTrue(parser.isFormatLetter('S'));
        assertTrue(parser.isFormatLetter('E'));
        assertTrue(parser.isFormatLetter('D'));
        assertTrue(parser.isFormatLetter('F'));
        assertTrue(parser.isFormatLetter('w'));
        assertTrue(parser.isFormatLetter('W'));
        assertTrue(parser.isFormatLetter('a'));
        assertTrue(parser.isFormatLetter('k'));
        assertTrue(parser.isFormatLetter('K'));
        assertTrue(parser.isFormatLetter('z'));
        assertTrue(parser.isFormatLetter('Z'));
    }
    
    @Test
    void testInvalidFormatLetters() {
        FastDateParser parser = new FastDateParser("", TimeZone.getDefault(), Locale.getDefault());
        assertFalse(parser.isFormatLetter('1'));
        assertFalse(parser.isFormatLetter('%'));
        assertFalse(parser.isFormatLetter('!'));
        assertFalse(parser.isFormatLetter('?'));
        assertFalse(parser.isFormatLetter(' '));
        assertFalse(parser.isFormatLetter('\n'));
        assertFalse(parser.isFormatLetter('\t'));
    }
}