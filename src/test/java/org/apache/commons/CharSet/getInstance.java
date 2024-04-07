import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.Serializable;

class getInstanceTest {

    @Test
    void testGetInstance_NullInput_ReturnNull() {
        CharSet charset = CharSet.getInstance(null);
        assertNull(charset);
    }

    @Test
    void testGetInstance_EmptyInput_ReturnEmptyCharSet() {
        CharSet charset = CharSet.getInstance("");
        assertNotNull(charset);
        // Check if the CharSet is empty
        assertEquals(0, charset.set.size());
    }

    @Test
    void testGetInstance_SingleChar_ReturnCharSetWithOneChar() {
        CharSet charset = CharSet.getInstance("a");
        assertNotNull(charset);
        // Check if the CharSet contains the specified character
        assertTrue(charset.set.contains(new CharRange('a', 'a')));
    }

    @Test
    void testGetInstance_MultiCharRange_ReturnCharSetWithRangeOfChars() {
        CharSet charset = CharSet.getInstance("a-e");
        assertNotNull(charset);
        // Check if the CharSet contains the specified range of characters
        assertTrue(charset.set.contains(new CharRange('a', 'e')));
    }

    @Test
    void testGetInstance_NegatedSingleChar_ReturnCharSetWithoutSpecifiedChar() {
        CharSet charset = CharSet.getInstance("^a");
        assertNotNull(charset);
        // Check if the CharSet does not contain the specified character
        assertFalse(charset.set.contains(new CharRange('a', 'a')));
    }

    @Test
    void testGetInstance_NegatedMultiCharRange_ReturnCharSetWithoutRangeOfChars() {
        CharSet charset = CharSet.getInstance("^a-e");
        assertNotNull(charset);
        // Check if the CharSet does not contain the specified range of characters
        assertFalse(charset.set.contains(new CharRange('a', 'e')));
    }

    @Test
    void testGetInstance_Combinations_ReturnCharSetWithCombinedChars() {
        CharSet charset = CharSet.getInstance("abe-g");
        assertNotNull(charset);
        // Check if the CharSet contains the specified combination of characters
        assertTrue(charset.set.contains(new CharRange('a', 'e')));
        assertTrue(charset.set.contains(new CharRange('g', 'g')));
    }

    @Test
    void testGetInstance_DuplicateRange_ReturnCharSetWithSingleRange() {
        CharSet charset = CharSet.getInstance("a-ca-c");
        assertNotNull(charset);
        // Check if the CharSet contains only one instance of the range
        assertEquals(1, charset.set.size());
        assertTrue(charset.set.contains(new CharRange('a', 'c')));
    }

    @Test
    void testGetInstance_RangeInWrongOrder_ReturnCharSetWithReversedRange() {
        CharSet charset = CharSet.getInstance("a-e");
        assertNotNull(charset);
        // Check if the CharSet contains the reversed range
        assertTrue(charset.set.contains(new CharRange('e', 'a')));
    }

    @Test
    void testGetInstance_NegationCharacterAsLastChar_ReturnCharSetWithNegatedRange() {
        CharSet charset = CharSet.getInstance("a-z^");
        assertNotNull(charset);
        // Check if the CharSet contains the negated range
        assertFalse(charset.set.contains(new CharRange('a', 'z')));
    }

    @Test
    void testGetInstance_NegationCharacterAsSeparateElement_ReturnCharSetWithNegatedRange() {
        CharSet charset = CharSet.getInstance("^", "a-z");
        assertNotNull(charset);
        // Check if the CharSet contains the negated range
        assertFalse(charset.set.contains(new CharRange('a', 'z')));
    }
}