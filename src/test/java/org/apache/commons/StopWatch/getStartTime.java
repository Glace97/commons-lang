import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getStartTimeTest {

    @Test
    void testGetStartTime_Started_StopWatch() {
        // Arrange
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        // Act
        long startTime = stopWatch.getStartTime();

        // Assert
        Assertions.assertTrue(startTime > 0);
    }

    @Test
    void testGetStartTime_Stopped_StopWatch() {
        // Arrange
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.stop();

        // Act and Assert
        Assertions.assertThrows(IllegalStateException.class, stopWatch::getStartTime);
    }

    @Test
    void testGetStartTime_Suspended_StopWatch() {
        // Arrange
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.suspend();

        // Act and Assert
        Assertions.assertThrows(IllegalStateException.class, stopWatch::getStartTime);
    }

    @Test
    void testGetStartTime_Unstarted_StopWatch() {
        // Arrange
        StopWatch stopWatch = new StopWatch();

        // Act and Assert
        Assertions.assertThrows(IllegalStateException.class, stopWatch::getStartTime);
    }
}