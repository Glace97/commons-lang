import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class stopTest {

    @Test
    void testStop() {
        StopWatch stopWatch = new StopWatch();

        // Test stopping a running StopWatch
        stopWatch.start();
        assertThrows(IllegalStateException.class, () -> stopWatch.stop());

        // Test stopping a suspended StopWatch
        stopWatch.suspend();
        assertThrows(IllegalStateException.class, () -> stopWatch.stop());

        // Test stopping an unstarted StopWatch
        stopWatch.reset();
        assertThrows(IllegalStateException.class, () -> stopWatch.stop());

        // Test stopping a stopped StopWatch
        stopWatch.start();
        stopWatch.stop();
        assertThrows(IllegalStateException.class, () -> stopWatch.stop());
    }

}