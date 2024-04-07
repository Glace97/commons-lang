import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ofTest {

    @Test
    void testOfConsumer() throws Exception {
        FailableConsumer<Instant, Exception> consumer = (instant) -> {
            // Add some logic here
        };

        Duration duration = DurationUtils.of(consumer);

        assertTrue(duration.toMillis() >= 0);
    }

    @Test
    void testOfRunnable() throws Exception {
        FailableRunnable<Exception> runnable = () -> {
            // Add some logic here
        };

        Duration duration = DurationUtils.of(runnable);

        assertTrue(duration.toMillis() >= 0);
    }

    @Test
    void testOfConsumerThrowsException() {
        FailableConsumer<Instant, Exception> consumer = (instant) -> {
            throw new Exception("Test Exception");
        };

        Executable executable = () -> DurationUtils.of(consumer);

        Exception exception = assertThrows(Exception.class, executable);
        assertEquals("Test Exception", exception.getMessage());
    }

    @Test
    void testOfRunnableThrowsException() {
        FailableRunnable<Exception> runnable = () -> {
            throw new Exception("Test Exception");
        };

        Executable executable = () -> DurationUtils.of(runnable);

        Exception exception = assertThrows(Exception.class, executable);
        assertEquals("Test Exception", exception.getMessage());
    }
}