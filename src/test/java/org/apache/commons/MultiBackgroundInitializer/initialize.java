import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class MultiBackgroundInitializerTest {

    private MultiBackgroundInitializer multiBackgroundInitializer;

    @BeforeEach
    void setUp() {
        multiBackgroundInitializer = new MultiBackgroundInitializer();
    }

    @Test
    void initialize_ReturnsResultsWithNoExceptions_WhenAllChildInitializersSucceed() throws Exception {
        // Arrange
        BackgroundInitializer<Integer> initializer1 = new BackgroundInitializer<Integer>() {
            @Override
            protected Integer initialize() throws Exception {
                return 1;
            }
        };
        BackgroundInitializer<String> initializer2 = new BackgroundInitializer<String>() {
            @Override
            protected String initialize() throws Exception {
                return "Hello";
            }
        };

        multiBackgroundInitializer.childInitializers.put("init1", initializer1);
        multiBackgroundInitializer.childInitializers.put("init2", initializer2);

        // Act
        MultiBackgroundInitializer.MultiBackgroundInitializerResults results = multiBackgroundInitializer.initialize();

        // Assert
        assertTrue(results.isSuccessful());
        assertNull(results.getException("init1"));
        assertNull(results.getException("init2"));
        assertEquals(1, results.getResultObject("init1"));
        assertEquals("Hello", results.getResultObject("init2"));
    }

    @Test
    void initialize_ReturnsResultsWithExceptions_WhenChildInitializersThrowException() throws Exception {
        // Arrange
        BackgroundInitializer<Integer> initializer1 = new BackgroundInitializer<Integer>() {
            @Override
            protected Integer initialize() throws Exception {
                throw new RuntimeException("Initializer 1 exception");
            }
        };
        BackgroundInitializer<String> initializer2 = new BackgroundInitializer<String>() {
            @Override
            protected String initialize() throws Exception {
                throw new IllegalArgumentException("Initializer 2 exception");
            }
        };

        multiBackgroundInitializer.childInitializers.put("init1", initializer1);
        multiBackgroundInitializer.childInitializers.put("init2", initializer2);

        // Act
        MultiBackgroundInitializer.MultiBackgroundInitializerResults results = multiBackgroundInitializer.initialize();

        // Assert
        assertFalse(results.isSuccessful());
        assertNotNull(results.getException("init1"));
        assertNotNull(results.getException("init2"));
        assertEquals("Initializer 1 exception", results.getException("init1").getMessage());
        assertEquals("Initializer 2 exception", results.getException("init2").getMessage());
        assertNull(results.getResultObject("init1"));
        assertNull(results.getResultObject("init2"));
    }

    @Test
    void initialize_ReturnsResultsWithNoExceptions_WhenChildInitializersAreEmpty() throws Exception {
        // Act
        MultiBackgroundInitializer.MultiBackgroundInitializerResults results = multiBackgroundInitializer.initialize();

        // Assert
        assertTrue(results.isSuccessful());
        assertTrue(results.initializerNames().isEmpty());
    }

    @Test
    void initialize_ReturnsResultsWithNoExceptions_WhenChildInitializersAreNull() throws Exception {
        // Arrange
        multiBackgroundInitializer.childInitializers = null;

        // Act
        MultiBackgroundInitializer.MultiBackgroundInitializerResults results = multiBackgroundInitializer.initialize();

        // Assert
        assertTrue(results.isSuccessful());
        assertTrue(results.initializerNames().isEmpty());
    }

    @Test
    void initialize_ReturnsResultsWithNoExceptions_WhenChildInitializerDoesNotExist() throws Exception {
        // Arrange
        BackgroundInitializer<Integer> initializer = new BackgroundInitializer<Integer>() {
            @Override
            protected Integer initialize() throws Exception {
                return 1;
            }
        };

        multiBackgroundInitializer.childInitializers.put("init1", initializer);

        // Act
        MultiBackgroundInitializer.MultiBackgroundInitializerResults results = multiBackgroundInitializer.initialize();

        // Assert
        assertTrue(results.isSuccessful());
        assertNull(results.getException("init2"));
        assertNotNull(results.getInitializer("init1"));
        assertEquals(1, results.getResultObject("init1"));
    }
}