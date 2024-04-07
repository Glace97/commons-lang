import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BuilderTest {

    @Test
    public void testGet() {
        BackgroundInitializer.Builder<BackgroundInitializer<TestObject>, TestObject> builder = BackgroundInitializer.builder();
        BackgroundInitializer<TestObject> initializer = builder.get();

        Assertions.assertNotNull(initializer);
    }

    @Test
    public void testSetExternalExecutor() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        BackgroundInitializer.Builder<BackgroundInitializer<TestObject>, TestObject> builder = BackgroundInitializer.builder();
        builder.setExternalExecutor(executorService);
        BackgroundInitializer<TestObject> initializer = builder.get();

        Assertions.assertEquals(executorService, initializer.getExternalExecutor());
    }

    @Test
    public void testInitializationTaskCall() throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        BackgroundInitializer.Builder<BackgroundInitializer<TestObject>, TestObject> builder = BackgroundInitializer.builder();
        builder.setExternalExecutor(executorService);
        BackgroundInitializer<TestObject> initializer = builder.get();

        TestObject result = initializer.getInitializer().call();

        Assertions.assertNotNull(result);
    }

    @Test
    public void testBackgroundInitializer() {
        BackgroundInitializer<TestObject> initializer = new BackgroundInitializer<>();

        Assertions.assertNotNull(initializer);
    }

    @Test
    public void testBackgroundInitializerWithExecutor() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        BackgroundInitializer<TestObject> initializer = new BackgroundInitializer<>(executorService);

        Assertions.assertNotNull(initializer);
        Assertions.assertEquals(executorService, initializer.getExternalExecutor());
    }

    @Test
    public void testBackgroundInitializerWithInitializerAndCloser() {
        BackgroundInitializer.Builder<BackgroundInitializer<TestObject>, TestObject> builder = BackgroundInitializer.builder();
        builder.setInitializer(() -> new TestObject());
        builder.setCloser(obj -> {});

        BackgroundInitializer<TestObject> initializer = builder.get();

        Assertions.assertNotNull(initializer);
    }

    @Test
    public void testBackgroundInitializerGetExternalExecutor() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        BackgroundInitializer<TestObject> initializer = new BackgroundInitializer<>(executorService);

        Assertions.assertEquals(executorService, initializer.getExternalExecutor());
    }

    @Test
    public void testBackgroundInitializerStart() {
        BackgroundInitializer<TestObject> initializer = new BackgroundInitializer<>();

        boolean result = initializer.start();

        Assertions.assertTrue(result);
        Assertions.assertTrue(initializer.isStarted());
        Assertions.assertTrue(initializer.isInitialized());
    }

    @Test
    public void testBackgroundInitializerMultipleStart() {
        BackgroundInitializer<TestObject> initializer = new BackgroundInitializer<>();

        boolean result1 = initializer.start();
        boolean result2 = initializer.start();

        Assertions.assertTrue(result1);
        Assertions.assertFalse(result2);
    }
    
    @Test
    public void testBackgroundInitializerStartWithExecutor() {
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        BackgroundInitializer<TestObject> initializer = new BackgroundInitializer<>(executorService);

        boolean result = initializer.start();

        Assertions.assertTrue(result);
        Assertions.assertTrue(initializer.isStarted());
        Assertions.assertTrue(initializer.isInitialized());
    }

    @Test
    public void testBackgroundInitializerInitialize() {
        BackgroundInitializer.Builder<BackgroundInitializer<TestObject>, TestObject> builder = BackgroundInitializer.builder();
        builder.setInitializer(() -> new TestObject());

        BackgroundInitializer<TestObject> initializer = builder.get();
        boolean result = initializer.start();

        Assertions.assertTrue(result);
        Assertions.assertTrue(initializer.isStarted());
        Assertions.assertTrue(initializer.isInitialized());
    }
    
    @Test
    public void testBuilderBuilder() {
        BackgroundInitializer.Builder<BackgroundInitializer<TestObject>, TestObject> builder = BackgroundInitializer.builder();

        Assertions.assertNotNull(builder);
    }
}