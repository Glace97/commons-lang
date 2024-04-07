import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class isInitializedTest {

    private MultiBackgroundInitializer multiBackgroundInitializer;

    @BeforeEach
    void setUp() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        multiBackgroundInitializer = new MultiBackgroundInitializer(executorService);
    }

    @Test
    void testIsInitialized_NoChildInitializers_ReturnsFalse() {
        assertFalse(multiBackgroundInitializer.isInitialized());
    }

    @Test
    void testIsInitialized_AllChildInitializersInitialized_ReturnsTrue() {
        BackgroundInitializer<String> initializer1 = new BackgroundInitializer<String>() {
            @Override
            protected String initialize() throws Exception {
                return "Initialized";
            }
        };

        BackgroundInitializer<Integer> initializer2 = new BackgroundInitializer<Integer>() {
            @Override
            protected Integer initialize() throws Exception {
                return 100;
            }
        };

        multiBackgroundInitializer.childInitializers.put("initializer1", initializer1);
        multiBackgroundInitializer.childInitializers.put("initializer2", initializer2);

        assertTrue(multiBackgroundInitializer.isInitialized());
    }

    @Test
    void testIsInitialized_SomeChildInitializersNotInitialized_ReturnsFalse() {
        BackgroundInitializer<String> initializer1 = new BackgroundInitializer<String>() {
            @Override
            protected String initialize() throws Exception {
                return "Initialized";
            }
        };

        BackgroundInitializer<Integer> initializer2 = new BackgroundInitializer<Integer>() {
            @Override
            protected Integer initialize() throws Exception {
                return 100;
            }
        };

        BackgroundInitializer<Boolean> initializer3 = new BackgroundInitializer<Boolean>() {
            @Override
            protected Boolean initialize() throws Exception {
                return false;
            }
        };

        multiBackgroundInitializer.childInitializers.put("initializer1", initializer1);
        multiBackgroundInitializer.childInitializers.put("initializer2", initializer2);
        multiBackgroundInitializer.childInitializers.put("initializer3", initializer3);

        assertFalse(multiBackgroundInitializer.isInitialized());
    }

    @Test
    void testIsInitialized_EmptyChildInitializers_ReturnsFalse() {
        assertTrue(multiBackgroundInitializer.isInitialized());
    }
}