import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import java.util.concurrent.TimeUnit;

class formatSplitTimeTest {
    private StopWatch stopWatch;

    @BeforeEach
    void setUp() {
        stopWatch = new StopWatch();
    }

    @Nested
    @DisplayName("formatSplitTime method")
    class formatSplitTimeMethod {
        @Test
        @DisplayName("returns formatted split time")
        void returnsFormattedSplitTime() {
            stopWatch.start();
            stopWatch.split();
            String expected = "00:00:01";
            assertEquals(expected, stopWatch.formatSplitTime());
        }

        @Test
        @DisplayName("returns formatted split time for long duration")
        void returnsFormattedSplitTimeForLongDuration() {
            stopWatch.start();
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            stopWatch.split();
            String expected = "00:00:10";
            assertEquals(expected, stopWatch.formatSplitTime());
        }

        @Test
        @DisplayName("returns formatted split time for suspended stop watch")
        void returnsFormattedSplitTimeForSuspendedStopWatch() {
            stopWatch.start();
            stopWatch.suspend();
            stopWatch.split();
            String expected = "00:00:00";
            assertEquals(expected, stopWatch.formatSplitTime());
        }

        @Test
        @DisplayName("returns empty string for unstarted stop watch")
        void returnsEmptyStringForUnstartedStopWatch() {
            String expected = "";
            assertEquals(expected, stopWatch.formatSplitTime());
        }
    }
}