import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;
import java.util.NoSuchElementException;

class RemoveTest {
    private CharRange charRange;

    @BeforeEach
    void setUp() {
        charRange = new CharRange('a', 'z', false);
    }

    @Test
    void testRemoveThrowsUnsupportedOperationException() {
        Iterator<Character> iterator = charRange.iterator();
        assertThrows(UnsupportedOperationException.class, iterator::remove);
    }
}