import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("getOffset Test Suite")
class getOffsetTest {

    private GmtTimeZone gmtTimeZone;

    @BeforeEach
    void setUp() {
        gmtTimeZone = new GmtTimeZone(true, 0, 0);
    }

    @Nested
    @DisplayName("Positive Test Cases")
    class PositiveTestCases {

        @Test
        @DisplayName("Test getOffset with valid parameters")
        void testGetOffsetWithValidParameters() {
            int era = 1;
            int year = 2022;
            int month = 10;
            int day = 1;
            int dayOfWeek = 6;
            int milliseconds = 0;

            int expectedOffset = 0;

            int actualOffset = gmtTimeZone.getOffset(era, year, month, day, dayOfWeek, milliseconds);

            assertEquals(expectedOffset, actualOffset);
        }
    }

    @Nested
    @DisplayName("Edge Test Cases")
    class EdgeTestCases {

        @Test
        @DisplayName("Test getOffset with maximum hours value")
        void testGetOffsetWithMaximumHoursValue() {
            int era = 1;
            int year = 2022;
            int month = 10;
            int day = 1;
            int dayOfWeek = 6;
            int milliseconds = 0;

            GmtTimeZone gmtTimeZone = new GmtTimeZone(true, 23, 0);

            int expectedOffset = 23 * 60 * 60 * 1000;

            int actualOffset = gmtTimeZone.getOffset(era, year, month, day, dayOfWeek, milliseconds);

            assertEquals(expectedOffset, actualOffset);
        }

        @Test
        @DisplayName("Test getOffset with maximum minutes value")
        void testGetOffsetWithMaximumMinutesValue() {
            int era = 1;
            int year = 2022;
            int month = 10;
            int day = 1;
            int dayOfWeek = 6;
            int milliseconds = 0;

            GmtTimeZone gmtTimeZone = new GmtTimeZone(true, 0, 59);

            int expectedOffset = 59 * 60 * 1000;

            int actualOffset = gmtTimeZone.getOffset(era, year, month, day, dayOfWeek, milliseconds);

            assertEquals(expectedOffset, actualOffset);
        }

        @Test
        @DisplayName("Test getOffset with maximum hours and minutes values")
        void testGetOffsetWithMaximumHoursAndMinutesValues() {
            int era = 1;
            int year = 2022;
            int month = 10;
            int day = 1;
            int dayOfWeek = 6;
            int milliseconds = 0;

            GmtTimeZone gmtTimeZone = new GmtTimeZone(true, 23, 59);

            int expectedOffset = 23 * 60 * 60 * 1000 + 59 * 60 * 1000;

            int actualOffset = gmtTimeZone.getOffset(era, year, month, day, dayOfWeek, milliseconds);

            assertEquals(expectedOffset, actualOffset);
        }
    }

    @Nested
    @DisplayName("Exception Test Cases")
    class ExceptionTestCases {

        @Test
        @DisplayName("Test getOffset with hours out of range")
        void testGetOffsetWithHoursOutOfRange() {
            int era = 1;
            int year = 2022;
            int month = 10;
            int day = 1;
            int dayOfWeek = 6;
            int milliseconds = 0;

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                GmtTimeZone gmtTimeZone = new GmtTimeZone(true, 24, 0);
                gmtTimeZone.getOffset(era, year, month, day, dayOfWeek, milliseconds);
            });

            String expectedMessage = "24 hours out of range";
            String actualMessage = exception.getMessage();

            assertEquals(expectedMessage, actualMessage);
        }

        @Test
        @DisplayName("Test getOffset with minutes out of range")
        void testGetOffsetWithMinutesOutOfRange() {
            int era = 1;
            int year = 2022;
            int month = 10;
            int day = 1;
            int dayOfWeek = 6;
            int milliseconds = 0;

            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                GmtTimeZone gmtTimeZone = new GmtTimeZone(true, 0, 60);
                gmtTimeZone.getOffset(era, year, month, day, dayOfWeek, milliseconds);
            });

            String expectedMessage = "60 minutes out of range";
            String actualMessage = exception.getMessage();

            assertEquals(expectedMessage, actualMessage);
        }
    }
}