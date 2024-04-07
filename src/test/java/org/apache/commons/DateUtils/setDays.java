import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Calendar;
import java.util.Date;

class setDaysTest {

    @Test
    void testSetDays() {
        // Test case 1: Set days to 1
        Calendar calendar1 = Calendar.getInstance();
        calendar1.set(Calendar.YEAR, 2022);
        calendar1.set(Calendar.MONTH, Calendar.JANUARY);
        calendar1.set(Calendar.DAY_OF_MONTH, 15);
        Date date1 = calendar1.getTime();
        Date result1 = DateUtils.setDays(date1, 1);
        Calendar expected1 = Calendar.getInstance();
        expected1.set(Calendar.YEAR, 2022);
        expected1.set(Calendar.MONTH, Calendar.JANUARY);
        expected1.set(Calendar.DAY_OF_MONTH, 1);
        Date expectedResult1 = expected1.getTime();
        assertEquals(expectedResult1, result1);

        // Test case 2: Set days to 31
        Calendar calendar2 = Calendar.getInstance();
        calendar2.set(Calendar.YEAR, 2022);
        calendar2.set(Calendar.MONTH, Calendar.JANUARY);
        calendar2.set(Calendar.DAY_OF_MONTH, 15);
        Date date2 = calendar2.getTime();
        Date result2 = DateUtils.setDays(date2, 31);
        Calendar expected2 = Calendar.getInstance();
        expected2.set(Calendar.YEAR, 2022);
        expected2.set(Calendar.MONTH, Calendar.JANUARY);
        expected2.set(Calendar.DAY_OF_MONTH, 31);
        Date expectedResult2 = expected2.getTime();
        assertEquals(expectedResult2, result2);

        // Test case 3: Set days to 0 (should throw IllegalArgumentException)
        Calendar calendar3 = Calendar.getInstance();
        calendar3.set(Calendar.YEAR, 2022);
        calendar3.set(Calendar.MONTH, Calendar.JANUARY);
        calendar3.set(Calendar.DAY_OF_MONTH, 15);
        Date date3 = calendar3.getTime();
        assertThrows(IllegalArgumentException.class, () -> DateUtils.setDays(date3, 0));

        // Test case 4: Set days to 32 (should throw IllegalArgumentException)
        Calendar calendar4 = Calendar.getInstance();
        calendar4.set(Calendar.YEAR, 2022);
        calendar4.set(Calendar.MONTH, Calendar.JANUARY);
        calendar4.set(Calendar.DAY_OF_MONTH, 15);
        Date date4 = calendar4.getTime();
        assertThrows(IllegalArgumentException.class, () -> DateUtils.setDays(date4, 32));
    }
}