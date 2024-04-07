import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class containsAllWordsTest {

    @Test
    public void testContainsAllWords_NullWord_ReturnsFalse() {
        assertFalse(WordUtils.containsAllWords(null, "abc", "def"));
    }
    
    @Test
    public void testContainsAllWords_EmptyWord_ReturnsFalse() {
        assertFalse(WordUtils.containsAllWords("", "abc", "def"));
    }
    
    @Test
    public void testContainsAllWords_NullWordsArray_ReturnsFalse() {
        assertFalse(WordUtils.containsAllWords("abcd", null));
    }
    
    @Test
    public void testContainsAllWords_EmptyWordsArray_ReturnsFalse() {
        assertFalse(WordUtils.containsAllWords("abcd"));
    }
    
    @Test
    public void testContainsAllWords_NullWordInArray_ReturnsFalse() {
        assertFalse(WordUtils.containsAllWords("abcd", "abc", null));
    }
    
    @Test
    public void testContainsAllWords_WordNotContained_ReturnsFalse() {
        assertFalse(WordUtils.containsAllWords("abcd", "efg", "hij"));
    }
    
    @Test
    public void testContainsAllWords_WordContained_ReturnsTrue() {
        assertTrue(WordUtils.containsAllWords("abc def", "def", "abc"));
    }
    
    @Test
    public void testContainsAllWords_WordContainedMultipleTimes_ReturnsTrue() {
        assertTrue(WordUtils.containsAllWords("abc def abc", "def", "abc"));
    }
    
    @Test
    public void testContainsAllWords_WordContainedPartially_ReturnsFalse() {
        assertFalse(WordUtils.containsAllWords("abc de", "def", "abc"));
    }
}