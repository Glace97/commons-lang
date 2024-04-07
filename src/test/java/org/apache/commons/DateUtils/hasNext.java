
import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class hasNextTest {

    private Calendar start;
    private Calendar end;
    private DateIterator dateIterator;

    @BeforeEach
    void setUp() {
        start = Calendar.getInstance();
        start.set(2022, Calendar.JANUARY, 1);
        
        end = Calendar.getInstance();
        end.set(2022, Calendar.FEBRUARY, 1);
        
        dateIterator = new DateIterator(start, end);
    }

    @Test
    void testHasNextBeforeIteration() {
        assertTrue(dateIterator.hasNext());
    }

    @Test
    void testHasNextAfterIteration() {
        while (dateIterator.hasNext()) {
            dateIterator.next();
        }
        assertFalse(dateIterator.hasNext());
    }

    @Test
    void testHasNextWithSingleDateRange() {
        start.set(2022, Calendar.JANUARY, 1);
        end.set(2022, Calendar.JANUARY, 1);
        dateIterator = new DateIterator(start, end);
        
        assertTrue(dateIterator.hasNext());
        dateIterator.next();
        assertFalse(dateIterator.hasNext());
    }

    @Test
    void testHasNextWithEmptyDateRange() {
        start.set(2022, Calendar.JANUARY, 1);
        end.set(2021, Calendar.DECEMBER, 31);
        dateIterator = new DateIterator(start, end);
        
        assertFalse(dateIterator.hasNext());
    }

    @Test
    void testHasNextWithNegativeDateRange() {
        start.set(2022, Calendar.JANUARY, 1);
        end.set(2021, Calendar.JANUARY, 1);
        dateIterator = new DateIterator(start, end);
        
        assertFalse(dateIterator.hasNext());
    }
    
    @Test
    void testHasNextWithSameStartAndEndDate() {
        start.set(2022, Calendar.JANUARY, 1);
        end.set(2022, Calendar.JANUARY, 1);
        dateIterator = new DateIterator(start, end);
        
        assertTrue(dateIterator.hasNext());
        dateIterator.next();
        assertFalse(dateIterator.hasNext());
    }
    
    @Test
    void testHasNextWithStartAfterEndDate() {
        start.set(2022, Calendar.FEBRUARY, 1);
        end.set(2022, Calendar.JANUARY, 1);
        dateIterator = new DateIterator(start, end);
        
        assertFalse(dateIterator.hasNext());
    }
}
