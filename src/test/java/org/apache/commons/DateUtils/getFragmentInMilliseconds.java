import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Calendar;
import java.util.Date;

class getFragmentInMillisecondsTest {

    @Test
    void testGetFragmentInMillisecondsWithCalendar() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2021, Calendar.JANUARY, 1, 7, 15, 10);
        calendar.set(Calendar.MILLISECOND, 538);

        long result = DateUtils.getFragmentInMilliseconds(calendar, Calendar.SECOND);
        Assertions.assertEquals(538, result);

        result = DateUtils.getFragmentInMilliseconds(calendar, Calendar.MINUTE);
        Assertions.assertEquals(10538, result);

        result = DateUtils.getFragmentInMilliseconds(calendar, Calendar.MILLISECOND);
        Assertions.assertEquals(0, result);
    }

    @Test
    void testGetFragmentInMillisecondsWithDate() {
        Date date = new Date(121, Calendar.JANUARY, 1, 7, 15, 10);
        date.setSeconds(10);
        date.setMilliseconds(538);

        long result = DateUtils.getFragmentInMilliseconds(date, Calendar.SECOND);
        Assertions.assertEquals(538, result);

        result = DateUtils.getFragmentInMilliseconds(date, Calendar.MINUTE);
        Assertions.assertEquals(10538, result);

        result = DateUtils.getFragmentInMilliseconds(date, Calendar.MILLISECOND);
        Assertions.assertEquals(0, result);
    }

}