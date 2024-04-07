import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.NoSuchElementException;

class isNotTest {

    @Test
    @DisplayName("Test hasNext when range is negated and start=0 and end=MAX_VALUE")
    void testHasNextNegatedRangeStartZeroEndMaxValue() {
        CharRange range = new CharRange((char) 0, Character.MAX_VALUE, true);
        CharRange.CharacterIterator iterator = range.iterator();
        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    @DisplayName("Test hasNext when range is negated and start=0 and end=start-1")
    void testHasNextNegatedRangeStartZeroEndStartMinusOne() {
        CharRange range = new CharRange((char) 0, (char) (0 - 1), true);
        CharRange.CharacterIterator iterator = range.iterator();
        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    @DisplayName("Test hasNext when range is negated and start=0 and end=start+1")
    void testHasNextNegatedRangeStartZeroEndStartPlusOne() {
        CharRange range = new CharRange((char) 0, (char) (0 + 1), true);
        CharRange.CharacterIterator iterator = range.iterator();
        Assertions.assertTrue(iterator.hasNext());
    }

    @Test
    @DisplayName("Test hasNext when range is not negated and start=end")
    void testHasNextNotNegatedRangeStartEnd() {
        CharRange range = new CharRange('a', 'a', false);
        CharRange.CharacterIterator iterator = range.iterator();
        Assertions.assertTrue(iterator.hasNext());
    }

    @Test
    @DisplayName("Test hasNext when range is not negated and start<end")
    void testHasNextNotNegatedRangeStartLessThanEnd() {
        CharRange range = new CharRange('a', 'b', false);
        CharRange.CharacterIterator iterator = range.iterator();
        Assertions.assertTrue(iterator.hasNext());
    }

    @Test
    @DisplayName("Test hasNext when range is not negated and start>end")
    void testHasNextNotNegatedRangeStartGreaterThanEnd() {
        CharRange range = new CharRange('b', 'a', false);
        CharRange.CharacterIterator iterator = range.iterator();
        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    @DisplayName("Test next when hasNext is false")
    void testNextHasNextFalse() {
        CharRange range = new CharRange('a', 'a', false);
        CharRange.CharacterIterator iterator = range.iterator();
        Assertions.assertFalse(iterator.hasNext());
        Assertions.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    @DisplayName("Test next when hasNext is true")
    void testNextHasNextTrue() {
        CharRange range = new CharRange('a', 'b', false);
        CharRange.CharacterIterator iterator = range.iterator();
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals('a', iterator.next());
    }

    @Test
    @DisplayName("Test remove")
    void testRemove() {
        CharRange range = new CharRange('a', 'b', false);
        CharRange.CharacterIterator iterator = range.iterator();
        Assertions.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }
}