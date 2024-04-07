import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import java.time.Duration;

class getNanosOfMiiliTest {

    @Test
    @DisplayName("Test getNanosOfMiili with positive nanoseconds")
    void testGetNanosOfMiiliWithPositiveNanos() {
        Duration duration = Duration.ofNanos(123456789);
        int nanosOfMiili = DurationUtils.getNanosOfMiili(duration);
        Assertions.assertEquals(789, nanosOfMiili);
    }

    @Test
    @DisplayName("Test getNanosOfMiili with zero nanoseconds")
    void testGetNanosOfMiiliWithZeroNanos() {
        Duration duration = Duration.ofNanos(123456000);
        int nanosOfMiili = DurationUtils.getNanosOfMiili(duration);
        Assertions.assertEquals(0, nanosOfMiili);
    }

    @Test
    @DisplayName("Test getNanosOfMiili with maximum nanoseconds")
    void testGetNanosOfMiiliWithMaxNanos() {
        Duration duration = Duration.ofNanos(999999999);
        int nanosOfMiili = DurationUtils.getNanosOfMiili(duration);
        Assertions.assertEquals(999, nanosOfMiili);
    }

    @Test
    @DisplayName("Test getNanosOfMiili with duration greater than 1 second")
    void testGetNanosOfMiiliWithDurationGreaterThan1Second() {
        Duration duration = Duration.ofSeconds(2).plusNanos(123456789);
        int nanosOfMiili = DurationUtils.getNanosOfMiili(duration);
        Assertions.assertEquals(789, nanosOfMiili);
    }

    @Test
    @DisplayName("Test getNanosOfMiili with negative nanoseconds")
    void testGetNanosOfMiiliWithNegativeNanos() {
        Duration duration = Duration.ofNanos(-123456789);
        int nanosOfMiili = DurationUtils.getNanosOfMiili(duration);
        Assertions.assertEquals(789, nanosOfMiili);
    }
}