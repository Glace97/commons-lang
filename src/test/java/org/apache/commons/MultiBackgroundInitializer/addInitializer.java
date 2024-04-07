import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

class addInitializerTest {
    MultiBackgroundInitializer multiInitializer;
    ExecutorService executorService;

    @BeforeEach
    void setUp() {
        executorService = Executors.newFixedThreadPool(5);
        multiInitializer = new MultiBackgroundInitializer(executorService);
    }

    @Test
    void testAddInitializer() {
        BackgroundInitializer<Object> initializer = new BackgroundInitializer<Object>() {
            @Override
            protected Object initialize() throws Exception {
                return new Object();
            }
        };

        multiInitializer.addInitializer("Initializer1", initializer);

        Assertions.assertEquals(1, multiInitializer.initializerNames().size());
        Assertions.assertTrue(multiInitializer.initializerNames().contains("Initializer1"));
        Assertions.assertEquals(initializer, multiInitializer.getInitializer("Initializer1"));
    }

    @Test
    void testAddInitializer_NullName() {
        BackgroundInitializer<Object> initializer = new BackgroundInitializer<Object>() {
            @Override
            protected Object initialize() throws Exception {
                return new Object();
            }
        };

        Assertions.assertThrows(NullPointerException.class, () -> {
            multiInitializer.addInitializer(null, initializer);
        });
    }

    @Test
    void testAddInitializer_NullBackgroundInitializer() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            multiInitializer.addInitializer("Initializer1", null);
        });
    }

    @Test
    void testAddInitializer_AfterStart() {
        multiInitializer.start();

        BackgroundInitializer<Object> initializer = new BackgroundInitializer<Object>() {
            @Override
            protected Object initialize() throws Exception {
                return new Object();
            }
        };

        Assertions.assertThrows(IllegalStateException.class, () -> {
            multiInitializer.addInitializer("Initializer1", initializer);
        });
    }
}