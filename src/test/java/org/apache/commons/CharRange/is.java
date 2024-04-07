import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class isTest {
    private CharRange charRange;

    @BeforeEach
    void setUp() {
        charRange = new CharRange('a', 'z', false);
    }

    @Test
    void testIs() {
        CharRange range = CharRange.is('a');
        assertEquals('a', range.start);
        assertEquals('a', range.end);
        assertFalse(range.negated);
    }

    @Test
    void testIsWithNegated() {
        CharRange range = CharRange.is('a').negated();
        assertEquals('a', range.start);
        assertEquals('a', range.end);
        assertTrue(range.negated);
    }

    @Test
    void testCharacterIterator() {
        CharRange range = CharRange.is('a');
        CharRange.CharacterIterator iterator = range.iterator();
        assertTrue(iterator.hasNext());
        assertEquals('a', iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testCharacterIteratorWithNegated() {
        CharRange range = CharRange.is('a').negated();
        CharRange.CharacterIterator iterator = range.iterator();
        assertTrue(iterator.hasNext());
        assertEquals('b', iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testCharacterIteratorWithEmptySet() {
        CharRange range = CharRange.is(Character.MAX_VALUE).negated();
        CharRange.CharacterIterator iterator = range.iterator();
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testCharacterIteratorWithEmptySetAndStartZero() {
        CharRange range = CharRange.is(0).negated();
        CharRange.CharacterIterator iterator = range.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(Character.MAX_VALUE, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testCharacterIteratorWithEmptySetAndEndMaxValue() {
        CharRange range = CharRange.is(Character.MAX_VALUE).negated();
        CharRange.CharacterIterator iterator = range.iterator();
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testCharacterIteratorWithEmptySetAndStartAndEndZero() {
        CharRange range = CharRange.is(0).negated();
        CharRange.CharacterIterator iterator = range.iterator();
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testCharacterIteratorWithRange() {
        CharRange range = CharRange.is('a').to('z');
        CharRange.CharacterIterator iterator = range.iterator();
        assertTrue(iterator.hasNext());
        assertEquals('a', iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals('b', iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals('z', iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testCharacterIteratorWithRangeAndNegated() {
        CharRange range = CharRange.is('a').to('z').negated();
        CharRange.CharacterIterator iterator = range.iterator();
        assertTrue(iterator.hasNext());
        assertEquals('A', iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals('B', iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Character.MAX_VALUE, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    void testToString() {
        CharRange range = CharRange.is('a');
        assertEquals("CharRange['a']", range.toString());
    }

    @Test
    void testToStringWithNegated() {
        CharRange range = CharRange.is('a').negated();
        assertEquals("CharRange['^a']", range.toString());
    }
}