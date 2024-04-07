
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

class addMonthsTest {

    private DateUtils dateUtils;
    private SimpleDateFormat dateFormat;

    @BeforeEach
    void setUp() {
        dateUtils = new DateUtils();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    }

    @Test
    void testAddMonths_positiveAmount() {
        Date date = createDate(2021, 5, 15);
        Date result = dateUtils.addMonths(date, 3);
        assertEquals("2021-08-15", dateFormat.format(result));
    }

    @Test
    void testAddMonths_negativeAmount() {
        Date date = createDate(2021, 5, 15);
        Date result = dateUtils.addMonths(date, -2);
        assertEquals("2021-03-15", dateFormat.format(result));
    }

    @Test
    void testAddMonths_zeroAmount() {
        Date date = createDate(2021, 5, 15);
        Date result = dateUtils.addMonths(date, 0);
        assertEquals("2021-05-15", dateFormat.format(result));
    }

    @Test
    void testAddMonths_leapYear() {
        Date date = createDate(2020, 2, 29);
        Date result = dateUtils.addMonths(date, 12);
        assertEquals("2021-02-28", dateFormat.format(result));
    }

    @Test
    void testAddMonths_endOfMonth() {
        Date date = createDate(2021, 1, 31);
        Date result = dateUtils.addMonths(date, 1);
        assertEquals("2021-02-28", dateFormat.format(result));
    }

    private Date createDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month - 1, day);
        return calendar.getTime();
    }
}
