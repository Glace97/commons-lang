import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isAsciiPrintableTest {

    @Test
    void testIsAsciiPrintable() {
        // Test for printable characters
        assertTrue(CharUtils.isAsciiPrintable('a'));
        assertTrue(CharUtils.isAsciiPrintable('A'));
        assertTrue(CharUtils.isAsciiPrintable('3'));
        assertTrue(CharUtils.isAsciiPrintable('-'));

        // Test for non-printable characters
        assertFalse(CharUtils.isAsciiPrintable('\n'));
        assertFalse(CharUtils.isAsciiPrintable('\r'));
        assertFalse(CharUtils.isAsciiPrintable('\0'));
    }
}