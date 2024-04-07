import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class isInitializedTest {

    @Test
    void testIsInitializedReturnsFalseForNewInstance() {
        LazyInitializer<Object> initializer = new LazyInitializer<>();
        assertFalse(initializer.isInitialized());
    }
    
    @Test
    void testIsInitializedReturnsTrueAfterInitialization() {
        LazyInitializer<Object> initializer = new LazyInitializer<>();
        initializer.initialize();
        assertTrue(initializer.isInitialized());
    }
    
    @Test
    void testIsInitializedReturnsTrueAfterInitializationWithNonNullObject() {
        LazyInitializer<Object> initializer = new LazyInitializer<>();
        initializer.initialize(() -> new Object());
        assertTrue(initializer.isInitialized());
    }
    
    @Test
    void testIsInitializedReturnsFalseAfterClose() {
        LazyInitializer<Object> initializer = new LazyInitializer<>();
        initializer.initialize();
        initializer.close();
        assertFalse(initializer.isInitialized());
    }
    
    @Test
    void testIsInitializedReturnsFalseAfterCloseWithNonNullObject() {
        LazyInitializer<Object> initializer = new LazyInitializer<>();
        initializer.initialize(() -> new Object());
        initializer.close();
        assertFalse(initializer.isInitialized());
    }
    
    @Test
    void testIsInitializedReturnsTrueAfterReinitialize() {
        LazyInitializer<Object> initializer = new LazyInitializer<>();
        initializer.initialize();
        initializer.close();
        initializer.initialize();
        assertTrue(initializer.isInitialized());
    }
    
    @Test
    void testIsInitializedReturnsTrueAfterReinitializeWithNonNullObject() {
        LazyInitializer<Object> initializer = new LazyInitializer<>();
        initializer.initialize(() -> new Object());
        initializer.close();
        initializer.initialize(() -> new Object());
        assertTrue(initializer.isInitialized());
    }
    
    @Test
    void testIsInitializedReturnsTrueAfterCloseWithoutInitialize() {
        LazyInitializer<Object> initializer = new LazyInitializer<>();
        initializer.close();
        assertTrue(initializer.isInitialized());
    }
    
    @Test
    void testIsInitializedReturnsTrueAfterCloseWithoutInitializeWithNonNullObject() {
        LazyInitializer<Object> initializer = new LazyInitializer<>();
        initializer.initialize(() -> new Object());
        initializer.close();
        initializer.close();
        assertTrue(initializer.isInitialized());
    }
}