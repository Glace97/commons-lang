
import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TruncateTest {

    private Calendar calendar;

    @BeforeEach
    void setUp() {
        calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, 2022);
        calendar.set(Calendar.MONTH, Calendar.MARCH);
        calendar.set(Calendar.DAY_OF_MONTH, 28);
        calendar.set(Calendar.HOUR_OF_DAY, 13);
        calendar.set(Calendar.MINUTE, 45);
        calendar.set(Calendar.SECOND, 1);
        calendar.set(Calendar.MILLISECOND, 231);
    }

    @Test
    void testTruncateWithYear() {
        Calendar truncated = DateUtils.truncate(calendar, Calendar.YEAR);

        assertEquals(2022, truncated.get(Calendar.YEAR));
        assertEquals(0, truncated.get(Calendar.MONTH));
        assertEquals(1, truncated.get(Calendar.DAY_OF_MONTH));
        assertEquals(0, truncated.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, truncated.get(Calendar.MINUTE));
        assertEquals(0, truncated.get(Calendar.SECOND));
        assertEquals(0, truncated.get(Calendar.MILLISECOND));
    }

    @Test
    void testTruncateWithMonth() {
        Calendar truncated = DateUtils.truncate(calendar, Calendar.MONTH);

        assertEquals(2022, truncated.get(Calendar.YEAR));
        assertEquals(Calendar.MARCH, truncated.get(Calendar.MONTH));
        assertEquals(1, truncated.get(Calendar.DAY_OF_MONTH));
        assertEquals(0, truncated.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, truncated.get(Calendar.MINUTE));
        assertEquals(0, truncated.get(Calendar.SECOND));
        assertEquals(0, truncated.get(Calendar.MILLISECOND));
    }

    @Test
    void testTruncateWithDayOfMonth() {
        Calendar truncated = DateUtils.truncate(calendar, Calendar.DAY_OF_MONTH);

        assertEquals(2022, truncated.get(Calendar.YEAR));
        assertEquals(Calendar.MARCH, truncated.get(Calendar.MONTH));
        assertEquals(28, truncated.get(Calendar.DAY_OF_MONTH));
        assertEquals(0, truncated.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, truncated.get(Calendar.MINUTE));
        assertEquals(0, truncated.get(Calendar.SECOND));
        assertEquals(0, truncated.get(Calendar.MILLISECOND));
    }

    @Test
    void testTruncateWithHourOfDay() {
        Calendar truncated = DateUtils.truncate(calendar, Calendar.HOUR_OF_DAY);

        assertEquals(2022, truncated.get(Calendar.YEAR));
        assertEquals(Calendar.MARCH, truncated.get(Calendar.MONTH));
        assertEquals(28, truncated.get(Calendar.DAY_OF_MONTH));
        assertEquals(13, truncated.get(Calendar.HOUR_OF_DAY));
        assertEquals(0, truncated.get(Calendar.MINUTE));
        assertEquals(0, truncated.get(Calendar.SECOND));
        assertEquals(0, truncated.get(Calendar.MILLISECOND));
    }

    @Test
    void testTruncateWithMinute() {
        Calendar truncated = DateUtils.truncate(calendar, Calendar.MINUTE);

        assertEquals(2022, truncated.get(Calendar.YEAR));
        assertEquals(Calendar.MARCH, truncated.get(Calendar.MONTH));
        assertEquals(28, truncated.get(Calendar.DAY_OF_MONTH));
        assertEquals(13, truncated.get(Calendar.HOUR_OF_DAY));
        assertEquals(45, truncated.get(Calendar.MINUTE));
        assertEquals(0, truncated.get(Calendar.SECOND));
        assertEquals(0, truncated.get(Calendar.MILLISECOND));
    }

    @Test
    void testTruncateWithSecond() {
        Calendar truncated = DateUtils.truncate(calendar, Calendar.SECOND);

        assertEquals(2022, truncated.get(Calendar.YEAR));
        assertEquals(Calendar.MARCH, truncated.get(Calendar.MONTH));
        assertEquals(28, truncated.get(Calendar.DAY_OF_MONTH));
        assertEquals(13, truncated.get(Calendar.HOUR_OF_DAY));
        assertEquals(45, truncated.get(Calendar.MINUTE));
        assertEquals(1, truncated.get(Calendar.SECOND));
        assertEquals(0, truncated.get(Calendar.MILLISECOND));
    }

    @Test
    void testTruncateWithMillisecond() {
        Calendar truncated = DateUtils.truncate(calendar, Calendar.MILLISECOND);

        assertEquals(2022, truncated.get(Calendar.YEAR));
        assertEquals(Calendar.MARCH, truncated.get(Calendar.MONTH));
        assertEquals(28, truncated.get(Calendar.DAY_OF_MONTH));
        assertEquals(13, truncated.get(Calendar.HOUR_OF_DAY));
        assertEquals(45, truncated.get(Calendar.MINUTE));
        assertEquals(1, truncated.get(Calendar.SECOND));
        assertEquals(231, truncated.get(Calendar.MILLISECOND));
    }

    @Test
    void testTruncateWithInvalidField() {
        assertThrows(IllegalArgumentException.class, () -> {
            DateUtils.truncate(calendar, Calendar.WEEK_OF_YEAR);
        });
    }

    @Test
    void testTruncateWithNullDate() {
        assertThrows(NullPointerException.class, () -> {
            DateUtils.truncate(null, Calendar.YEAR);
        });
    }
}
