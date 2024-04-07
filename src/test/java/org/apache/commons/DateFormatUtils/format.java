
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import static org.junit.jupiter.api.Assertions.*;

class formatTest {

    @Test
    void format_CalendarPattern_ReturnFormattedCalendar() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.JANUARY, 1);
        String pattern = "yyyy-MM-dd";

        // Act
        String result = DateFormatUtils.format(calendar, pattern);

        // Assert
        assertEquals("2022-01-01", result);
    }

    @Test
    void format_CalendarPatternLocale_ReturnFormattedCalendar() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.JANUARY, 1);
        String pattern = "yyyy-MM-dd";
        Locale locale = Locale.US;

        // Act
        String result = DateFormatUtils.format(calendar, pattern, locale);

        // Assert
        assertEquals("2022-01-01", result);
    }

    @Test
    void format_CalendarPatternTimeZone_ReturnFormattedCalendar() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.JANUARY, 1);
        String pattern = "yyyy-MM-dd";
        TimeZone timeZone = TimeZone.getTimeZone("GMT");

        // Act
        String result = DateFormatUtils.format(calendar, pattern, timeZone);

        // Assert
        assertEquals("2022-01-01", result);
    }

    @Test
    void format_CalendarPatternTimeZoneLocale_ReturnFormattedCalendar() {
        // Arrange
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, Calendar.JANUARY, 1);
        String pattern = "yyyy-MM-dd";
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Locale locale = Locale.US;

        // Act
        String result = DateFormatUtils.format(calendar, pattern, timeZone, locale);

        // Assert
        assertEquals("2022-01-01", result);
    }

    @Test
    void format_DatePattern_ReturnFormattedDate() {
        // Arrange
        Date date = new Date(1640995200000L); // January 1, 2022
        String pattern = "yyyy-MM-dd";

        // Act
        String result = DateFormatUtils.format(date, pattern);

        // Assert
        assertEquals("2022-01-01", result);
    }

    @Test
    void format_DatePatternLocale_ReturnFormattedDate() {
        // Arrange
        Date date = new Date(1640995200000L); // January 1, 2022
        String pattern = "yyyy-MM-dd";
        Locale locale = Locale.US;

        // Act
        String result = DateFormatUtils.format(date, pattern, locale);

        // Assert
        assertEquals("2022-01-01", result);
    }

    @Test
    void format_DatePatternTimeZone_ReturnFormattedDate() {
        // Arrange
        Date date = new Date(1640995200000L); // January 1, 2022
        String pattern = "yyyy-MM-dd";
        TimeZone timeZone = TimeZone.getTimeZone("GMT");

        // Act
        String result = DateFormatUtils.format(date, pattern, timeZone);

        // Assert
        assertEquals("2022-01-01", result);
    }

    @Test
    void format_DatePatternTimeZoneLocale_ReturnFormattedDate() {
        // Arrange
        Date date = new Date(1640995200000L); // January 1, 2022
        String pattern = "yyyy-MM-dd";
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Locale locale = Locale.US;

        // Act
        String result = DateFormatUtils.format(date, pattern, timeZone, locale);

        // Assert
        assertEquals("2022-01-01", result);
    }

    @Test
    void format_LongPattern_ReturnFormattedDate() {
        // Arrange
        long millis = 1640995200000L; // January 1, 2022
        String pattern = "yyyy-MM-dd";

        // Act
        String result = DateFormatUtils.format(millis, pattern);

        // Assert
        assertEquals("2022-01-01", result);
    }

    @Test
    void format_LongPatternLocale_ReturnFormattedDate() {
        // Arrange
        long millis = 1640995200000L; // January 1, 2022
        String pattern = "yyyy-MM-dd";
        Locale locale = Locale.US;

        // Act
        String result = DateFormatUtils.format(millis, pattern, locale);

        // Assert
        assertEquals("2022-01-01", result);
    }

    @Test
    void format_LongPatternTimeZone_ReturnFormattedDate() {
        // Arrange
        long millis = 1640995200000L; // January 1, 2022
        String pattern = "yyyy-MM-dd";
        TimeZone timeZone = TimeZone.getTimeZone("GMT");

        // Act
        String result = DateFormatUtils.format(millis, pattern, timeZone);

        // Assert
        assertEquals("2022-01-01", result);
    }

    @Test
    void format_LongPatternTimeZoneLocale_ReturnFormattedDate() {
        // Arrange
        long millis = 1640995200000L; // January 1, 2022
        String pattern = "yyyy-MM-dd";
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        Locale locale = Locale.US;

        // Act
        String result = DateFormatUtils.format(millis, pattern, timeZone, locale);

        // Assert
        assertEquals("2022-01-01", result);
    }
}
