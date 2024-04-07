import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import java.util.Locale;

public class toStringAllTest {

    @Test
    public void testToStringAll() {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        Calendar calendar = new GregorianCalendar(2022, Calendar.JANUARY, 1);
        String expected = "CaseInsensitiveTextStrategy [field=1, locale=en_US, lKeyValues={}, pattern=()]";
        Assertions.assertEquals(expected, parser.toStringAll(calendar));
    }

    @Test
    public void testToStringAllWithTimeZone() {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        TimeZone timeZone = TimeZone.getTimeZone("America/New_York");
        Calendar calendar = new GregorianCalendar(2022, Calendar.JANUARY, 1);
        String expected = "TimeZoneStrategy [locale=en_US, tzNames={}, pattern=()]: TimeZone [ID=America/New_York, offset=-18000000, dstSavings=3600000, useDaylight=true, transitions=235]";
        Assertions.assertEquals(expected, parser.toStringAll(calendar, timeZone));
    }

    @Test
    public void testToStringAllWithLocale() {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        Locale locale = Locale.GERMANY;
        Calendar calendar = new GregorianCalendar(2022, Calendar.JANUARY, 1);
        String expected = "CaseInsensitiveTextStrategy [field=1, locale=de_DE, lKeyValues={}, pattern=()]";
        Assertions.assertEquals(expected, parser.toStringAll(calendar, locale));
    }

    @Test
    public void testToStringAllWithTimeZoneAndLocale() {
        FastDateParser parser = new FastDateParser("yyyy-MM-dd", TimeZone.getTimeZone("GMT"), Locale.US);
        TimeZone timeZone = TimeZone.getTimeZone("America/New_York");
        Locale locale = Locale.GERMANY;
        Calendar calendar = new GregorianCalendar(2022, Calendar.JANUARY, 1);
        String expected = "TimeZoneStrategy [locale=de_DE, tzNames={}, pattern=()]: TimeZone [ID=America/New_York, offset=-18000000, dstSavings=3600000, useDaylight=true, transitions=235]";
        Assertions.assertEquals(expected, parser.toStringAll(calendar, timeZone, locale));
    }
}