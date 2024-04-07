import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isAsciiAlphaLowerTest {

    @Test
    void testLowercaseLetters() {
        assertTrue(CharUtils.isAsciiAlphaLower('a'));
        assertTrue(CharUtils.isAsciiAlphaLower('z'));
    }

    @Test
    void testUppercaseLetters() {
        assertFalse(CharUtils.isAsciiAlphaLower('A'));
        assertFalse(CharUtils.isAsciiAlphaLower('Z'));
    }

    @Test
    void testNumbers() {
        assertFalse(CharUtils.isAsciiAlphaLower('0'));
        assertFalse(CharUtils.isAsciiAlphaLower('9'));
    }

    @Test
    void testSpecialCharacters() {
        assertFalse(CharUtils.isAsciiAlphaLower('-'));
        assertFalse(CharUtils.isAsciiAlphaLower('\n'));
        assertFalse(CharUtils.isAsciiAlphaLower('&'));
        assertFalse(CharUtils.isAsciiAlphaLower(';'));
    }

    @Test
    void testNullCharacter() {
        assertFalse(CharUtils.isAsciiAlphaLower('\0'));
    }

    @Test
    void testAllAsciiLowercaseLetters() {
        for (char c = 'a'; c <= 'z'; c++) {
            assertTrue(CharUtils.isAsciiAlphaLower(c));
        }
    }
}