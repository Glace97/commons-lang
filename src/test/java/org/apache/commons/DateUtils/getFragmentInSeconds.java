import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

class getFragmentInSecondsTest {

    private Calendar calendar;
    private Date date;

    @BeforeEach
    void setUp() {
        calendar = Calendar.getInstance();
        date = new Date();
    }

    @Test
    void testGetFragmentInSeconds_WithYearFragment_ShouldReturnZero() {
        long result = DateUtils.getFragmentInSeconds(calendar, Calendar.YEAR);
        assertEquals(0, result);
    }

    @Test
    void testGetFragmentInSeconds_WithMonthFragment_ShouldReturnZero() {
        long result = DateUtils.getFragmentInSeconds(calendar, Calendar.MONTH);
        assertEquals(0, result);
    }

    @Test
    void testGetFragmentInSeconds_WithDayOfYearFragment_ShouldReturnZero() {
        long result = DateUtils.getFragmentInSeconds(calendar, Calendar.DAY_OF_YEAR);
        assertEquals(0, result);
    }

    @Test
    void testGetFragmentInSeconds_WithDateFragment_ShouldReturnZero() {
        long result = DateUtils.getFragmentInSeconds(calendar, Calendar.DATE);
        assertEquals(0, result);
    }

    @Test
    void testGetFragmentInSeconds_WithHourOfDayFragment_ShouldReturnZero() {
        long result = DateUtils.getFragmentInSeconds(calendar, Calendar.HOUR_OF_DAY);
        assertEquals(0, result);
    }

    @Test
    void testGetFragmentInSeconds_WithMinuteFragment_ShouldReturnZero() {
        long result = DateUtils.getFragmentInSeconds(calendar, Calendar.MINUTE);
        assertEquals(0, result);
    }

    @Test
    void testGetFragmentInSeconds_WithSecondFragment_ShouldReturnCurrentSecond() {
        long expected = calendar.get(Calendar.SECOND);
        long result = DateUtils.getFragmentInSeconds(calendar, Calendar.SECOND);
        assertEquals(expected, result);
    }

    @Test
    void testGetFragmentInSeconds_WithMillisecondFragment_ShouldReturnZero() {
        long result = DateUtils.getFragmentInSeconds(calendar, Calendar.MILLISECOND);
        assertEquals(0, result);
    }

    @Test
    void testGetFragmentInSeconds_WithInvalidFragment_ShouldThrowException() {
        assertThrows(IllegalArgumentException.class, () -> {
            DateUtils.getFragmentInSeconds(calendar, Calendar.ERA);
        });
    }

    @Test
    void testGetFragmentInSeconds_WithNullCalendar_ShouldThrowException() {
        assertThrows(NullPointerException.class, () -> {
            DateUtils.getFragmentInSeconds(null, Calendar.SECOND);
        });
    }

    @Test
    void testGetFragmentInSeconds_WithNullDate_ShouldThrowException() {
        assertThrows(NullPointerException.class, () -> {
            DateUtils.getFragmentInSeconds(null, Calendar.SECOND);
        });
    }
}