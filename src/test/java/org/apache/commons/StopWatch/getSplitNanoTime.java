import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class getSplitNanoTimeTest {

    private StopWatch stopWatch;

    @BeforeEach
    void setUp() {
        stopWatch = new StopWatch();
    }

    @Test
    void testGetSplitNanoTime_ThrowsIllegalStateExceptionWhenNotSplit() {
        Assertions.assertThrows(IllegalStateException.class, () -> {
            stopWatch.getSplitNanoTime();
        });
    }

    @Test
    void testGetSplitNanoTime_ReturnsCorrectSplitTime() {
        stopWatch.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        stopWatch.split();
        long splitNanoTime = stopWatch.getSplitNanoTime();
        Assertions.assertTrue(splitNanoTime > 0);
    }
}