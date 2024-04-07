import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

class ResetTest {
    private StopWatch stopWatch;

    @BeforeEach
    void setUp() {
        stopWatch = new StopWatch();
    }

    @Test
    void testReset() {
        // Test reset when StopWatch is unstarted
        stopWatch.reset();
        assertEquals(StopWatch.State.UNSTARTED, stopWatch.runningState);
        assertEquals(StopWatch.SplitState.UNSPLIT, stopWatch.splitState);

        // Test reset when StopWatch is started
        stopWatch.start();
        stopWatch.reset();
        assertEquals(StopWatch.State.UNSTARTED, stopWatch.runningState);
        assertEquals(StopWatch.SplitState.UNSPLIT, stopWatch.splitState);

        // Test reset when StopWatch is stopped
        stopWatch.start();
        stopWatch.stop();
        stopWatch.reset();
        assertEquals(StopWatch.State.UNSTARTED, stopWatch.runningState);
        assertEquals(StopWatch.SplitState.UNSPLIT, stopWatch.splitState);

        // Test reset when StopWatch is suspended
        stopWatch.start();
        stopWatch.suspend();
        stopWatch.reset();
        assertEquals(StopWatch.State.UNSTARTED, stopWatch.runningState);
        assertEquals(StopWatch.SplitState.UNSPLIT, stopWatch.splitState);
    }
}