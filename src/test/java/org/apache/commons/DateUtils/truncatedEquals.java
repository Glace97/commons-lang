import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class truncatedEqualsTest {

    @Test
    void testTruncatedEqualsShouldReturnTrueWhenDatesAreEqual() {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2021, Calendar.JANUARY, 1, 0, 0, 0);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2021, Calendar.JANUARY, 1, 12, 0, 0);
        assertTrue(DateUtils.truncatedEquals(cal1, cal2, Calendar.DATE));
    }

    @Test
    void testTruncatedEqualsShouldReturnFalseWhenDatesAreNotEqual() {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2021, Calendar.JANUARY, 1, 0, 0, 0);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2021, Calendar.JANUARY, 2, 0, 0, 0);
        assertFalse(DateUtils.truncatedEquals(cal1, cal2, Calendar.DATE));
    }

    @Test
    void testTruncatedEqualsShouldReturnTrueWhenDatesAreEqualUpToHour() {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2021, Calendar.JANUARY, 1, 12, 30, 0);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2021, Calendar.JANUARY, 1, 12, 45, 0);
        assertTrue(DateUtils.truncatedEquals(cal1, cal2, Calendar.HOUR_OF_DAY));
    }

    @Test
    void testTruncatedEqualsShouldReturnFalseWhenDatesAreNotEqualUpToHour() {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2021, Calendar.JANUARY, 1, 12, 0, 0);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2021, Calendar.JANUARY, 1, 13, 0, 0);
        assertFalse(DateUtils.truncatedEquals(cal1, cal2, Calendar.HOUR_OF_DAY));
    }

    @Test
    void testTruncatedEqualsShouldReturnTrueWhenDatesAreEqualUpToMonth() {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2021, Calendar.JANUARY, 1, 0, 0, 0);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2021, Calendar.JANUARY, 31, 23, 59, 59);
        assertTrue(DateUtils.truncatedEquals(cal1, cal2, Calendar.MONTH));
    }

    @Test
    void testTruncatedEqualsShouldReturnFalseWhenDatesAreNotEqualUpToMonth() {
        Calendar cal1 = Calendar.getInstance();
        cal1.set(2021, Calendar.JANUARY, 1, 0, 0, 0);
        Calendar cal2 = Calendar.getInstance();
        cal2.set(2021, Calendar.FEBRUARY, 1, 0, 0, 0);
        assertFalse(DateUtils.truncatedEquals(cal1, cal2, Calendar.MONTH));
    }
}