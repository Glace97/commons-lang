import org.junit.jupiter.api.Test;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import static org.junit.jupiter.api.Assertions.*;

class formatTest {

    @Test
    void testFormatCalendar() {
        // Test formatting a Calendar object
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.JANUARY, 1); // January 1, 2022
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd", TimeZone.getDefault(), Locale.getDefault());
        String formattedDate = fastDateFormat.format(calendar);
        assertEquals("2022-01-01", formattedDate);
    }

    @Test
    void testFormatDate() {
        // Test formatting a Date object
        Date date = new Date();
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd HH:mm:ss", TimeZone.getDefault(), Locale.getDefault());
        String formattedDate = fastDateFormat.format(date);
        assertNotNull(formattedDate);
    }

    @Test
    void testFormatLong() {
        // Test formatting a millisecond long value
        long millis = System.currentTimeMillis();
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd HH:mm:ss", TimeZone.getDefault(), Locale.getDefault());
        String formattedDate = fastDateFormat.format(millis);
        assertNotNull(formattedDate);
    }

    @Test
    void testFormatObject() {
        // Test formatting a Date object using Format#format(Object, StringBuffer, FieldPosition)
        Date date = new Date();
        FastDateFormat fastDateFormat = new FastDateFormat("yyyy-MM-dd HH:mm:ss", TimeZone.getDefault(), Locale.getDefault());
        StringBuffer stringBuffer = new StringBuffer();
        fastDateFormat.format(date, stringBuffer, null);
        assertNotNull(stringBuffer.toString());
    }
}