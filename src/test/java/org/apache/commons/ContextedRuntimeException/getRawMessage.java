import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class getRawMessageTest {
    private ContextedRuntimeException exception;

    @BeforeEach
    void setUp() {
        exception = new ContextedRuntimeException("Test Message");
    }

    @Test
    @DisplayName("Test getRawMessage returns the correct message")
    void testGetRawMessage() {
        assertEquals("Test Message", exception.getRawMessage());
    }
}