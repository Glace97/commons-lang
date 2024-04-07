import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;

class isSameDayTest {
    private Calendar cal1;
    private Calendar cal2;
    private Date date1;
    private Date date2;

    @BeforeEach
    void setup() {
        cal1 = Calendar.getInstance();
        cal2 = Calendar.getInstance();
        date1 = new Date();
        date2 = new Date();
    }

    @Test
    void testIsSameDay_SameDay_ReturnsTrue() {
        cal1.set(2022, Calendar.JANUARY, 1);
        cal2.set(2022, Calendar.JANUARY, 1);
        assertTrue(DateUtils.isSameDay(cal1, cal2));
    }

    @Test
    void testIsSameDay_DifferentDays_ReturnsFalse() {
        cal1.set(2022, Calendar.JANUARY, 1);
        cal2.set(2022, Calendar.JANUARY, 2);
        assertFalse(DateUtils.isSameDay(cal1, cal2));
    }

    @Test
    void testIsSameDay_NullCal1_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> DateUtils.isSameDay(null, cal2));
    }

    @Test
    void testIsSameDay_NullCal2_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> DateUtils.isSameDay(cal1, null));
    }

    @Test
    void testIsSameDay_SameDate_ReturnsTrue() {
        date1.setYear(122);
        date1.setMonth(Calendar.JANUARY);
        date1.setDate(1);
        date2.setYear(122);
        date2.setMonth(Calendar.JANUARY);
        date2.setDate(1);
        assertTrue(DateUtils.isSameDay(date1, date2));
    }

    @Test
    void testIsSameDay_DifferentDates_ReturnsFalse() {
        date1.setYear(122);
        date1.setMonth(Calendar.JANUARY);
        date1.setDate(1);
        date2.setYear(122);
        date2.setMonth(Calendar.JANUARY);
        date2.setDate(2);
        assertFalse(DateUtils.isSameDay(date1, date2));
    }

    @Test
    void testIsSameDay_NullDate1_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> DateUtils.isSameDay(null, date2));
    }

    @Test
    void testIsSameDay_NullDate2_ThrowsNullPointerException() {
        assertThrows(NullPointerException.class, () -> DateUtils.isSameDay(date1, null));
    }
}