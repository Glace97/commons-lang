import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import static org.junit.jupiter.api.Assertions.*;

class isStartedTest {
    private BackgroundInitializer<Object> initializer;

    @BeforeEach
    void setUp() {
        initializer = new BackgroundInitializer<>();
    }

    @AfterEach
    void tearDown() {
        initializer = null;
    }

    @Test
    void testIsStartedReturnsFalseWhenNotStarted() {
        assertFalse(initializer.isStarted());
    }

    @Test
    void testIsStartedReturnsTrueAfterStart() {
        initializer.start();
        assertTrue(initializer.isStarted());
    }

    @Test
    void testIsStartedReturnsFalseAfterStartAndShutdown() {
        initializer.start();
        initializer.shutdown();
        assertFalse(initializer.isStarted());
    }
}