import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BuilderTest {

    @Test
    void testGet() {
        FailableSupplier<Object, ConcurrentException> initializer = mock(FailableSupplier.class);
        FailableConsumer<Object, ConcurrentException> closer = mock(FailableConsumer.class);
        LazyInitializer<Object> lazyInitializer = new LazyInitializer<>(initializer, closer);
        
        LazyInitializer.Builder<LazyInitializer<Object>, Object> builder = LazyInitializer.builder();
        builder.setInitializer(initializer);
        builder.setCloser(closer);
        
        LazyInitializer<Object> result = builder.get();
        
        assertEquals(lazyInitializer, result);
    }
    
    @Test
    void testGet_NoInitializerOrCloser() {
        LazyInitializer.Builder<LazyInitializer<Object>, Object> builder = LazyInitializer.builder();
        
        LazyInitializer<Object> result = builder.get();
        
        assertNotNull(result);
        assertNotEquals(LazyInitializer.NO_INIT, result.object);
    }
    
    @Test
    void testBuilder() {
        LazyInitializer.Builder<LazyInitializer<Object>, Object> builder = LazyInitializer.builder();
        
        assertNotNull(builder);
    }

}