import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class removePatternTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    void testRemovePattern_nullSourceString() {
        assertNull(stringUtils.removePattern(null, "regex"));
    }

    @Test
    void testRemovePattern_nullRegex() {
        assertEquals("source", stringUtils.removePattern("source", null));
    }

    @Test
    void testRemovePattern_emptySourceString() {
        assertEquals("", stringUtils.removePattern("", "regex"));
    }

    @Test
    void testRemovePattern_emptyRegex() {
        assertEquals("source", stringUtils.removePattern("source", ""));
    }

    @Test
    void testRemovePattern_noMatch() {
        assertEquals("source", stringUtils.removePattern("source", "regex"));
    }

    @Test
    void testRemovePattern_singleMatchAtBeginning() {
        assertEquals("B", stringUtils.removePattern("A<__>\n<__>B", "<.*>"));
    }

    @Test
    void testRemovePattern_singleMatchAtEnd() {
        assertEquals("A", stringUtils.removePattern("A<__>\n<__>B", "<.*>B"));
    }

    @Test
    void testRemovePattern_singleMatchInMiddle() {
        assertEquals("AB", stringUtils.removePattern("A<__>\n<__>B", "<.*>"));
    }

    @Test
    void testRemovePattern_multipleMatches() {
        assertEquals("ABC123", stringUtils.removePattern("ABCabc123", "[a-z]"));
    }

    @Test
    void testRemovePattern_unicodeCharacters() {
        assertEquals("o", stringUtils.removePattern("héllö", "[a-zäüö]"));
    }
}