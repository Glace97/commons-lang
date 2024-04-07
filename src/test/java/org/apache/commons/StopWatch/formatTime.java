import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class formatTimeTest {

    private StopWatch stopWatch;

    @BeforeEach
    void setUp() {
        stopWatch = new StopWatch();
    }

    @Test
    void testFormatTime_ZeroTime() {
        assertEquals("00:00:00.000", stopWatch.formatTime());
    }

    @Test
    void testFormatTime_NegativeTime() {
        stopWatch.stopTimeMillis = -1000L;
        assertEquals("-00:00:01.000", stopWatch.formatTime());
    }

    @Test
    void testFormatTime_Milliseconds() {
        stopWatch.stopTimeMillis = 1234L;
        assertEquals("00:00:01.234", stopWatch.formatTime());
    }

    @Test
    void testFormatTime_Seconds() {
        stopWatch.stopTimeMillis = TimeUnit.SECONDS.toMillis(30);
        assertEquals("00:00:30.000", stopWatch.formatTime());
    }

    @Test
    void testFormatTime_Minutes() {
        stopWatch.stopTimeMillis = TimeUnit.MINUTES.toMillis(5);
        assertEquals("00:05:00.000", stopWatch.formatTime());
    }

    @Test
    void testFormatTime_Hours() {
        stopWatch.stopTimeMillis = TimeUnit.HOURS.toMillis(2);
        assertEquals("02:00:00.000", stopWatch.formatTime());
    }

    @Test
    void testFormatTime_MillisecondsWithLeadingZero() {
        stopWatch.stopTimeMillis = 5L;
        assertEquals("00:00:00.005", stopWatch.formatTime());
    }

    @Test
    void testFormatTime_SecondsWithLeadingZero() {
        stopWatch.stopTimeMillis = TimeUnit.SECONDS.toMillis(5);
        assertEquals("00:00:05.000", stopWatch.formatTime());
    }

    @Test
    void testFormatTime_MinutesWithLeadingZero() {
        stopWatch.stopTimeMillis = TimeUnit.MINUTES.toMillis(10);
        assertEquals("00:10:00.000", stopWatch.formatTime());
    }

    @Test
    void testFormatTime_HoursWithLeadingZero() {
        stopWatch.stopTimeMillis = TimeUnit.HOURS.toMillis(20);
        assertEquals("20:00:00.000", stopWatch.formatTime());
    }

    @Test
    void testFormatTime_MillisecondsWithTrailingZero() {
        stopWatch.stopTimeMillis = 1230L;
        assertEquals("00:00:01.230", stopWatch.formatTime());
    }

    @Test
    void testFormatTime_SecondsWithTrailingZero() {
        stopWatch.stopTimeMillis = TimeUnit.SECONDS.toMillis(30);
        assertEquals("00:00:30.000", stopWatch.formatTime());
    }

    @Test
    void testFormatTime_MinutesWithTrailingZero() {
        stopWatch.stopTimeMillis = TimeUnit.MINUTES.toMillis(5);
        assertEquals("00:05:00.000", stopWatch.formatTime());
    }

    @Test
    void testFormatTime_HoursWithTrailingZero() {
        stopWatch.stopTimeMillis = TimeUnit.HOURS.toMillis(2);
        assertEquals("02:00:00.000", stopWatch.formatTime());
    }

    @Test
    void testFormatTime_MessageIncluded() {
        stopWatch.message = "Stopwatch";
        stopWatch.stopTimeMillis = 500L;
        assertEquals("Stopwatch: 00:00:00.500", stopWatch.formatTime());
    }
}