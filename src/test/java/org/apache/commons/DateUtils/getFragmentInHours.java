import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

class getFragmentInHoursTest {

    private DateUtils dateUtils;

    @BeforeEach
    void setup() {
        MockitoAnnotations.initMocks(this);
        dateUtils = new DateUtils();
    }

    @Test
    void testGetFragmentInHoursWithValidCalendarFragment() {
        Calendar calendar = new GregorianCalendar();
        calendar.set(Calendar.YEAR, 2022);
        calendar.set(Calendar.MONTH, Calendar.JANUARY);
        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.HOUR_OF_DAY, 7);
        calendar.set(Calendar.MINUTE, 15);
        calendar.set(Calendar.SECOND, 10);
        calendar.set(Calendar.MILLISECOND, 538);

        long fragmentInHours = dateUtils.getFragmentInHours(calendar, Calendar.DAY_OF_YEAR);

        assertEquals(7, fragmentInHours);
    }

    @Test
    void testGetFragmentInHoursWithValidDateFragment() {
        Date date = new Date(122, Calendar.JANUARY, 1, 7, 15, 10);

        long fragmentInHours = dateUtils.getFragmentInHours(date, Calendar.DAY_OF_YEAR);

        assertEquals(7, fragmentInHours);
    }

    @Test
    void testGetFragmentInHoursWithInvalidFragment() {
        Calendar calendar = new GregorianCalendar();

        assertThrows(IllegalArgumentException.class, () -> {
            dateUtils.getFragmentInHours(calendar, Calendar.WEEK_OF_YEAR);
        });
    }

    @Test
    void testGetFragmentInHoursWithNullCalendar() {
        assertThrows(NullPointerException.class, () -> {
            dateUtils.getFragmentInHours(null, Calendar.DAY_OF_YEAR);
        });
    }

    @Test
    void testGetFragmentInHoursWithNullDate() {
        assertThrows(NullPointerException.class, () -> {
            dateUtils.getFragmentInHours((Date) null, Calendar.DAY_OF_YEAR);
        });
    }

    @Test
    void testGetFragmentInHoursWithMockedCalendar() {
        Calendar calendar = mock(Calendar.class);
        when(calendar.get(Calendar.YEAR)).thenReturn(2022);
        when(calendar.get(Calendar.MONTH)).thenReturn(Calendar.JANUARY);
        when(calendar.get(Calendar.DAY_OF_MONTH)).thenReturn(1);
        when(calendar.get(Calendar.HOUR_OF_DAY)).thenReturn(7);
        when(calendar.get(Calendar.MINUTE)).thenReturn(15);
        when(calendar.get(Calendar.SECOND)).thenReturn(10);
        when(calendar.get(Calendar.MILLISECOND)).thenReturn(538);

        long fragmentInHours = dateUtils.getFragmentInHours(calendar, Calendar.DAY_OF_YEAR);

        assertEquals(7, fragmentInHours);
    }
}