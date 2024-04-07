import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AddTest {
    private CharSet charSet;

    @BeforeEach
    void setUp() {
        charSet = new CharSet();
    }

    @Test
    void testAddNull() {
        charSet.add(null);
        // Assert that no changes are made to the CharSet
        assertEquals(0, charSet.set.size());
    }

    @Test
    void testAddEmptyString() {
        charSet.add("");
        // Assert that no changes are made to the CharSet
        assertEquals(0, charSet.set.size());
    }

    @Test
    void testAddSingleChar() {
        charSet.add("a");
        // Assert that a single CharRange is added to the CharSet
        assertEquals(1, charSet.set.size());
        assertTrue(charSet.set.contains(CharRange.is('a')));
    }

    @Test
    void testAddCharRange() {
        charSet.add("a-z");
        // Assert that a CharRange representing the range 'a' to 'z' is added to the CharSet
        assertEquals(1, charSet.set.size());
        assertTrue(charSet.set.contains(CharRange.isIn('a', 'z')));
    }

    @Test
    void testAddNegatedCharRange() {
        charSet.add("^a-z");
        // Assert that a CharRange representing the negated range 'a' to 'z' is added to the CharSet
        assertEquals(1, charSet.set.size());
        assertTrue(charSet.set.contains(CharRange.isNotIn('a', 'z')));
    }

    @Test
    void testAddNegatedChar() {
        charSet.add("^a");
        // Assert that a CharRange representing the negated character 'a' is added to the CharSet
        assertEquals(1, charSet.set.size());
        assertTrue(charSet.set.contains(CharRange.isNot('a')));
    }

    @Test
    void testMultipleAdditions() {
        charSet.add("a-z");
        charSet.add("^b-d");
        charSet.add("e");
        // Assert that the CharSet contains all the added CharRanges
        assertEquals(3, charSet.set.size());
        assertTrue(charSet.set.contains(CharRange.isIn('a', 'z')));
        assertTrue(charSet.set.contains(CharRange.isNotIn('b', 'd')));
        assertTrue(charSet.set.contains(CharRange.is('e')));
    }
}