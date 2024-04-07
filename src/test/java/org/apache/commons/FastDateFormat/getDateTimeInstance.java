import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getDateTimeInstanceTest {

    @Test
    void testGetDateTimeInstanceWithDefaultLocaleAndTimeZone() {
        FastDateFormat format = FastDateFormat.getDateTimeInstance(FastDateFormat.MEDIUM, FastDateFormat.SHORT);

        assertNotNull(format);
        assertEquals(FastDateFormat.MEDIUM, format.getDateStyle());
        assertEquals(FastDateFormat.SHORT, format.getTimeStyle());
        assertEquals(Locale.getDefault(), format.getLocale());
        assertEquals(TimeZone.getDefault(), format.getTimeZone());
    }

    @Test
    void testGetDateTimeInstanceWithCustomLocale() {
        Locale locale = new Locale("fr", "FR");
        FastDateFormat format = FastDateFormat.getDateTimeInstance(FastDateFormat.MEDIUM, FastDateFormat.SHORT, locale);

        assertNotNull(format);
        assertEquals(FastDateFormat.MEDIUM, format.getDateStyle());
        assertEquals(FastDateFormat.SHORT, format.getTimeStyle());
        assertEquals(locale, format.getLocale());
        assertEquals(TimeZone.getDefault(), format.getTimeZone());
    }

    @Test
    void testGetDateTimeInstanceWithCustomTimeZone() {
        TimeZone timeZone = TimeZone.getTimeZone("GMT+02:00");
        FastDateFormat format = FastDateFormat.getDateTimeInstance(FastDateFormat.MEDIUM, FastDateFormat.SHORT, timeZone);

        assertNotNull(format);
        assertEquals(FastDateFormat.MEDIUM, format.getDateStyle());
        assertEquals(FastDateFormat.SHORT, format.getTimeStyle());
        assertEquals(Locale.getDefault(), format.getLocale());
        assertEquals(timeZone, format.getTimeZone());
    }

    @Test
    void testGetDateTimeInstanceWithCustomLocaleAndTimeZone() {
        Locale locale = new Locale("fr", "FR");
        TimeZone timeZone = TimeZone.getTimeZone("GMT+02:00");
        FastDateFormat format = FastDateFormat.getDateTimeInstance(FastDateFormat.MEDIUM, FastDateFormat.SHORT, timeZone, locale);

        assertNotNull(format);
        assertEquals(FastDateFormat.MEDIUM, format.getDateStyle());
        assertEquals(FastDateFormat.SHORT, format.getTimeStyle());
        assertEquals(locale, format.getLocale());
        assertEquals(timeZone, format.getTimeZone());
    }

    @Test
    void testGetDateTimeInstanceWithInvalidDateStyle() {
        assertThrows(IllegalArgumentException.class, () ->
                FastDateFormat.getDateTimeInstance(10, FastDateFormat.SHORT));
    }

    @Test
    void testGetDateTimeInstanceWithInvalidTimeStyle() {
        assertThrows(IllegalArgumentException.class, () ->
                FastDateFormat.getDateTimeInstance(FastDateFormat.MEDIUM, 10));
    }
}