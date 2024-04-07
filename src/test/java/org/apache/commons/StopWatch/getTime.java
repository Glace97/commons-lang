import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class getTimeTest {

    private StopWatch stopWatch;

    @BeforeEach
    void setUp() {
        stopWatch = new StopWatch();
    }

    @Nested
    @DisplayName("Tests for getTime() method")
    class GetTimeTests {

        @Test
        @DisplayName("Should return 0 when StopWatch is not started")
        void shouldReturnZeroWhenNotStarted() {
            assertEquals(0, stopWatch.getTime());
        }

        @Test
        @DisplayName("Should return the elapsed time when StopWatch is stopped")
        void shouldReturnElapsedTimeWhenStopped() {
            stopWatch.start();
            stopWatch.stop();
            assertTrue(stopWatch.getTime() > 0);
        }

        @Test
        @DisplayName("Should return the elapsed time when StopWatch is suspended and resumed")
        void shouldReturnElapsedTimeWhenSuspendedAndResumed() {
            stopWatch.start();
            stopWatch.suspend();
            stopWatch.resume();
            assertTrue(stopWatch.getTime() > 0);
        }

        @Test
        @DisplayName("Should return the elapsed time when StopWatch is split and unsplit")
        void shouldReturnElapsedTimeWhenSplitAndUnsplit() {
            stopWatch.start();
            stopWatch.split();
            stopWatch.unsplit();
            assertTrue(stopWatch.getTime() > 0);
        }

        @Test
        @DisplayName("Should return the elapsed time when StopWatch is split and stopped")
        void shouldReturnElapsedTimeWhenSplitAndStopped() {
            stopWatch.start();
            stopWatch.split();
            stopWatch.stop();
            assertTrue(stopWatch.getTime() > 0);
        }

    }

    @Nested
    @DisplayName("Tests for getTime(TimeUnit) method")
    class GetTimeWithTimeUnitTest {

        @Test
        @DisplayName("Should return 0 when StopWatch is not started")
        void shouldReturnZeroWhenNotStarted() {
            assertEquals(0, stopWatch.getTime(TimeUnit.MILLISECONDS));
        }

        @Test
        @DisplayName("Should return the elapsed time in the specified TimeUnit when StopWatch is stopped")
        void shouldReturnElapsedTimeInSpecifiedTimeUnitWhenStopped() {
            stopWatch.start();
            stopWatch.stop();
            assertTrue(stopWatch.getTime(TimeUnit.MILLISECONDS) > 0);
        }

        @Test
        @DisplayName("Should return the elapsed time in the specified TimeUnit when StopWatch is suspended and resumed")
        void shouldReturnElapsedTimeInSpecifiedTimeUnitWhenSuspendedAndResumed() {
            stopWatch.start();
            stopWatch.suspend();
            stopWatch.resume();
            assertTrue(stopWatch.getTime(TimeUnit.MILLISECONDS) > 0);
        }

        @Test
        @DisplayName("Should return the elapsed time in the specified TimeUnit when StopWatch is split and unsplit")
        void shouldReturnElapsedTimeInSpecifiedTimeUnitWhenSplitAndUnsplit() {
            stopWatch.start();
            stopWatch.split();
            stopWatch.unsplit();
            assertTrue(stopWatch.getTime(TimeUnit.MILLISECONDS) > 0);
        }

        @Test
        @DisplayName("Should return the elapsed time in the specified TimeUnit when StopWatch is split and stopped")
        void shouldReturnElapsedTimeInSpecifiedTimeUnitWhenSplitAndStopped() {
            stopWatch.start();
            stopWatch.split();
            stopWatch.stop();
            assertTrue(stopWatch.getTime(TimeUnit.MILLISECONDS) > 0);
        }

    }

}