import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class closeTest {
    private MultiBackgroundInitializer multiBackgroundInitializer;

    @BeforeEach
    void setUp() {
        ExecutorService exec = Executors.newFixedThreadPool(5);
        multiBackgroundInitializer = new MultiBackgroundInitializer(exec);
    }

    @Test
    void testCloseAllChildInitializers() {
        BackgroundInitializer<String> initializer1 = new BackgroundInitializer<String>() {
            @Override
            protected String initialize() throws Exception {
                return "Initializer 1";
            }
        };
        BackgroundInitializer<Integer> initializer2 = new BackgroundInitializer<Integer>() {
            @Override
            protected Integer initialize() throws Exception {
                return 2;
            }
        };

        multiBackgroundInitializer.childInitializers.put("init1", initializer1);
        multiBackgroundInitializer.childInitializers.put("init2", initializer2);

        assertDoesNotThrow(() -> multiBackgroundInitializer.close());
    }

    @Test
    void testCloseWithException() {
        BackgroundInitializer<Boolean> initializer1 = new BackgroundInitializer<Boolean>() {
            @Override
            protected Boolean initialize() throws Exception {
                throw new Exception("Initializer 1 exception");
            }
        };
        BackgroundInitializer<Float> initializer2 = new BackgroundInitializer<Float>() {
            @Override
            protected Float initialize() throws Exception {
                throw new Exception("Initializer 2 exception");
            }
        };

        multiBackgroundInitializer.childInitializers.put("init1", initializer1);
        multiBackgroundInitializer.childInitializers.put("init2", initializer2);

        assertThrows(ConcurrentException.class, () -> multiBackgroundInitializer.close());
    }
}