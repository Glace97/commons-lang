import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class nextTest {

    @Test
    void testNext() {
        CharRange range = new CharRange('a', 'e', false);
        CharRange.CharacterIterator iterator = range.new CharacterIterator(range);

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals('a', iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals('b', iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals('c', iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals('d', iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals('e', iterator.next());

        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    void testNext_NegatedRange() {
        CharRange range = new CharRange('a', 'e', true);
        CharRange.CharacterIterator iterator = range.new CharacterIterator(range);

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(0, iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(6, iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(7, iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(8, iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(9, iterator.next());

        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    void testNext_EmptyRange() {
        CharRange range = new CharRange('e', 'a', false);
        CharRange.CharacterIterator iterator = range.new CharacterIterator(range);

        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    void testNext_EmptyNegatedRange() {
        CharRange range = new CharRange('e', 'a', true);
        CharRange.CharacterIterator iterator = range.new CharacterIterator(range);

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(1, iterator.next());

        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    void testNext_SingleCharacterRange() {
        CharRange range = new CharRange('a', 'a', false);
        CharRange.CharacterIterator iterator = range.new CharacterIterator(range);

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals('a', iterator.next());

        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    void testNext_SingleCharacterNegatedRange() {
        CharRange range = new CharRange('a', 'a', true);
        CharRange.CharacterIterator iterator = range.new CharacterIterator(range);

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(0, iterator.next());

        Assertions.assertFalse(iterator.hasNext());
    }
}