import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class containsTest {

    @Test
    void testContains() {
        CharRange range = new CharRange('a', 'e', false);
        Assertions.assertTrue(range.contains('a'));
        Assertions.assertTrue(range.contains('b'));
        Assertions.assertTrue(range.contains('c'));
        Assertions.assertTrue(range.contains('d'));
        Assertions.assertTrue(range.contains('e'));
        Assertions.assertFalse(range.contains('f'));
    }

    @Test
    void testContainsNegatedRange() {
        CharRange range = new CharRange('a', 'e', true);
        Assertions.assertFalse(range.contains('a'));
        Assertions.assertFalse(range.contains('b'));
        Assertions.assertFalse(range.contains('c'));
        Assertions.assertFalse(range.contains('d'));
        Assertions.assertFalse(range.contains('e'));
        Assertions.assertTrue(range.contains('f'));
    }

    @Test
    void testContainsEmptyRange() {
        CharRange range = new CharRange('a', 'a', false);
        Assertions.assertTrue(range.contains('a'));
        Assertions.assertFalse(range.contains('b'));
    }

    @Test
    void testContainsRange() {
        CharRange range1 = new CharRange('a', 'e', false);
        CharRange range2 = new CharRange('b', 'd', false);
        CharRange range3 = new CharRange('f', 'h', false);
        CharRange range4 = new CharRange('a', 'e', true);
        CharRange range5 = new CharRange('b', 'd', true);
        CharRange range6 = new CharRange('f', 'h', true);

        Assertions.assertTrue(range1.contains(range2));
        Assertions.assertFalse(range1.contains(range3));
        Assertions.assertFalse(range1.contains(range4));
        Assertions.assertFalse(range1.contains(range5));
        Assertions.assertTrue(range1.contains(range6));
    }

    @Test
    void testContainsNullRange() {
        CharRange range = new CharRange('a', 'e', false);
        Assertions.assertThrows(NullPointerException.class, () -> range.contains(null));
    }
}