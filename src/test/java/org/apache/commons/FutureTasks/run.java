import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

class runTest {
    
    @Test
    void testRun() {
        // Create a callable for testing
        Callable<String> callable = () -> "Test";

        // Create a future task using the run method
        FutureTask<String> futureTask = FutureTasks.run(callable);

        // Test that the future task is not null
        assertNotNull(futureTask);

        // Test that the future task is done
        assertTrue(futureTask.isDone());

        // Test that the future task's result matches the expected result
        try {
            assertEquals("Test", futureTask.get());
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
    
    @Test
    void testRunWithException() {
        // Create a callable that throws an exception
        Callable<Integer> callable = () -> {
            throw new Exception("Test Exception");
        };

        // Create a future task using the run method
        FutureTask<Integer> futureTask = FutureTasks.run(callable);

        // Test that the future task is not null
        assertNotNull(futureTask);

        // Test that the future task is done
        assertTrue(futureTask.isDone());

        // Test that getting the result throws an exception
        try {
            futureTask.get();
            fail("Exception not thrown");
        } catch (Exception e) {
            assertEquals("Test Exception", e.getMessage());
        }
    }
    
    @Test
    void testRunWithInterrupt() {
        // Create a callable that sleeps for a long time
        Callable<Boolean> callable = () -> {
            try {
                Thread.sleep(Long.MAX_VALUE);
                return true;
            } catch (InterruptedException e) {
                return false;
            }
        };

        // Create a future task using the run method
        FutureTask<Boolean> futureTask = FutureTasks.run(callable);

        // Test that the future task is not null
        assertNotNull(futureTask);

        // Test that the future task is not done
        assertFalse(futureTask.isDone());

        // Test interrupting the future task
        futureTask.cancel(true);

        // Test that the future task is done after interruption
        assertTrue(futureTask.isDone());

        // Test that getting the result returns false
        try {
            assertFalse(futureTask.get());
        } catch (Exception e) {
            fail("Exception occurred: " + e.getMessage());
        }
    }
}