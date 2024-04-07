import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ExecutorService;

class getResultObjectTest {

    private MultiBackgroundInitializer.MultiBackgroundInitializerResults results;

    @BeforeEach
    void setup() {
        // Initialize child initializers and result objects
        BackgroundInitializer<Object> initializer1 = new BackgroundInitializer<Object>() {
            @Override
            protected Object initialize() throws Exception {
                return "Result 1";
            }
        };
        BackgroundInitializer<Object> initializer2 = new BackgroundInitializer<Object>() {
            @Override
            protected Object initialize() throws Exception {
                throw new Exception("Exception");
            }
        };

        MultiBackgroundInitializer multiInitializer = new MultiBackgroundInitializer();
        multiInitializer.childInitializers.put("initializer1", initializer1);
        multiInitializer.childInitializers.put("initializer2", initializer2);

        ExecutorService exec = null; // Replace with actual ExecutorService
        multiInitializer.initialize(exec);
        results = multiInitializer.getResults();
    }

    @Test
    void testGetResultObject() {
        // Test for successful result object
        Object result1 = results.getResultObject("initializer1");
        Assertions.assertEquals("Result 1", result1);

        // Test for null result object due to exception
        Object result2 = results.getResultObject("initializer2");
        Assertions.assertNull(result2);

        // Test for unknown initializer name
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            results.getResultObject("unknown");
        });
    }

    @Test
    void testIsException() {
        // Test for successful initializer without exception
        boolean exception1 = results.isException("initializer1");
        Assertions.assertFalse(exception1);

        // Test for initializer with exception
        boolean exception2 = results.isException("initializer2");
        Assertions.assertTrue(exception2);

        // Test for unknown initializer name
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            results.isException("unknown");
        });
    }

    @Test
    void testGetException() {
        // Test for exception object
        ConcurrentException exception2 = results.getException("initializer2");
        Assertions.assertNotNull(exception2);

        // Test for null exception object
        ConcurrentException exception1 = results.getException("initializer1");
        Assertions.assertNull(exception1);

        // Test for unknown initializer name
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            results.getException("unknown");
        });
    }

    @Test
    void testGetInitializer() {
        // Test for existing initializer
        BackgroundInitializer<?> initializer1 = results.getInitializer("initializer1");
        Assertions.assertNotNull(initializer1);

        // Test for unknown initializer name
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            results.getInitializer("unknown");
        });
    }

    @Test
    void testInitializerNames() {
        // Test for initializer names
        Set<String> names = results.initializerNames();
        Assertions.assertEquals(2, names.size());
        Assertions.assertTrue(names.contains("initializer1"));
        Assertions.assertTrue(names.contains("initializer2"));
    }

    @Test
    void testIsSuccessful() {
        // Test for successful initialization
        boolean successful = results.isSuccessful();
        Assertions.assertFalse(successful);
    }
}