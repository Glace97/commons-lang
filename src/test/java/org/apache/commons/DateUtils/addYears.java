import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class addYearsTest {
    private DateUtils dateUtils;

    @BeforeEach
    void setUp() {
        dateUtils = new DateUtils();
    }

    @Test
    void testAddYears_PositiveAmount() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1);
        Date result = dateUtils.addYears(calendar.getTime(), 5);
        Calendar expected = Calendar.getInstance();
        expected.set(2025, Calendar.JANUARY, 1);
        assertNotNull(result);
        assertEquals(expected.getTime(), result);
    }

    @Test
    void testAddYears_NegativeAmount() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1);
        Date result = dateUtils.addYears(calendar.getTime(), -5);
        Calendar expected = Calendar.getInstance();
        expected.set(2015, Calendar.JANUARY, 1);
        assertNotNull(result);
        assertEquals(expected.getTime(), result);
    }

    @Test
    void testAddYears_ZeroAmount() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2020, Calendar.JANUARY, 1);
        Date result = dateUtils.addYears(calendar.getTime(), 0);
        assertNotNull(result);
        assertEquals(calendar.getTime(), result);
    }
}