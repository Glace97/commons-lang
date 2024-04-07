import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class APOS_UNESCAPETest {

    @Test
    void testAPOS_UNESCAPE() {
        // Test unescaping of single quote
        assertEquals("'", EntityArrays.APOS_UNESCAPE("&apos;"));
        assertEquals("'", EntityArrays.APOS_UNESCAPE("&#39;"));
        assertEquals("'", EntityArrays.APOS_UNESCAPE("&#x27;"));

        // Test unescaping of other characters
        assertEquals(">", EntityArrays.APOS_UNESCAPE("&gt;"));
        assertEquals("<", EntityArrays.APOS_UNESCAPE("&lt;"));
        assertEquals("&", EntityArrays.APOS_UNESCAPE("&amp;"));
        assertEquals("\"", EntityArrays.APOS_UNESCAPE("&quot;"));
    }
}