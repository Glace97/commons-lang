import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class toSplitStringTest {
    private StopWatch stopWatch;

    @BeforeEach
    void setUp() {
        stopWatch = new StopWatch();
    }

    @Test
    @DisplayName("Test toSplitString when message is null")
    void testToSplitStringWithNullMessage() {
        String expected = "00:00:00.000";
        String actual = stopWatch.toSplitString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test toSplitString when message is empty")
    void testToSplitStringWithEmptyMessage() {
        stopWatch = new StopWatch("");
        String expected = "00:00:00.000";
        String actual = stopWatch.toSplitString();
        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test toSplitString with non-empty message")
    void testToSplitStringWithNonEmptyMessage() {
        stopWatch = new StopWatch("Elapsed time:");
        String expected = "Elapsed time: 00:00:00.000";
        String actual = stopWatch.toSplitString();
        Assertions.assertEquals(expected, actual);
    }
}