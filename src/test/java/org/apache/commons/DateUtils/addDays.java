import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class addDaysTest {

    private DateUtils dateUtils;

    @BeforeEach
    void setUp() {
        dateUtils = new DateUtils();
    }

    @Test
    void testAddDaysPositiveAmount() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.JULY, 1); // July 1, 2021
        Date result = dateUtils.addDays(calendar.getTime(), 10);
        calendar.add(Calendar.DAY_OF_MONTH, 10);

        assertEquals(calendar.getTime(), result);
    }

    @Test
    void testAddDaysNegativeAmount() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.JULY, 15); // July 15, 2021
        Date result = dateUtils.addDays(calendar.getTime(), -5);
        calendar.add(Calendar.DAY_OF_MONTH, -5);

        assertEquals(calendar.getTime(), result);
    }

    @Test
    void testAddDaysZeroAmount() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.JULY, 1); // July 1, 2021
        Date result = dateUtils.addDays(calendar.getTime(), 0);

        assertEquals(calendar.getTime(), result);
    }

    @Test
    void testAddDaysNullDate() {
        assertThrows(NullPointerException.class, () -> dateUtils.addDays(null, 10));
    }
}