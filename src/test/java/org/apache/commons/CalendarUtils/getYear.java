import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getYearTest {
    CalendarUtils calendarUtils;

    @BeforeEach
    void setUp() {
        calendarUtils = new CalendarUtils(Calendar.getInstance());
    }

    @Test
    void testGetYear() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        assertEquals(currentYear, calendarUtils.getYear());
    }
}