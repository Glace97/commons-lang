import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isSuspendedTest {

    @Test
    void testIsSuspended() {
        StopWatch stopWatch = new StopWatch();
        
        assertFalse(stopWatch.isSuspended());
        
        stopWatch.start();
        assertFalse(stopWatch.isSuspended());
        
        stopWatch.suspend();
        assertTrue(stopWatch.isSuspended());
        
        stopWatch.resume();
        assertFalse(stopWatch.isSuspended());
        
        stopWatch.stop();
        assertFalse(stopWatch.isSuspended());
    }
}