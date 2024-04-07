
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class RemoveFirstTest {
    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    void testRemoveFirst_NullText() {
        String result = stringUtils.removeFirst(null, "regex");
        assertNull(result);
    }

    @Test
    void testRemoveFirst_NullRegex() {
        String result = stringUtils.removeFirst("text", null);
        assertEquals("text", result);
    }

    @Test
    void testRemoveFirst_EmptyText() {
        String result = stringUtils.removeFirst("", "regex");
        assertEquals("", result);
    }

    @Test
    void testRemoveFirst_EmptyRegex() {
        String result = stringUtils.removeFirst("text", "");
        assertEquals("text", result);
    }

    @Test
    void testRemoveFirst_NoMatch() {
        String result = stringUtils.removeFirst("text", "regex");
        assertEquals("text", result);
    }

    @Test
    void testRemoveFirst_MatchAtStart() {
        String result = stringUtils.removeFirst("text", "t");
        assertEquals("ext", result);
    }

    @Test
    void testRemoveFirst_MatchInMiddle() {
        String result = stringUtils.removeFirst("text", "e");
        assertEquals("txt", result);
    }

    @Test
    void testRemoveFirst_MatchAtEnd() {
        String result = stringUtils.removeFirst("text", "t");
        assertEquals("ex", result);
    }

    @Test
    void testRemoveFirst_MatchMultipleTimes() {
        String result = stringUtils.removeFirst("text", "t");
        assertEquals("ex", result);
    }

    @Test
    void testRemoveFirst_MatchWithSpecialCharacters() {
        String result = stringUtils.removeFirst("A<__>\n<__>B", "<.*>");
        assertEquals("A\n<__>B", result);
    }

    @Test
    void testRemoveFirst_MatchWithSingleLineMode() {
        String result = stringUtils.removeFirst("A<__>\n<__>B", "(?s)<.*>");
        assertEquals("AB", result);
    }

    @Test
    void testRemoveFirst_MatchWithCharacterClass() {
        String result = stringUtils.removeFirst("ABCabc123", "[a-z]");
        assertEquals("ABCbc123", result);
    }

    @Test
    void testRemoveFirst_MatchWithQuantifier() {
        String result = stringUtils.removeFirst("ABCabc123abc", "[a-z]+");
        assertEquals("ABC123abc", result);
    }
}
