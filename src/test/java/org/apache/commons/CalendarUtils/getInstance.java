import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Locale;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class getInstanceTest {

    private CalendarUtils calendarUtils;

    @BeforeEach
    void setUp() {
        calendarUtils = CalendarUtils.getInstance();
    }

    @Test
    void testGetInstance() {
        assertNotNull(calendarUtils);
    }

    @Test
    void testGetInstanceWithLocale() {
        Locale locale = Locale.US;
        CalendarUtils calendarUtilsWithLocale = CalendarUtils.getInstance(locale);
        assertNotNull(calendarUtilsWithLocale);
        assertEquals(locale, calendarUtilsWithLocale.locale);
    }

    @Test
    void testGetInstanceWithNullLocale() {
        assertThrows(NullPointerException.class, () -> {
            CalendarUtils.getInstance(null);
        });
    }
}