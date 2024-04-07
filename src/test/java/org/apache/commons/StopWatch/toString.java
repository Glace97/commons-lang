import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class toStringTest {

    private StopWatch stopWatch;

    @BeforeEach
    void setUp() {
        stopWatch = new StopWatch();
    }

    @Test
    void testToStringWithNoMessage() {
        String expected = "0:00:00.000";
        String actual = stopWatch.toString();
        assertEquals(expected, actual);
    }

    @Test
    void testToStringWithMessage() {
        stopWatch = new StopWatch("Test");
        String expected = "Test 0:00:00.000";
        String actual = stopWatch.toString();
        assertEquals(expected, actual);
    }

    @Test
    void testToStringWithHours() {
        stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        String expected = "0:00:00.000";
        String actual = stopWatch.toString();
        assertEquals(expected, actual);
    }

    @Test
    void testToStringWithMinutes() {
        stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        String expected = "0:00:00.000";
        String actual = stopWatch.toString();
        assertEquals(expected, actual);
    }

    @Test
    void testToStringWithSeconds() {
        stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.start();
        stopWatch.stop();
        String expected = "0:00:00.000";
        String actual = stopWatch.toString();
        assertEquals(expected, actual);
    }

    @Test
    void testToStringWithMilliseconds() {
        stopWatch = new StopWatch();
        stopWatch.start();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopWatch.stop();
        String expected = "0:00:00.100";
        String actual = stopWatch.toString();
        assertEquals(expected, actual);
    }

}