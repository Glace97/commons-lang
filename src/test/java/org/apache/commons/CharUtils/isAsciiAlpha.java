import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class isAsciiAlphaTest {

    @Test
    void testIsAsciiAlphaLower() {
        assertTrue(CharUtils.isAsciiAlpha('a'));
        assertTrue(CharUtils.isAsciiAlpha('z'));
        assertFalse(CharUtils.isAsciiAlpha('0'));
        assertFalse(CharUtils.isAsciiAlpha(' '));
        assertFalse(CharUtils.isAsciiAlpha('\n'));
        assertFalse(CharUtils.isAsciiAlpha('\r'));
        assertFalse(CharUtils.isAsciiAlpha('\0'));
    }

    @Test
    void testIsAsciiAlphaUpper() {
        assertTrue(CharUtils.isAsciiAlpha('A'));
        assertTrue(CharUtils.isAsciiAlpha('Z'));
        assertFalse(CharUtils.isAsciiAlpha('0'));
        assertFalse(CharUtils.isAsciiAlpha(' '));
        assertFalse(CharUtils.isAsciiAlpha('\n'));
        assertFalse(CharUtils.isAsciiAlpha('\r'));
        assertFalse(CharUtils.isAsciiAlpha('\0'));
    }

    @ParameterizedTest
    @ValueSource(chars = {'a', 'A', 'z', 'Z'})
    void testIsAsciiAlpha(char ch) {
        assertTrue(CharUtils.isAsciiAlpha(ch));
    }

    @ParameterizedTest
    @ValueSource(chars = {'0', ' ', '\n', '\r', '\0'})
    void testIsNotAsciiAlpha(char ch) {
        assertFalse(CharUtils.isAsciiAlpha(ch));
    }
}