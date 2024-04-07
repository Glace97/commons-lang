import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.concurrent.ExecutorService;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getInitializerTest {
    private MultiBackgroundInitializer multiBackgroundInitializer;

    @BeforeAll
    void setup() {
        ExecutorService executorService = // Create an ExecutorService for testing
        multiBackgroundInitializer = new MultiBackgroundInitializer(executorService);
    }

    @Test
    void testGetInitializer_ValidName_ReturnsInitializer() {
        // Arrange
        String validName = "validInitializer";

        // Act
        BackgroundInitializer<?> result = multiBackgroundInitializer.getInitializer(validName);

        // Assert
        Assertions.assertNotNull(result);
    }

    @Test
    void testGetInitializer_InvalidName_ThrowsNoSuchElementException() {
        // Arrange
        String invalidName = "invalidInitializer";

        // Act & Assert
        Assertions.assertThrows(NoSuchElementException.class, () -> {
            multiBackgroundInitializer.getInitializer(invalidName);
        });
    }
}