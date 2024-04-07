
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("formatUTC Test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class formatUTCTest {

    private DateFormatUtils dateFormatUtils;

    @BeforeAll
    void setUp() {
        dateFormatUtils = new DateFormatUtils();
    }

    @Nested
    @DisplayName("formatUTC(Date, pattern)")
    class FormatUTCDatePatternTest {

        @Test
        @DisplayName("Should return formatted date using UTC timezone and default locale")
        void shouldReturnFormattedDateWithUtcTimeZoneAndDefaultLocale() throws ParseException {
            // Arrange
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = sdf.parse("2022-01-01T12:00:00");
            String expected = "2022-01-01T12:00:00";

            // Act
            String result = dateFormatUtils.formatUTC(date, "yyyy-MM-dd'T'HH:mm:ss");

            // Assert
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Should return formatted date using UTC timezone and specified locale")
        void shouldReturnFormattedDateWithUtcTimeZoneAndSpecifiedLocale() throws ParseException {
            // Arrange
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
            Date date = sdf.parse("2022-01-01T12:00:00");
            String expected = "2022-01-01T12:00:00";

            // Act
            String result = dateFormatUtils.formatUTC(date, "yyyy-MM-dd'T'HH:mm:ss", Locale.US);

            // Assert
            assertEquals(expected, result);
        }
    }

    @Nested
    @DisplayName("formatUTC(millis, pattern)")
    class FormatUTCMillisPatternTest {

        @Test
        @DisplayName("Should return formatted date using UTC timezone and default locale")
        void shouldReturnFormattedDateWithUtcTimeZoneAndDefaultLocale() {
            // Arrange
            long millis = 1641024000000L; // 2022-01-01T00:00:00
            String expected = "2022-01-01T00:00:00";

            // Act
            String result = dateFormatUtils.formatUTC(millis, "yyyy-MM-dd'T'HH:mm:ss");

            // Assert
            assertEquals(expected, result);
        }

        @Test
        @DisplayName("Should return formatted date using UTC timezone and specified locale")
        void shouldReturnFormattedDateWithUtcTimeZoneAndSpecifiedLocale() {
            // Arrange
            long millis = 1641024000000L; // 2022-01-01T00:00:00
            String expected = "2022-01-01T00:00:00";

            // Act
            String result = dateFormatUtils.formatUTC(millis, "yyyy-MM-dd'T'HH:mm:ss", Locale.US);

            // Assert
            assertEquals(expected, result);
        }
    }
}
