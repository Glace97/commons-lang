import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.time.Duration;

class waitTest {

    @Test
    @DisplayName("Test wait with positive duration")
    void testWaitWithPositiveDuration() {
        Object obj = new Object();
        Duration duration = Duration.ofSeconds(1);

        assertDoesNotThrow(() -> ObjectUtils.wait(obj, duration));
    }

    @Test
    @DisplayName("Test wait with zero duration")
    void testWaitWithZeroDuration() {
        Object obj = new Object();
        Duration duration = Duration.ZERO;

        assertDoesNotThrow(() -> ObjectUtils.wait(obj, duration));
    }

    @Test
    @DisplayName("Test wait with null duration")
    void testWaitWithNullDuration() {
        Object obj = new Object();
        Duration duration = null;

        assertDoesNotThrow(() -> ObjectUtils.wait(obj, duration));
    }

    @Test
    @DisplayName("Test wait with negative duration")
    void testWaitWithNegativeDuration() {
        Object obj = new Object();
        Duration duration = Duration.ofSeconds(-1);

        assertThrows(IllegalArgumentException.class, () -> ObjectUtils.wait(obj, duration));
    }

    @Test
    @DisplayName("Test wait with interrupted thread")
    void testWaitWithInterruptedThread() {
        Object obj = new Object();
        Duration duration = Duration.ofSeconds(1);

        Thread.currentThread().interrupt();

        assertThrows(InterruptedException.class, () -> ObjectUtils.wait(obj, duration));
    }

    @Test
    @DisplayName("Test wait with illegal monitor state")
    void testWaitWithIllegalMonitorState() {
        Object obj = new Object();
        Duration duration = Duration.ofSeconds(1);

        assertThrows(IllegalMonitorStateException.class, () -> ObjectUtils.wait(NULL, duration));
    }
}