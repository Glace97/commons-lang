import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class StartTest {

    private BackgroundInitializer<Object, Object> initializer;
    private ExecutorService externalExecutor;

    @BeforeEach
    public void setUp() {
        initializer = new BackgroundInitializer<>();
        externalExecutor = Executors.newFixedThreadPool(1);
    }

    @Test
    public void testStart() {
        boolean result = initializer.start();
        assertTrue(result);
    }

    @Test
    public void testStart_AlreadyStarted() {
        initializer.start();
        boolean result = initializer.start();
        assertFalse(result);
    }

    @Test
    public void testStart_WithExternalExecutor() {
        initializer.setExternalExecutor(externalExecutor);
        boolean result = initializer.start();
        assertTrue(result);
    }

    @Test
    public void testStart_WithExternalExecutor_AlreadyStarted() {
        initializer.setExternalExecutor(externalExecutor);
        initializer.start();
        boolean result = initializer.start();
        assertFalse(result);
    }

    @Test
    public void testStart_WithNullExternalExecutor() {
        initializer.setExternalExecutor(null);
        boolean result = initializer.start();
        assertTrue(result);
    }

    @Test
    public void testStart_WithNullExternalExecutor_AlreadyStarted() {
        initializer.setExternalExecutor(null);
        initializer.start();
        boolean result = initializer.start();
        assertFalse(result);
    }
}