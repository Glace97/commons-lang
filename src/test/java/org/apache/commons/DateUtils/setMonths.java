import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class setMonthsTest {

    private DateUtils dateUtils;

    @BeforeEach
    void setUp() {
        dateUtils = new DateUtils();
    }

    @Test
    @DisplayName("Test setting months to 0")
    void testSetMonthsToZero() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, 0, 1); // January 1, 2022
        Date date = calendar.getTime();

        Date result = dateUtils.setMonths(date, 0);

        calendar.set(2022, 0, 1); // January 1, 2022
        Date expected = calendar.getTime();

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test setting months to 5")
    void testSetMonthsToFive() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, 0, 1); // January 1, 2022
        Date date = calendar.getTime();

        Date result = dateUtils.setMonths(date, 5);

        calendar.set(2022, 5, 1); // June 1, 2022
        Date expected = calendar.getTime();

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test setting months to 11")
    void testSetMonthsToEleven() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, 0, 1); // January 1, 2022
        Date date = calendar.getTime();

        Date result = dateUtils.setMonths(date, 11);

        calendar.set(2022, 11, 1); // December 1, 2022
        Date expected = calendar.getTime();

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("Test setting months to an invalid value")
    void testSetMonthsInvalidValue() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2022, 0, 1); // January 1, 2022
        Date date = calendar.getTime();

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            dateUtils.setMonths(date, 13);
        });

        String expectedMessage = "Amount must be in the range 0 <= amount <= 11";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }
}