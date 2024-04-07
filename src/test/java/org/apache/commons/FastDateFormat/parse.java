import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class parseTest {

    private FastDateFormat fastDateFormat;

    @BeforeEach
    public void setup() {
        fastDateFormat = new FastDateFormat("yyyy-MM-dd HH:mm:ss", TimeZone.getDefault(), Locale.getDefault());
    }

    @Test
    public void testParse_ValidDate_ReturnsDateObject() throws ParseException {
        String dateString = "2022-01-01 12:00:00";
        Date expectedDate = new GregorianCalendar(2022, Calendar.JANUARY, 1, 12, 0, 0).getTime();

        Date parsedDate = fastDateFormat.parse(dateString);

        Assertions.assertEquals(expectedDate, parsedDate);
    }

    @Test
    public void testParse_InvalidDate_ThrowsParseException() {
        String dateString = "2022-01-01 25:00:00";

        Assertions.assertThrows(ParseException.class, () -> fastDateFormat.parse(dateString));
    }

    @Test
    public void testParse_NullSource_ThrowsNullPointerException() {
        String dateString = null;

        Assertions.assertThrows(NullPointerException.class, () -> fastDateFormat.parse(dateString));
    }

    @Test
    public void testParse_PosParameter_ValidDate_ReturnsDateObject() {
        String dateString = "2022-01-01 12:00:00";
        Date expectedDate = new GregorianCalendar(2022, Calendar.JANUARY, 1, 12, 0, 0).getTime();
        ParsePosition pos = new ParsePosition(0);

        Date parsedDate = fastDateFormat.parse(dateString, pos);

        Assertions.assertEquals(expectedDate, parsedDate);
        Assertions.assertEquals(dateString.length(), pos.getIndex());
    }

    @Test
    public void testParse_PosParameter_InvalidDate_ReturnsNull() {
        String dateString = "2022-01-01 25:00:00";
        ParsePosition pos = new ParsePosition(0);

        Date parsedDate = fastDateFormat.parse(dateString, pos);

        Assertions.assertNull(parsedDate);
        Assertions.assertEquals(0, pos.getIndex());
    }

    @Test
    public void testParse_CalendarParameter_ValidDate_ReturnsTrue() {
        String dateString = "2022-01-01 12:00:00";
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(2022, Calendar.JANUARY, 1, 12, 0, 0);

        ParsePosition pos = new ParsePosition(0);
        boolean result = fastDateFormat.parse(dateString, pos, calendar);

        Assertions.assertTrue(result);
        Assertions.assertEquals(dateString.length(), pos.getIndex());
        Assertions.assertEquals(calendar.getTime(), fastDateFormat.parse(dateString));
    }

    @Test
    public void testParse_CalendarParameter_InvalidDate_ReturnsFalse() {
        String dateString = "2022-01-01 25:00:00";
        Calendar calendar = Calendar.getInstance();
        calendar.clear();

        ParsePosition pos = new ParsePosition(0);
        boolean result = fastDateFormat.parse(dateString, pos, calendar);

        Assertions.assertFalse(result);
        Assertions.assertEquals(0, pos.getIndex());
    }
}