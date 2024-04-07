import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getSplitTimeTest {

    private StopWatch stopWatch;

    @BeforeEach
    void setUp() {
        stopWatch = new StopWatch();
    }

    @Test
    void testGetSplitTime_ThrowsExceptionWhenNotSplit() {
        assertThrows(IllegalStateException.class, () -> {
            stopWatch.getSplitTime();
        });
    }

    @Test
    void testGetSplitTime_ReturnsCorrectSplitTime() {
        // Start the stopWatch
        stopWatch.start();
        
        // Wait for 1 second
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Split the stopWatch
        stopWatch.split();

        // Get the split time
        long splitTime = stopWatch.getSplitTime();

        // Verify that the split time is greater than 0
        assertTrue(splitTime > 0);
    }
    
    @Test
    void testGetSplitTime_ReturnsZeroWhenNotStarted() {
        // Split the stopWatch
        stopWatch.split();

        // Get the split time
        long splitTime = stopWatch.getSplitTime();

        // Verify that the split time is 0
        assertEquals(0, splitTime);
    }

    @Test
    void testGetSplitTime_ReturnsZeroWhenStopped() {
        // Start the stopWatch
        stopWatch.start();
        
        // Wait for 1 second
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Stop the stopWatch
        stopWatch.stop();

        // Get the split time
        long splitTime = stopWatch.getSplitTime();

        // Verify that the split time is 0
        assertEquals(0, splitTime);
    }

    @Test
    void testGetSplitTime_ReturnsZeroWhenReset() {
        // Start the stopWatch
        stopWatch.start();
        
        // Wait for 1 second
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Split the stopWatch
        stopWatch.split();
        
        // Reset the stopWatch
        stopWatch.reset();

        // Get the split time
        long splitTime = stopWatch.getSplitTime();

        // Verify that the split time is 0
        assertEquals(0, splitTime);
    }
}