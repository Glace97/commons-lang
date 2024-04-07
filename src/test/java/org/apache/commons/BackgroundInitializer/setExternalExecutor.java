import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class setExternalExecutorTest {

    private BackgroundInitializer.Builder<BackgroundInitializer, Object> builder;

    @BeforeEach
    void setUp() {
        builder = new BackgroundInitializer.Builder<>();
    }

    @Test
    void setExternalExecutor_ShouldSetExternalExecutor() {
        ExecutorService externalExecutor = Executors.newSingleThreadExecutor();
        
        builder.setExternalExecutor(externalExecutor);

        ExecutorService result = builder.getExternalExecutor();
        
        assertEquals(externalExecutor, result);
    }

    @Test
    void setExternalExecutor_ShouldSetNullExternalExecutor() {
        builder.setExternalExecutor(null);

        ExecutorService result = builder.getExternalExecutor();
        
        assertNull(result);
    }

    @Test
    void setExternalExecutor_ShouldThrowExceptionIfCalledAfterStart() {
        ExecutorService externalExecutor = Executors.newSingleThreadExecutor();
        builder.start();
        
        assertThrows(IllegalStateException.class, () -> {
            builder.setExternalExecutor(externalExecutor);
        });
    }
}