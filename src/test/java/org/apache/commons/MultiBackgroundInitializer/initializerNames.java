import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.ExecutorService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(Lifecycle.PER_CLASS)
class initializerNamesTest {

    private MultiBackgroundInitializer multiBackgroundInitializer;
    private Map<String, BackgroundInitializer<?>> childInitializers;

    @BeforeEach
    void setup() {
        childInitializers = new HashMap<>();
        multiBackgroundInitializer = new MultiBackgroundInitializer(childInitializers);
    }

    @Test
    void testInitializerNames_EmptyInitializer() {
        assertEquals(0, multiBackgroundInitializer.initializerNames().size());
    }

    @Test
    void testInitializerNames_SingleInitializer() {
        BackgroundInitializer<String> initializer = new BackgroundInitializer<>();
        childInitializers.put("initializer1", initializer);
        assertEquals(1, multiBackgroundInitializer.initializerNames().size());
        assertTrue(multiBackgroundInitializer.initializerNames().contains("initializer1"));
    }

    @Test
    void testInitializerNames_MultipleInitializers() {
        BackgroundInitializer<String> initializer1 = new BackgroundInitializer<>();
        BackgroundInitializer<Integer> initializer2 = new BackgroundInitializer<>();
        BackgroundInitializer<Double> initializer3 = new BackgroundInitializer<>();
        childInitializers.put("initializer1", initializer1);
        childInitializers.put("initializer2", initializer2);
        childInitializers.put("initializer3", initializer3);
        assertEquals(3, multiBackgroundInitializer.initializerNames().size());
        assertTrue(multiBackgroundInitializer.initializerNames().contains("initializer1"));
        assertTrue(multiBackgroundInitializer.initializerNames().contains("initializer2"));
        assertTrue(multiBackgroundInitializer.initializerNames().contains("initializer3"));
    }

    @Test
    void testInitializerNames_ModifyInitializersAfterCreation() {
        BackgroundInitializer<String> initializer = new BackgroundInitializer<>();
        childInitializers.put("initializer1", initializer);
        assertEquals(1, multiBackgroundInitializer.initializerNames().size());
        assertTrue(multiBackgroundInitializer.initializerNames().contains("initializer1"));

        childInitializers.remove("initializer1");
        assertEquals(0, multiBackgroundInitializer.initializerNames().size());
    }

    @Test
    void testInitializerNames_ImmutableSet() {
        BackgroundInitializer<String> initializer = new BackgroundInitializer<>();
        childInitializers.put("initializer1", initializer);
        assertEquals(1, multiBackgroundInitializer.initializerNames().size());
        assertTrue(multiBackgroundInitializer.initializerNames().contains("initializer1"));

        assertThrows(UnsupportedOperationException.class, () -> {
            multiBackgroundInitializer.initializerNames().add("initializer2");
        });
    }
}