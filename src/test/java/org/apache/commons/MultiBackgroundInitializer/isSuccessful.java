import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isSuccessfulTest {

    private MultiBackgroundInitializer.MultiBackgroundInitializerResults results;

    @BeforeEach
    void setUp() {
        results = new MultiBackgroundInitializer.MultiBackgroundInitializerResults(
                new HashMap<>(),
                new HashMap<>(),
                new HashMap<>()
        );
    }

    @Test
    void testIsSuccessful_NoExceptions() {
        assertTrue(results.isSuccessful());
    }

    @Test
    void testIsSuccessful_WithExceptions() {
        results.getExceptions().put("initializer1", new ConcurrentException());
        assertFalse(results.isSuccessful());
    }

    @Test
    void testIsSuccessful_UnknownName() {
        assertThrows(NoSuchElementException.class, () -> results.isSuccessful("unknown"));
    }
}