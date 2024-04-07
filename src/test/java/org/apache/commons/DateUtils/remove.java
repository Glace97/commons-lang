import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;
import java.util.Date;

class removeTest {

    @Test
    void testRemove() {
        // Test removing a single date
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        end.add(Calendar.DATE, 1);
        DateUtils.DateIterator iterator = new DateUtils.DateIterator(start, end);
        iterator.next();
        iterator.remove();
        assertFalse(iterator.hasNext());

        // Test removing multiple dates
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        end.add(Calendar.DATE, 5);
        iterator = new DateUtils.DateIterator(start, end);
        iterator.next();
        iterator.next();
        iterator.remove();
        iterator.next();
        iterator.next();
        iterator.remove();
        assertFalse(iterator.hasNext());

        // Test removing all dates
        start = Calendar.getInstance();
        end = Calendar.getInstance();
        end.add(Calendar.DATE, 3);
        iterator = new DateUtils.DateIterator(start, end);
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        assertFalse(iterator.hasNext());
    }

    @Test
    void testRemoveThrowsException() {
        Calendar start = Calendar.getInstance();
        Calendar end = Calendar.getInstance();
        end.add(Calendar.DATE, 1);
        DateUtils.DateIterator iterator = new DateUtils.DateIterator(start, end);
        assertThrows(UnsupportedOperationException.class, iterator::remove);
    }
}