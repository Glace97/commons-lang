
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexOfAnyTest {

    private StringUtils stringUtils;

    @BeforeEach
    void setUp() {
        stringUtils = new StringUtils();
    }

    @Test
    void testIndexOfAny_NullCharSequence() {
        int result = stringUtils.indexOfAny(null, 'a', 'b', 'c');
        assertEquals(-1, result);
    }

    @Test
    void testIndexOfAny_NullSearchChars() {
        int result = stringUtils.indexOfAny("abc", (char[]) null);
        assertEquals(-1, result);
    }

    @Test
    void testIndexOfAny_EmptyCharSequence() {
        int result = stringUtils.indexOfAny("", 'a', 'b', 'c');
        assertEquals(-1, result);
    }

    @Test
    void testIndexOfAny_EmptySearchChars() {
        int result = stringUtils.indexOfAny("abc", new char[0]);
        assertEquals(-1, result);
    }

    @Test
    void testIndexOfAny_NoMatch() {
        int result = stringUtils.indexOfAny("abc", 'd', 'e', 'f');
        assertEquals(-1, result);
    }

    @Test
    void testIndexOfAny_SingleMatch() {
        int result = stringUtils.indexOfAny("abc", 'a', 'b', 'c');
        assertEquals(0, result);
    }

    @Test
    void testIndexOfAny_MultipleMatches() {
        int result = stringUtils.indexOfAny("abc", 'a', 'b', 'c', 'b');
        assertEquals(1, result);
    }

    @Test
    void testIndexOfAny_HighSurrogateMatch() {
        int result = stringUtils.indexOfAny("\uD83D\uDE00\uD83D\uDE01", '😀', '😁');
        assertEquals(0, result);
    }

    @Test
    void testIndexOfAny_HighSurrogateNoMatch() {
        int result = stringUtils.indexOfAny("\uD83D\uDE00\uD83D\uDE01", '😂', '😃');
        assertEquals(-1, result);
    }

    @Test
    void testIndexOfAny_NullCharSequenceArray() {
        int result = stringUtils.indexOfAny(null, (CharSequence[]) null);
        assertEquals(-1, result);
    }

    @Test
    void testIndexOfAny_NullSearchStrs() {
        int result = stringUtils.indexOfAny("abc", (CharSequence) null);
        assertEquals(-1, result);
    }

    @Test
    void testIndexOfAny_EmptyCharSequenceArray() {
        int result = stringUtils.indexOfAny("", new CharSequence[0]);
        assertEquals(-1, result);
    }

    @Test
    void testIndexOfAny_EmptySearchStrs() {
        int result = stringUtils.indexOfAny("abc", "");
        assertEquals(-1, result);
    }

    @Test
    void testIndexOfAny_NoMatchInArray() {
        int result = stringUtils.indexOfAny("abc", "def", "ghi");
        assertEquals(-1, result);
    }

    @Test
    void testIndexOfAny_SingleMatchInArray() {
        int result = stringUtils.indexOfAny("abc", "def", "a", "ghi");
        assertEquals(0, result);
    }

    @Test
    void testIndexOfAny_MultipleMatchesInArray() {
        int result = stringUtils.indexOfAny("abc", "def", "a", "ghi", "b");
        assertEquals(1, result);
    }

    @Test
    void testIndexOfAny_NullCharSequenceString() {
        int result = stringUtils.indexOfAny(null, (String) null);
        assertEquals(-1, result);
    }

    @Test
    void testIndexOfAny_NullSearchCharsString() {
        int result = stringUtils.indexOfAny("abc", (String) null);
        assertEquals(-1, result);
    }

    @Test
    void testIndexOfAny_EmptyCharSequenceString() {
        int result = stringUtils.indexOfAny("", "");
        assertEquals(-1, result);
    }

    @Test
    void testIndexOfAny_EmptySearchCharsString() {
        int result = stringUtils.indexOfAny("abc", "");
        assertEquals(-1, result);
    }

    @Test
    void testIndexOfAny_NoMatchString() {
        int result = stringUtils.indexOfAny("abc", "def");
        assertEquals(-1, result);
    }

    @Test
    void testIndexOfAny_SingleMatchString() {
        int result = stringUtils.indexOfAny("abc", "def", "a");
        assertEquals(0, result);
    }

    @Test
    void testIndexOfAny_MultipleMatchesString() {
        int result = stringUtils.indexOfAny("abc", "def", "a", "b");
        assertEquals(1, result);
    }
}
