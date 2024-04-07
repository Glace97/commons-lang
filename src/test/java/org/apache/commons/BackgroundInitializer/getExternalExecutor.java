import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@DisplayName("getExternalExecutor Test")
class getExternalExecutorTest {

    private BackgroundInitializer backgroundInitializer;

    @BeforeEach
    void setUp() {
        backgroundInitializer = new BackgroundInitializer();
    }

    @Nested
    @DisplayName("when externalExecutor is not set")
    @TestInstance(Lifecycle.PER_CLASS)
    class WhenExternalExecutorNotSet {

        @Test
        @DisplayName("should return null")
        void returnsNull() {
            ExecutorService executorService = backgroundInitializer.getExternalExecutor();

            assertNull(executorService);
        }

        @Test
        @DisplayName("should return the same executor service after start")
        void returnsSameExecutorServiceAfterStart() {
            backgroundInitializer.start();
            ExecutorService executorService1 = backgroundInitializer.getExternalExecutor();
            ExecutorService executorService2 = backgroundInitializer.getExternalExecutor();

            assertEquals(executorService1, executorService2);
        }

    }

    @Nested
    @DisplayName("when externalExecutor is set")
    @TestInstance(Lifecycle.PER_CLASS)
    class WhenExternalExecutorSet {

        private ExecutorService externalExecutor;

        @BeforeEach
        void setUp() {
            externalExecutor = Executors.newSingleThreadExecutor();
            backgroundInitializer.setExternalExecutor(externalExecutor);
        }

        @AfterEach
        void tearDown() {
            externalExecutor.shutdown();
        }

        @Test
        @DisplayName("should return the set externalExecutor")
        void returnsSetExternalExecutor() {
            ExecutorService executorService = backgroundInitializer.getExternalExecutor();

            assertEquals(externalExecutor, executorService);
        }

        @Test
        @DisplayName("should return the same executor service after start")
        void returnsSameExecutorServiceAfterStart() {
            backgroundInitializer.start();
            ExecutorService executorService1 = backgroundInitializer.getExternalExecutor();
            ExecutorService executorService2 = backgroundInitializer.getExternalExecutor();

            assertEquals(executorService1, executorService2);
        }

    }

}