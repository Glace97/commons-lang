import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(Lifecycle.PER_CLASS)
class getTimeInstanceTest {

    @Test
    void testGetTimeInstance() {
        FastDateFormat format;

        // Test with FULL style
        format = FastDateFormat.getTimeInstance(FastDateFormat.FULL);
        assertNotNull(format);
        Calendar calendar = Calendar.getInstance();
        String formattedDate = format.format(calendar);
        assertNotNull(formattedDate);

        // Test with LONG style
        format = FastDateFormat.getTimeInstance(FastDateFormat.LONG);
        assertNotNull(format);
        calendar = Calendar.getInstance();
        formattedDate = format.format(calendar);
        assertNotNull(formattedDate);

        // Test with MEDIUM style
        format = FastDateFormat.getTimeInstance(FastDateFormat.MEDIUM);
        assertNotNull(format);
        calendar = Calendar.getInstance();
        formattedDate = format.format(calendar);
        assertNotNull(formattedDate);

        // Test with SHORT style
        format = FastDateFormat.getTimeInstance(FastDateFormat.SHORT);
        assertNotNull(format);
        calendar = Calendar.getInstance();
        formattedDate = format.format(calendar);
        assertNotNull(formattedDate);

        // Test with specific TimeZone
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        format = FastDateFormat.getTimeInstance(FastDateFormat.MEDIUM, timeZone);
        assertNotNull(format);
        calendar = Calendar.getInstance(timeZone);
        formattedDate = format.format(calendar);
        assertNotNull(formattedDate);

        // Test with specific Locale
        Locale locale = Locale.FRANCE;
        format = FastDateFormat.getTimeInstance(FastDateFormat.MEDIUM, locale);
        assertNotNull(format);
        calendar = Calendar.getInstance(locale);
        formattedDate = format.format(calendar);
        assertNotNull(formattedDate);

        // Test with specific TimeZone and Locale
        timeZone = TimeZone.getTimeZone("GMT");
        locale = Locale.FRANCE;
        format = FastDateFormat.getTimeInstance(FastDateFormat.MEDIUM, timeZone, locale);
        assertNotNull(format);
        calendar = Calendar.getInstance(timeZone, locale);
        formattedDate = format.format(calendar);
        assertNotNull(formattedDate);
    }
}