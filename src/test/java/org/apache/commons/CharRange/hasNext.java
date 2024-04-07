import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class hasNextTest {

    @Test
    void testHasNextWithEmptyRange() {
        CharRange range = new CharRange('a', 'a', false);
        CharRange.CharacterIterator iterator = range.iterator();
        
        boolean result = iterator.hasNext();
        
        assertFalse(result);
    }
    
    @Test
    void testHasNextWithSingleCharacterRange() {
        CharRange range = new CharRange('a', 'a', true);
        CharRange.CharacterIterator iterator = range.iterator();
        
        boolean result = iterator.hasNext();
        
        assertFalse(result);
    }
    
    @Test
    void testHasNextWithNegatedRange() {
        CharRange range = new CharRange('a', 'z', true);
        CharRange.CharacterIterator iterator = range.iterator();
        
        boolean result = iterator.hasNext();
        
        assertTrue(result);
    }
    
    @Test
    void testHasNextWithValidRange() {
        CharRange range = new CharRange('a', 'z', false);
        CharRange.CharacterIterator iterator = range.iterator();
        
        boolean result = iterator.hasNext();
        
        assertTrue(result);
    }
    
    @Test
    void testHasNextWithMaxCharacterRange() {
        CharRange range = new CharRange(Character.MIN_VALUE, Character.MAX_VALUE, false);
        CharRange.CharacterIterator iterator = range.iterator();
        
        boolean result = iterator.hasNext();
        
        assertTrue(result);
    }
    
    @Test
    void testHasNextAfterIteratingThroughRange() {
        CharRange range = new CharRange('a', 'z', false);
        CharRange.CharacterIterator iterator = range.iterator();
        
        while (iterator.hasNext()) {
            iterator.next();
        }
        
        boolean result = iterator.hasNext();
        
        assertFalse(result);
    }

    @Test
    void testHasNextThrowsNoSuchElementException() {
        CharRange range = new CharRange('a', 'a', false);
        CharRange.CharacterIterator iterator = range.iterator();
        
        assertThrows(NoSuchElementException.class, iterator::next);
    }
}