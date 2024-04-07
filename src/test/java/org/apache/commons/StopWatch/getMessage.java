import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class getMessageTest {

    private StopWatch stopWatch;

    @BeforeEach
    public void setUp() {
        stopWatch = new StopWatch();
    }

    @Test
    @DisplayName("Test getMessage when message is null")
    public void testGetMessageNull() {
        Assertions.assertNull(stopWatch.getMessage());
    }

    @Test
    @DisplayName("Test getMessage when message is empty")
    public void testGetMessageEmpty() {
        stopWatch = new StopWatch("");
        Assertions.assertEquals("", stopWatch.getMessage());
    }

    @Test
    @DisplayName("Test getMessage when message is not empty")
    public void testGetMessageNotEmpty() {
        stopWatch = new StopWatch("Hello");
        Assertions.assertEquals("Hello", stopWatch.getMessage());
    }
}