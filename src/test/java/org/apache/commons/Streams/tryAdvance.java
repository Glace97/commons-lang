import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class tryAdvanceTest {

    Enumeration<Integer> enumeration;
    Streams.EnumerationSpliterator<Integer> spliterator;
    List<Integer> list;

    @BeforeEach
    void setup() {
        enumeration = Collections.enumeration(Arrays.asList(1, 2, 3, 4, 5));
        spliterator = new Streams.EnumerationSpliterator<>(5, 0, enumeration);
        list = new ArrayList<>();
    }

    @Test
    void tryAdvance_shouldConsumeNextElement_whenEnumerationHasMoreElements() {
        assertTrue(spliterator.tryAdvance(list::add));
        assertEquals(1, list.get(0));
    }

    @Test
    void tryAdvance_shouldNotConsumeNextElement_whenEnumerationDoesNotHaveMoreElements() {
        spliterator.tryAdvance(list::add);
        spliterator.tryAdvance(list::add);
        spliterator.tryAdvance(list::add);
        spliterator.tryAdvance(list::add);
        spliterator.tryAdvance(list::add);
        assertFalse(spliterator.tryAdvance(list::add));
        assertEquals(5, list.size());
    }

    @Test
    void tryAdvance_shouldReturnTrue_whenEnumerationHasMoreElements() {
        assertTrue(spliterator.tryAdvance(list::add));
    }

    @Test
    void tryAdvance_shouldReturnFalse_whenEnumerationDoesNotHaveMoreElements() {
        spliterator.tryAdvance(list::add);
        spliterator.tryAdvance(list::add);
        spliterator.tryAdvance(list::add);
        spliterator.tryAdvance(list::add);
        spliterator.tryAdvance(list::add);
        assertFalse(spliterator.tryAdvance(list::add));
    }
}