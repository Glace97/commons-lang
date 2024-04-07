import org.junit.jupiter.api.*;
import java.util.Calendar;
import java.util.Iterator;
import java.util.NoSuchElementException;

class IteratorTest {
    private Calendar start;
    private Calendar end;

    @BeforeEach
    void setUp() {
        start = Calendar.getInstance();
        start.set(2021, Calendar.JANUARY, 1);
        end = Calendar.getInstance();
        end.set(2021, Calendar.JANUARY, 31);
    }

    @Test
    void testHasNext() {
        Iterator<Calendar> iterator = new DateUtils.DateIterator(start, end);
        while (iterator.hasNext()) {
            iterator.next();
        }
        Assertions.assertFalse(iterator.hasNext());
    }

    @Test
    void testNext() {
        Iterator<Calendar> iterator = new DateUtils.DateIterator(start, end);
        for (int i = 1; i <= 31; i++) {
            Calendar expected = Calendar.getInstance();
            expected.set(2021, Calendar.JANUARY, i);
            Calendar actual = iterator.next();
            Assertions.assertEquals(expected, actual);
        }
    }

    @Test
    void testNextNoSuchElementException() {
        Iterator<Calendar> iterator = new DateUtils.DateIterator(start, start);
        Assertions.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testRemoveUnsupportedOperationException() {
        Iterator<Calendar> iterator = new DateUtils.DateIterator(start, end);
        Assertions.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }
}