
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class lastIndexOfTest {

    @Test
    void testLastIndexOf_String() {
        // Test with null parameters
        assertEquals(-1, CharSequenceUtils.lastIndexOf(null, null, 0));
        assertEquals(-1, CharSequenceUtils.lastIndexOf("", null, 0));
        assertEquals(-1, CharSequenceUtils.lastIndexOf(null, "", 0));

        // Test with empty strings
        assertEquals(0, CharSequenceUtils.lastIndexOf("", "", 0));
        assertEquals(-1, CharSequenceUtils.lastIndexOf("", "", 1));
        assertEquals(-1, CharSequenceUtils.lastIndexOf("", "abc", 0));

        // Test with start index out of range
        assertEquals(-1, CharSequenceUtils.lastIndexOf("abc", "a", 3));
        assertEquals(-1, CharSequenceUtils.lastIndexOf("abc", "a", -1));

        // Test with searchChar not found
        assertEquals(-1, CharSequenceUtils.lastIndexOf("abc", "d", 0));

        // Test with searchChar found at start index
        assertEquals(0, CharSequenceUtils.lastIndexOf("abc", "a", 0));
        assertEquals(1, CharSequenceUtils.lastIndexOf("abc", "b", 1));
        assertEquals(2, CharSequenceUtils.lastIndexOf("abc", "c", 2));

        // Test with searchChar found at different indices
        assertEquals(0, CharSequenceUtils.lastIndexOf("abcabc", "a", 5));
        assertEquals(3, CharSequenceUtils.lastIndexOf("abcabc", "b", 5));
        assertEquals(4, CharSequenceUtils.lastIndexOf("abcabc", "c", 5));

        // Test with searchChar not found after start index
        assertEquals(-1, CharSequenceUtils.lastIndexOf("abcabc", "a", 4));
        assertEquals(-1, CharSequenceUtils.lastIndexOf("abcabc", "b", 2));
        assertEquals(-1, CharSequenceUtils.lastIndexOf("abcabc", "c", 1));
    }

    @Test
    void testLastIndexOf_Char() {
        // Test with null parameter
        assertEquals(-1, CharSequenceUtils.lastIndexOf(null, 'a', 0));

        // Test with empty string
        assertEquals(-1, CharSequenceUtils.lastIndexOf("", 'a', 0));

        // Test with start index out of range
        assertEquals(-1, CharSequenceUtils.lastIndexOf("abc", 'a', 3));
        assertEquals(-1, CharSequenceUtils.lastIndexOf("abc", 'a', -1));

        // Test with searchChar not found
        assertEquals(-1, CharSequenceUtils.lastIndexOf("abc", 'd', 0));

        // Test with searchChar found at start index
        assertEquals(0, CharSequenceUtils.lastIndexOf("abc", 'a', 0));
        assertEquals(1, CharSequenceUtils.lastIndexOf("abc", 'b', 1));
        assertEquals(2, CharSequenceUtils.lastIndexOf("abc", 'c', 2));

        // Test with searchChar found at different indices
        assertEquals(0, CharSequenceUtils.lastIndexOf("abcabc", 'a', 5));
        assertEquals(3, CharSequenceUtils.lastIndexOf("abcabc", 'b', 5));
        assertEquals(4, CharSequenceUtils.lastIndexOf("abcabc", 'c', 5));

        // Test with searchChar not found after start index
        assertEquals(-1, CharSequenceUtils.lastIndexOf("abcabc", 'a', 4));
        assertEquals(-1, CharSequenceUtils.lastIndexOf("abcabc", 'b', 2));
        assertEquals(-1, CharSequenceUtils.lastIndexOf("abcabc", 'c', 1));
    }
}
