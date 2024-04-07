import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class createStartedTest {
    
    @Test
    void testCreateStarted() {
        StopWatch sw = StopWatch.createStarted();
        
        Assertions.assertTrue(sw.isStarted());
        Assertions.assertFalse(sw.isStopped());
        Assertions.assertFalse(sw.isSuspended());
        Assertions.assertEquals(StopWatch.State.RUNNING, sw.getRunningState());
        Assertions.assertEquals(StopWatch.SplitState.UNSPLIT, sw.getSplitState());
        Assertions.assertTrue(sw.getStartTimeNanos() > 0);
        Assertions.assertTrue(sw.getStartTimeMillis() > 0);
        Assertions.assertEquals(0, sw.getStopTimeNanos());
        Assertions.assertEquals(0, sw.getStopTimeMillis());
        Assertions.assertNull(sw.getMessage());
    }
    
    @Test
    void testCreateStartedWithMessage() {
        String message = "Test StopWatch";
        StopWatch sw = StopWatch.createStarted(message);
        
        Assertions.assertTrue(sw.isStarted());
        Assertions.assertFalse(sw.isStopped());
        Assertions.assertFalse(sw.isSuspended());
        Assertions.assertEquals(StopWatch.State.RUNNING, sw.getRunningState());
        Assertions.assertEquals(StopWatch.SplitState.UNSPLIT, sw.getSplitState());
        Assertions.assertTrue(sw.getStartTimeNanos() > 0);
        Assertions.assertTrue(sw.getStartTimeMillis() > 0);
        Assertions.assertEquals(0, sw.getStopTimeNanos());
        Assertions.assertEquals(0, sw.getStopTimeMillis());
        Assertions.assertEquals(message, sw.getMessage());
    }
}