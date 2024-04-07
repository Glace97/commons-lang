import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class addSecondsTest {

    private DateUtils dateUtils;

    @BeforeEach
    void setUp() {
        dateUtils = new DateUtils();
    }

    @Nested
    @DisplayName("addSeconds method")
    class AddSecondsMethod {

        @Test
        @DisplayName("should add positive seconds to the date")
        void shouldAddPositiveSecondsToDate() {
            Calendar calendar = Calendar.getInstance();
            calendar.set(2021, Calendar.JANUARY, 1, 0, 0, 0);
            Date initialDate = calendar.getTime();
            int secondsToAdd = 10;
            Date expectedDate = calendar.getTime();
            expectedDate.setTime(expectedDate.getTime() + (secondsToAdd * 1000));

            Date actualDate = dateUtils.addSeconds(initialDate, secondsToAdd);

            assertEquals(expectedDate, actualDate);
        }

        @Test
        @DisplayName("should add negative seconds to the date")
        void shouldAddNegativeSecondsToDate() {
            Calendar calendar = Calendar.getInstance();
            calendar.set(2021, Calendar.JANUARY, 1, 0, 0, 0);
            Date initialDate = calendar.getTime();
            int secondsToAdd = -10;
            Date expectedDate = calendar.getTime();
            expectedDate.setTime(expectedDate.getTime() + (secondsToAdd * 1000));

            Date actualDate = dateUtils.addSeconds(initialDate, secondsToAdd);

            assertEquals(expectedDate, actualDate);
        }

        @Test
        @DisplayName("should return the same date when adding 0 seconds")
        void shouldReturnSameDateWhenAddingZeroSeconds() {
            Calendar calendar = Calendar.getInstance();
            calendar.set(2021, Calendar.JANUARY, 1, 0, 0, 0);
            Date initialDate = calendar.getTime();
            int secondsToAdd = 0;

            Date actualDate = dateUtils.addSeconds(initialDate, secondsToAdd);

            assertEquals(initialDate, actualDate);
        }

        @Test
        @DisplayName("should throw NullPointerException when date is null")
        void shouldThrowNullPointerExceptionWhenDateIsNull() {
            assertThrows(NullPointerException.class, () -> dateUtils.addSeconds(null, 10));
        }
    }
}