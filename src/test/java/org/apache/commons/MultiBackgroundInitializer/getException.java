import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class getExceptionTest {
    private MultiBackgroundInitializer multiBackgroundInitializer;

    @BeforeEach
    void setUp() {
        multiBackgroundInitializer = new MultiBackgroundInitializer();
    }

    @Test
    void testGetException() {
        assertThrows(NoSuchElementException.class, () -> {
            multiBackgroundInitializer.getException("nonexistentInitializer");
        });

        BackgroundInitializer<?> initializer1 = new BackgroundInitializer<Object>() {
            @Override
            protected Object initialize() throws Exception {
                throw new Exception("Initializer exception");
            }
        };
        BackgroundInitializer<?> initializer2 = new BackgroundInitializer<Object>() {
            @Override
            protected Object initialize() throws Exception {
                return new Object();
            }
        };

        multiBackgroundInitializer.childInitializers.put("initializer1", initializer1);
        multiBackgroundInitializer.childInitializers.put("initializer2", initializer2);
        multiBackgroundInitializer.initialize();

        assertNull(multiBackgroundInitializer.getException("initializer2"));
        assertNotNull(multiBackgroundInitializer.getException("initializer1"));

        assertThrows(NoSuchElementException.class, () -> {
            multiBackgroundInitializer.getException("nonexistentInitializer");
        });
    }
}