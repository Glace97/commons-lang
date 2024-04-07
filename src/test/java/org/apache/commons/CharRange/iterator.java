import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Iterator;
import java.util.NoSuchElementException;

class IteratorTest {

    private CharRange charRange;
    private Iterator<Character> iterator;

    @BeforeEach
    void setUp() {
        charRange = new CharRange('A', 'Z', false);
        iterator = charRange.iterator();
    }

    @Test
    void testHasNext() {
        assertTrue(iterator.hasNext());
    }

    @Test
    void testNext() {
        assertEquals('A', iterator.next());
        assertEquals('B', iterator.next());
        assertEquals('C', iterator.next());
    }

    @Test
    void testNextThrowsNoSuchElementException() {
        while (iterator.hasNext()) {
            iterator.next();
        }
        assertThrows(NoSuchElementException.class, () -> iterator.next());
    }

    @Test
    void testRemoveThrowsUnsupportedOperationException() {
        assertThrows(UnsupportedOperationException.class, () -> iterator.remove());
    }
}