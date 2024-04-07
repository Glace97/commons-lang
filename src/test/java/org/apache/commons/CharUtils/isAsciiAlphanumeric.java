import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class isAsciiAlphanumericTest {

    @Test
    void testIsAsciiAlphanumericWithLowercaseLetter() {
        assertTrue(CharUtils.isAsciiAlphanumeric('a'));
    }
    
    @Test
    void testIsAsciiAlphanumericWithUppercaseLetter() {
        assertTrue(CharUtils.isAsciiAlphanumeric('A'));
    }
    
    @Test
    void testIsAsciiAlphanumericWithDigit() {
        assertTrue(CharUtils.isAsciiAlphanumeric('3'));
    }
    
    @Test
    void testIsAsciiAlphanumericWithSpecialCharacter() {
        assertFalse(CharUtils.isAsciiAlphanumeric('-'));
    }
    
    @Test
    void testIsAsciiAlphanumericWithNewLineCharacter() {
        assertFalse(CharUtils.isAsciiAlphanumeric('\n'));
    }
    
    @Test
    void testIsAsciiAlphanumericWithUnicodeCharacter() {
        assertFalse(CharUtils.isAsciiAlphanumeric('\u00a9'));
    }
    
    @ParameterizedTest
    @ValueSource(chars = {'a', 'A', '3'})
    void testIsAsciiAlphanumericWithValidCharacters(char ch) {
        assertTrue(CharUtils.isAsciiAlphanumeric(ch));
    }
    
    @ParameterizedTest
    @ValueSource(chars = {'-', '\n', '\u00a9'})
    void testIsAsciiAlphanumericWithInvalidCharacters(char ch) {
        assertFalse(CharUtils.isAsciiAlphanumeric(ch));
    }
    
    @ParameterizedTest
    @ValueSource(chars = {'0', '9', 'Z', 'z'})
    void testIsAsciiAlphanumericWithEdgeCharacters(char ch) {
        assertTrue(CharUtils.isAsciiAlphanumeric(ch));
    }
    
    @ParameterizedTest
    @ValueSource(chars = {' ', '\'', '!', '~'})
    void testIsAsciiAlphanumericWithNonAlphanumericCharacters(char ch) {
        assertFalse(CharUtils.isAsciiAlphanumeric(ch));
    }
}