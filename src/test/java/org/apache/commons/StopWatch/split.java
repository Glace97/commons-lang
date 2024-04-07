import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SplitTest {
    private StopWatch stopWatch;

    @BeforeEach
    void setUp() {
        stopWatch = new StopWatch();
    }

    @Test
    void split_WhenStopWatchIsNotRunning_ThrowsIllegalStateException() {
        assertThrows(IllegalStateException.class, () -> {
            stopWatch.split();
        });
    }

    @Test
    void split_WhenStopWatchIsRunning_SetsStopTimeAndSplitState() {
        stopWatch.start();

        stopWatch.split();

        assertEquals(StopWatch.SplitState.SPLIT, stopWatch.getSplitState());
        assertEquals(true, stopWatch.getStopTimeNanos() > 0);
    }
}