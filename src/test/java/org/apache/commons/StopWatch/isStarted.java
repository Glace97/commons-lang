import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isStartedTest {

    @Test
    void testIsStarted_Unstarted() {
        StopWatch stopWatch = new StopWatch();
        assertFalse(stopWatch.isStarted());
    }
    
    @Test
    void testIsStarted_Running() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        assertTrue(stopWatch.isStarted());
    }
    
    @Test
    void testIsStarted_Suspended() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.suspend();
        assertTrue(stopWatch.isStarted());
    }
    
    @Test
    void testIsStarted_Stopped() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.stop();
        assertFalse(stopWatch.isStarted());
    }
    
    @Test
    void testIsStarted_StoppedAndReset() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.reset();
        assertFalse(stopWatch.isStarted());
    }
    
    @Test
    void testIsStarted_StoppedAndSplit() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.split();
        assertFalse(stopWatch.isStarted());
    }
    
    @Test
    void testIsStarted_StoppedAndUnsplit() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.split();
        stopWatch.unsplit();
        assertFalse(stopWatch.isStarted());
    }
    
    @Test
    void testIsStarted_Reset() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.reset();
        assertFalse(stopWatch.isStarted());
    }
    
    @Test
    void testIsStarted_ResetAndResume() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.reset();
        stopWatch.resume();
        assertTrue(stopWatch.isStarted());
    }
    
    @Test
    void testIsStarted_ResumeAfterStop() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.stop();
        stopWatch.resume();
        assertFalse(stopWatch.isStarted());
    }
    
    @Test
    void testIsStarted_ResumeAfterSplit() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.split();
        stopWatch.resume();
        assertFalse(stopWatch.isStarted());
    }
    
    @Test
    void testIsStarted_ResumeAfterUnsplit() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        stopWatch.split();
        stopWatch.unsplit();
        stopWatch.resume();
        assertTrue(stopWatch.isStarted());
    }
}