import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

class parseDateStrictlyTest {

    @Test
    void testParseDateStrictly_WithValidDateFormat_ShouldReturnParsedDate() throws ParseException {
        String dateStr = "2022-01-01";
        String[] parsePatterns = {"yyyy-MM-dd"};
        Date expectedDate = createDate(2022, Calendar.JANUARY, 1);
        Date actualDate = DateUtils.parseDateStrictly(dateStr, parsePatterns);
        Assertions.assertEquals(expectedDate, actualDate);
    }

    @Test
    void testParseDateStrictly_WithInvalidDateFormat_ShouldThrowParseException() {
        String dateStr = "2022/01/01";
        String[] parsePatterns = {"yyyy-MM-dd"};
        Assertions.assertThrows(ParseException.class, () -> {
            DateUtils.parseDateStrictly(dateStr, parsePatterns);
        });
    }

    @Test
    void testParseDateStrictly_WithNullString_ShouldThrowNullPointerException() {
        String[] parsePatterns = {"yyyy-MM-dd"};
        Assertions.assertThrows(NullPointerException.class, () -> {
            DateUtils.parseDateStrictly(null, parsePatterns);
        });
    }

    @Test
    void testParseDateStrictly_WithNullParsePatterns_ShouldThrowNullPointerException() {
        String dateStr = "2022-01-01";
        Assertions.assertThrows(NullPointerException.class, () -> {
            DateUtils.parseDateStrictly(dateStr, (String[]) null);
        });
    }

    @Test
    void testParseDateStrictly_WithEmptyParsePatterns_ShouldThrowIllegalArgumentException() {
        String dateStr = "2022-01-01";
        String[] parsePatterns = {};
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            DateUtils.parseDateStrictly(dateStr, parsePatterns);
        });
    }

    private Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        return calendar.getTime();
    }
}