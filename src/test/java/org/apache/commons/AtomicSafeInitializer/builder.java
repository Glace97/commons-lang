import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class builderTest {

    @Test
    void testBuilder() {
        AtomicSafeInitializer<String> initializer = AtomicSafeInitializer.builder().get();
        assertNotNull(initializer);
    }

    @Test
    void testInitialize() {
        AtomicSafeInitializer<String> initializer = AtomicSafeInitializer.builder().get();
        assertThrows(ConcurrentException.class, initializer::initialize);
    }

    @Test
    void testClose() {
        AtomicSafeInitializer<String> initializer = AtomicSafeInitializer.builder().get();
        assertDoesNotThrow(initializer::close);
    }
}