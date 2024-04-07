import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isSupportedTest {

    @Test
    void testIsSupported() {
        assertTrue(CharEncoding.isSupported("ISO-8859-1"));
        assertTrue(CharEncoding.isSupported("US-ASCII"));
        assertTrue(CharEncoding.isSupported("UTF-16"));
        assertTrue(CharEncoding.isSupported("UTF-16BE"));
        assertTrue(CharEncoding.isSupported("UTF-16LE"));
        assertTrue(CharEncoding.isSupported("UTF-8"));
        assertFalse(CharEncoding.isSupported(null));
        assertFalse(CharEncoding.isSupported("InvalidCharset"));
    }
}