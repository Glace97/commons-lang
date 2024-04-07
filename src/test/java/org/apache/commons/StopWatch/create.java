
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class createTest {
    private StopWatch stopWatch;

    @BeforeEach
    void setUp() {
        stopWatch = StopWatch.create();
    }

    @Test
    void testCreate() {
        assertNotNull(stopWatch);
        assertEquals(StopWatch.State.UNSTARTED, stopWatch.getState());
        assertEquals(StopWatch.SplitState.UNSPLIT, stopWatch.getSplitState());
        assertEquals(0, stopWatch.getStartTimeMillis());
        assertEquals(0, stopWatch.getStartTimeNanos());
        assertEquals(0, stopWatch.getStopTimeMillis());
        assertEquals(0, stopWatch.getStopTimeNanos());
        assertNull(stopWatch.getMessage());
    }
}
