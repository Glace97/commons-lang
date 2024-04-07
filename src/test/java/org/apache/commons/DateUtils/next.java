import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.Calendar;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class nextTest {

    @Test
    void testNext() {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        end.add(Calendar.DATE, 10);

        DateUtils.DateIterator iterator = new DateUtils.DateIterator(start, end);

        Assertions.assertTrue(iterator.hasNext());

        Calendar nextCalendar = iterator.next();
        start.add(Calendar.DATE, 1);

        Assertions.assertEquals(start, nextCalendar);
    }

    @Test
    void testNextWithEndDate() {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();

        DateUtils.DateIterator iterator = new DateUtils.DateIterator(start, end);

        Assertions.assertFalse(iterator.hasNext());

        Assertions.assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    void testRemove() {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        end.add(Calendar.DATE, 10);

        DateUtils.DateIterator iterator = new DateUtils.DateIterator(start, end);

        Assertions.assertThrows(UnsupportedOperationException.class, iterator::remove);
    }
}